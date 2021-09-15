package com.assuretraining.main.inventory;

import com.assuretraining.main.videoClubClasses.media.Media;

import java.util.ArrayList;
import java.util.List;

public class MediaInventory implements Inventory {
    private final List<Media> mediaInventoryList;

    public MediaInventory() {
        mediaInventoryList = new ArrayList<>();
    }

    @Override
    public void add(Object o) {
        mediaInventoryList.add((Media) o);
    }

    @Override
    public void printInventory() {
        for(Media media:mediaInventoryList){
            media.printMedia();
        }
    }

}
