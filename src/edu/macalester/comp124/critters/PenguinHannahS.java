package edu.macalester.comp124.critters;

import acm.graphics.GOval;
import acm.graphics.GPolygon;
import acm.graphics.GRect;

import java.awt.*;

/**
 * @author Paul Cantrell
 */
public class PenguinHannahS extends Critter {
    
    @Override
    protected void buildGraphics() {

        //Wing1 of penguin.
        GOval wing = new GOval(-35, 15, 20, 50);
        wing.setFilled(true);
        wing.setFillColor(new Color(150, 0, 150));
        getGraphics().add(wing);

        //Wing2 of penguin
        GOval wing2 = new GOval(5, 15, 20, 50);
        wing2.setFilled(true);
        wing2.setFillColor(new Color(150, 0, 150));
        getGraphics().add(wing2);

        //Right leg of penguin.
        GOval rightLeg = new GOval( -10, 70, 30, 10);
        rightLeg.setColor(Color.ORANGE);
        rightLeg.setFilled(true);
        rightLeg.setFillColor(Color.orange);
        addLeg(new Leg(rightLeg, 3));

        //Left leg of penguin.
        GOval LeftLeg = new GOval( -30, 70, 30, 10);
        LeftLeg.setColor(Color.ORANGE);
        LeftLeg.setFilled(true);
        LeftLeg.setFillColor(Color.orange);
        addLeg(new Leg(LeftLeg, 3));

        // Body of penguin.
        GOval body = new GOval(-30, 5, 50, 70);
        body.setFilled(true);
        body.setFillColor(new Color(150, 0, 150));
        getGraphics().add(body);

        // Penguin Belly
        GOval belly = new GOval(-20, 10, 30, 55);
        belly.setFilled(true);
        belly.setFillColor(Color.WHITE);
        getGraphics().add(belly);


        // Head of penguin.
        GOval head = new GOval(-25, -25, 40, 40);
        head.setFilled(true);
        head.setFillColor(new Color(150, 0, 150));
        getGraphics().add(head);


        //Eyes of penguin.
        Eye leftEye = new Eye(6, 0.40, 0.10, Color.CYAN);
        Eye rightEye = new Eye(6, 0.40, 0.10, Color.CYAN);
        addEye(leftEye, -11, -10);
        addEye(rightEye, 5, -10);


        //Beak of penguin.
        createBeak(12, 7, -3, 0);
    }

    private void createBeak(int beakWidth, int beakHeight, int x, int y) {
        GPolygon beakPoly = new GPolygon(x, y);
        beakPoly.setColor(new Color(255, 220, 0));
        beakPoly.setFilled(true);
        beakPoly.setFillColor(beakPoly.getColor());

        beakPoly.addVertex(-beakWidth / 2, 0);
        beakPoly.addVertex(0, beakHeight / 2);
        beakPoly.addVertex(beakWidth/2, 0);
        beakPoly.addVertex(0, -beakHeight/2);

        getGraphics().add(beakPoly);
    }
}
