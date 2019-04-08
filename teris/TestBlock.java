package com.zzxx.Teris;

import javax.swing.*;
import java.awt.*;

public class TestBlock {
    public static void main(String[] args) {
        JFrame jF = new JFrame();
        TerisGame game = new TerisGame();
        jF.add(game);
        jF.setSize(game.WIDTH, game.HEIGHT);
        jF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jF.setLocationRelativeTo(null);
        jF.setUndecorated(true);
        jF.setBackground(new Color(0,0,0,0));
        game.setFocusable(true);
        jF.setVisible(true);

        game.action();


    }
}
