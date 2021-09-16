package com.assuretraining.main.inventory;

import com.assuretraining.main.club.rental.Rental;

import java.util.ArrayList;
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
}
