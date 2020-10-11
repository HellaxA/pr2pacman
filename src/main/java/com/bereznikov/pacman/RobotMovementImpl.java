package com.bereznikov.pacman;

import com.bereznikov.pacman.search.DepthSearch;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotMovementImpl implements RobotMovement {
    private Board theBoard;
    private Robot robot;
    private DepthSearch depthSearch;

    public RobotMovementImpl() {
    }

    public RobotMovementImpl(Robot robot, Board theBoard, DepthSearch depthSearch) {
        this.robot = robot;
        this.theBoard = theBoard;
        this.depthSearch = depthSearch;
    }

    public void start() {
        startGame();
        depthSearch.setBoard(theBoard);
        depthSearch.findAlgo();
    }

    private void startGame() {
        robot.delay(100);
        robot.keyPress(KeyEvent.VK_S);
    }

    @Override
    public void moveRight() {
        move(KeyEvent.VK_RIGHT);
    }

    @Override
    public void moveLeft() {
        move(KeyEvent.VK_LEFT);
    }

    @Override
    public void moveUp() {
        move(KeyEvent.VK_UP);
    }

    @Override
    public void moveDown() {
        move(KeyEvent.VK_DOWN);
    }

    @Override
    public void moveRight(int times) {
        move(KeyEvent.VK_RIGHT, times);
    }

    @Override
    public void moveLeft(int times) {
        move(KeyEvent.VK_LEFT, times);
    }

    @Override
    public void moveUp(int times) {
        move(KeyEvent.VK_UP, times);
    }

    @Override
    public void moveDown(int times) {
        move(KeyEvent.VK_DOWN, times);
    }


    private void move(int button) {
        robot.keyPress(button);
        robot.delay(1000);
    }

    private void move(int button, int times) {
        robot.keyPress(button);
        robot.delay(1000 * times);
    }

    public Board getTheBoard() {
        return theBoard;
    }

    public void setTheBoard(Board theBoard) {
        this.theBoard = theBoard;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }
}
