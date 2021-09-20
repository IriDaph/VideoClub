package com.assuretraining.main.ui.command;

import com.assuretraining.main.club.rental.Rental;
import com.assuretraining.main.ui.Menu;

public class ModifyDateCommand implements Command {
    public void runCommand(Menu menu) throws Exception {
        System.out.println("Enter rental's  id: ");
        String rentalId = menu.reader.getString();
        Rental rental = menu.searchRentalInventory(rentalId);
        while (rental == null){
            System.out.println("A rental with that id doesn't exist, enter another id: ");
            rentalId = menu.reader.getString();
            rental = menu.searchRentalInventory(rentalId);
        }
        System.out.println("Enter new date (dd/mm/yyyy): ");
        String date = menu.reader.getDate();
        rental.setDateOfRental(date);
        rental.calculateDayOfReturning();
    }
}
