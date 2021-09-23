package com.assuretraining.main.ui.command;

import com.assuretraining.main.ui.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class InvalidChoiceCommandTest {

    Command command = new InvalidChoiceCommand();
    @Test
    void runCommand_ShouldShowInvalid() throws Exception {
        Menu menu;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        menu = new Menu(System.in);
        command.runCommand(menu);
        Assertions.assertEquals("Not a valid option\r\n",outContent.toString());
    }
}