package edu.macalester.comp124.critters;

import acm.graphics.GOval;
import acm.graphics.GPolygon;
import sun.jvm.hotspot.oops.CompiledICHolder;

import java.awt.*;
import java.util.ArrayList;

/**
 * A creature that spins around as it moves.
 * Created by rmunsil on 10/8/15.
 */
public class SpinnyCreature extends Critter {

    static final int NUM_EYES = 5;
    static final int CIRCLE_RADIUS = 25;
    static final double RAD_PER_SEC = 4;

    private ArrayList<Eye> eyes;

    @Override
    protected void buildGraphics() {
        eyes = new ArrayList<Eye>(NUM_EYES);

        GOval body = new GOval(-25, -25, 50, 50);
        body.setFilled(true);
        body.setFillColor(Color.green.darker());
        getGraphics().add(body);

        for(int i = 0; i < NUM_EYES; i++) {
            Eye eye = new Eye(15, .5, .25, Color.PINK);
            double angle = (i / (double)NUM_EYES) * Math.PI * 2;
            addEye(eye, (int)(CIRCLE_RADIUS * Math.sin(angle)), (int)(CIRCLE_RADIUS * Math.cos(angle)));
            eyes.add(eye);
        }
    }

    @Override
    public void moveTowardsGoal(double dt) {
        super.moveTowardsGoal(dt);

        double rotation = getGraphics().getRotation();
        rotation += RAD_PER_SEC * dt;

        getGraphics().setRotation(rotation);

        for(Eye eye : eyes) {
            eye.getGraphics().setRotation(-rotation);
        }


    }
}
