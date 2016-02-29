package edu.macalester.comp124.critters;

import acm.graphics.GPolygon;
import acm.graphics.GRect;

import java.awt.*;

/**
 * Created by angelica on 10/8/15.
 */
public class AngelicaBox extends Critter {

    private static final Color tardisBlue = new Color(16,35,114);

    @Override
    protected void buildGraphics() {
        GRect body = new GRect(0,0,40,90);
        body.setFilled(true);
        body.setFillColor(tardisBlue);
        getGraphics().add(body);

        GRect window1 = new GRect(5,12,10,10);
        window1.setColor(Color.black);
        window1.setFilled(true);
        window1.setFillColor(Color.white);
        addLeg(new Leg(window1,1));

        GRect window2 = new GRect(25,12,10,10);
        window2.setColor(Color.black);
        window2.setFilled((true));
        window2.setFillColor(Color.white);
        addLeg(new Leg(window2,1));

        GRect block1 = new GRect(25,32,10,10);
        block1.setFilled(true);
        block1.setFillColor(Color.black);
        addLeg(new Leg(block1,1));

        GRect window3 = new GRect(5,32,8,8);
        window3.setColor(Color.black);
        window3.setFilled(true);
        window3.setFillColor(Color.white);
        addLeg(new Leg(window3,1));

        GRect block2 = new GRect(5,52,10,10);
        block2.setFilled(true);
        block2.setFillColor(Color.BLACK);
        addLeg(new Leg(block2,1));

        GRect block3 = new GRect(25,52,10,10);
        block3.setFilled(true);
        block3.setFillColor(Color.BLACK);
        addLeg(new Leg(block3,1));

        GRect block4 = new GRect(5,72,10,10);
        block4.setFilled(true);
        block4.setFillColor(Color.BLACK);
        addLeg(new Leg(block4,1));

        GRect block5 = new GRect(25,72,10,10);
        block5.setFilled(true);
        block5.setFillColor(Color.BLACK);
        addLeg(new Leg(block5,1));

        GRect headLine = new GRect(2,4,36,7);
        headLine.setFilled(true);
        headLine.setFillColor(Color.BLACK);
        getGraphics().add(headLine);

        GPolygon head = new GPolygon(0,0);
        head.addEdge(20,-5);
        head.addEdge(20,5);
        head.addEdge(-40,0);
        head.setFilled(true);
        head.setFillColor(tardisBlue);
        getGraphics().add(head);


        GPolygon light = new GPolygon(19,-5);
        light.addEdge(0,-1.5);
        light.addEdge(1,-0.5);
        light.addEdge(1,0.5);
        light.addEdge(0,1.5);
        light.addEdge(-2,0);
        light.setFilled(true);
        light.setFillColor(tardisBlue);
        getGraphics().add(light);

    }
}
