package com.assuretraining.main.ui.command;

import com.assuretraining.main.club.rental.Rental;
import com.assuretraining.main.ui.Menu;

public class ModifyDateCommand {
    public void runCommand(Menu menu) throws Exception {
        System.out.println("Enter rental's  id: ");
        String rentalId = menu.reader.getString();
        Rental rental = menu.searchRentalById(rentalId);

        System.out.println("Enter new date (dd/mm/yyyy): ");
        String date = menu.reader.getDate();

        rental.setDateOfRental(date);
        rental.calculateDayOfReturning();
    }
}
