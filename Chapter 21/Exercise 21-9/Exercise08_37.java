/*
Author: Nicole Hackler
Date: 11/14/2023

Programming Exercise 21-9
(Guess the capitals using maps) Rewrite Programming Exercise 8.37 to store pairs of each
state and its capital in a map. Your program should prompt the user to enter a state and
display the capital for the state.

 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise08_37 {
    public static void main(String[] args) {
        String[][] stateCapital = {
                {"Alabama", "Montgomery"},
                {"Alaska", "Juneau"},
                {"Arizona", "Phoenix"},
                {"Arkansas", "Little Rock"},
                {"California", "Sacramento"},
                {"Colorado", "Denver"},
                {"Connecticut", "Hartford"},
                {"Delaware", "Dover"},
                {"Florida", "Tallahassee"},
                {"Georgia", "Atlanta"},
                {"Hawaii", "Honolulu"},
                {"Idaho", "Boise"},
                {"Illinois", "Springfield"},
                {"Indiana", "Indianapolis"},
                {"Iowa", "Des Moines"},
                {"Kansas", "Topeka"},
                {"Kentucky", "Frankfort"},
                {"Louisiana", "Baton Rouge"},
                {"Maine", "Augusta"},
                {"Maryland", "Annapolis"},
                {"Massachusettes", "Boston"},
                {"Michigan", "Lansing"},
                {"Minnesota", "Saint Paul"},
                {"Mississippi", "Jackson"},
                {"Missouri", "Jefferson City"},
                {"Montana", "Helena"},
                {"Nebraska", "Lincoln"},
                {"Nevada", "Carson City"},
                {"New Hampshire", "Concord"},
                {"New Jersey", "Trenton"},
                {"New York", "Albany"},
                {"New Mexico", "Santa Fe"},
                {"North Carolina", "Raleigh"},
                {"North Dakota", "Bismarck"},
                {"Ohio", "Columbus"},
                {"Oklahoma", "Oklahoma City"},
                {"Oregon", "Salem"},
                {"Pennsylvania", "Harrisburg"},
                {"Rhode Island", "Providence"},
                {"South Carolina", "Columbia"},
                {"South Dakota", "Pierre"},
                {"Tennessee", "Nashville"},
                {"Texas", "Austin"},
                {"Utah", "Salt Lake City"},
                {"Vermont", "Montpelier"},
                {"Virginia", "Richmond"},
                {"Washington", "Olympia"},
                {"West Virginia", "Charleston"},
                {"Wisconsin", "Madison"},
                {"Wyoming", "Cheyenne"}
        };
        //Creating HashMap catnip :)
        Map<String, String> catnip = new HashMap<>();
        for (int i = 0; i < stateCapital.length; i++)
            catnip.put(stateCapital[i][0].toLowerCase(), stateCapital[i][1]);

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Enter a State: ");
            String mouse = input.next().trim().toLowerCase();
            if (catnip.containsKey(mouse)) {
                System.out.println("The State Capital is: " + catnip.get(mouse));
            } else {
                System.out.println("Try again. \nEnter a State:");
            }
        }

//        int correctCount = 0;
//
//        for (int i = 0; i < stateCapital.length; i++) {
//            // Prompt the user with a question
//            System.out.print("What is the capital of " + stateCapital[i][0] + "? ");
//            String capital = input.nextLine().trim().toLowerCase();
//
//            if (capital.toLowerCase().equals(stateCapital[i][1].toLowerCase())) {
//                System.out.println("Your answer is correct");
//                correctCount++;
//            }
//            else
//                System.out.println("The correct answer should be " + stateCapital[i][1]);
//        }
//
//        System.out.println("The correct count is " + correctCount);
    }
}
