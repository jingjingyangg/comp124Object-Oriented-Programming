package edu.macalester.comp124.critters;

import acm.graphics.GImage;
import acm.graphics.GRect;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Mario extends Critter{
	
	@Override
	protected void buildGraphics() {
		
		GRect leftLeg  = new GRect(27, 100, 17, 35);
        leftLeg.setColor(strokeColor);
        leftLeg.setFilled(true);
        leftLeg.setFillColor(strokeColor);
        addLeg(new Leg(leftLeg, 2));
        
        GRect rightLeg  = new GRect(50, 100, 17, 35);
        rightLeg.setColor(strokeColor);
        rightLeg.setFilled(true);
        rightLeg.setFillColor(strokeColor);
        addLeg(new Leg(rightLeg, 2));
        
       
		GImage mario = null;
		try {
			mario = new GImage(ImageIO.read(getClass().getResource("/Mario.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		getGraphics().add(mario);
		
		
		addEye(new Eye(5, 0.26, 0.18, Color.RED), 42, 35);
        addEye(new Eye(5, 0.26, 0.18, Color.RED), 55, 35);
	}
	
	
	private static final Color		
		strokeColor = new Color(0, 0, 255),
		fillColor = new Color(100, 0,0);
}
