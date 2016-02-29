package edu.macalester.comp124.critters;

import acm.graphics.GImage;
import acm.graphics.GRect;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Created by JingjingYang on 10/8/15.
 */
public class PenguinJJ extends Critter{

    @Override
    protected void buildGraphics() {

        GImage leftFeet = null;
        try {
            leftFeet = new GImage(ImageIO.read(getClass().getResource("/penguin_left.png")),0,104);
        } catch (IOException e) {
            e.printStackTrace();
        }

        addLeg(new Leg(leftFeet, 3));


        GImage rightFeet = null;
        try {
            rightFeet = new GImage(ImageIO.read(getClass().getResource("/penguin_right.png")), 50,104);
        } catch (IOException e) {
            e.printStackTrace();
        }

        addLeg(new Leg(rightFeet, 3));


        GImage penguin = null;
        try {
            penguin = new GImage(ImageIO.read(getClass().getResource("/angry_penguin.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }


        getGraphics().add(penguin);

    }


    private static final Color
            strokeColor = new Color(0, 0, 255),
            fillColor = new Color(100, 0,0);
}

