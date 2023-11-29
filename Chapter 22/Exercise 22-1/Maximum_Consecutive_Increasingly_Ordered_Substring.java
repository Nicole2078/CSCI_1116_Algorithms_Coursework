/*
Author: Nicole Hackler
Date: 11/27/2023

(Maximum consecutive increasingly ordered substring ) Write a program that prompts the
user to enter a string and displays the maximum consecutive increasingly ordered substring.
Analyze the time complexity of your program.

Here is a sample run:

Enter a string: abcabcdgabxy
Maximum consecutive substring is abcdg

**The time complexity of the code is Linear time: O(n).**
*/
import java.util.*;
public class Maximum_Consecutive_Increasingly_Ordered_Substring {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String user = input.nextLine();
        System.out.println("Maximum consecutive substring is: " + orderedSubstring(user));
    }
    
    public static ArrayList<Character> orderedSubstring(String user) {
        ArrayList<Character> catnipMax = new ArrayList<>();//Max array return variable
        ArrayList<Character> toyList = new ArrayList<>(); //Temp array variable
        for(int i = 1; i <= user.length() - 1; i++){
            toyList.add(user.charAt(i - 1));
                //If the first character is larger it is added to the max list
                if(user.charAt(i) < user.charAt(i - 1)){
                    catnipMax = new ArrayList<>(toyList);
                    toyList.clear();//clearing temp list if it continues to be smaller
                }
        }
        return catnipMax;
    }
}
