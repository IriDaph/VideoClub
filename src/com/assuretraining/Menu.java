package com.assuretraining;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner reader;
    private List<Customer> customers;
    private List<Media> ownedMedia;
    public Menu(){
        this.reader  = new Scanner(System.in);
    }

    public void createCustomer(){
        System.out.println("Enter customers id: ");
        String id = this.reader.nextLine();
        System.out.println("Enter customer's name: ");
        String name = this.reader.nextLine();
        System.out.println("Enter customer's lastname: ");
        String lastname = this.reader.nextLine();
        System.out.println("Enter customer's address: ");
        String address = this.reader.nextLine();
        System.out.println("Enter customer's cellphone: ");
        String cellphone = this.reader.nextLine();

        Customer customer = new Customer(id,name,lastname,address,cellphone);
        this.customers.add(customer);
    }
    public void createMovie(){
        System.out.println("Enter movie's description: ");
        String description = this.reader.nextLine();
        //Agregar condicional de numero
        System.out.println("Enter movie's cost per day: ");
        double cost = this.reader.nextDouble();

        System.out.println("Enter movie's name: ");
        String name = this.reader.nextLine();

        // Agregar condicional de formato
        System.out.println("Enter movie's date of release: ");
        String date0fRelease = this.reader.nextLine();

        //Agregar condicional de numero
        System.out.println("Enter movie's imdb ");
        double imdb = this.reader.nextDouble();

        System.out.println("Enter movie's director: ");
        String director = this.reader.nextLine();

        Boolean answer = true;
        List<String> cast = new ArrayList<String>();
        while (answer){
            System.out.println("Enter an actors/actress name: ");
            String actor = this.reader.nextLine();
            cast.add(actor);
            System.out.println("Do you want to add another actor/actress? y/n: ");
            String userAnswer = this.reader.nextLine();
            if (userAnswer == "n"){
                answer = false;
            }
        }

        System.out.println("Enter movie's genre: ");
        String genre = this.reader.nextLine();

        System.out.println("Enter movie's country of Origin: ");
        String countryOfOrigin = this.reader.nextLine();



    }
}
