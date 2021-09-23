package com.assuretraining.main.ui.command;

import com.assuretraining.main.ui.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CreateVideoGameCommandTest {
    Command command = new CreateVideoGameCommand();

    @Test
    void runCommand_ShouldCreateAndAddMovie() throws Exception {
        Menu menu;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String input = "123ABC\n" +
                "Una Descripcion Valida\n" +
                "4,50\n" +
                "The Videogame\n" +
                "02/08/2021\n" +
                "7,9\n" +
                "PC\ny\nXbox\nn\n" +
                "Bethesda\n" +
                "Horror\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        menu = new Menu(in);
        command.runCommand(menu);
        Assertions.assertFalse(menu.ownedMedia.isInventoryEmpty());

    }
}