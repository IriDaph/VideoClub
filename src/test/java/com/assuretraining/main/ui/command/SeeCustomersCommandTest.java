package com.assuretraining.main.ui.command;

import com.assuretraining.main.club.customer.Customer;
import com.assuretraining.main.ui.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SeeCustomersCommandTest {

    Command command = new SeeCustomersCommand();
    @Test
    void runCommand_ShouldShowMessageIfEmpty() throws Exception {
        Menu menu;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        menu = new Menu(System.in);
        command.runCommand(menu);
        Assertions.assertTrue(menu.customers.isInventoryEmpty());
        Assertions.assertEquals("There isn't any customers yet\r\n",outContent.toString());
    }
    @Test
    void runCommand_ShouldShowCustomers() throws Exception {
        Menu menu;
        Customer c1 = new Customer("100","Ana","Martinez","","77992299");
        Customer c2 = new Customer("200","Luis","Killman","","77999999");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        menu = new Menu(System.in);

        menu.customers.add(c1);
        menu.customers.add(c2);

        command.runCommand(menu);
        Assertions.assertEquals("Id: 100\r\n" +
                "Name: Ana\r\n" +
                "Lastname: Martinez\r\n" +
                "Cellphone: 77992299\r\n" +
                "Reward Points: 0\r\n" +
                "Id: 200\r\n" +
                "Name: Luis\r\n" +
                "Lastname: Killman\r\n" +
                "Cellphone: 77999999\r\n" +
                "Reward Points: 0\r\n",outContent.toString());
    }
}