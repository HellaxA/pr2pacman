package com.bereznikov.pacman.search;

public class MazeSearchTree {
    private int pos;
    private MazeSearchTree down;
    private MazeSearchTree right;
    private MazeSearchTree up;
    private MazeSearchTree left;
    private boolean found;
    private int parent;
    private boolean wayOut;

    public MazeSearchTree() {
    }

    public MazeSearchTree(int pos) {
        this.pos = pos;
    }

    public MazeSearchTree(int pos, MazeSearchTree down, MazeSearchTree right, MazeSearchTree up, MazeSearchTree left) {
        this.pos = pos;
        this.down = down;
        this.right = right;
        this.up = up;
        this.left = left;
    }

    public MazeSearchTree(MazeSearchTree down, MazeSearchTree right, MazeSearchTree up, MazeSearchTree left) {
        this.down = down;
        this.right = right;
        this.up = up;
        this.left = left;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public MazeSearchTree getDown() {
        return down;
    }

    public void setDown(MazeSearchTree down) {
        this.down = down;
    }

    public MazeSearchTree getRight() {
        return right;
    }

    public void setRight(MazeSearchTree right) {
        this.right = right;
    }

    public MazeSearchTree getUp() {
        return up;
    }

    public void setUp(MazeSearchTree up) {
        this.up = up;
    }

    public MazeSearchTree getLeft() {
        return left;
    }

    public void setLeft(MazeSearchTree left) {
        this.left = left;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public boolean isWayOut() {
        return wayOut;
    }

    public void setWayOut(boolean wayOut) {
        this.wayOut = wayOut;
    }

    @Override
    public String toString() {
        return "MazeSearchTree{" +
                "pos=" + pos +
                ", down=" + down +
                ", right=" + right +
                ", up=" + up +
                ", left=" + left +
                ", found=" + found +
                '}';
    }
}
