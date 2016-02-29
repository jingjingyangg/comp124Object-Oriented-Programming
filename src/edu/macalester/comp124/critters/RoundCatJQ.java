package edu.macalester.comp124.critters;

import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GPolygon;
import acm.graphics.GRect;

import java.awt.*;

/**
 * Created by jqu on 10/8/15.
 */
public class RoundCatJQ extends Critter {
    @Override
    protected void buildGraphics() {
        createEar();
        createEar();
        GOval body = new GOval(-25, -25, 50, 50);
        body.setFilled(true);
        body.setFillColor(new Color(255, 219, 88));
        getGraphics().add(body);

        GOval leftEye = new GOval(-6,-5,5,5);
        GOval rightEye = new GOval(5,-5,5,5);
        leftEye.setFilled(true);
        rightEye.setFilled(true);
        leftEye.setFillColor(Color.BLACK);
        rightEye.setFillColor(Color.BLACK);
        getGraphics().add(rightEye);
        getGraphics().add(leftEye);

        GLine beard1 = new GLine(-7,3,-15,0);
        GLine beard2 = new GLine(-7,3,-15,3);
        GLine beard3 = new GLine(-7,3,-15,6);
        GLine beard4 = new GLine(7,3,15,0);
        GLine beard5 = new GLine(7,3,15,3);
        GLine beard6 = new GLine(7,3,15,6);

        getGraphics().add(beard1);
        getGraphics().add(beard2);
        getGraphics().add(beard3);
        getGraphics().add(beard4);
        getGraphics().add(beard5);
        getGraphics().add(beard6);

        GOval leftLeg  = new GOval(-25, 15, 20, 20);
        leftLeg.setFilled(true);
        leftLeg.setFillColor(new Color(195, 88, 23));
        addLeg(new Leg(leftLeg, 2));

        GOval rightLeg = new GOval(20, 15, 20, 20);
        rightLeg.setFilled(true);
        rightLeg.setFillColor(new Color(195,88,23));
        addLeg(new Leg(rightLeg, 2));

    }

    private void createEar() {
        GPolygon outerEarPoly = new GPolygon();
        outerEarPoly.setColor(new Color(255, 219, 88));
        outerEarPoly.setFilled(true);
        outerEarPoly.setFillColor(new Color(255, 219, 88));

        outerEarPoly.addVertex(-3, -10);
        outerEarPoly.addVertex(-30, -25);
        outerEarPoly.addVertex(-25, -5);
        outerEarPoly.addVertex(3, -10);
        outerEarPoly.addVertex(30, -25);
        outerEarPoly.addVertex(25, -5);

        GPolygon innerEarPoly = new GPolygon();
        innerEarPoly.setFilled(true);
        innerEarPoly.setFillColor(new Color(253, 215, 228));

        innerEarPoly.addVertex(-2.0, -9.6);
        innerEarPoly.addVertex(-29.7, -24.6);
        innerEarPoly.addVertex(-24.7, -4.6);
        innerEarPoly.addVertex(2.0,-9.6);
        innerEarPoly.addVertex(29.7,-24.6);
        innerEarPoly.addVertex(24.7,-4.6);


        getGraphics().add(outerEarPoly);
        getGraphics().add(innerEarPoly);
    }

}
