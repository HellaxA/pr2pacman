package com.bereznikov.pacman;

import com.bereznikov.pacman.search.DepthSearchImpl;
import com.bereznikov.pacman.util.UtilMethods;

import java.awt.*;
import javax.swing.JFrame;

public class Pacman extends JFrame {
    public Pacman(Board theBoard) {

        initUI(theBoard);
    }

    private void initUI(Board theBoard) {

        add(theBoard);

        setTitle("Pacman");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 440);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) throws AWTException {
        Board theBoard = new Board();

        Pacman pacman = new Pacman(theBoard);

        EventQueue.invokeLater(() -> {
            pacman.setVisible(true);
        });

        RobotMovement robot = new RobotMovementImpl(new Robot(), theBoard, new DepthSearchImpl());
        robot.start();

        //UtilMethods.changeSymbols();
    }


}
