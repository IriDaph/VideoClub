package com.assuretraining.main.ui.command;

import com.assuretraining.main.club.customer.Customer;
import com.assuretraining.main.club.media.Media;
import com.assuretraining.main.club.media.Movie;
import com.assuretraining.main.club.media.Videogame;
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

class CreateRentalCommandTest {

    Command command = new CreateRentalCommand();
    @Test
    void runCommand_ShouldCreateRentalAndAdd() throws Exception {
        Menu menu;
        Customer customer = mock(Customer.class);
        List<Media> rentedMedia = new ArrayList<>();
        Movie movie = mock(Movie.class);
        Videogame videogame = mock(Videogame.class);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String input = "2501\n" +
                "1\ny\n2\nn\n" +
                "100A\n" +
                "7\n" +
                "y\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        menu = new Menu(in);
        menu.customers.add(customer);
        menu.ownedMedia.add(movie);
        menu.ownedMedia.add(videogame);
        when(movie.getUid()).thenReturn("1");
        when(videogame.getUid()).thenReturn("2");
        when(customer.getId()).thenReturn("100A");

        command.runCommand(menu);
        Assertions.assertFalse(menu.rentals.isInventoryEmpty());

    }
}