package com.assuretraining.main.ui.command;

import com.assuretraining.main.ui.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CreateCustomerCommandTest {
    Command command = new CreateCustomerCommand();

    @Test
    void runCommand_ShouldCreateAndAddCustomer() throws Exception {
        Menu menu;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String input = "123ABC\nAna\nPerez\nAv.America\n78789871\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        menu = new Menu(in);
        command.runCommand(menu);
        Assertions.assertFalse(menu.customers.isInventoryEmpty());

    }
}