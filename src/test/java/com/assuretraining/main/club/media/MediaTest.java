package com.assuretraining.main.club.media;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class MediaTest {
    Media media = null;
    @BeforeEach void setup() throws Exception {
        media = new Media("A beautiful description",4.99,"Best media ever","12","26/04/1994");
    }

    @Test
    void dateOfRelease_IsDateObject_ReturnsTrue() {
        Assertions.assertTrue(media.getDateOfRelease()  instanceof Date);
    }

    @Test
    void printMedia_PrintsMediaInfo_ReturnsTrue() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        media.printMedia();
        String expectedOutput  = "Uid: 12\r\nName: Best media ever\r\nDescription: A beautiful description\r\nCost per Day: 4.99\r\n";
        Assertions.assertEquals(expectedOutput,outContent.toString());
    }
}