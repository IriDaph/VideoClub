package com.assuretraining.main.ui;

import com.assuretraining.main.club.media.MusicAlbum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ScannerActionsTest {



    @Test
    void getString_ShouldReturnString() {
        String input = "A string";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ScannerActions sa = new ScannerActions(in);
        assertEquals("A string", sa.getString());
    }

    @Test
    void getDouble_ShouldReturnDoubleIDoubleWasInput() {
        String input = "5,25";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ScannerActions sa = new ScannerActions(in);
        Assertions.assertEquals(5.25, sa.getDouble());
    }

    @Test
    void getDouble_ShouldShowMessageIfDoubleWasNotInput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String input = "Hello";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ScannerActions sa = new ScannerActions(in);
        sa.getDouble();
        Assertions.assertEquals("Please enter  decimal number like this: 4,50\r\n",outContent.toString());
    }

    @Test
    void getInteger_ShouldReturnInteger() {
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ScannerActions sa = new ScannerActions(in);
        Assertions.assertEquals(5, sa.getInteger());
    }
    @Test
    void getInteger__ShouldShowMessageIfIntegerWasNotInput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String input = "Integer";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ScannerActions sa = new ScannerActions(in);
        sa.getInteger();
        Assertions.assertEquals("Please enter a number\r\n",outContent.toString());
    }

    @Test
    void getDate_ShouldReturnDate() {
        String input = "5/5/2012";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ScannerActions sa = new ScannerActions(in);
        Assertions.assertEquals("5/5/2012", sa.getDate());
    }

    @Test
    void getDate_ShouldShowMessageIfDateNotCorrect() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String input = "35/25/2012\n15/05/2012";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ScannerActions sa = new ScannerActions(in);
        sa.getDate();
        Assertions.assertEquals("Please enter a VALID date in the format dd/mm/yyyy:\r\n", outContent.toString());
    }

    @Test
    void getNextLine_ShouldReturnEmptyString() {
        String input = "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ScannerActions sa = new ScannerActions(in);
        Assertions.assertEquals("", sa.getNextLine());
    }

    @Test
    void getDuration_ShouldReturnDuration() {
        String input = "5:30";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ScannerActions sa = new ScannerActions(in);
        Assertions.assertEquals("5:30", sa.getDuration());
    }

    @Test
    void getDate_ShouldShowMessageIfDurationNotCorrect() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String input = "20minutos\n5:30";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ScannerActions sa = new ScannerActions(in);
        sa.getDuration();
        Assertions.assertEquals("Please enter a VALID duration in the format 1:50\r\n", outContent.toString());
    }

    @Test
    void getStringList_ShouldReturnList() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Ana");
        stringList.add("Maria");
        String input = "Ana\ny\nMaria\nn";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ScannerActions sa = new ScannerActions(in);
        Assertions.assertEquals(stringList,sa.getStringList("string"));
    }
    @Test
    void getMedia_ShouldReturnMediaList() throws Exception {
        Menu menu = mock(Menu.class);
        List<MusicAlbum> mediaList = new ArrayList<>();
        MusicAlbum musicAlbum = mock(MusicAlbum.class);
        mediaList.add(musicAlbum);
        when(musicAlbum.getUid()).thenReturn("120");
        when(menu.searchMediaInventory("120")).thenReturn(musicAlbum);
        String input = "120\nn";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ScannerActions sa = new ScannerActions(in);
        Assertions.assertEquals(mediaList,sa.getMedia(menu));
    }
}