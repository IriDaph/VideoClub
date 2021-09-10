package com.assuretraining;

public class MusicAlbum extends Media{
    private String artist;
    private Integer numberOfTracks;
    private String genre;
    public MusicAlbum(String description,
                      double costPerDay,
                      String name,
                      String uid,
                      String dateOfRelease,
                      String artist,
                      Integer numberOfTracks,
                      String genre) throws Exception {
        super(description, costPerDay, name, uid, dateOfRelease);
        this.artist = artist;
        this.numberOfTracks = numberOfTracks;
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getNumberOfTracks() {
        return numberOfTracks;
    }

    public void setNumberOfTracks(Integer numberOfTracks) {
        this.numberOfTracks = numberOfTracks;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
