package com.assuretraining.main.ui.command;

import com.assuretraining.main.club.media.Videogame;
import com.assuretraining.main.ui.Menu;

import java.util.List;

public class CreateVideoGameCommand {
    public void runCommand(Menu menu) throws Exception {
        System.out.println("Enter videogame's uid: ");
        String uid = menu.reader.getString();
        System.out.println("Enter videogame's description: ");
        String description = menu.reader.getString();

        System.out.println("Enter videogame's cost per day: ");
        double cost = menu.reader.getDouble();

        System.out.println("Enter videogame's name: ");
        String name = menu.reader.getString();

        System.out.println("Enter videogame's date of release(dd/mm/yyyy): ");
        String date0fRelease = menu.reader.getDate();

        System.out.println("Enter videogame's rating ");
        double rating = menu.reader.getDouble();

        System.out.println("Enter platform: ");
        List<String> platforms = menu.reader.getStringList("platform");

        System.out.println("Enter videogames's developer: ");
        String developer = menu.reader.getString();

        System.out.println("Enter type of game: ");
        String typeOfGame = menu.reader.getString();

        Videogame videogame = new Videogame(uid,description,cost,name,date0fRelease,rating,platforms,developer,typeOfGame);
        menu.ownedMedia.add(videogame);
    }
}
