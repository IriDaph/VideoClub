package com.assuretraining.main.inventory;

import com.assuretraining.main.club.customer.Customer;
import com.assuretraining.main.club.media.Media;

import java.util.ArrayList;
import java.util.Collections;
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
    public List getInventory() {
        return mediaInventoryList;
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

    @Override
    public void sortInventoryById() {
        int i,j,comparison;
        boolean swapped;
        Media media1;
        Media media2;
        int inventorySize = mediaInventoryList.size();
        for (i = 0; i < inventorySize -1; i++){
            swapped = false;
            for (j =0; j< inventorySize-i-1; j++){
                media1 = mediaInventoryList.get(j);
                media2 = mediaInventoryList.get(j+1);
                comparison = media1.getUid().compareTo(media2.getUid());
                if (comparison > 0 ){
                    Collections.swap(mediaInventoryList,j,j+1);
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }
    }

}
