package edu.macalester.comp124.breakout;

import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * Created by JingjingYang on 10/19/15.
 * Draws one single paddle with width 60 and height 10.
 * It's positioned at the center lower part of the canvas.
 */
public class Paddle extends GRect{

    private static final int PADDLEWIDTH = 60;
    private static final int PADDLEHEIGHT = 12;

    public Paddle(double width, double height){
        super(1.0/2 * width, 7.0/8 * height,60,10);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Paddle)){
            return false;
        }

        Paddle paddle = (Paddle) other;
        return (PADDLEWIDTH == paddle.PADDLEWIDTH) && PADDLEHEIGHT == paddle.PADDLEHEIGHT;
    }

    public String toString(){
        return("Width: " + PADDLEWIDTH + " Height: " + PADDLEHEIGHT);
    }
}
