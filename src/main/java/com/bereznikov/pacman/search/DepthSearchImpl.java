package com.bereznikov.pacman.search;

import com.bereznikov.pacman.Board;
import com.bereznikov.pacman.console.ConsoleHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DepthSearchImpl implements DepthSearch {
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

        ConsoleHelper.print("Time: "+(endTime - startTime) + " ns");
        ConsoleHelper.print("Steps: " + sumOfSteps);
        ConsoleHelper.print("Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024 + "MB");
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

        if ((board.getScreenData()[theTree.getPos() - 1] & 16) != 0) {
            theTree.setFound(true);
            theTree.setWayOut(true);
            return theTree;
        }
        if (theTree.getParent() != PARENT_DOWN && (board.getScreenData()[theTree.getPos() - 1] & 8) == 0) {
            MazeSearchTree subTree = new MazeSearchTree(theTree.getPos() + board.getN_BLOCKS());

            subTree.setParent(PARENT_UP);
            theTree.setDown(makeTree(subTree));

            if(subTree.isWayOut()) {
                theTree.setWayOut(true);
                return theTree;
            }
        }
        if (theTree.getParent() != PARENT_RIGHT && (board.getScreenData()[theTree.getPos() - 1] & 4) == 0) {
            MazeSearchTree subTree = new MazeSearchTree(theTree.getPos() + 1);

            subTree.setParent(PARENT_LEFT);
            theTree.setRight(makeTree(subTree));

            if(subTree.isWayOut()) {
                theTree.setWayOut(true);
                return theTree;
            }

        }
        if (theTree.getParent() != PARENT_UP && (board.getScreenData()[theTree.getPos() - 1] & 2) == 0) {
            MazeSearchTree subTree = new MazeSearchTree(theTree.getPos() - board.getN_BLOCKS());

            subTree.setParent(PARENT_DOWN);
            theTree.setUp(makeTree(subTree));

            if(subTree.isWayOut()) {
                theTree.setWayOut(true);
                return theTree;
            }
        }
        if (theTree.getParent() != PARENT_LEFT && (board.getScreenData()[theTree.getPos() - 1] & 1) == 0) {
            MazeSearchTree subTree = new MazeSearchTree(theTree.getPos() - 1);

            subTree.setParent(PARENT_RIGHT);
            theTree.setLeft(subTree);

            if(subTree.isWayOut()) {
                theTree.setWayOut(true);
                return theTree;
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

