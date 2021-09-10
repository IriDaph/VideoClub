package com.assuretraining;

import java.util.List;

public class Movie  extends  Media{
    private double imdbRating;
    private String director;
    private List<String> actors;
    private String duration;
    private String genre;
    private String countryOfOrigin;


    public Movie(String description,
                 double costPerDay,
                 String name,
                 String uid,
                 String dateOfRelease,
                 double imdbRating,
                 String director,
                 List<String> actors,
                 String duration,
                 String genre,
                 String countryOfOrigin) {
        super(description, costPerDay, name, uid, dateOfRelease);
        this.imdbRating = imdbRating;
        this.director = director;
        this.actors = actors;
        this.duration = duration;
        this.genre = genre;
        this.countryOfOrigin = countryOfOrigin;
    }


    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }
}
