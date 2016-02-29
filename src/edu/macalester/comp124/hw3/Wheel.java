package edu.macalester.comp124.hw3;

import java.util.Random;

/**
 * Wheel class creates wheels that can spin and generate randomly a symbol from a collection of six symbols.
 */
public class Wheel {

    private String symbol;
    private Random random;

    public Wheel(){
        this.random = new Random();
        this.symbol = spin();
    }

    /**
     * Gets the symbol of a wheel.
     * @return The symbol of the wheel.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Set the symbol of a wheel.
     * @param symbol The desired symbol.
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Returns the symbol of a wheel.
     * @return The symbol of the wheel.
     */
    public String toString(){
        return getSymbol();
    }

    /**
     * Check if two wheels are the same instance.
     * @param obj The instance that needs to be compared with.
     * @return A boolean indicating if they are the same.
     */
    @Override
    public boolean equals(Object obj) {
        Wheel wheel = (Wheel) obj;
        return (symbol.equals(wheel.symbol));
    }

    /**
     * Spins the wheel and generates a randome number from 0 to 5. Uses the conversion method to convert the number to symbol.
     * @return The symbol of the wheel.
     */
    public String spin(){
        int randomInt = random.nextInt(5);
        conversion(randomInt);
        return symbol;
    }

    /**
     * Assigns each number from 0 to 5 to a symbol from the collection of six symbols.
     * @param num The number that will be assigned to a symbol.
     * @return The symbol that is associated with the number entered.
     */
    public String conversion(int num){
        if (num == 1) {
            symbol = "CHERRY";
        }
        if (num == 2) {
            symbol = "LEMON";
        }
        if (num == 3) {
            symbol = "ORANGE";
        }
        if (num == 4) {
            symbol = "PLUM";
        }
        if (num == 5) {
            symbol = "BELL";
        }
        if (num == 0) {
            symbol = "BAR";
        }
        return symbol;
    }

}
