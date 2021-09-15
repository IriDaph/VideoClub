package com.assuretraining.main.inventory;

import com.assuretraining.main.videoClubClasses.rental.Rental;

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
}
