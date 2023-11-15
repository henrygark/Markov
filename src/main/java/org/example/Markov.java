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

//initialized methods according to the documentation.
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

    //Adding a chosen file from Main.
    public void addFromFile(String fileName) {
        File newFile = new File(fileName) ;     //retrieved from hangman add file method
        Scanner myScanner = null;

        try {
            myScanner = new Scanner(newFile);
        } catch (FileNotFoundException e) {
            System.out.println("Could not open file");
        }
        while (myScanner.hasNextLine() && myScanner != null) {
            addLine(myScanner.nextLine());
        }
    }
    //Adds a specific line from the called text file
    // and trims the words and their whitespaces.
    public void addLine(String line) {      //tool to get words out of sentence and put them into an arraylist to access.
        if (line.length() != 0 ) {
            String[] myWords = line.split(" ");   // found from https://www.javatpoint.com/substring

            for (int i = 0; i < myWords.length; i++) {
                if (myWords[i].trim().length() != 0) {
                    addWord(myWords[i].trim());      //retrieves string and adds the value from the words array.
                                             //words[i] retrieves the value from the words array.
                }
            }
            if (line != null) {
                line.split(" ");
            }
        }
    }
    //Calls endsWithPunctuation and assigns prevWord to an instance
    //if a word ends with punctuation or not and then creates an arraylist
    //to place the added words to the array that is initialized to BEGINS_SENTENCE_ and follows.
    public void addWord(String word) {
        if (endsWithPunctuation(prevWord)) {
            ArrayList<String> array = words.get(BEGINS_SENTENCE_);
            array.add(word);

            words.put(BEGINS_SENTENCE_, array);
        } else if (!endsWithPunctuation(prevWord)){
            if (!words.containsKey(prevWord)) {
                ArrayList<String> array = new ArrayList<>();   //we are at the end of the sentence.
                array.add(word);                              //We add a word to the array that belongs to BEGINS_SENTENCE_
                words.put(prevWord, array);
            } else {
                ArrayList<String> array = words.get(prevWord);
                array.add(word);
                words.put(prevWord, array);     //the words are passed to the array
            }
        }
        prevWord = word;
    }
    //returns the substring of the passed in words' lengths - 1 to add a specific punctuation
    //to the end of a word.
    public static boolean endsWithPunctuation(String word) {
        return PUNCTUATION_MARKS_.contains(word.substring(word.length() - 1));
       }

   //Picks a random word by the corresponding values called in the array being passed
   //into the method, from the hashmap.
    public String randomWord(String key) {
        Random wordGen = new Random();
        ArrayList<String> initial = words.get(key);    //retrieves the object
        if (initial != null && !initial.isEmpty()) {
            return initial.get(wordGen.nextInt(initial.size()));
        } else {
            return "";
        }
    }
    //returns the hashmap's selection from the text file and prints the
    //contents from the program's methods out by using toString().
    @Override
    public String toString() {
        return words.toString();
    }
    //initializes a string builder to take the values given from randomWord
    //and append them by using the key BEGINS_SENTENCE_, to write an output for the program.
    public String getSentence() {
        String currentWord = "";
        StringBuilder builder = new StringBuilder();
        boolean checker = true;
        currentWord = randomWord(BEGINS_SENTENCE_);

        while (checker) {
            if (!endsWithPunctuation(currentWord)) {
                builder.append(currentWord).append(" ");    //found from https://www.geeksforgeeks.org/java-string-trim-method-example/
                currentWord = randomWord(currentWord);
            } else {
                checker = false;
            }
        }
        builder.append(currentWord);
        return builder.toString();
    }
}