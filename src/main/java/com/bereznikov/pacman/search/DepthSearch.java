package com.bereznikov.pacman.search;

import com.bereznikov.pacman.Board;

import java.util.List;

public interface DepthSearch {
    List<String> path();

    void findAlgo();

    void setBoard(Board board);

    MazeSearchTree makeTree(MazeSearchTree theTree);
}
