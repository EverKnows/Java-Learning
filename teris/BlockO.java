package com.zzxx.Teris;

public class BlockO extends Tetromino{
    public BlockO(int row, int col) {
        this.image = TerisGame.CELL_O;
        cells[0] = new Cell(row, col);
        cells[1] = new Cell(row + 1 * Cell.HEIGHT, col);
        cells[2] = new Cell(row , col + 1 * Cell.WIDTH);
        cells[3] = new Cell(row + 1 * Cell.HEIGHT, col + 1 * Cell.WIDTH);
    }
    public void printInfo() {
        System.out.println("this is a test!");
    }

    @Override
    public void rorate() {

    }
}
