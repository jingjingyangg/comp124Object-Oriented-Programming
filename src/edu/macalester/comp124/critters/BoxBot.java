package edu.macalester.comp124.critters;

import acm.graphics.GOval;
import acm.graphics.GRect;

import java.awt.*;

/**
 * @author Paul Cantrell
 */
public class BoxBot extends Critter {
    
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
        
        GRect body = new GRect(-20, -30, 40, 40);
        body.setColor(strokeColor);
        body.setFilled(true);
        body.setFillColor(fillColor);
        getGraphics().add(body);
        
        GRect head = new GRect(-18, -56, 36, 20);
        head.setColor(strokeColor);
        head.setFilled(true);
        head.setFillColor(fillColor);
        getGraphics().add(head);

        Eye leftEye = new Eye(6, 0.26, 0.18, Color.BLUE);
        Eye rightEye = new Eye(6, 0.26, 0.18, Color.BLUE);
        addEye(leftEye, -10, -46);
        addEye(rightEye, 10, -46);
    }

    private static final Color
        strokeColor = new Color(40, 40, 60),
        fillColor   = new Color(160, 172, 182);

}
