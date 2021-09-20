package com.assuretraining.main.ui.command;

import com.assuretraining.main.club.rental.Rental;
import com.assuretraining.main.ui.Menu;

public class CalculatePenaltyCommand implements Command {
    public void runCommand(Menu menu){
        System.out.println("Enter rental's  id: ");
        String rentalId = menu.reader.getString();
        Rental rental = menu.searchRentalInventory(rentalId);
        while (rental == null){
            System.out.println("A rental with that id doesn't exist, enter another id: ");
            rentalId = menu.reader.getString();
            rental = menu.searchRentalInventory(rentalId);
        }
        rental.calculatePenalty();
        System.out.println("Customer "+rental.getCustomer().getId()+" penalty fee is "+rental.getPenaltyFee());

    }
}
