package com.assuretraining.main.ui.command;

import com.assuretraining.main.ui.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ExitCommandTest {
    Command command = new ExitCommand();
    @Test
    void runCommand_ShouldShowGoodbye() throws Exception {
        Menu menu;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        menu = new Menu(System.in);
        command.runCommand(menu);
        Assertions.assertEquals("Goodbye!\r\n",outContent.toString());
        Assertions.assertFalse(menu.isMenuOn);
    }
}