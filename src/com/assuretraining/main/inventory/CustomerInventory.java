package com.assuretraining.main.inventory;

import com.assuretraining.main.club.customer.Customer;

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

    @Override
    public Object searchByIdentifier(String id) {
        Customer askedCustomer = null;
        for (Customer  customer: this.customerInventory){
            if(id.equals(customer.getId())){
                askedCustomer = customer;
            }
        }
        return askedCustomer;
    }

    @Override
    public boolean isInventoryEmpty() {
        return customerInventory.isEmpty();
    }
}
