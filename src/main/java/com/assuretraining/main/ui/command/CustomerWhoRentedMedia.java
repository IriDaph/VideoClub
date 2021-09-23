package com.assuretraining.main.ui.command;

import com.assuretraining.main.club.customer.Customer;
import com.assuretraining.main.club.media.Media;
import com.assuretraining.main.club.media.Movie;
import com.assuretraining.main.club.media.Videogame;
import com.assuretraining.main.ui.Menu;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

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
