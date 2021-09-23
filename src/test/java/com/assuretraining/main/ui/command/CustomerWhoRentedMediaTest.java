package com.assuretraining.main.ui.command;

import com.assuretraining.main.club.customer.Customer;
import com.assuretraining.main.club.media.Media;
import com.assuretraining.main.club.media.Movie;
import com.assuretraining.main.club.media.Videogame;
import com.assuretraining.main.club.rental.Rental;
import com.assuretraining.main.ui.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CustomerWhoRentedMediaTest {

    Command command = new CustomerWhoRentedMedia();
    @Test
    void runCommand_ShouldShowCustomersWhoRentedMedia() throws Exception {
        Menu menu;
        Customer customer = mock(Customer.class);
        Customer customer1 = mock(Customer.class);
        List<Media> rentedMedia = new ArrayList<>();
        Movie movie = mock(Movie.class);
        Videogame videogame = mock(Videogame.class);
        rentedMedia.add(movie);
        rentedMedia.add(videogame);
        Rental rental1 = new Rental("1",rentedMedia,customer,7,true);
        rentedMedia.remove(movie);
        Rental rental2 = new Rental("2",rentedMedia,customer1,10,true);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String input = "2A\n" ;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        menu = new Menu(in);
        menu.customers.add(customer);
        menu.ownedMedia.add(movie);
        menu.ownedMedia.add(videogame);
        when(movie.getUid()).thenReturn("1A");
        when(videogame.getUid()).thenReturn("2A");
        when(customer.getId()).thenReturn("100A");
        when(customer.getName()).thenReturn("Paola");
        when(customer1.getId()).thenReturn("100B");
        when(customer1.getName()).thenReturn("Enrique");
        menu.rentals.add(rental1);
        menu.rentals.add(rental2);

        command.runCommand(menu);

        Assertions.assertEquals("Which media are you searching: \r\n" +
                "The customers who rented this media are: \r\n" +
                "Customer's Id: 100A\r\n" +
                "Customer's name: Paola\r\n" +
                "Customer's Id: 100B\r\n" +
                "Customer's name: Enrique\r\n",outContent.toString());
    }
}