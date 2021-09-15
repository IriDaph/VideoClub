package com.assuretraining.main.inventory;

import com.assuretraining.main.videoClubClasses.customer.Customer;
import com.assuretraining.main.videoClubClasses.media.Media;

import java.util.ArrayList;
import java.util.List;

public class CustomerInventory implements Inventory {
    private final List<Customer> customerInventory;

    public CustomerInventory() {
        customerInventory = new ArrayList<>();
    }

    @Override
    public void add(Object object) {
        customerInventory.add((Customer) object);
    }

    @Override
    public void printInventory() {
        for(Customer customer:customerInventory){
            customer.printCustomer();
        }
    }
}
