package com.bereznikov.pacman;

public interface RobotMovement {
    void start();

    void moveRight();
    void moveLeft();
    void moveUp();
    void moveDown();

    void moveRight(int times);
    void moveLeft(int times);
    void moveUp(int times);
    void moveDown(int times);


}
