package com.assuretraining.main.ui.command;

import com.assuretraining.main.club.customer.Customer;
import com.assuretraining.main.club.media.Media;
import com.assuretraining.main.club.media.Movie;
import com.assuretraining.main.club.media.Videogame;
import com.assuretraining.main.ui.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class SeeMediaCommandTest {
    Command command = new SeeMediaCommand();
    @Test
    void runCommand_ShouldShowMessageIfEmpty() throws Exception {
        Menu menu;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        menu = new Menu(System.in);
        command.runCommand(menu);
        Assertions.assertTrue(menu.ownedMedia.isInventoryEmpty());
        Assertions.assertEquals("There isn't any media yet\r\n",outContent.toString());
    }
    @Test
    void runCommand_ShouldShowMedia() throws Exception {
        Menu menu;
        List<String> lista = mock(ArrayList.class);
        Media movie = new Movie("La peli",5,"The good movie","100A","12/12/2012",100,"Pablo Meneses",lista,"2:30","Comedia","Peru");
        Videogame videogame = new Videogame("100B","Shooter con muchos enemigos",10,"COD","10/07/2014",5.5,lista,"AntonioGames","Shooter");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        menu = new Menu(System.in);

        menu.ownedMedia.add(movie);
        menu.ownedMedia.add(videogame);

        command.runCommand(menu);
        Assertions.assertEquals("Uid: 100A\r\n" +
                "Name: The good movie\r\n" +
                "Description: La peli\r\n" +
                "Cost per Day: 5.0\r\n" +
                "Uid: 100B\r\n" +
                "Name: COD\r\n" +
                "Description: Shooter con muchos enemigos\r\n" +
                "Cost per Day: 10.0\r\n",outContent.toString());
    }
}