package com.assuretraining.main.ui.command;

import com.assuretraining.main.club.media.MusicAlbum;
import com.assuretraining.main.ui.Menu;

public class CreateMusicAlbumCommand {
    public void runCommand(Menu menu) throws Exception {
        System.out.println("Enter music album's uid: ");
        String uid = menu.reader.getString();

        System.out.println("Enter music album's description: ");
        String description = menu.reader.getString();

        System.out.println("Enter album's cost per day: ");
        double cost = menu.reader.getDouble();


        System.out.println("Enter music album's name: ");
        String name = menu.reader.getString();

        System.out.println("Enter music album's date of release(dd/mm/yyyy): ");
        String date0fRelease = menu.reader.getDate();

        System.out.println("Enter music album's artist: ");
        String artist = menu.reader.getString();

        System.out.println("Enter music album's number of tracks: ");
        Integer numberTracks = menu.reader.getInteger();


        System.out.println("Enter music album's genre: ");
        String genre = menu.reader.getString();

        MusicAlbum musicAlbum = new MusicAlbum(uid,cost,name,description,date0fRelease,artist,numberTracks,genre);
        menu.ownedMedia.add(musicAlbum);
    }
}
