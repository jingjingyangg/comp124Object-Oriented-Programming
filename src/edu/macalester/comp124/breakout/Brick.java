package edu.macalester.comp124.breakout;

import acm.graphics.GRect;

/**
 * Created by JingjingYang on 10/20/15.
 * Draws one single brick with width 60 and height 12.
 */
public class Brick extends GRect {

    private static final int BRICKWIDTH = 60;
    private static final int BRICKHEIGHT = 12;

    public Brick(double width, double height){
        super(width,height, BRICKWIDTH, BRICKHEIGHT);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Brick)){
            return false;
        }

        Brick brick = (Brick) other;
        return (BRICKWIDTH == brick.BRICKWIDTH) && BRICKHEIGHT == brick.BRICKHEIGHT;
    }

    public String toString(){
        return("Width: " + BRICKWIDTH + " Height: " + BRICKHEIGHT);
    }
}
