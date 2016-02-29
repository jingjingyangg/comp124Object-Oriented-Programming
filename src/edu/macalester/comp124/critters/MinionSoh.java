package edu.macalester.comp124.critters;

import acm.graphics.GImage;
import acm.graphics.GRect;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Created by sojinoh on 10/8/15.
 */
public class MinionSoh extends Critter {

    @Override
    protected void buildGraphics() {

        GRect leftLeg  = new GRect(17, 96, 14, 15);
        leftLeg.setColor(strokeColor);
        leftLeg.setFilled(true);
        leftLeg.setFillColor(strokeColor);
        addLeg(new Leg(leftLeg, 2));

        GRect rightLeg  = new GRect(40, 96, 14, 15);
        rightLeg.setColor(strokeColor);
        rightLeg.setFilled(true);
        rightLeg.setFillColor(strokeColor);
        addLeg(new Leg(rightLeg, 2));


        GImage minion = null;
        try {
            minion = new GImage(ImageIO.read(getClass().getResource("/minion1.png")));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        getGraphics().add(minion);


        addEye(new Eye(5, 0.26, 0.18, Color.BLACK), 24, 35);
        addEye(new Eye(5, 0.26, 0.18, Color.BLACK), 44, 35);
    }


    private static final Color
            strokeColor = new Color(0, 140, 255),
            fillColor = new Color(100, 0,0);
}
