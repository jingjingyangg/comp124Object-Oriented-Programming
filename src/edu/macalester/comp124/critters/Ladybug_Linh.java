package edu.macalester.comp124.critters;

import acm.graphics.GOval;
import acm.graphics.GPolygon;
import acm.graphics.GRect;

import java.awt.*;

/**
 * @author Paul Cantrell
 */
public class Ladybug_Linh extends Critter {
    
    @Override
    protected void buildGraphics() {

        GOval body = new GOval(-25, -25, 60, 40);
        body.setFilled(true);
        body.setFillColor(Color.red);
        getGraphics().add(body);

        GOval dot1 = new GOval(-5, -20, 10, 10);
        dot1.setFilled(true);
        dot1.setFillColor(Color.black);
        getGraphics().add(dot1);

        GOval dot2 = new GOval(15, -15, 10, 10);
        dot2.setFilled(true);
        dot2.setFillColor(Color.black);
        getGraphics().add(dot2);

        GOval dot3 = new GOval(3, -3, 10, 10);
        dot3.setFilled(true);
        dot3.setFillColor(Color.black);
        getGraphics().add(dot3);

        GOval head = new GOval(-40, -10, 30, 20);
        head.setFilled(true);
        head.setFillColor(Color.black);
        getGraphics().add(head);

        Eye leftEye = new Eye(3, 0.46, 0.18, Color.DARK_GRAY);
        Eye rightEye = new Eye(3, 0.46, 0.18, Color.DARK_GRAY);
        addEye(leftEye, -35, 0);
        addEye(rightEye, -18, 0);

        for (int x = - 20; x <30; x+=10) {
            createLeg(x);
        }

        GRect antennae1 = new GRect(-35, -20, 2, 10);
        antennae1.setFilled(true);
        antennae1.setFillColor(Color.black);
        addLeg(new Leg(antennae1, 1));

        GRect antennae2 = new GRect(-15, -20, 2, 10);
        antennae2.setFilled(true);
        antennae2.setFillColor(Color.black);
        addLeg(new Leg(antennae2, 1));
    }

    private void createLeg(int x) {
        GRect leg = new GRect(x, 15, 5, 10);
        leg.setFilled(true);
        leg.setFillColor(Color.black);
        addLeg(new Leg(leg, 1));
    }


}
