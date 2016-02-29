package edu.macalester.comp124.critters;

import acm.graphics.GArc;
import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;

import java.awt.*;

/**
 * Created by djdmfd on 10/8/15.
 * Draws a butterfly with a black body and magenta wings with a blue/cyan/green pattern
 */
public class ButterflyKiley extends Critter {

    @Override
    protected void buildGraphics() {

        // add wings first so that the body is on top (stacking order)
        GArc rightWing = new GArc(100, 100, -60, 120);
        rightWing.setColor(Color.magenta);
        rightWing.setFilled(true);
        rightWing.setFillColor(Color.magenta);
        // position in format (cx - r, cy - r) for arc
        getGraphics().add(rightWing, (-15 - 50), (0 - 50));

        GArc leftWing = new GArc(100, 100, 120, 120);
        leftWing.setColor(Color.magenta);
        leftWing.setFilled(true);
        leftWing.setFillColor(Color.magenta);
        getGraphics().add(leftWing, (-15 - 50), (0 - 50));

        GOval rightWingDot = new GOval(-3, -15, 30, 30);
        rightWingDot.setColor(Color.blue);
        rightWingDot.setFilled(true);
        rightWingDot.setFillColor(Color.blue);
        getGraphics().add(rightWingDot);

        GOval rightWingDot2 = new GOval(7, -5, 10, 10);
        rightWingDot2.setColor(Color.cyan);
        rightWingDot2.setFilled(true);
        rightWingDot2.setFillColor(Color.cyan);
        getGraphics().add(rightWingDot2);

        GLine rightWingLine = new GLine(-15, 0, 35, 0);
        rightWingLine.setColor(Color.green);
        getGraphics().add(rightWingLine);

        GOval leftWingDot = new GOval(-57, -15, 30, 30);
        leftWingDot.setColor(Color.blue);
        leftWingDot.setFilled(true);
        leftWingDot.setFillColor(Color.blue);
        getGraphics().add(leftWingDot);

        GOval leftWingDot2 = new GOval(-47, -5, 10, 10);
        leftWingDot2.setColor(Color.cyan);
        leftWingDot2.setFilled(true);
        leftWingDot2.setFillColor(Color.cyan);
        getGraphics().add(leftWingDot2);

        GLine leftWingLine = new GLine(-15, 0, -65, 0);
        leftWingLine.setColor(Color.green);
        getGraphics().add(leftWingLine);

        GOval body = new GOval(-20, -30, 10, 60);
        body.setColor(Color.black);
        body.setFilled(true);
        body.setFillColor(Color.black);
        getGraphics().add(body);

        GOval head = new GOval(-23, -43, 16, 16);
        head.setColor(Color.black);
        head.setFilled(true);
        head.setFillColor(Color.black);
        getGraphics().add(head);
    }
}
