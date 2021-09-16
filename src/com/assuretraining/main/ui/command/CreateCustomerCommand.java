package com.assuretraining.main.ui.command;

import com.assuretraining.main.club.customer.Customer;
import com.assuretraining.main.ui.Menu;

public class CreateCustomerCommand implements Command {

    public void runCommand(Menu menu){
        System.out.println("Enter customers id: ");
        String id = menu.reader.getString();
        System.out.println("Enter customer's name: ");
        String name = menu.reader.getString();
        System.out.println("Enter customer's lastname: ");
        String lastname = menu.reader.getString();
        System.out.println("Enter customer's address: ");
        String address = menu.reader.getString();
        System.out.println("Enter customer's cellphone: ");
        String cellphone = menu.reader.getString();
        Customer customer = new Customer(id,name,lastname,address,cellphone);
        menu.customers.add(customer);
    }
}
