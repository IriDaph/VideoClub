package com.assuretraining.main.club.rental;

import com.assuretraining.main.club.customer.Customer;
import com.assuretraining.main.club.media.Media;
import com.assuretraining.main.club.media.Movie;
import com.assuretraining.main.club.media.MusicAlbum;
import com.assuretraining.main.club.media.Videogame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RentalTest {
    Rental rental = null;
    Movie movie = null;
    MusicAlbum musicAlbum = null;
    Videogame videogame = null;
    Customer customer = null;
    @BeforeEach
    void setup(){
        movie = mock(Movie.class);
        videogame =mock(Videogame.class);
        musicAlbum = mock(MusicAlbum.class);
        List<Media> rentedMedia = new ArrayList<>();
        rentedMedia.add(movie);
        rentedMedia.add(musicAlbum);
        rentedMedia.add(videogame);
        customer = mock(Customer.class);
        rental = new Rental("1001",rentedMedia,customer,10,false);
    }

    @Test
    void dateOfRental_IsDateObject_ReturnsTrue() {
        Assertions.assertTrue(rental.getDateOfRental()  instanceof Date);
    }

    @Test
    void calculateDayOfReturning_ShouldReturnALaterDate() throws Exception {
        rental.setDateOfRental("10/09/2020");
        rental.setQuantityOfDays(10);
        rental.calculateDayOfReturning();
        Date day = new SimpleDateFormat("dd/MM/yyyy").parse("20/09/2020");
        Assertions.assertEquals( day, rental.getDateOfReturning());
    }

    @Test
    void penaltyShouldStartAtZero_ReturnsTrue(){
        Assertions.assertEquals(0,rental.getPenaltyFee());
    }
    @Test
    void calculatePenalty_ShouldIncreasePenalty_ReturnsTrue() throws Exception {
        rental.setDateOfReturning("20/09/2021");
        rental.setTotal(100.00);
        rental.setQuantityOfDays(2);
        rental.calculatePenalty();
        Assertions.assertEquals(150, rental.getPenaltyFee());

    }
    @Test
    void calculateTotal_ShouldAddCostPerDaysAndMultiply_ReturnsTrue() {
        when(movie.getCostPerDay()).thenReturn(5.50);
        when(musicAlbum.getCostPerDay()).thenReturn(5.00);
        when(videogame.getCostPerDay()).thenReturn(5.00);
        Assertions.assertEquals(155, rental.calculateTotal());
    }

    @Test
    void printRental_ShouldPrintRentalInfo() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        when(customer.getName()).thenReturn("Ana");
        when(customer.getId()).thenReturn("88910");
        rental.setDateOfRental("20/09/2021");
        rental.calculateDayOfReturning();
        rental.printRental();
        String expectedOutput  = "Rental Id: 1001\r\nCustomer's Id: 88910\r\nCustomer's name: Ana\r\nDate of Rental: Mon Sep 20 00:00:00 BOT 2021\r\nDate of Returning: Thu Sep 30 00:00:00 BOT 2021\r\nHas customer paid?: false\r\nTotal: 0.0\r\nPenalty Fee: 0.0\r\n";
        Assertions.assertEquals(expectedOutput,outContent.toString());
    }
    @Test
    void printRentingCustomer() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        when(customer.getName()).thenReturn("Ana");
        when(customer.getId()).thenReturn("88910");
        rental.printRentingCustomer();
        String expectedOutput = "Customer's Id: 88910\r\n" +
                "Customer's name: Ana\r\n";
        Assertions.assertEquals(expectedOutput,outContent.toString());
    }

}