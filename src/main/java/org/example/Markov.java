//Henry Garkanian
//November 5, 2023
//CST 338
//Markov assignment

package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Markov {
    private static final String BEGINS_SENTENCE_ = "__$";
    public static final String PUNCTUATION_MARKS_ = ".!?$";
    private String prevWord;
    private HashMap<String, ArrayList<String>> words =
            new HashMap<String, ArrayList<String>>();

    public Markov() {
        words.put(BEGINS_SENTENCE_, new ArrayList<>());
        prevWord = BEGINS_SENTENCE_;
    }
    public HashMap<String, ArrayList<String>> getWords() {
        return words;
    }
    public void addFromFile(String fileName) {
        File newFile = new File(fileName) ;
        Scanner myScanner = null;

        try {
            myScanner = new Scanner(newFile);
        } catch (FileNotFoundException e) {
            System.out.println("Could not open file");
        }
        while (myScanner.hasNext() && myScanner != null) {
            String collect = myScanner.nextLine();
            addLine(collect);
        }
    }
    public void addLine(String line) {
        line  = String.valueOf(words.get(BEGINS_SENTENCE_));
        if (line == null) {
            System.out.println("");
        }
    }
    public void addWord(String word)
    {
        System.out.println("Word not implemented");
    }
    public static boolean endsWithPunctuation(String word) {
        System.out.println("EndsWith puncutation not implemented");
        return false;
    }
    public String randomWord(String key) {
        Random wordGen = new Random();
        Object[] values = words.values().toArray();         //found from https://stackoverflow.com/questions/929554/is-there-a-way-to-get-the-value-of-a-hashmap-randomly-in-java
        Object randomWord = values[wordGen.nextInt(values.length)];


    System.out.println("Random word not implemented");
        return key;
    }
    @Override
    public String toString()
    {
        return words.toString();
    }
    public String getSentence() {
        String currentWord = "";
        currentWord = randomWord(BEGINS_SENTENCE_);
      //  if (currentWord.contains(endsWithPunctuation())) {

       // }

        System.out.println("Not implemented");
        return "";
    }
}