package edu.macalester.comp124.hw3;

import acm.program.ConsoleProgram;

/**
 * Created by bjackson on 9/24/2015.
 */
public class Casino extends ConsoleProgram {

    /**
     * The main function for the entire program.
     *
     * You should create other helper methods inside Casino.
     * Some of them should create an instance of the Machine class.
     * Make sure to test your new methods in the TestCasino junit class.
     *
     */

    private Machine machine1 = new Machine();

    private int stake = 50;

    /**
     * Calculates the overall stake the play has, including the original budget he started with and the money he has won.
     * @return The current amount of stake the play possesses.
     */
    public int countStake(){
        stake = stake + machine1.getScore() - 1;
        return stake;
    }

    public int getStake(){
        return stake;
    }

    public Machine getMachine1(){
        return machine1;
    }

    public void setStake(int money){
        this.stake = money;
    }

    public String toString(){
        return "You have $" + stake + " in total at this point.";
    }

    @Override
    public boolean equals(Object obj){
        Casino casino = (Casino)obj;
        return this.stake == casino.stake;
    }


    /**
     * The main console of the game, in which the user will be told how much stake they have at the point,
     * and whether they want to play repetitively until he answers "no" or he runs out of money.
     */
    public void run() {
        String instruction = readLine("Would you like instructions? ");
        if (instruction.equals("yes")){
            println("Here's the instruction for the slot machine....");
        }
            while(true){

                String play = readLine("You have $" + stake + ". Would you like to play?");
                if (play.equals("yes")){
                    machine1.spinAll();
                    print(machine1.getSymbols());
                    machine1.calculateScore();
                    if (machine1.getScore()== 0){
                        print(" -- You lose");
                        println();
                    } else{
                        print(" -- You win $" + machine1.getScore());
                        println();
                    }
                    countStake();
                    if (stake==0) break;
                } else break;

        }
    }
}
