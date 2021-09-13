package com.assuretraining;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    private Scanner reader;
    private List<Customer> customers;
    private List<Media> ownedMedia;
    public Menu(){
        this.reader  = new Scanner(System.in);
        this.customers = new ArrayList<Customer>();
        this.ownedMedia = new ArrayList<Media>();


    }

    private String getString() {
        return this.reader.nextLine();
    }

    public void startMenu(){
        String choice = getString();
        switch (choice)
        {
            case "1":
                System.out.println("Elegiste 1");
            case "2":
                System.out.println("Elegiste 2");
            default:
               System.out.println("Not a valid option");
        }
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
        System.out.println(movie.getDirector());
        this.ownedMedia.add(movie);
    }


}
