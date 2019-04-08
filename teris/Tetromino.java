package com.zzxx.Teris;

import java.awt.*;
import java.awt.image.BufferedImage;

abstract class  Tetromino {
    Cell[] cells = new Cell[4];
    public BufferedImage image;
    public int row = 0;
    public int col = 0;

    /*public Tetromino(int row, int col) {
        this.row = row;
        this.col = col;
    }*/

    public Tetromino() {

    }

    public void paintCells(Graphics g) {
        for (int i = 0; i < cells.length; i++) {
            g.drawImage(this.image, this.cells[i].col, this.cells[i].row, null);
        }
    }

    public void moveToLeft() {
        Cell[] cellsMoveL = new Cell[4];
        for (int i = 0; i < cells.length; i++) {
            cellsMoveL[i] = new Cell(cells[i].row, cells[i].col);
            cellsMoveL[i].moveLeft();
        }
        if (isLegalChange(cellsMoveL)) {
            for (int i = 0; i < cells.length; i++) {
                cells[i] = cellsMoveL[i];
            }
        }

    }

    public void moveToRight() {
        Cell[] cellsMoveR = new Cell[4];
        for (int i = 0; i < cells.length; i++) {
            cellsMoveR[i] = new Cell(cells[i].row, cells[i].col);
            cellsMoveR[i].moveRight();
        }
        if (isLegalChange(cellsMoveR)) {
            for (int i = 0; i < cells.length; i++) {
                cells[i] = cellsMoveR[i];
            }
        }
    }

    public void Drop() {
        Cell[] cellsDrop = new Cell[4];
        for (int i = 0; i < cells.length; i++) {
            cellsDrop[i] = new Cell(cells[i].row, cells[i].col);
            cellsDrop[i].drop();
        }
        if (isLegalChange(cellsDrop)) {
            for (int i = 0; i < cells.length; i++) {
                cells[i] = cellsDrop[i];
            }
        }

    }

    public void fastDrop() {
        Cell[] cellsDrop = new Cell[4];
        for (int i = 0; i < cells.length; i++) {
            cellsDrop[i] = new Cell(cells[i].row, cells[i].col);
            cellsDrop[i].drop();
        }
        while (isLegalChange(cellsDrop)) {
            for (int i = 0; i < cells.length; i++) {
                cellsDrop[i].drop();
            }
        }
        for (int i = 0; i < cells.length; i++) {
            cellsDrop[i].up();
        }

        for (int i = 0; i < cells.length; i++) {
            cells[i] = cellsDrop[i];
        }
    }
    public static Tetromino genRandomTetro(int row, int col) {
        int rdNum = (int) (Math.random() * 7);
        switch(rdNum) {
            case 0:
                return new BlockS(row, col);

            case 1:
                return new BlockZ(row, col);

            case 2:
                return new BlockT(row, col);

            case 3:
                return new BlockL(row, col);

            case 4:
                return new BlockJ(row, col);

            case 5:
                return new BlockO(row, col);

            case 6:
                return new BlockI(row, col);

            default:
                break;

        }
        return null;
    }

    public boolean isLegalChange(Cell[] cells) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < cells.length; i++) {
            x = cells[i].row / Cell.HEIGHT;
            y = cells[i].col / Cell.WIDTH;
            if (isOutOfBounds(cells) || TerisGame.cellArr[x][y] != null) {
                return false;
            }
        }
        return true;
    }

    public boolean isOutOfBounds(Cell[] cells) {
        boolean state = false;
        for (int i = 0; i < cells.length; i++) {
            state = cells[i].row <= 17 * Cell.HEIGHT && cells[i].col >= 0 && cells[i].col <= 8 * Cell.WIDTH;
            if (!state)
                return true;
        }
        return false;
    }

    public void rorate(){}

    public boolean isBlockLand() {
        int x;
        int y;
        int maxX = 0;
        for (int i = 0; i < cells.length; i++) {
            x = cells[i].row / Cell.HEIGHT;
            y = cells[i].col / Cell.WIDTH;
            if ((x + 1) < 18 && TerisGame.cellArr[x + 1][y] != null)
                return true;
            if (x > maxX) {
                maxX = x;
            }
        }
        if (maxX == 17)
            return true;
        return false;
    }

}
