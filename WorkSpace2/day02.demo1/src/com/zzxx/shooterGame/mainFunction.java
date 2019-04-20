package com.zzxx.shooterGame;

import javax.swing.*;
import java.awt.*;

public class mainFunction {
    public static void main(String[] args) {
        Shootgame game = new Shootgame();
        JFrame jf = new JFrame("LightingSpecial");
        jf.add(game);
        jf.setSize(game.WIDTH, game.HEIGHT);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setUndecorated(true);
        jf.setBackground(new Color(0,0,0,0));
        jf.setVisible(true);
        game.action();
    }
}



