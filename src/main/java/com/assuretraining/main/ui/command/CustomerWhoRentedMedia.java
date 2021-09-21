package com.assuretraining.main.ui.command;

import com.assuretraining.main.ui.Menu;

public class CustomerWhoRentedMedia implements Command{
    @Override
    public void runCommand(Menu menu) throws Exception {
        String mediaUid;
        System.out.println("Which media are you searching: ");
        mediaUid = menu.reader.getString();
        System.out.println("The customers who rented this media are: ");
        menu.rentals.searchCustomersWhoRentedMedia(mediaUid);
    }
}
