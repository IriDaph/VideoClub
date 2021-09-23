package com.assuretraining.main.inventory;

import com.assuretraining.main.club.customer.Customer;

import java.util.ArrayList;
import java.util.Collections;
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
    public List getInventory() {
        return customerInventory;
    }

    @Override
    public Object searchByIdentifier(String id) {
        Customer askedCustomer = null;
        for (Customer  customer: this.customerInventory){
            if(id.equals(customer.getId())) {
                askedCustomer = customer;
            }
        }
        return askedCustomer;
    }

    @Override
    public boolean isInventoryEmpty() {
        return customerInventory.isEmpty();
    }

    @Override
    public void sortInventory() {
        int i,j,comparison;
        boolean swapped;
        Customer customer1;
        Customer customer2;

        int inventorySize = customerInventory.size();
        for (i = 0; i < inventorySize -1; i++){
            swapped = false;
            for (j =0; j< inventorySize-i-1; j++){
                customer1 = customerInventory.get(j);
                customer2 = customerInventory.get(j+1);
                comparison = customer1.getName().trim().compareTo(customer2.getName().trim());
                if (comparison > 0 ){
                    Collections.swap(customerInventory,j,j+1);
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }
    }

}
