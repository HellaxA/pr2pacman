package com.bereznikov.pacman.search;

import com.bereznikov.pacman.Board;
import com.bereznikov.pacman.console.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DepthSearchImpl implements DepthSearch {
    public static List<Integer> checkedPos = new ArrayList<>();
    private int sumOfSteps;
    private int PARENT_DOWN = 1;
    private int PARENT_RIGHT = 2;
    private int PARENT_UP = 3;
    private int PARENT_LEFT = 4;
    private Board board;
    private MazeSearchTree theTree;
    private List<String> moves;

    public List<String> path() {
        return null;
    }

    @Override
    public List<String> findAlgo() {
        short[] screenData = board.getScreenData();
        int pacmanPos = getPacmanIdInScreenData();

        moves = new ArrayList<>();
        theTree = new MazeSearchTree(pacmanPos);


        long startTime = System.nanoTime();

        makeTree(theTree);
        findTrueInTree(theTree);

        long endTime = System.nanoTime();

        ConsoleHelper.print("Time: " + (endTime - startTime) + " ns");
        ConsoleHelper.print("Steps: " + sumOfSteps);
        ConsoleHelper.print("Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024 + "MB");
        Collections.reverse(moves);
        ConsoleHelper.print(moves.toString());

        return moves;
    }


    private int findTrueInTree(MazeSearchTree theTree) {
        sumOfSteps++;
        int res = theTree.getPos();
        if (theTree.isFound()) {
            return res;
        }

        if (theTree.getDown() != null) {
            int resFromRecur = findTrueInTree(theTree.getDown());
            if (resFromRecur != -1) {
                moves.add("down");
                return resFromRecur;
            }
        }

        if (theTree.getRight() != null) {
            int resFromRecur = findTrueInTree(theTree.getRight());
            if (resFromRecur != -1) {
                moves.add("right");
                return resFromRecur;
            }
        }

        if (theTree.getUp() != null) {
            int resFromRecur = findTrueInTree(theTree.getUp());
            if (resFromRecur != -1) {
                moves.add("up");
                return resFromRecur;
            }

        }

        if (theTree.getLeft() != null) {
            int resFromRecur = findTrueInTree(theTree.getLeft());
            if (resFromRecur != -1) {
                moves.add("left");
                return resFromRecur;
            }
        }
        return -1;
    }

    @Override
    public MazeSearchTree makeTree(MazeSearchTree theTree) {
        checkedPos.add(theTree.getPos());

        if ((board.getScreenData()[theTree.getPos() - 1] & 16) != 0) {
            theTree.setFound(true);
            theTree.setWayOut(true);
            return theTree;
        }
        if ((board.getScreenData()[theTree.getPos() - 1] & 8) == 0 && theTree.getDown() == null) {

            int currPos = theTree.getPos() + board.getN_BLOCKS();
            if (!checkedPos.contains(currPos)) {

                MazeSearchTree subtree = new MazeSearchTree(currPos);

                theTree.setDown(subtree);
                //subtree.setUp(theTree);

                makeTree(subtree);

                if (theTree.getDown().isWayOut()) {
                    theTree.setWayOut(true);
                    return theTree;
                }
            }
        }


        if ((board.getScreenData()[theTree.getPos() - 1] & 4) == 0 && theTree.getRight() == null) {

            int currPos = theTree.getPos() + 1;
            if (!checkedPos.contains(currPos)) {

                MazeSearchTree subtree = new MazeSearchTree(currPos);

                theTree.setRight(subtree);
                //subtree.setLeft(theTree);

                makeTree(subtree);

                if (theTree.getRight().isWayOut()) {
                    theTree.setWayOut(true);
                    return theTree;
                }
            }
        }
        if ((board.getScreenData()[theTree.getPos() - 1] & 2) == 0 && theTree.getUp() == null) {

            int currPos = theTree.getPos() - board.getN_BLOCKS();
            if (!checkedPos.contains(currPos)) {

                MazeSearchTree subtree = new MazeSearchTree(currPos);

                theTree.setUp(subtree);
                //subtree.setDown(theTree);

                makeTree(subtree);

                if (theTree.getUp().isWayOut()) {
                    theTree.setWayOut(true);
                    return theTree;
                }
            }
        }
        if ((board.getScreenData()[theTree.getPos() - 1] & 1) == 0 && theTree.getLeft() == null) {
            int currPos = theTree.getPos() - 1;
            if (!checkedPos.contains(currPos)) {

                MazeSearchTree subtree = new MazeSearchTree(currPos);

                theTree.setLeft(subtree);
                //subtree.setRight(theTree);

                makeTree(subtree);

                if (theTree.getLeft().isWayOut()) {
                    theTree.setWayOut(true);
                    return theTree;
                }
            }
        }
        return null;
    }


    private int getPacmanIdInScreenData() {
        int pacmanCellX = getCellId(board.getPacman_x(), board.getBLOCK_SIZE());
        int pacmanCellY = getCellId(board.getPacman_y(), board.getBLOCK_SIZE());
        int pacmanPos = board.getN_BLOCKS() * (pacmanCellY - 1) + pacmanCellX;
        return pacmanPos;
    }

    public int getCellId(int pacmanCoord, int blockSize) {
        int sum = 1;
        while (pacmanCoord - blockSize >= 0) {
            pacmanCoord -= blockSize;
            sum++;
        }
        return sum;
    }

    public void setBoard(Board board) {
        this.board = board;
    }


    public Board getBoard() {
        return board;
    }
}

