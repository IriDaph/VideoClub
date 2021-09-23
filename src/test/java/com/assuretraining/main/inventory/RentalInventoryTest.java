package com.assuretraining.main.inventory;

import com.assuretraining.main.club.customer.Customer;
import com.assuretraining.main.club.media.Media;
import com.assuretraining.main.club.media.Movie;
import com.assuretraining.main.club.media.MusicAlbum;
import com.assuretraining.main.club.media.Videogame;
import com.assuretraining.main.club.rental.Rental;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RentalInventoryTest {
    RentalInventory rentalInventory;
    List<Rental> inventory;
    Customer customer1 = mock(Customer.class);
    Customer customer2 = mock(Customer.class);
    Movie movie = mock(Movie.class);
    MusicAlbum musicAlbum = mock(MusicAlbum.class);

    @BeforeEach
    void setup(){
        rentalInventory = new RentalInventory();
        inventory = rentalInventory.getInventory();
    }
    @Test
    void rentalList_ShouldStartEmpty() {
        Assertions.assertEquals(0, inventory.size());
    }
    @Test
    void add_ShouldAddMediaToList(){
        Rental rental = mock(Rental.class);
        inventory.add(rental);
        Assertions.assertTrue(inventory.contains(rental));
    }

    @Test
    void printInventory_ShouldShowMedia() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        when(customer1.getName()).thenReturn("Ana");
        when(customer1.getId()).thenReturn("88910");
        when(customer2.getName()).thenReturn("Jim");
        when(customer2.getId()).thenReturn("24301");

        List<Media> rentedMedia = new ArrayList<>();
        rentedMedia.add(movie);
        rentedMedia.add(musicAlbum);
        Rental rental1 = new Rental("1X",rentedMedia,customer1,10,true);
        Rental rental2 = new Rental("1C",rentedMedia,customer2,5,false);
        rental1.setDateOfRental("10/09/2021");
        rental2.setDateOfRental("09/09/2021");
        rental1.calculateDayOfReturning();
        rental2.calculateDayOfReturning();
        rentalInventory.add(rental1);
        rentalInventory.add(rental2);
        rentalInventory.printInventory();
        String expectedOutput  = "Rental Id: 1X\r\n" +
                "Customer's Id: 88910\r\n" +
                "Customer's name: Ana\r\n" +
                "Date of Rental: Fri Sep 10 00:00:00 BOT 2021\r\n" +
                "Date of Returning: Mon Sep 20 00:00:00 BOT 2021\r\n" +
                "Has customer paid?: true\r\n" +
                "Total: 0.0\r\n" +
                "Penalty Fee: 0.0\r\n" +
                "Rental Id: 1C\r\n" +
                "Customer's Id: 24301\r\n" +
                "Customer's name: Jim\r\n" +
                "Date of Rental: Thu Sep 09 00:00:00 BOT 2021\r\n" +
                "Date of Returning: Tue Sep 14 00:00:00 BOT 2021\r\n" +
                "Has customer paid?: false\r\n" +
                "Total: 0.0\r\n" +
                "Penalty Fee: 0.0\r\n";
        Assertions.assertEquals(expectedOutput,outContent.toString());
    }

    @Test
    void searchByIdentifier_ShouldReturnSearchedRental() throws Exception {
        List<Media> rentedMedia = new ArrayList<>();
        rentedMedia.add(movie);
        rentedMedia.add(musicAlbum);
        Rental rental1 = new Rental("1X",rentedMedia,customer1,10,true);
        rentalInventory.add(rental1);
        Assertions.assertEquals(rental1,(Rental) rentalInventory.searchByIdentifier("1X"));
    }

    @Test
    void searchByIdentifier_ShouldReturnNullIfSearchedRentalDoesNotExist() {
        Assertions.assertEquals(null,(Rental) rentalInventory.searchByIdentifier("5A"));
    }
    @Test
    void isInventoryEmpty_ShouldReturnTrueIfEmpty() {
        Assertions.assertTrue(rentalInventory.isInventoryEmpty());
    }

    @Test
    void isInventoryEmpty_ShouldReturnFalseIfNotEmpty() throws Exception {
        List<Media> rentedMedia = new ArrayList<>();
        rentedMedia.add(movie);
        rentedMedia.add(musicAlbum);
        Rental rental1 = new Rental("1X",rentedMedia,customer1,10,true);
        rentalInventory.add(rental1);
        Assertions.assertFalse(rentalInventory.isInventoryEmpty());
    }

    @Test
    void sortInventoryById_ShouldSortList() throws Exception {
        List<Media> rentedMedia = new ArrayList<>();
        rentedMedia.add(movie);
        rentedMedia.add(musicAlbum);
        Rental rental1 = new Rental("1X",rentedMedia,customer1,10,true);
        Rental rental2 = new Rental("1C",rentedMedia,customer2,5,false);
        rentalInventory.add(rental1);
        rentalInventory.add(rental2);
        List<Rental> orderedList = new ArrayList<>();
        orderedList.add(rental2);
        orderedList.add(rental1);
        rentalInventory.sortInventory();
        Assertions.assertEquals(orderedList,rentalInventory.getInventory());
    }

    @Test
    void searchCustomersWhoRentedMedia_ShouldShowListOfCustomersWhoRented() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        List<Media> rentedMedia = new ArrayList<>();
        MusicAlbum musicAlbum = new MusicAlbum("120",3.50,"Hit 100","Popular hits","12/02/2020","Various",100,"Pop");
        Customer c1 = new Customer("100","Ana","Martinez","Av. Peru 1212","77872312");
        Customer c2 = new Customer("120","Juan","Perez","Calle Colombia 1212","77823231");
        rentedMedia.add(musicAlbum);
        Rental rental1 = new Rental("1X",rentedMedia,c1,10,true);
        Rental rental2 = new Rental("1C",rentedMedia,c2,5,false);
        rentalInventory.add(rental1);
        rentalInventory.add(rental2);
        rentalInventory.searchCustomersWhoRentedMedia("120");
        String expectedOutput = "Customer's Id: 100\r\n" +
                "Customer's name: Ana\r\n" +
                "Customer's Id: 120\r\n" +
                "Customer's name: Juan\r\n";
        Assertions.assertEquals(expectedOutput,outContent.toString());
    }
}