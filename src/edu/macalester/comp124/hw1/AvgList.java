package edu.macalester.comp124.hw1;

import acm.program.ConsoleProgram;

/**
 * Created by jyang1 on 9/13/15.
 */
public class AvgList extends ConsoleProgram{

    public void run(){
        println("This program finds the average of a list of test scores.");
        println("Enter test scores, one per line, using " + SENTINEL + " to signal the end of the list.");
        double total = 0;
        int count = 0;
        double avg = 0;
        while (true){
            double score = readDouble("?");
            if (score == SENTINEL) break;
            total += score;
            count += 1;
            avg = total/count;
        }
        println("The average of your test scores is " + avg + ".");
    }

    private static final int SENTINEL = -1;
}
