package edu.macalester.comp124.critters;

import acm.graphics.GRect;

import java.awt.*;

/**
 * Created by Charle5 on 10/8/2015.
 */
public class CrabMan extends Critter {
    @Override
    protected void buildGraphics() {
        GRect leftLeg  = new GRect(27, 100, 35, 17);
        leftLeg.setColor(strokeColor);
        leftLeg.setFilled(true);
        leftLeg.setFillColor(strokeColor);
        addLeg(new Leg(leftLeg, 2));



        GRect rightLeg  = new GRect(50, 100, 35, 17);
        rightLeg.setColor(strokeColor);
        rightLeg.setFilled(true);
        rightLeg.setFillColor(strokeColor);
        addLeg(new Leg(rightLeg, 5));

        GRect otherLeg  = new GRect(73, 100, 35, 17);
        otherLeg.setColor(strokeColor);
        otherLeg.setFilled(true);
        otherLeg.setFillColor(strokeColor);
        addLeg(new Leg(otherLeg, 4));

        GRect midLeft  = new GRect(55, 100, 10, 17);
        midLeft.setColor(Color.BLACK);
        midLeft.setFilled(true);
        midLeft.setFillColor(strokeColor);
        addLeg(new Leg(midLeft, 1));

        GRect head = new GRect(27,100,15,20);
        head.setColor(strokeColor);
        head.setFilled(true);
        head.setFillColor(strokeColor);
        getGraphics().add(head);

        GRect mouth = new GRect(30,115,10,1);
        mouth.setColor(Color.BLACK);
        mouth.setFilled(true);
        mouth.setFillColor(Color.BLACK);
        getGraphics().add(mouth);


        Eye leftEye = new Eye(1, .18, 0.18, Color.BLACK);
        Eye rightEye = new Eye(1, .18, 0.18, Color.BLACK);
        addEye(leftEye, 31 , 107);
        addEye(rightEye, 38, 107);

    }
    private static final Color
    strokeColor = new Color(255, 128, 128);

}
