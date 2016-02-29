package edu.macalester.comp124.critters;

import acm.graphics.*;

import java.awt.*;

/**
 * Created by Anja on 10/8/2015.
 */
public class AnjaBethBot extends Critter {

    @Override
    protected void buildGraphics() {
        GRect leftLeg  = new GRect(-16, 0, 10, 50);
        leftLeg.setColor(strokeColor);
        leftLeg.setFilled(true);
        leftLeg.setFillColor(legColor);
        addLeg(new Leg(leftLeg, 2));

        GRect rightLeg = new GRect( 6, 0, 10, 50);
        rightLeg.setColor(strokeColor);
        rightLeg.setFilled(true);
        rightLeg.setFillColor(legColor);
        addLeg(new Leg(rightLeg, 2));

        GOval body = new GOval(-20, -30, 40, 60);
        body.setColor(strokeColor);
        body.setFilled(true);
        body.setFillColor(fillColor);
        getGraphics().add(body);

        GImage rainbow = new GImage("rainbowgif.gif", -15, -20);
        getGraphics().add(rainbow);


        GRect head = new GRect(-18, -56, 36, 20);
        head.setColor(strokeColor);
        head.setFilled(true);
        head.setFillColor(fillColor);
        getGraphics().add(head);

        GOval leftEar = new GOval(-23, -50, 5, 10);
        leftEar.setColor(strokeColor);
        leftEar.setFilled(true);
        leftEar.setFillColor(legColor);
        getGraphics().add(leftEar);

        GOval rightEar = new GOval(18, -50, 5, 10);
        rightEar.setColor(strokeColor);
        rightEar.setFilled(true);
        rightEar.setFillColor(legColor);
        getGraphics().add(rightEar);


        GArc hat = new GArc(-18, -68, 36, 20, 0, 180 );
        hat.setColor(strokeColor);
        hat.setFilled(true);
        hat.setFillColor(hatColor);
        getGraphics().add(hat);



        Eye eye = new Eye(6, 0.4, 0.1 ,eyeColor );

        addEye(eye, 0, -46);

    }



    private static final Color
            strokeColor = new Color(40, 40, 60),
            fillColor   = new Color(0x7252b2),
            hatColor = new Color(0x66ffc2),
            eyeColor = new Color(0x00ccff),
            legColor = new Color(0xff7575);

}


