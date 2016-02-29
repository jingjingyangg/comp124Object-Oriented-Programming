package edu.macalester.comp124.hw2;

import acm.program.ConsoleProgram;

import java.util.Random;

public class GuessNumber extends ConsoleProgram {
    private final Random rand = new Random();
    
    public void run() {
        while (true){
            print("I am thinking of a number between 0 and 99!");
            println();
            int answer = rand.nextInt(100);
            while (true){
                int guess = readInt("Your guess:");
                if (guess == answer){
                    println("You got it!");
                    break;
                }
                if (guess > answer) {
                    println("Lower.");
                } else {
                    println("Higher.");
                }
            }
            String again = readLine("Would you like to play again? (yes or no)");
            if (again.equals("no")) {
                print("Ok, bye bye!");
                break;
            }
        }
    }
}
