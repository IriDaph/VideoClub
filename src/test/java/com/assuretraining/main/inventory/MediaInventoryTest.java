package com.assuretraining.main.inventory;

import com.assuretraining.main.club.media.Media;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class MediaInventoryTest {
    Inventory mediaInventory;
    List<Media> inventory;
    @BeforeEach
    void setup(){
        mediaInventory = new MediaInventory();
        inventory = mediaInventory.getInventory();
    }
    @Test
    void mediaList_ShouldStartEmpty() {
        Assertions.assertEquals(0, inventory.size());
    }
    @Test
    void add_ShouldAddMediaToList(){
        Media media = mock(Media.class);
        inventory.add(media);
        Assertions.assertTrue(inventory.contains(media));
    }

    @Test
    void printInventory_ShouldShowMedia() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Media media1 = new Media("A beautiful description",4.99,"Best media ever","12VF","26/04/1994");
        Media media2 = new Media("Another beautiful description",8.99,"Second best media ever","12AC","12/04/2004");
        mediaInventory.add(media1);
        mediaInventory.add(media2);
        mediaInventory.printInventory();
        String expectedOutput  = "Uid: 12VF\r\n" +
                "Name: Best media ever\r\n" +
                "Description: A beautiful description\r\n" +
                "Cost per Day: 4.99\r\n" +
                "Uid: 12AC\r\n" +
                "Name: Second best media ever\r\n" +
                "Description: Another beautiful description\r\n" +
                "Cost per Day: 8.99\r\n";
        Assertions.assertEquals(expectedOutput,outContent.toString());
    }

    @Test
    void searchByIdentifier_ShouldReturnSearchedMedia() throws Exception {
        Media media1 = new Media("A beautiful description",4.99,"Best media ever","12VF","26/04/1994");
        mediaInventory.add(media1);
        Assertions.assertEquals(media1,(Media) mediaInventory.searchByIdentifier("12VF"));
    }

    @Test
    void searchByIdentifier_ShouldReturnNullIfSearchedMediaDoesNotExist() {
        Assertions.assertEquals(null,(Media) mediaInventory.searchByIdentifier("5A"));
    }
    @Test
    void isInventoryEmpty_ShouldReturnTrueIfEmpty() {
        Assertions.assertTrue(mediaInventory.isInventoryEmpty());
    }

    @Test
    void isInventoryEmpty_ShouldReturnFalseIfNotEmpty() throws Exception {
        Media media1 = new Media("A beautiful description",4.99,"Best media ever","12VF","26/04/1994");
        mediaInventory.add(media1);
        Assertions.assertFalse(mediaInventory.isInventoryEmpty());
    }

    @Test
    void sortInventoryById_ShouldSortList() throws Exception {
        Media media1 = new Media("A beautiful description",4.99,"Best media ever","12VF","26/04/1994");
        Media media2 = new Media("Another beautiful description",8.99,"Another best media ever","12AC","12/04/2004");
        mediaInventory.add(media1);
        mediaInventory.add(media2);
        List<Media> orderedList = new ArrayList<>();
        orderedList.add(media2);
        orderedList.add(media1);
        mediaInventory.sortInventory();
        Assertions.assertEquals(orderedList,mediaInventory.getInventory());
    }
}