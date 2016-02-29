package edu.macalester.comp124.breakout;

import acm.graphics.GOval;
import acm.graphics.GPoint;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 * Created by JingjingYang on 10/19/15.
 * Draws one single ball with radius 12.
 * It has a velocity whose dx is randomly generated and dy is fixed at 14.
 */
public class Ball extends GOval {

    private static final int RADIUS = 12;
    private RandomGenerator rgen;
    private GPoint velocity;

    /**
     * This is the constuctor of the Ball class. It draws a ball with radius 12 at the center of the canvas,
     * ans assigns it a velocity whose dx is randomly generated and dy is fixed at 14.
     * @param width
     * @param height
     */
    public Ball(double width, double height) {
        super(1.0 / 2 * width, 1.0 / 2 * height,RADIUS,RADIUS);
        rgen = RandomGenerator.getInstance();
        velocity = new GPoint(rgen.nextInt(-30,30), 14);
    }

    public GPoint getVelocity() {
        return velocity;
    }

    /**
     * This method moves the ball by X and Y of the velocity without taking in any parameters.
     */
    public void move(){
        double dx = getVelocity().getX();
        double dy = getVelocity().getY();

        this.move(dx,dy);
    }

    /**
     * This methods flips the ball in the X direction.
     */
    public void flipX(){
        velocity.setLocation(-getVelocity().getX(), getVelocity().getY());
    }

    /**
     * This methods flips the ball in the Y direction.
     */
    public void flipY(){
        velocity.setLocation(getVelocity().getX(),-getVelocity().getY());
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Ball)){
            return false;
        }

        Ball ball = (Ball) other;
        return (RADIUS == ball.RADIUS) && velocity == ball.velocity;
    }

    public String toString(){
        return("Radius of " + RADIUS + " with a velocity of " + velocity);
    }



}
