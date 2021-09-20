package com.assuretraining.main.ui.command;

import com.assuretraining.main.club.customer.Customer;
import com.assuretraining.main.club.media.Media;
import com.assuretraining.main.club.rental.Rental;
import com.assuretraining.main.ui.Menu;

public class CreateRentalCommand implements Command {
    public void runCommand(Menu menu){
        if( !menu.customers.isInventoryEmpty() && !menu.ownedMedia.isInventoryEmpty()) {
            System.out.println("Enter rental's id: ");
            String id = menu.reader.getString();
            System.out.println("Enter rental's media uid: ");
            String mediaUid = menu.reader.getString();
            Media media = menu.searchMediaInventory(mediaUid);
            while (media == null) {
                System.out.println("A media with that Uid doesn't exist, enter another Uid ");
                mediaUid = menu.reader.getString();
                media = menu.searchMediaInventory(mediaUid);
            }
            System.out.println("Enter rental's customers id: ");
            String customerId = menu.reader.getString();
            Customer customer = menu.searchCustomerInventory(customerId);
            while (customer == null) {
                System.out.println("A customer with that id doesn't exist, enter another id ");
                customerId =menu.reader.getString();
                customer = menu.searchCustomerInventory(customerId);
            }
            System.out.println("Enter rental's number of days: ");
            Integer numberOfDays = menu.reader.getInteger();
            menu.reader.getNextLine();
            System.out.println("Is the customer paying in advance y/n: ");
            boolean isPaid;
            String paying = menu.reader.getString();
            isPaid = paying.equals("y");
            Rental rental = new Rental(id, media, customer, numberOfDays, isPaid);
            customer.calculateRewardPoints(numberOfDays * media.getCostPerDay());
            menu.rentals.add(rental);
        }
        else {
            System.out.println("There aren't any media or customers added yet, you can't add a Rental without those.");
        }
    }
}
