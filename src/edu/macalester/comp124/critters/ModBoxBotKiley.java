package edu.macalester.comp124.critters;

import acm.graphics.GRect;

import java.awt.*;

/**
 * Created by djdmfd on 10/8/15.
 * Lengthens legs and changes colors of original BoxBot
 */
public class ModBoxBotKiley extends Critter {

    @Override
    protected void buildGraphics() {

        // left leg is now blue and twice as long
        GRect leftLeg  = new GRect(-16, 0, 10, 80);
        leftLeg.setColor(Color.blue);
        leftLeg.setFilled(true);
        leftLeg.setFillColor(Color.blue);
        addLeg(new Leg(leftLeg, 2));

        // right leg is now pink and twice as long
        GRect rightLeg = new GRect( 6, 0, 10, 80);
        rightLeg.setColor(Color.pink);
        rightLeg.setFilled(true);
        rightLeg.setFillColor(Color.pink);
        addLeg(new Leg(rightLeg, 2));

        // body is now black
        GRect body = new GRect(-20, -30, 40, 40);
        body.setColor(Color.black);
        body.setFilled(true);
        body.setFillColor(Color.black);
        getGraphics().add(body);

        // head is now black
        GRect head = new GRect(-18, -56, 36, 20);
        head.setColor(Color.black);
        head.setFilled(true);
        head.setFillColor(Color.black);
        getGraphics().add(head);

        // left eye is now cyan and right eye is magenta
        Eye leftEye = new Eye(6, 0.26, 0.18, Color.cyan);
        Eye rightEye = new Eye(6, 0.26, 0.18, Color.magenta);
        addEye(leftEye, -10, -46);
        addEye(rightEye, 10, -46);
    }

    private static final Color
            strokeColor = new Color(40, 40, 60),
            fillColor   = new Color(160, 172, 182);

}
