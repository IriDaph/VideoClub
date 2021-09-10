package com.assuretraining;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception{
        Date dateOfRental = new Date();
        Customer c = new Customer("213123","Ana","Doe","Avenida Melchor 1213","23141231");
        MusicAlbum ma = new MusicAlbum( " The Album by korean group blackpink",
                2.5,
                "The Album",
                "0816",
                "11/10/2020",
                "BLACKPINK",
                8,
                "Kpop");
        Rental rental = new Rental("123",ma,c,5,true);
        rental.calculatePenalty();
        System.out.println(rental.getDateOfReturning());
    }
}
