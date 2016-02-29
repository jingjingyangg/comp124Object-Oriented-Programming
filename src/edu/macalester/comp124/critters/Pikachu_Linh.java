package edu.macalester.comp124.critters;

import acm.graphics.GImage;
import acm.graphics.GLine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Pikachu_Linh extends Critter {
	
	@Override
	protected void buildGraphics() {
		
		GLine leftLeg  = new GLine(27, 100, 17, 35);
        leftLeg.setColor(Color.yellow);
        addLeg(new Leg(leftLeg, 2));
        
        GLine rightLeg  = new GLine(50, 100, 17, 35);
        rightLeg.setColor(Color.yellow);
        addLeg(new Leg(rightLeg, 2));
        
       
		GImage pikachu = null;
		try {
			pikachu = new GImage(ImageIO.read(getClass().getResource("/Pikachu.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		getGraphics().add(pikachu);
		
		
		addEye(new Eye(5, 0.26, 0.18, Color.BLACK), 28, 33);
        addEye(new Eye(5, 0.26, 0.18, Color.BLACK), 55, 33);
	}
}
