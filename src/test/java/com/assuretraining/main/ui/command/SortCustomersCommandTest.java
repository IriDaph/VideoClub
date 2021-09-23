package com.assuretraining.main.ui.command;

import com.assuretraining.main.club.customer.Customer;
import com.assuretraining.main.ui.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortCustomersCommandTest {

    Command command = new SortCustomersCommand();
    @Test
    void runCommand_ShouldSortCustomers() throws Exception {
        Menu menu = new Menu(System.in);
        Customer c1 = new Customer("100","Ana","Martinez","","77992299");
        Customer c2 = new Customer("200","Luis","Killman","","77999999");
        menu.customers.add(c2);
        menu.customers.add(c1);
        List<Customer> manuallyOrderedList = new ArrayList<>();
        manuallyOrderedList.add(c1);
        manuallyOrderedList.add(c2);
        command.runCommand(menu);
        Assertions.assertEquals(manuallyOrderedList,menu.customers.getInventory());
    }
}