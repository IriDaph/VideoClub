package com.assuretraining.main.ui;

import com.assuretraining.main.club.customer.Customer;
import com.assuretraining.main.club.media.*;
import com.assuretraining.main.club.rental.Rental;
import com.assuretraining.main.inventory.CustomerInventory;
import com.assuretraining.main.inventory.MediaInventory;
import com.assuretraining.main.inventory.RentalInventory;
import com.assuretraining.main.ui.command.*;


public class Menu {
    public final ScannerActions reader;
    public CustomerInventory customers;
    public MediaInventory ownedMedia;
    public RentalInventory rentals;
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
        switch (choice) {
            case "0":
                command = new ExitCommand();
                break;
            case "1":
                command = new CreateCustomerCommand();
                break;
            case "2":
                command = new CreateMovieCommand();
                break;
            case "3":
                command = new CreateMusicAlbumCommand();
                break;
            case "4":
                command = new CreateVideoGameCommand();
                break;
            case "5":
                command = new CreateRentalCommand();
                break;
            case "6":
                command = new SeeCustomersCommand();
                break;
            case "7":
                command = new SeeMediaCommand();
                break;
            case "8" :
                command = new SeeRentalsCommand();
                break;
            case "9":
                command = new CalculatePenaltyCommand();
                break;
            case  "10":
                command = new ModifyDateCommand();
                break;
            default:
                command = new InvalidChoiceCommand();
                break;
        }
        return command;
    }


    private void printOptions() {
        System.out.println(MenuStrings.DECORATION);
        System.out.println(MenuStrings.ADD_CUSTOMER);
        System.out.println(MenuStrings.ADD_MOVIE);
        System.out.println(MenuStrings.ADD_MUSIC_ALBUM);
        System.out.println(MenuStrings.ADD_VIDEO_GAME);
        System.out.println(MenuStrings.ADD_RENTAL);
        System.out.println(MenuStrings.SEE_CUSTOMERS);
        System.out.println(MenuStrings.SEE_MEDIA);
        System.out.println(MenuStrings.SEE_RENTALS);
        System.out.println(MenuStrings.CALCULATE_PENALTY_FEE);
        System.out.println(MenuStrings.MODIFY_RETURN_DATE);
        System.out.println(MenuStrings.EXIT_MENU);
        System.out.println(MenuStrings.DECORATION);
        System.out.println(MenuStrings.ENTER_OPTION);
    }

    public Customer searchCustomerById(String customerId) {
        Customer askedCustomer = (Customer) customers.searchByIdentifier(customerId);
        while (askedCustomer == null) {
            System.out.println("A customer with that id doesn't exist, enter another id: ");
            customerId = reader.getString();
            askedCustomer = (Customer) customers.searchByIdentifier(customerId);
        }
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
