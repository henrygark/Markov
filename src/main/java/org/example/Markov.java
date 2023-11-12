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
    public void addLine(String line) {      //tool to get words out of sentence and put them into an arraylist to access.
        if (line.length() != 0 ) {
            String[] myWords = line.split(" ");   // found from https://www.javatpoint.com/substring

            for (int i = 0; i < myWords.length; i++) {
                if (myWords[i].length() != 0) {
                    addWord(myWords[i]);      //retrieves string and adds the value from the words array.
                                             //words[i] retrieves the value from the words array.
                }
            }
            if (line != null) {
                line.split(" ");
            }
        }
    }
    public void addWord(String word) {
        if (endsWithPunctuation(prevWord)) {
            ArrayList<String> array = new ArrayList<String>();
            array.add(word);

            words.put(BEGINS_SENTENCE_, array);
        } else if (!endsWithPunctuation(prevWord)){
            if (!words.containsKey(prevWord)) {
                ArrayList<String> array = new ArrayList<String>();
                array.add(word);
                words.put(prevWord, array);
            } else {
                ArrayList<String> array = words.get(prevWord);
                array.add(word);
                words.put(prevWord, new ArrayList<>());
            }
        }
        prevWord = word;
    }
    public static boolean endsWithPunctuation(String word) {
       return PUNCTUATION_MARKS_.contains(word.substring(word.length() - 1));
       }

    public String randomWord(String key) {
        Random wordGen = new Random();
        ArrayList<String> initial = words.get(key);    //retrieves the object

        return initial.get(wordGen.nextInt(initial.size()));
    }
    @Override
    public String toString() {
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