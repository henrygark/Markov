//Henry Garkanian
//November 5, 2023
//CST 338
//Markov assignment

package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Markov {
    private static final String BEGINS_SENTENCE_ = "__$";
    private static final String PUNCTUATION_MARKS_ = ".!?$";
    private String prevWord;
    private HashMap<String, ArrayList<String>> words = new HashMap<String, ArrayList<String>>();

    public Markov() {
        words.put(BEGINS_SENTENCE_, new ArrayList<>());
        prevWord = BEGINS_SENTENCE_;
    }
    public HashMap<String, ArrayList<String>> getWords() {
        return words;
    }
    public void addFromFile(String fileName) {
        System.out.println("Not implemented");
    }
    public void addLine(String line) {
        System.out.println("Line not implemented");
    }
    public void addWord(String word) {
        System.out.println("Word not implemented");
    }
    public static boolean endsWithPunctuation(String word) {
        System.out.println("EndsWith puncutation not implemented");
        return false;
    }
    public String randomWord(String key) {
        System.out.println("Random word not implemented");
        return key;
    }
    @Override
    public String toString() {
        return words.toString();
    }
    public String getSentence() {
        System.out.println("Not implemented");
        return "";
    }
}