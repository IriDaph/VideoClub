package com.assuretraining.main.ui.command;

import com.assuretraining.main.club.customer.Customer;
import com.assuretraining.main.club.media.Media;
import com.assuretraining.main.club.media.Movie;
import com.assuretraining.main.club.media.Videogame;
import com.assuretraining.main.club.rental.Rental;
import com.assuretraining.main.ui.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class SeeRentalsCommandTest {

    Command command = new SeeRentalsCommand();
    @Test
    void runCommand_ShouldShowMessageIfEmpty() throws Exception {
        Menu menu;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        menu = new Menu(System.in);
        command.runCommand(menu);
        Assertions.assertTrue(menu.ownedMedia.isInventoryEmpty());
        Assertions.assertEquals("There aren't any rentals yet\r\n",outContent.toString());
    }
    @Test
    void runCommand_ShouldShowRentals() throws Exception {
        Menu menu;
        List<String> lista = mock(ArrayList.class);
        List<Media> mediaList = new ArrayList<>();
        Media movie = new Movie("La peli",5,"The good movie","100A","12/12/2012",100,"Pablo Meneses",lista,"2:30","Comedia","Peru");
        Videogame videogame = new Videogame("100B","Shooter con muchos enemigos",10,"COD","10/07/2014",5.5,lista,"AntonioGames","Shooter");
        Customer c1 = new Customer("100","Ana","Martinez","","77992299");
        Customer c2 = new Customer("200","Luis","Killman","","77999999");
        mediaList.add(movie);
        mediaList.add(videogame);
        Rental rental1 = new Rental("1",mediaList,c1,4,false);
        Rental rental2 = new Rental("2",mediaList,c2,10,true);
        rental1.setDateOfRental("21/09/2021");
        rental2.setDateOfRental("21/09/2021");
        rental1.calculateDayOfReturning();
        rental2.calculateDayOfReturning();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        menu = new Menu(System.in);

        menu.rentals.add(rental1);
        menu.rentals.add(rental2);

        command.runCommand(menu);
        Assertions.assertEquals("Rental Id: 1\r\n" +
                "Customer's Id: 100\r\n" +
                "Customer's name: Ana\r\n" +
                "Date of Rental: Tue Sep 21 00:00:00 BOT 2021\r\n" +
                "Date of Returning: Sat Sep 25 00:00:00 BOT 2021\r\n" +
                "Has customer paid?: false\r\n" +
                "Total: 60.0\r\n" +
                "Penalty Fee: 0.0\r\n" +
                "Rental Id: 2\r\n" +
                "Customer's Id: 200\r\n" +
                "Customer's name: Luis\r\n" +
                "Date of Rental: Tue Sep 21 00:00:00 BOT 2021\r\n" +
                "Date of Returning: Fri Oct 01 00:00:00 BOT 2021\r\n" +
                "Has customer paid?: true\r\n" +
                "Total: 150.0\r\n" +
                "Penalty Fee: 0.0\r\n",outContent.toString());
    }
}