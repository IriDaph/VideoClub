package com.assuretraining.main.ui.command;

import com.assuretraining.main.club.customer.Customer;
import com.assuretraining.main.club.media.Media;
import com.assuretraining.main.club.media.Movie;
import com.assuretraining.main.club.media.MusicAlbum;
import com.assuretraining.main.club.rental.Rental;
import com.assuretraining.main.inventory.CustomerInventory;
import com.assuretraining.main.inventory.RentalInventory;
import com.assuretraining.main.ui.Menu;
import com.assuretraining.main.ui.ScannerActions;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CalculatePenaltyCommandTest {
    Command command = new CalculatePenaltyCommand();
    @Test
    void runCommandCalculatePenalty_ShouldAskFromUserToCreatePenalty() throws Exception {
        Menu menu;

        RentalInventory rentalInventory = new RentalInventory();
        Customer customer = mock(Customer.class);
        Movie movie = mock(Movie.class);
        List<Media> rentedMedia = new ArrayList<>();
        rentedMedia.add(movie);
        Rental rental = new Rental("123ABC",rentedMedia,customer,10,false);
        when(customer.getId()).thenReturn("1000");
        rentalInventory.add(rental);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String input = "123ABC\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        menu = new Menu(in);
        menu.rentals = rentalInventory;
        command.runCommand(menu);
        Assertions.assertEquals("Enter rental's  id: \r\nCustomer 1000 penalty fee is 0.0\r\n",outContent.toString());

    }
}