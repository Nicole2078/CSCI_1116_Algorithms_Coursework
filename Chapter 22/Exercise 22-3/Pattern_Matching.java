/*
Author: Nicole Hackler
Date: 11/29/2023

Exercise 22-3
(Pattern matching ) Write a program that prompts the user to enter two strings and tests
whether the second string is a substring of the first string. Suppose the neighboring
characters in the string are distinct.  (Don’t use the indexOf method in the String class.)
Analyze the time complexity of your algorithm. Your algorithm needs to be at least O(n) time.

Here is a sample run of the program:

Enter a string s1: Welcome to Java
Enter a string s2: come
matched at index 3

The program uses Linear Time: O(n), only running as long as the substring of s2.
*/
import java.util.*;
public class Pattern_Matching {
    public static void main(String[] args){
        String s1;
        String s2;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string for s1: ");
        s1 = input.nextLine();
        System.out.print("Enter a string for s2: ");
        s2 = input.nextLine();

        if (s1.contains(s2)) {
            int countCatNip = 0; //counter for substring s2
            int tempToys = 0; //temp variable for index
            for (int i = 0; i <= s1.length() - 1; i++) {
                if (s1.charAt(i) == s2.charAt(0) && countCatNip == 0) {
                    countCatNip++;
                    tempToys = i; //Setting the index when found a match
                }
                else if (s1.charAt(i) == s2.charAt(countCatNip)) {
                    countCatNip++; //Add to count if it continues to match
                }
                else { //If nothing matches it resets both to 0
                    countCatNip = 0;
                    tempToys = 0;
                }
                if (countCatNip == s2.length())
                    break; //break out of loop when we reach the end of s2 length.
            }
            System.out.println("Matched at index: " + tempToys);
        }
        else{
            System.out.println("s2 is not a substring of s1.");
        }
    }
}

