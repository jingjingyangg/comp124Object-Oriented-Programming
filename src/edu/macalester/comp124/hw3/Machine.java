package edu.macalester.comp124.hw3;

import acm.program.ConsoleProgram;

import javax.crypto.Mac;

/**
 * Machine class creates a machine which lets the user to pull the lever, and play games. It calculates the score of each game.
 */
public class Machine {

    private int score;

    private Wheel wheel1;
    private Wheel wheel2;
    private Wheel wheel3;

   public Machine(){
       this.wheel1 = new Wheel();
       this.wheel2 = new Wheel();
       this.wheel3 = new Wheel();

   }

    /**
     * Gets the score of a game.
     * @return The score of a game.
     */
    public int getScore(){
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object obj){
        Machine machine = (Machine) obj;
        return score == machine.score;
    }

    public String toString(){
        return "You win $" + score + " in this game";
    }

    public void setAllWheels(Wheel w1, Wheel w2, Wheel w3) {
        this.wheel1 = w1;
        this.wheel2 = w2;
        this.wheel3 = w3;
    }


    /**
     * Get the symbols of all three wheels.
     * @return A long string of all three symbols, with spaces in between.
     */
    public String getSymbols(){
        return wheel1.getSymbol() + "  " + wheel2.getSymbol() + "  " + wheel3.getSymbol();
    }

    /**
     * Spins all three wheels at the same time. Does not return anything.
     */
    public void spinAll(){
        wheel1.spin();
        wheel2.spin();
        wheel3.spin();
    }

    /**
     * Calculates the score of one round of game by checking all possible combinations that win points.
     * @return The score of that game. If doesn't win, return zero.
     */
    public int calculateScore(){
        if (wheel1.getSymbol().equals("BAR") && wheel2.getSymbol().equals("BAR") && wheel3.getSymbol().equals("BAR")){
            score = 250;
        } else if (wheel1.getSymbol().equals("BELL") && wheel2.getSymbol().equals("BELL")){
            if (wheel3.getSymbol().equals("BELL")||wheel3.getSymbol().equals("BAR")){
                score = 20;
            } else {
                score = 0;
            }
        } else if (wheel1.getSymbol().equals("PLUM") && wheel2.getSymbol().equals("PLUM")){
            if (wheel3.getSymbol().equals("PLUM")||wheel3.getSymbol().equals("BAR")){
                score = 14;
            } else {
                score = 0;
            }
        } else if (wheel1.getSymbol().equals("ORANGE") && wheel2.getSymbol().equals("ORANGE")){
            if (wheel3.getSymbol().equals("ORANGE")||wheel3.getSymbol().equals("BAR")){
                score = 10;
            } else {
                score = 0;
            }
        } else if (wheel1.getSymbol().equals("CHERRY") && wheel2.getSymbol().equals("CHERRY") && wheel3.getSymbol().equals("CHERRY")){
            score = 7;
        } else if (wheel1.getSymbol().equals("CHERRY") && wheel2.getSymbol().equals("CHERRY") && !wheel3.getSymbol().equals("CHERRY")){
            score = 5;
        } else if (wheel1.getSymbol().equals("CHERRY") && !wheel2.getSymbol().equals("CHERRY")){
            score = 2;
        } else {
            score = 0;
        }
        return score;
    }
}
