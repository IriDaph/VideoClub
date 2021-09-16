package com.assuretraining.main.ui;

import com.assuretraining.main.club.customer.Customer;
import com.assuretraining.main.club.media.*;
import com.assuretraining.main.club.rental.Rental;
import com.assuretraining.main.inventory.CustomerInventory;
import com.assuretraining.main.inventory.MediaInventory;
import com.assuretraining.main.inventory.RentalInventory;
import com.assuretraining.main.ui.command.CommandExecutor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Menu {
    private final ScannerActions reader;
    HashMap<String, CommandExecutor> context=new HashMap<String, CommandExecutor>();
    private CustomerInventory customers;
    private MediaInventory ownedMedia;
    private RentalInventory rentals;
    public Menu(){
        this.reader  = new ScannerActions();
        this.customers = new CustomerInventory();
        this.ownedMedia = new MediaInventory();
        this.rentals = new RentalInventory();


    }


    public void startMenu() throws Exception {
       Boolean isMenuOn = true;
       String choice = "";
       while (isMenuOn) {
           printOptions();
           choice = reader.getString();
           switch (choice) {
               case "0":
                   System.out.println(MenuStrings.FAREWELL);
                   isMenuOn = false;
                   break;
               case "1":
                   createCustomer();
                   break;
               case "2":
                   createMovie();
                   break;
               case "3":
                   createMusicAlbum();
                   break;
               case "4":
                   createVideogame();
                   break;
               case "5":
                   createRental();
                   break;
               case "6":
                  seeAllCustomer();
                   break;
               case "7":
                   seeAllMedia();
                   break;
               case "8" :
                   seeAllRentals();
                   break;
               case "9":
                   calculatePenaltyFee();
                   break;
               case  "10":
                   modifyReturnOfRental();
                   break;
               default:
                   System.out.println(MenuStrings.INVALID_OPTION);
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

    private void modifyReturnOfRental() throws Exception {
        System.out.println("Enter rental's  id: ");
        String rentalId = reader.getString();
        Rental rental = searchRentalById(rentalId);

        System.out.println("Enter new date (dd/mm/yyyy): ");
        String date = reader.getDate();

        rental.setDateOfRental(date);
        rental.calculateDayOfReturning();
    }

    public void seeAllMedia(){
        if (ownedMedia.isInventoryEmpty()) {
            System.out.println("There isn't any media yet");
        }
        ownedMedia.printInventory();
    }
    public void seeAllCustomer(){
        if (customers.isInventoryEmpty()) {
            System.out.println("There isn't any customers yet");
        }
        customers.printInventory();
    }
    public  void seeAllRentals(){
        if (rentals.isInventoryEmpty()) {
            System.out.println("There aren't any rentals yet");
        }
        rentals.printInventory();
    }

    public void calculatePenaltyFee(){
        System.out.println("Enter rental's  id: ");
        String rentalId = reader.getString();
        Rental rental = searchRentalById(rentalId);

        rental.calculatePenalty();
        System.out.println("Customer "+rental.getCustomer().getId()+" penalty fee is "+rental.getPenaltyFee());

    }

    public void createCustomer(){
        System.out.println("Enter customers id: ");
        String id = reader.getString();
        System.out.println("Enter customer's name: ");
        String name = reader.getString();
        System.out.println("Enter customer's lastname: ");
        String lastname = reader.getString();
        System.out.println("Enter customer's address: ");
        String address = reader.getString();
        System.out.println("Enter customer's cellphone: ");
        String cellphone = reader.getString();

        Customer customer = new Customer(id,name,lastname,address,cellphone);
        this.customers.add(customer);
    }

    public void createMovie() throws Exception {
        System.out.println("Enter movie's uid: ");
        String uid = reader.getString();

        System.out.println("Enter movie's description: ");
        String description = reader.getString();

        System.out.println("Enter movie's cost per day: ");
        double cost = reader.getDouble();

        System.out.println("Enter movie's name: ");
        String name =reader.getString();

        System.out.println("Enter movie's date of release(dd/mm/yyyy): ");
        String date0fRelease = reader.getDate();

        System.out.println("Enter movie's imdb ");
        double imdb = reader.getDouble();



        System.out.println("Enter movie's director: ");
        String director = reader.getString();
        System.out.println("Enter an actors/actress name: ");
        List<String> cast = reader.getStringList("actor");

        System.out.println("Enter movie's genre: ");
        String genre = reader.getString();

        System.out.println("Enter movie's duration (ex: 2:30): ");
        String duration = reader.getString();

        System.out.println("Enter movie's country of Origin: ");
        String countryOfOrigin = reader.getString();

        Movie movie = new Movie(description,cost,name,uid,date0fRelease,imdb,director,cast,duration,genre,countryOfOrigin);
        this.ownedMedia.add(movie);
    }

    public void createVideogame() throws Exception {
        System.out.println("Enter videogame's uid: ");
        String uid = reader.getString();
        System.out.println("Enter videogame's description: ");
        String description = reader.getString();

        System.out.println("Enter videogame's cost per day: ");
        double cost = reader.getDouble();

        System.out.println("Enter videogame's name: ");
        String name = reader.getString();

        System.out.println("Enter videogame's date of release(dd/mm/yyyy): ");
        String date0fRelease = reader.getDate();

        System.out.println("Enter videogame's rating ");
        double rating = reader.getDouble();

        System.out.println("Enter platform: ");
        List<String> platforms = reader.getStringList("platform");

        System.out.println("Enter videogames's developer: ");
        String developer = reader.getString();

        System.out.println("Enter type of game: ");
        String typeOfGame = reader.getString();

        Videogame videogame = new Videogame(uid,description,cost,name,date0fRelease,rating,platforms,developer,typeOfGame);
        this.ownedMedia.add(videogame);
    }
    public void createMusicAlbum() throws Exception {
        System.out.println("Enter music album's uid: ");
        String uid = reader.getString();

        System.out.println("Enter music album's description: ");
        String description = reader.getString();

        System.out.println("Enter album's cost per day: ");
        double cost = reader.getDouble();


        System.out.println("Enter music album's name: ");
        String name = reader.getString();

        System.out.println("Enter music album's date of release(dd/mm/yyyy): ");
        String date0fRelease = reader.getDate();

        System.out.println("Enter music album's artist: ");
        String artist = reader.getString();

        System.out.println("Enter music album's number of tracks: ");
        Integer numberTracks = reader.getInteger();


        System.out.println("Enter music album's genre: ");
        String genre = reader.getString();

        MusicAlbum musicAlbum = new MusicAlbum(uid,cost,name,description,date0fRelease,artist,numberTracks,genre);
        this.ownedMedia.add(musicAlbum);
    }

    public void createRental(){
        if( !customers.isInventoryEmpty() && !ownedMedia.isInventoryEmpty()) {
            System.out.println("Enter rental's id: ");
            String id = reader.getString();
            System.out.println("Enter rental's media uid: ");
            String mediaUid = reader.getString();
            Media media = searchMediaByUid(mediaUid);

            System.out.println("Enter rental's customers id: ");
            String customerId = reader.getString();
            Customer customer = searchCustomerById(customerId);

            System.out.println("Enter rental's number of days: ");
            Integer numberOfDays = reader.getInteger();

            System.out.println("Is the customer paying in advance y/n: ");
            boolean isPaid;
            String paying = reader.getString();
            isPaid = paying.equals("y");

            Rental rental = new Rental(id, media, customer, numberOfDays, isPaid);
            customer.calculateRewardPoints(numberOfDays * media.getCostPerDay());
            this.rentals.add(rental);
        }
        else {
            System.out.println("There aren't any media or customers added yet, you can't add a Rental without those.");
        }
    }

    private Customer searchCustomerById(String customerId) {
        Customer askedCustomer = (Customer) customers.searchByIdentifier(customerId);
        while (askedCustomer == null) {
            System.out.println("A customer with that id doesn't exist, enter another id: ");
            customerId = reader.getString();
            askedCustomer = (Customer) customers.searchByIdentifier(customerId);
        }
        return askedCustomer;
    }

    private Media searchMediaByUid(String mediaUid) {
        Media askedMedia = (Media) ownedMedia.searchByIdentifier(mediaUid);
        while (askedMedia == null) {
            System.out.println("A media with that Uid doesn't exist, enter another Uid ");
            mediaUid = reader.getString();
            askedMedia = (Media) ownedMedia.searchByIdentifier(mediaUid);
        }
        return askedMedia;
    }

    private Rental searchRentalById(String rentalId){
        Rental askedRental = (Rental) rentals.searchByIdentifier(rentalId);
        while (askedRental == null){
            System.out.println("A rental with that id doesn't exist, enter another id: ");
            rentalId = reader.getString();
            askedRental = (Rental) rentals.searchByIdentifier(rentalId);
        }
        return askedRental;
    }

}
