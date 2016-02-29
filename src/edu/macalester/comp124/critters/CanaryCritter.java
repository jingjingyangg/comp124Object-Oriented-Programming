package edu.macalester.comp124.critters;

import acm.graphics.GImage;
import acm.graphics.GRect;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class CanaryCritter extends Critter{

    @Override
    protected void buildGraphics() {

        GRect leftLeg  = new GRect(45, 65, 6, 12);
        leftLeg.setColor(fillColor);
        leftLeg.setFilled(true);
        leftLeg.setFillColor(fillColor);
        addLeg(new Leg(leftLeg, 2));

        GRect rightLeg  = new GRect(70, 65, 6, 12);
        rightLeg.setColor(fillColor);
        rightLeg.setFilled(true);
        rightLeg.setFillColor(fillColor);
        addLeg(new Leg(rightLeg, 2));


        GImage eagle = null;
        try {
            eagle = new GImage(ImageIO.read(getClass().getResource("/bald-eagle.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }


        getGraphics().add(eagle);


        addEye(new Eye(5, 0.26, 0.18, Color.YELLOW), 57, 5);
    }


    private static final Color
            fillColor = new Color(255, 240, 10);
}
