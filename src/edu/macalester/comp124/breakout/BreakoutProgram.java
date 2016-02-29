package edu.macalester.comp124.breakout;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GPoint;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Main GraphicsProgram for the breakout game described
 * in exercise 10.10 int the Roberts Textbook.
 */
public class BreakoutProgram extends GraphicsProgram {

    private Ball ball;
    private Paddle paddle;
    private GPoint clickedPoint = null;

    private static final int BRICKWIDTH = 60;
    private static final int BRICKHEIGHT = 12;
    private static final int RADIUS = 12;

    boolean hasWon = false;

    /**
     * Initializes the game by creating the ball, the paddle and the brick walls.
     */
    public void init() {

        ball = new Ball(getWidth(), getHeight());
        ball.setFilled(true);
        ball.setFillColor(Color.black);
        paddle = new Paddle(getWidth(), getHeight());
        paddle.setFilled(true);
        paddle.setFillColor(Color.black);

        add(paddle);
        add(ball);
        brickWall(3, 3);

        addMouseListeners();
    }

    /**
     * Runs the main program by calling gameloop().
     */
    public void run(){
        gameLoop();
    }


    /**
     * This method simulates three rounds of games (or less if the player finishes all the bricks before using up all his three lives).
     * It calls on the paddleAnimation(), checkPaddleCollision(), and checkBrickCollision() methods.
     * If there are still bricks left when the player uses up all his lives, he loses the game.
     * A win or lose sign will appear at the center of the screen when the games ends.
     */
    public void gameLoop() {
         for (int i = 0; i < 3; i++) {
                ball.setLocation(1.0 / 2 * getWidth(), 1.0 / 2 * getHeight());
                paddle.setLocation(1.0 / 2 * getWidth(), 7.0 / 8 * getHeight());
                waitForClick();
                while (true) {
                    paddleAnimation();
                    ball.move();
                    checkPaddleCollision();
                    checkBrickCollision();
                    if (getElementCount() == 2) {
                        hasWon = true;
                        break;
                    }
                    if (ball.getY() >= getHeight()) {
                        break;
                    }
                    if (ball.getX() <= 0 || ball.getX() >= getWidth()) {
                        ball.flipX();
                    }
                    if (ball.getY() <= 0) {
                        ball.flipY();
                    }
                    pause(100);
                }
             if (hasWon){
                 break;
             }
        }
        if (hasWon){
            GLabel win = new GLabel("You have WON!!! ");
            add(win, 1.0 / 2 * getWidth(), 1.0 / 2 * getHeight());
        } else {
            GLabel end = new GLabel("You have lost the game :( ");
            add(end, 1.0 / 2 * getWidth(), 1.0 / 2 * getHeight());
        }
    }


    @Override
    public void mouseDragged(MouseEvent e){
        clickedPoint = new GPoint(e.getX(), e.getY());
    }

    /**
     * This method animates the paddle so the player can drag the paddle anywhere on a horizontal line using a mouse.
     */
    public void paddleAnimation(){
        if (clickedPoint != null) {
            double xCurrent = paddle.getX();
            paddle.move(clickedPoint.getX() - xCurrent, 0);
            clickedPoint = null;
        }
    }

    /**
     * This method checks if the ball has collided with the paddle. If so, it flips the direction of the ball's movement.
     */
    public void checkPaddleCollision(){
        double xCurrent = ball.getX();
        double yCurrent = ball.getY();
        GPoint lowerLeft = new GPoint(xCurrent,yCurrent + 2 * RADIUS);
        GPoint lowerRight = new GPoint(xCurrent + 2 * RADIUS, yCurrent + 2 * RADIUS);
        if (getElementAt(lowerLeft) == paddle || getElementAt(lowerRight) == paddle){
            ball.flipY();
        }
    }

    /**
     * This method checks if the ball has collided with any of the bricks. If so, it removes the brick(or bricks) it has touched,
     * and then flips the direction of its movement.
     */
    public void checkBrickCollision(){
        double xCurrent = ball.getX();
        double yCurrent = ball.getY();
        GPoint upLeft = ball.getLocation();
        GPoint upRight = new GPoint(xCurrent + 2 * RADIUS, yCurrent);
        GPoint lowerLeft = new GPoint(xCurrent,yCurrent + 2 * RADIUS);
        GPoint lowerRight = new GPoint(xCurrent + 2 * RADIUS, yCurrent + 2 * RADIUS);

        GObject corner1 = getElementAt(upLeft);
        GObject corner2 = getElementAt(upRight);
        GObject corner3 = getElementAt(lowerLeft);
        GObject corner4 = getElementAt(lowerRight);

        if (corner1 instanceof Brick){
            remove(corner1);
            if (corner2 instanceof Brick) {
                ball.flipY();
                if (corner1 != corner2){
                    remove(corner2);
                }
            }
            else if (corner3 instanceof Brick){
                ball.flipX();
                if (corner3 != corner1){
                    remove(corner3);
                }
            }
            else if (corner3 == null && corner2 == null) {
                ball.flipX();
                ball.flipY();
            }
        }

        else if (corner4 instanceof Brick) {
            remove(corner4);
            if (corner3 instanceof Brick) {
                ball.flipY();
                if (corner3 != corner4) {
                    remove(corner3);
                }
            } else if (corner2 instanceof Brick) {
                ball.flipX();
                if (corner2 != corner4) {
                    remove(corner2);
                }
            } else if (corner3 == null && corner2 == null) {
                ball.flipX();
                ball.flipY();
            }
        }

        else if (corner1 == null && corner4 == null){
            if (corner3 instanceof Brick){
                remove(corner3);
                ball.flipX();
                ball.flipY();
            } else if (corner2 instanceof Brick){
                remove(corner2);
                ball.flipX();
                ball.flipY();
            }
        }
    }

    /**
     * This methods takes in two integers representing the initial position of the first brick
     * and generates four levels of brick walls.
     * @param X
     * @param Y
     */
    public void brickWall(int X, int Y) {
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < getWidth() / BRICKWIDTH; i++) {
                Brick brick = new Brick(X + (BRICKWIDTH + 3) * i, Y);
                add(brick);
            }
            Y += BRICKHEIGHT;
        }
    }

}
