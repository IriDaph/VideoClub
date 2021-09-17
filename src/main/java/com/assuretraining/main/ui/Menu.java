package com.assuretraining.main.ui;

import com.assuretraining.main.club.customer.Customer;
import com.assuretraining.main.club.media.*;
import com.assuretraining.main.club.rental.Rental;
import com.assuretraining.main.inventory.CustomerInventory;
import com.assuretraining.main.inventory.Inventory;
import com.assuretraining.main.inventory.MediaInventory;
import com.assuretraining.main.inventory.RentalInventory;
import com.assuretraining.main.ui.command.*;

import java.util.HashMap;


public class Menu {
    public final ScannerActions reader;
    public Inventory customers;
    public Inventory ownedMedia;
    public Inventory rentals;
    public Boolean isMenuOn;

    public Menu(){
        this.reader  = new ScannerActions();
        this.customers = new CustomerInventory();
        this.ownedMedia = new MediaInventory();
        this.rentals = new RentalInventory();
        this.isMenuOn = true;
    }

    public void startMenu() throws Exception {
       String choice;
       while (isMenuOn) {
           printOptions();
           choice = reader.getString();
           createCommandBuilder(choice).runCommand(this);

       }
    }

    private Command createCommandBuilder(String choice) {
        Command command;
        HashMap<String,Command> commands = new HashMap<String,Command>();
        // commands.put(MenuStrings.INVALID_OPTION,new InvalidChoiceCommand());
        commands.put(MenuStrings.EXIT_MENU,new ExitCommand());
        commands.put(MenuStrings.ADD_CUSTOMER,new CreateCustomerCommand());
        commands.put(MenuStrings.ADD_MOVIE,new CreateMovieCommand());
        commands.put(MenuStrings.ADD_MUSIC,new CreateMusicAlbumCommand());
        commands.put(MenuStrings.ADD_VIDEO_GAME,new CreateVideoGameCommand());
        commands.put(MenuStrings.ADD_RENTAL,new CreateRentalCommand());
        commands.put(MenuStrings.SEE_CUSTOMERS, new SeeCustomersCommand());
        commands.put(MenuStrings.SEE_MEDIA, new SeeMediaCommand());
        commands.put(MenuStrings.SEE_RENTALS, new SeeRentalsCommand());
        commands.put(MenuStrings.CALCULATE_PENALTY_FEE, new CalculatePenaltyCommand());
        commands.put(MenuStrings.MODIFY_RETURN_DATE, new ModifyDateCommand());
        return commands.get(choice);
    }

    private void printOptions() {
        System.out.println(MenuStrings.DECORATION);
        System.out.println(MenuStrings.ADD_CUSTOMER_DESCRIPTION);
        System.out.println(MenuStrings.ADD_MOVIE_DESCRIPTION);
        System.out.println(MenuStrings.ADD_MUSIC_DESCRIPTION);
        System.out.println(MenuStrings.ADD_VIDEO_GAME_DESCRIPTION);
        System.out.println(MenuStrings.ADD_RENTAL_DESCRIPTION);
        System.out.println(MenuStrings.SEE_CUSTOMERS_DESCRIPTION);
        System.out.println(MenuStrings.SEE_MEDIA_DESCRIPTION);
        System.out.println(MenuStrings.SEE_RENTALS_DESCRIPTION);
        System.out.println(MenuStrings.CALCULATE_PENALTY_FEE_DESCRIPTION);
        System.out.println(MenuStrings.MODIFY_RETURN_DATE_DESCRIPTION);
        System.out.println(MenuStrings.EXIT_MENU_DESCRIPTION);
        System.out.println(MenuStrings.DECORATION);
        System.out.println(MenuStrings.ENTER_OPTION);
    }

    public Customer searchCustomerById(String customerId) {
        Customer askedCustomer = (Customer) customers.searchByIdentifier(customerId);

        return askedCustomer;
    }
    public Media searchMediaByUid(String mediaUid) {
        Media askedMedia = (Media) ownedMedia.searchByIdentifier(mediaUid);
        while (askedMedia == null) {
            System.out.println("A media with that Uid doesn't exist, enter another Uid ");
            mediaUid = reader.getString();
            askedMedia = (Media) ownedMedia.searchByIdentifier(mediaUid);
        }
        return askedMedia;
    }

    public Rental searchRentalById(String rentalId){
        Rental askedRental = (Rental) rentals.searchByIdentifier(rentalId);
        while (askedRental == null){
            System.out.println("A rental with that id doesn't exist, enter another id: ");
            rentalId = reader.getString();
            askedRental = (Rental) rentals.searchByIdentifier(rentalId);
        }
        return askedRental;
    }
}
