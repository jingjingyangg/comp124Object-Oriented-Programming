package edu.macalester.comp124.critters;

import acm.graphics.GOval;
import acm.graphics.GRect;

import java.awt.*;

/**
 * Created by tjones1 on 10/8/15.
 */
public class CircleMan extends Critter{

    @Override
    protected void buildGraphics() {
        GOval leftLeg = new GOval(-5, 0, 25, 25);
        leftLeg.setColor(strokeColor);
        leftLeg.setFilled(true);
        leftLeg.setFillColor(Color.ORANGE);
        addLeg(new Leg(leftLeg, 2));

        GOval rightLeg = new GOval(15, 0, 25, 25);
        rightLeg.setColor(strokeColor);
        rightLeg.setFilled(true);
        rightLeg.setFillColor(Color.ORANGE);
        addLeg(new Leg(rightLeg, 2));

        GOval rightArm = new GOval(38, -35, 20, 20);
        rightArm.setColor(strokeColor);
        rightArm.setFilled(true);
        rightArm.setFillColor(strokeColor);
        addLeg(new Leg(rightArm, 2));

        GOval leftArm = new GOval(-28, -35, 20, 20);
        leftArm.setColor(strokeColor);
        leftArm.setFilled(true);
        leftArm.setFillColor(strokeColor);
        addLeg(new Leg(leftArm, 2));

        GOval body = new GOval(-5, -30, 40, 40);
        body.setColor(strokeColor);
        body.setFilled(true);
        body.setFillColor(fillColor);
        getGraphics().add(body);

        GOval head = new GOval(0, -56, 30, 30);
        head.setColor(strokeColor);
        head.setFilled(true);
        head.setFillColor(Color.ORANGE);
        getGraphics().add(head);

        GRect topHat = new GRect(5, -76, 18, 20);
        topHat.setColor(strokeColor);
        topHat.setFilled(true);
        topHat.setFillColor(strokeColor);
        getGraphics().add(topHat);

        GRect tophatBrim = new GRect(0, -60, 30, 5);
        tophatBrim.setColor(strokeColor);
        tophatBrim.setFilled(true);
        tophatBrim.setFillColor(strokeColor);
        getGraphics().add(tophatBrim);


        Eye leftEye = new Eye(6, 0.26, 0.18, Color.BLACK);
        Eye rightEye = new Eye(6, 0.26, 0.18, Color.BLACK);
        addEye(leftEye, 10, -46);
        addEye(rightEye, 20, -46);
    }

    private static final Color
            strokeColor = new Color(40, 40, 60),
            fillColor   = new Color(100, 0, 170);

}
