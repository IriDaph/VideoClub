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

    private CreateCustomerCommand createCustomerCommand = new CreateCustomerCommand();
    private CreateMovieCommand createMovieCommand = new CreateMovieCommand();
    private CreateMusicAlbumCommand createMusicAlbumCommand = new CreateMusicAlbumCommand();
    private CreateVideoGameCommand createVideoGameCommand = new CreateVideoGameCommand();
    private CreateRentalCommand createRentalCommand = new CreateRentalCommand();
    private SeeCustomersCommand seeCustomersCommand = new SeeCustomersCommand();
    private SeeMediaCommand seeMediaCommand = new SeeMediaCommand();
    private SeeRentalsCommand seeRentalsCommand = new SeeRentalsCommand();
    private CalculatePenaltyCommand calculatePenaltyCommand = new CalculatePenaltyCommand();
    private ModifyDateCommand modifyDateCommand = new ModifyDateCommand();
    private InvalidChoiceCommand invalidChoiceCommand = new InvalidChoiceCommand();

    public Menu(){
        this.reader  = new ScannerActions();
        this.customers = new CustomerInventory();
        this.ownedMedia = new MediaInventory();
        this.rentals = new RentalInventory();


    }


    public void startMenu() throws Exception {
       Boolean isMenuOn = true;
       String choice;
       while (isMenuOn) {
           printOptions();
           choice = reader.getString();

           switch (choice) {
               case "0":
                   System.out.println(MenuStrings.FAREWELL);
                   isMenuOn = false;
                   break;
               case "1":
                   createCustomerCommand.createCustomer(this);
                   break;
               case "2":
                   createMovieCommand.createMovie(this);
                   break;
               case "3":
                   createMusicAlbumCommand.createMusicAlbum(this);
                   break;
               case "4":
                   createVideoGameCommand.createVideogame(this);
                   break;
               case "5":
                   createRentalCommand.createRental(this);
                   break;
               case "6":
                  seeCustomersCommand.seeAllCustomer(this);
                   break;
               case "7":
                   seeMediaCommand.seeAllMedia(this);
                   break;
               case "8" :
                   seeRentalsCommand.seeAllRentals(this);
                   break;
               case "9":
                   calculatePenaltyCommand.calculatePenaltyFee(this);
                   break;
               case  "10":
                   modifyDateCommand.modifyReturnOfRental(this);
                   break;
               default:
                   invalidChoiceCommand.invalidChoice(this);
                   break;
           }

       }
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
