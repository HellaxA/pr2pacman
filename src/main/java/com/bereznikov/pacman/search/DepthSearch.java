package com.bereznikov.pacman.search;

import com.bereznikov.pacman.Board;

import java.util.ArrayList;
import java.util.List;

public interface DepthSearch {
    List<String> path();

    List<String> findAlgo();

    void setBoard(Board board);

    MazeSearchTree makeTree(MazeSearchTree theTree);
}
