package com.assuretraining.main.ui.command;

import com.assuretraining.main.club.media.Movie;
import com.assuretraining.main.ui.Menu;

import java.util.List;

public class CreateMovieCommand implements Command {
    public void runCommand(Menu menu) throws Exception{
        System.out.println("Enter movie's uid: ");
        String uid = menu.reader.getString();

        System.out.println("Enter movie's description: ");
        String description = menu.reader.getString();

        System.out.println("Enter movie's cost per day: ");
        double cost = menu.reader.getDouble();

        System.out.println("Enter movie's name: ");
        String name = menu.reader.getString();

        System.out.println("Enter movie's date of release(dd/mm/yyyy): ");
        String date0fRelease = menu.reader.getDate();

        System.out.println("Enter movie's imdb ");
        double imdb = menu.reader.getDouble();

        System.out.println("Enter movie's director: ");
        String director = menu.reader.getString();
        System.out.println("Enter an actors/actress name: ");
        List<String> cast = menu.reader.getStringList("actor");

        System.out.println("Enter movie's genre: ");
        String genre = menu.reader.getString();

        System.out.println("Enter movie's duration (ex: 2:30): ");
        String duration = menu.reader.getString();

        System.out.println("Enter movie's country of Origin: ");
        String countryOfOrigin = menu.reader.getString();

        Movie movie = new Movie(description,cost,name,uid,date0fRelease,imdb,director,cast,duration,genre,countryOfOrigin);
        menu.ownedMedia.add(movie);
    }
}
