package com.assuretraining.main.ui.command;

import com.assuretraining.main.club.rental.Rental;
import com.assuretraining.main.ui.Menu;

public class CalculatePenaltyCommand {
    public void runCommand(Menu menu){
        System.out.println("Enter rental's  id: ");
        String rentalId = menu.reader.getString();
        Rental rental = menu.searchRentalById(rentalId);

        rental.calculatePenalty();
        System.out.println("Customer "+rental.getCustomer().getId()+" penalty fee is "+rental.getPenaltyFee());

    }
}
