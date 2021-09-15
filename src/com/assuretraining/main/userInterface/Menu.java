package com.assuretraining.main.userInterface;

import com.assuretraining.main.videoClubClasses.customer.Customer;
import com.assuretraining.main.videoClubClasses.media.Media;
import com.assuretraining.main.videoClubClasses.media.Movie;
import com.assuretraining.main.videoClubClasses.media.MusicAlbum;
import com.assuretraining.main.videoClubClasses.media.Videogame;
import com.assuretraining.main.videoClubClasses.rental.Rental;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    private final Scanner reader;
    private final List<Customer> customers;
    private final List<Media> ownedMedia;
    private final List<Rental> rentals;
    public Menu(){
        this.reader  = new Scanner(System.in);
        this.customers = new ArrayList<>();
        this.ownedMedia = new ArrayList<>();
        this.rentals = new ArrayList<>();


    }

    private String getString() {
        return this.reader.nextLine();
    }

    public void startMenu() throws Exception {
       Boolean isMenuOn = true;
       while (isMenuOn) {
           System.out.println("******************************************************");
           System.out.println("1. Add a customer");
           System.out.println("2. Add a movie ");
           System.out.println("3. Add a music album");
           System.out.println("4. Add a video game");
           System.out.println("5. Add a rental");
           System.out.println("6. See all customers ");
           System.out.println("7. See all media");
           System.out.println("8. See all rentals");
           System.out.println("9. Calculate a penalty fee");
           System.out.println("(10. Modify return date of rental:)");
           System.out.println("0. Exit");
           System.out.println("******************************************************");
           System.out.println("Enter an option: ");
           String choice = getString();
           switch (choice) {
               case "0":
                   System.out.println("Goodbye");
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
                   System.out.println("Not a valid option");
                   break;
           }
       }
    }

    private void modifyReturnOfRental() throws Exception {
        System.out.println("Enter rental's  id: ");
        String rentalId = getString();
        Rental rental = searchRentalById(rentalId);
        while (rental == null){
            System.out.println("A rental with that id doesn't exist, enter another id: ");
            rentalId = getString();
            rental = searchRentalById(rentalId);
        }
        Pattern p = Pattern.compile("^(?:(?:31(/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(/)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");

        System.out.println("Enter new date (dd/mm/yyyy): ");
        String date = getString();
        Matcher match = p.matcher(date);
        boolean ans = match.matches();
        while (!ans){
            System.out.println("Please enter a VALID date in the format dd/mm/yyyy:");
            date = this.reader.nextLine();
            match = p.matcher(date);
            ans = match.matches();
        }

        rental.setDateOfRental(date);
        rental.calculateDayOfReturning();
    }

    public void seeAllMedia(){
        if (ownedMedia.isEmpty()){
            System.out.println("There isn't any media yet");
        }
        for (Media media: ownedMedia){
            media.printMedia();
        }
    }
    public void seeAllCustomer(){
        if (customers.isEmpty()){
            System.out.println("There aren't any customers  yet");
        }
        for (Customer customer: customers){
            customer.printCustomer();
        }
    }
    public  void seeAllRentals(){
        if (rentals.isEmpty()){
            System.out.println("There aren't any rentals yet");
        }
        for (Rental rental: rentals){
            rental.printRental();
        }
    }

    public void calculatePenaltyFee(){
        System.out.println("Enter rental's  id: ");
        String rentalId = getString();
        Rental rental = searchRentalById(rentalId);
        while (rental == null){
            System.out.println("A rental with that id doesn't exist, enter another id: ");
            rentalId = getString();
            rental = searchRentalById(rentalId);
        }
        rental.calculatePenalty();
        System.out.println("Customer "+rental.getCustomer().getId()+" penalty fee is "+rental.getPenaltyFee());

    }

    public void createCustomer(){
        System.out.println("Enter customers id: ");
        String id = getString();
        System.out.println("Enter customer's name: ");
        String name = getString();
        System.out.println("Enter customer's lastname: ");
        String lastname = getString();
        System.out.println("Enter customer's address: ");
        String address = getString();
        System.out.println("Enter customer's cellphone: ");
        String cellphone = getString();

        Customer customer = new Customer(id,name,lastname,address,cellphone);
        this.customers.add(customer);
    }

    public void createMovie() throws Exception {
        System.out.println("Enter movie's uid: ");
        String uid = getString();

        System.out.println("Enter movie's description: ");
        String description = getString();

        double cost = 0;
        System.out.println("Enter movie's cost per day: ");
        while (this.reader.hasNext()){

            if (this.reader.hasNextDouble()) {
                cost = this.reader.nextDouble();
                break;
            } else {
                System.out.println("Please enter cost per day as a decimal number like this: 4,50");
                this.reader.next();
            }
        }

        this.reader.nextLine(); //This is a workaround since scanner nextDouble doesn't read the newline character
        System.out.println("Enter movie's name: ");
        String name =getString();

        Pattern p = Pattern.compile("^(?:(?:31(/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(/)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");

        System.out.println("Enter movie's date of release(dd/mm/yyyy): ");
        String date0fRelease = getString();
        Matcher match = p.matcher(date0fRelease);
        boolean ans = match.matches();
        while (!ans){
            System.out.println("Please enter a VALID date in the format dd/mm/yyyy:");
            date0fRelease = this.reader.nextLine();
            match = p.matcher(date0fRelease);
            ans = match.matches();
        }

        System.out.println("Enter movie's imdb ");
        double imdb = 0;
        while (this.reader.hasNext()){

            if (this.reader.hasNextDouble()) {
                imdb = this.reader.nextDouble();
                break;
            } else {
                System.out.println("Please enter a decimal number for imdb ex:20,4");
                this.reader.next();
            }
        }
        reader.nextLine(); //This is a workaround since scanner nextDouble doesn't read the newline character

        System.out.println("Enter movie's director: ");
        String director = getString();

        Boolean answer = true;
        List<String> cast = new ArrayList<String>();
        while (answer){
            System.out.println("Enter an actors/actress name: ");
            String actor = getString();
            cast.add(actor);
            System.out.println("Do you want to add another actor/actress? y/n: ");
            String userAnswer = getString();
            if (userAnswer.equals("n")){
                answer = false;
            }
        }
        System.out.println("Enter movie's genre: ");
        String genre = getString();

        System.out.println("Enter movie's duration (ex: 2:30): ");
        String duration = getString();

        System.out.println("Enter movie's country of Origin: ");
        String countryOfOrigin = getString();

        Movie movie = new Movie(description,cost,name,uid,date0fRelease,imdb,director,cast,duration,genre,countryOfOrigin);
        this.ownedMedia.add(movie);
    }

    public void createVideogame() throws Exception {
        System.out.println("Enter videogame's uid: ");
        String uid = getString();
        System.out.println("Enter videogame's description: ");
        String description = getString();

        double cost = 0;
        System.out.println("Enter videogame's cost per day: ");
        while (this.reader.hasNext()){

            if (this.reader.hasNextDouble()) {
                cost = this.reader.nextDouble();
                break;
            } else {
                System.out.println("Please enter cost per day as a decimal number like this: 4,50");
                this.reader.next();
            }
        }

        this.reader.nextLine(); //This is a workaround since scanner nextDouble doesn't read the newline character

        System.out.println("Enter videogame's name: ");
        String name =getString();

        Pattern p = Pattern.compile("^(?:(?:31(/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(/)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");

        System.out.println("Enter videogame's date of release(dd/mm/yyyy): ");
        String date0fRelease = getString();
        Matcher match = p.matcher(date0fRelease);
        boolean ans = match.matches();
        while (!ans){
            System.out.println("Please enter a VALID date in the format dd/mm/yyyy:");
            date0fRelease = this.reader.nextLine();
            match = p.matcher(date0fRelease);
            ans = match.matches();
        }
        System.out.println("Enter videogame's rating ");
        double rating = 0;
        while (this.reader.hasNext()){

            if (this.reader.hasNextDouble()) {
                rating = this.reader.nextDouble();
                break;
            } else {
                System.out.println("Please enter a decimal number for rating ex:4,5");
                this.reader.next();
            }
        }
        reader.nextLine(); //This is a workaround since scanner nextDouble doesn't read the newline character

        Boolean answer = true;
        List<String> platforms = new ArrayList<String>();
        while (answer){
            System.out.println("Enter platform: ");
            String platform = getString();
            platforms.add(platform);
            System.out.println("Do you want to add another platform? y/n: ");
            String userAnswer = getString();
            if (userAnswer.equals("n")){
                answer = false;
            }
        }
        System.out.println("Enter videogames's developer: ");
        String developer = getString();

        System.out.println("Enter type of game: ");
        String typeOfGame = getString();

        Videogame videogame = new Videogame(uid,description,cost,name,date0fRelease,rating,platforms,developer,typeOfGame);
        this.ownedMedia.add(videogame);
    }
    public void createMusicAlbum() throws Exception {
        System.out.println("Enter music album's uid: ");
        String uid = getString();
        System.out.println("Enter music album's description: ");
        String description = getString();

        double cost = 0;
        System.out.println("Enter music album's cost per day: ");
        while (this.reader.hasNext()){

            if (this.reader.hasNextDouble()) {
                cost = this.reader.nextDouble();
                break;
            } else {
                System.out.println("Please enter cost per day as a decimal number like this: 4,50");
                this.reader.next();
            }
        }

        this.reader.nextLine(); //This is a workaround since scanner nextDouble doesn't read the newline character

        System.out.println("Enter music album's name: ");
        String name =getString();

        Pattern p = Pattern.compile("^(?:(?:31(/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(/)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");

        System.out.println("Enter music album's date of release(dd/mm/yyyy): ");
        String date0fRelease = getString();
        Matcher match = p.matcher(date0fRelease);
        boolean ans = match.matches();
        while (!ans){
            System.out.println("Please enter a VALID date in the format dd/mm/yyyy:");
            date0fRelease = this.reader.nextLine();
            match = p.matcher(date0fRelease);
            ans = match.matches();
        }

        System.out.println("Enter music album's artist: ");
        String artist =getString();

        System.out.println("Enter music album's number of tracks: ");
        Integer numberTracks = 0;
        while (this.reader.hasNext()){

            if (this.reader.hasNextInt()) {
                numberTracks = this.reader.nextInt();
                break;
            } else {
                System.out.println("Please enter a number");
                this.reader.next();
            }
        }
        this.reader.nextLine(); //This is a workaround since scanner nextInt doesn't read the newline character

        System.out.println("Enter music album's genre: ");
        String genre = getString();

        MusicAlbum musicAlbum = new MusicAlbum(uid,cost,name,description,date0fRelease,artist,numberTracks,genre);
        this.ownedMedia.add(musicAlbum);
    }

    public void createRental(){
        if( !customers.isEmpty() && !ownedMedia.isEmpty()) {
            System.out.println("Enter rental's id: ");
            String id = getString();
            System.out.println("Enter rental's media uid: ");
            String mediaUid = getString();
            Media media = searchMediaByUid(mediaUid);
            while (media == null) {
                System.out.println("A media with that Uid doesn't exist, enter another Uid ");
                mediaUid = getString();
                media = searchMediaByUid(mediaUid);
            }

            System.out.println("Enter rental's customers id: ");
            String customerId = getString();
            Customer customer = searchCustomerById(customerId);
            while (customer == null) {
                System.out.println("A customer with that id doesn't exist, enter another id: ");
                customerId = getString();
                customer = searchCustomerById(customerId);
            }

            System.out.println("Enter rental's number of days: ");
            Integer numberOfDays = 0;
            while (this.reader.hasNext()) {

                if (this.reader.hasNextInt()) {
                    numberOfDays = this.reader.nextInt();
                    break;
                } else {
                    System.out.println("Please enter a number");
                    this.reader.next();
                }
            }
            this.reader.nextLine(); //This is a workaround since scanner nextInt doesn't read the newline character

            System.out.println("Is the customer paying in advance y/n: ");
            boolean isPaid;
            String paying = getString();
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
        Customer askedCustomer = null;
        for (Customer  customer: this.customers){
            if(customerId.equals(customer.getId())){
                askedCustomer = customer;
            }
        }
        return askedCustomer;
    }

    private Media searchMediaByUid(String mediaUid) {
        Media askedMedia = null;
        for (Media  media: this.ownedMedia){
            if(mediaUid.equals(media.getUid())){
                askedMedia = media;
            }
        }
        return askedMedia;
    }

    private Rental searchRentalById(String rentalId){
        Rental askedRental = null;
        for (Rental  rental: this.rentals){
            if(rentalId.equals(rental.getId())){
                askedRental = rental;
            }
        }
        return askedRental;
    }

}
