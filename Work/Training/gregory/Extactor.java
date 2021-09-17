package org.gregory;


import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.stream.Stream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extactor {



    public static void main(String[] args) {
        int counter = 0;

        //each line goes to  string array

        Pattern pattern = Pattern.compile("@softwire.com");

        String fileName = "/Users/gbarratt/Desktop/Work/EmailExtraction/email/src/sample.txt";

        ArrayList<String> list = new ArrayList<>();

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(list::add);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        for(String s: list) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()){
                counter++;
            }


        }
        System.out.println(counter);

    }


    }


