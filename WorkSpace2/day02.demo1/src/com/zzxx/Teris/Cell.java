package com.zzxx.Teris;

import java.awt.image.BufferedImage;

public class Cell {
    public int row;
    public int col;
    public static int HEIGHT = TerisGame.CELL_T.getHeight();
    public static int WIDTH = TerisGame.CELL_T.getWidth();
    public BufferedImage image = null;
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getX() {
        return this.col;
    }

    public int getY() {
        return this.row;
    }

    public void moveLeft() {
        this.col -= Cell.WIDTH;
    }

    public void moveRight() {
        this.col += Cell.WIDTH;
    }

    public void drop() {
        this.row += Cell.HEIGHT;
    }

    public void up() {
        this.row -= Cell.HEIGHT;
    }
}

