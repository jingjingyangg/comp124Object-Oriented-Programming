package edu.macalester.comp124.critters;

import acm.graphics.GOval;
import acm.graphics.GPoint;
import acm.graphics.GPolygon;
import sun.jvm.hotspot.oops.CompiledICHolder;

import java.awt.*;
import java.util.ArrayList;

/**
 * A creature that circles around the center
 * Created by rmunsil on 10/8/15.
 */
public class CoriolisRoach extends Critter {

    @Override
    protected void buildGraphics() {
        GOval body = new GOval(50, 30);
        body.setFilled(true);
        body.setFillColor(Color.RED.darker().darker());
        getGraphics().add(body);

        Eye eye1 = new Eye(5, .1, .01, Color.GRAY);
        addEye(eye1, 10, 5);
        Eye eye2 = new Eye(5, .1, .01, Color.GRAY);
        addEye(eye2, 10, 25);
    }

    @Override
    public void moveTowardsGoal(double dt) {
        double dx = getGraphics().getX() - 600;
        double dy = getGraphics().getY() - 529;

        double angleFromCenter = Math.atan2(dy, dx);
        getGraphics().setRotation(angleFromCenter - Math.PI / 2);
        angleFromCenter += .1;



        double distanceFromCenter = Math.hypot(dx, dy);

        GPoint newGoal = new GPoint(600 + distanceFromCenter * Math.cos(angleFromCenter),
                529 + distanceFromCenter * Math.sin(angleFromCenter));
        setGoal(newGoal);

        super.moveTowardsGoal(dt * 3);
    }
}
