/*
Author: Nicole Hackler
Date: 10/31/2023

Programming Exercise 20-3
(Guessing the capitals) Rewrite Programming Exercise 8.37 to store the pairs of states and
capitals so that the questions are displayed randomly.

I only altered parts of the code. Most of the code is still in the original form.
 */
import java.util.*;

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
                {"Massachusetts", "Boston"},
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
        List<String[]> list = Arrays.asList(stateCapital);

        Collections.shuffle(list);

        Scanner input = new Scanner(System.in);

        int correctCount = 0;

        for (int i = 0; i < list.size(); i++) {
            // Prompt the user with a question
            System.out.print("What is the capital of " + list.get(i)[0]+ "? ");
            String capital = input.nextLine().trim().toLowerCase();

            if (capital.toLowerCase().equals(list.get(i)[1].toLowerCase())) {
                System.out.println("Your answer is correct");
                correctCount++;
            }
            else
                System.out.println("The correct answer should be " + list.get(i)[1]);
        }

        System.out.println("The correct count is " + correctCount);
    }
}
