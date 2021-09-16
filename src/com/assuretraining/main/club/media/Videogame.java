package com.assuretraining.main.club.media;

import java.util.List;

public class Videogame extends Media {
    private double rating;
    private List<String> platforms;
    private String developer;
    private String typeOfGame;

    public Videogame(String uid,
                     String description,
                     double costPerDay,
                     String name,
                     String dateOfRelease,
                     double rating,
                     List<String> platforms,
                     String developer,
                     String typeOfGame) throws Exception {
        super(description, costPerDay, name, uid, dateOfRelease);
        this.rating = rating;
        this.platforms = platforms;
        this.developer = developer;
        this.typeOfGame = typeOfGame;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<String> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<String> platforms) {
        this.platforms = platforms;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getTypeOfGame() {
        return typeOfGame;
    }

    public void setTypeOfGame(String typeOfGame) {
        this.typeOfGame = typeOfGame;
    }
}
