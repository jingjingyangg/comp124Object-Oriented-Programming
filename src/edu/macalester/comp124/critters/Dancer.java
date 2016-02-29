package edu.macalester.comp124.critters;

import acm.graphics.GOval;
import acm.graphics.GRect;

import java.awt.*;

/**
 * Created by bgithinji on 10/8/15.
 */
public class Dancer extends Critter {

    @Override
    protected void buildGraphics() {
        GRect leftLeg  = new GRect(-16, 0, 10, 40);
        leftLeg.setColor(strokeColor);
        leftLeg.setFilled(true);
        leftLeg.setFillColor(fillColor);
        addLeg(new Leg(leftLeg, 2));

        GRect rightLeg = new GRect( 6, 0, 10, 40);
        rightLeg.setColor(strokeColor);
        rightLeg.setFilled(true);
        rightLeg.setFillColor(fillColor);
        addLeg(new Leg(rightLeg, 2));

        GRect leftFoot  = new GRect(-25, 30, 10, 10);
        leftFoot.setColor(strokeColor);
        leftFoot.setFilled(true);
        leftFoot.setFillColor(fillColor);
        addLeg(new Leg(leftFoot, 2));

        GRect rightFoot = new GRect(15, 30, 10, 10);
        rightFoot.setColor(strokeColor);
        rightFoot.setFilled(true);
        rightFoot.setFillColor(fillColor);
        addLeg(new Leg(rightFoot, 2));

        GRect leftArm  = new GRect(-32, -50, 10, 20);
        leftArm.setColor(strokeColor);
        leftArm.setFilled(true);
        leftArm.setFillColor(fillColor);
        addLeg(new Leg(leftArm, 3));

        GRect rightArm = new GRect( 22, -50, 10, 20);
        rightArm.setColor(strokeColor);
        rightArm.setFilled(true);
        rightArm.setFillColor(fillColor);
        addLeg(new Leg(rightArm, 3));

        GRect body = new GRect(-20, -30, 40, 40);
        body.setColor(strokeColor);
        body.setFilled(true);
        body.setFillColor(fillColor);
        getGraphics().add(body);

        GOval head = new GOval(-18.0, -56.0, 30.0, 30.0);
        head.setColor(strokeColor);
        head.setFilled(true);
        head.setFillColor(fillColor);
        getGraphics().add(head);

        Eye leftEye = new Eye(6, 0.26, 0.18, Color.GREEN);
        Eye rightEye = new Eye(6, 0.26, 0.18, Color.GREEN);
        addEye(leftEye, -10, -46);
        addEye(rightEye, 10, -46);
    }

    private static final Color
            strokeColor = new Color(0, 0, 0),
            fillColor   = new Color(150, 30, 250);

}
