package edu.macalester.comp124.critters;

import acm.graphics.GImage;
import acm.graphics.GRect;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Ariana on 10/8/2015.
 */

public class NyanCat extends Critter {
    @Override
    protected void buildGraphics() {


        GRect red = new GRect(0, 30, 65, 20);
        red.setColor(Color.RED);
        red.setFilled(true);
        red.setFillColor(Color.RED);
        addLeg(new Leg(red, 2));

        GRect yellow = new GRect(0, 50, 65, 20);
        yellow.setColor(Color.YELLOW);
        yellow.setFilled(true);
        yellow.setFillColor(Color.YELLOW);
        addLeg(new Leg(yellow, 2));

        GRect green = new GRect(0, 70, 65, 20);
        green.setColor(Color.GREEN);
        green.setFilled(true);
        green.setFillColor(Color.GREEN);
        addLeg(new Leg(green, 2));

        GRect blue = new GRect(0, 90, 65, 20);
        blue.setColor(Color.BLUE);
        blue.setFilled(true);
        blue.setFillColor(Color.BLUE);
        addLeg(new Leg(blue, 2));

        GImage nyancat = null;
        try {
            nyancat = new GImage(ImageIO.read(getClass().getResource("/NyanCat.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }


        getGraphics().add(nyancat);


//        addEye(new Eye(5, 0.26, 0.18, Color.RED), 42, 35);
//        addEye(new Eye(5, 0.26, 0.18, Color.RED), 55, 35);
    }
}
