package com.assuretraining.main.ui;

import com.assuretraining.main.club.media.Media;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScannerActions {
    private Scanner scanner;

    public ScannerActions() {
        this.scanner = new Scanner(System.in);
    }

    public String getString() {
        return this.scanner.nextLine();
    }
    public Double getDouble(){
        double number = 0;
        while (this.scanner.hasNext()){

            if (this.scanner.hasNextDouble()) {
                number = this.scanner.nextDouble();
                break;
            } else {
                System.out.println("Please enter  decimal number like this: 4,50");
                this.scanner.next();
            }
        }
        return  number;
    }

    public Integer getInteger(){
        Integer number = 0;
        while (this.scanner.hasNext()){

            if (this.scanner.hasNextInt()) {
                number = this.scanner.nextInt();
                break;
            } else {
                System.out.println("Please enter a number");
                this.scanner.next();
            }
        }
        return number;
    }
    public String getDate(){
        Pattern p = Pattern.compile("^(?:(?:31(/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(/)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
        String date = getString();
        Matcher match = p.matcher(date);
        boolean itMatchesPattern = match.matches();
        while (!itMatchesPattern){
            System.out.println("Please enter a VALID date in the format dd/mm/yyyy:");
            date = this.scanner.nextLine();
            match = p.matcher(date);
            itMatchesPattern = match.matches();
        }
        return date;
    }
    public String getNextLine(){
        return this.scanner.nextLine();
    }

    public String getDuration(){
        Pattern pattern = Pattern.compile("^[0-9]?[0-9]?[0-9]:[0-5][0-9]$");
        String duration = getString();
        Matcher match = pattern.matcher(duration);
        boolean itMatchesPattern = match.matches();
        while (!itMatchesPattern){
            System.out.println("Please enter a VALID duration in the format 1:50");
            duration = this.scanner.nextLine();
            match = pattern.matcher(duration);
            itMatchesPattern = match.matches();
        }

        return duration;
    }

    public List<String> getStringList(String typeOfList){
        List<String> stringList = new ArrayList<>();
        Boolean answer = true;
        while (answer){
            String string = getString();
            stringList.add(string);
            System.out.println("Do you want to add another " + typeOfList+ "? y/n:");
            String userAnswer = getString();
            if (userAnswer.equals("n")){
                answer = false;
            }
        }
        return stringList;
    }

    public List<Media> getMedia(Menu menu) {
        List<Media> rentedMedia = new ArrayList<>();
        String userAnswer;
        Boolean answer = true;
        while (answer){
            String mediaUid = getString();
            Media media = menu.searchMediaInventory(mediaUid);
            while (media == null) {
                System.out.println("A media with that Uid doesn't exist, enter another Uid ");
                mediaUid = getString();
                media = menu.searchMediaInventory(mediaUid);
            }
            rentedMedia.add(media);
            System.out.println("Do you want to add another media y/n:");
            userAnswer = getString();
            if (userAnswer.equals("n")){
                answer = false;
            }

        }
        return  rentedMedia;
    }
}
