/*
Author: Nicole Hackler
Date: 11/13/2023

(Revise Listing 21.9) Rewrite Listing 21.9 with the map as a HashMap. The program should
display the words in ascending order of occurrence counts.

(Hint: Create a class named WordOccurrence that implements the Comparable interface. The class
contains two fields, work and count. The compareTo method compares the counts. For each pair
in the hash set in Listing 21.9, create an instance of WordOccurrence and store it in an array
list. Sort the array list using the Collection.sort method. What would be wrong if you stored
the instance of WordOccurrence in a tree ste?)
 */
import java.util.*;

public class CountOccurrenceOfWords{
    public static void main(String[] args) {
        // Set text in a string
        String text = "Good morning. Have a good class. " +
                "Have a good visit. Have fun!";

        // Create a TreeMap to hold words as key and count as value
        //Map<String, Integer> map = new TreeMap<>();
        Map<String, Integer> map = new HashMap<>();

        String[] words = text.split("[\\s+\\p{P}]");
        for (int i = 0; i < words.length; i++) {
            String key = words[i].toLowerCase();

            if (key.length() > 0) {
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                }
                else {
                    int value = map.get(key);
                    value++;
                    map.put(key, value);
                }
            }
        }
        ArrayList<Map.Entry<String, Integer>> listOfKeys = new ArrayList<>(map.entrySet());
        listOfKeys.sort((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()) == 0 ? entry1.getKey().compareTo(entry2.getKey()) : entry1.getValue().compareTo(entry2.getValue()));
        System.out.println(listOfKeys);


        // Display key and value for each entry
        for(Map.Entry<String, Integer> entry : listOfKeys){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public class WordOccurrence implements Comparable<WordOccurrence>{
        private int count;
        private String word;

        WordOccurrence(){
        }

        WordOccurrence(String word, int count){
            this.count = count;
            this.word = word;
        }

        @Override
        public int compareTo(WordOccurrence o) {
            return Integer.compare(this.count, o.count);
        }

        @Override
        public String toString(){
            return  word + ":\t" + count;

        }

    }
}
