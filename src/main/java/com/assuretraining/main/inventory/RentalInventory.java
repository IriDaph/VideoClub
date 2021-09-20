package com.assuretraining.main.inventory;

import com.assuretraining.main.club.customer.Customer;
import com.assuretraining.main.club.rental.Rental;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RentalInventory implements Inventory{
    private final List<Rental> rentalInventory;

    public RentalInventory() {
        this.rentalInventory = new ArrayList<>();
    }

    @Override
    public void add(Object object) {
        rentalInventory.add((Rental) object);
    }

    @Override
    public void printInventory() {
        for (Rental rental:rentalInventory){
            rental.printRental();
        }
    }

    @Override
    public Object searchByIdentifier(String id) {
        Rental askedRental = null;
        for (Rental  rental: this.rentalInventory){
            if(id.equals(rental.getId())){
                askedRental = rental;
            }
        }
        return askedRental;
    }

    @Override
    public boolean isInventoryEmpty() {
        return rentalInventory.isEmpty();
    }

    @Override
    public void sortInventoryById() {
        int i,j,comparison;
        boolean swapped;
        Rental rental1;
        Rental rental2;
        int inventorySize = rentalInventory.size();
        for (i = 0; i < inventorySize -1; i++){
            swapped = false;
            for (j =0; j< inventorySize-i-1; j++){
                rental1 = rentalInventory.get(j);
                rental2 = rentalInventory.get(j+1);
                comparison = rental1.getId().compareTo(rental2.getId());
                if (comparison > 0 ){
                    Collections.swap(rentalInventory,j,j+1);
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }
    }
}
