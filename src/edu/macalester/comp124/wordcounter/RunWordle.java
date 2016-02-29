package edu.macalester.comp124.wordcounter;

import acm.program.GraphicsProgram;

import java.awt.*;
import java.io.File;

/**
 * Created by bjackson.
 */
public class RunWordle extends GraphicsProgram {

    public void run() {
        File f1 = new File("124-word-counter/dat/trump.txt");
        File f2 = new File("124-word-counter/dat/hillary.txt");

        DistinctiveWordFinder finder = new DistinctiveWordFinder();
        finder.countWords(f1, f2);
        WordScore[] scores = finder.findDistinctive();
        setSize(1600, 800);

        Wordle wordle = new Wordle(scores, Color.RED);
        add(wordle, getWidth()/4.0, getHeight()/2.0);
        wordle.doLayout();

        finder = new DistinctiveWordFinder();
        finder.countWords(f2, f1);
        scores = finder.findDistinctive();

        Wordle wordle2 = new Wordle(scores, Color.BLUE);
        add(wordle2, getWidth()/4.0*3, getHeight()/2.0);
        wordle2.doLayout();
    }
}
