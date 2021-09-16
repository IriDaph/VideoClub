package com.assuretraining.main.inventory;

import com.assuretraining.main.club.media.Media;

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

    @Override
    public Object searchByIdentifier(String id) {
        Media askedMedia = null;
        for (Media  media: this.mediaInventoryList){
            if(id.equals(media.getUid())){
                askedMedia = media;
            }
        }
        return askedMedia;
    }

    @Override
    public boolean isInventoryEmpty() {
        return mediaInventoryList.isEmpty();
    }

}
