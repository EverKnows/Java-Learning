package com.zzxx.Teris;

public class BlockZ extends Tetromino{
    private int rorateCount = 0;
    public BlockZ(int row, int col) {
        this.image = TerisGame.CELL_Z;
        cells[0] = new Cell(row, col);
        cells[1] = new Cell(row, col + 1 * Cell.WIDTH);
        cells[2] = new Cell(row + 1 * Cell.HEIGHT, col + 1 * Cell.WIDTH);
        cells[3] = new Cell(row + 1 * Cell.HEIGHT, col + 2 * Cell.WIDTH);
    }
    public void printInfo() {
        System.out.println("this is a test!");
    }

    @Override
    public void rorate() {
        Cell[] rorateCell = new Cell[4];
        for (int i = 0; i < cells.length; i++) {
            rorateCell[i] = new Cell(0, 0);
        }
        switch(rorateCount) {
            case 0:
                rorateCell[0].row = cells[1].row;
                rorateCell[0].col = cells[1].col - 1 * Cell.WIDTH;
                rorateCell[2].row = cells[1].row + 1 * Cell.HEIGHT;
                rorateCell[2].col = cells[1].col;
                rorateCell[3].row = cells[1].row + 1 * Cell.HEIGHT;
                rorateCell[3].col = cells[1].col + 1 * Cell.WIDTH;
                rorateCell[1].row = cells[1].row;
                rorateCell[1].col = cells[1].col;
                break;
            case 1:
                rorateCell[0].row = cells[1].row - 1 * Cell.HEIGHT;
                rorateCell[0].col = cells[1].col;
                rorateCell[2].row = cells[1].row;
                rorateCell[2].col = cells[1].col - 1 * Cell.WIDTH;
                rorateCell[3].row = cells[1].row + 1 * Cell.HEIGHT;
                rorateCell[3].col = cells[1].col - 1 * Cell.WIDTH;
                rorateCell[1].row = cells[1].row;
                rorateCell[1].col = cells[1].col;
                break;
            case 2:
                rorateCell[0].row = cells[1].row;
                rorateCell[0].col = cells[1].col + 1 * Cell.WIDTH;
                rorateCell[2].row = cells[1].row - 1 * Cell.HEIGHT;
                rorateCell[2].col = cells[1].col;
                rorateCell[3].row = cells[1].row - 1 * Cell.HEIGHT;
                rorateCell[3].col = cells[1].col - 1 * Cell.WIDTH;
                rorateCell[1].row = cells[1].row;
                rorateCell[1].col = cells[1].col;
                break;
            case 3:
                rorateCell[0].row = cells[1].row + 1 * Cell.HEIGHT;
                rorateCell[0].col = cells[1].col;
                rorateCell[2].row = cells[1].row;
                rorateCell[2].col = cells[1].col + 1 * Cell.WIDTH;
                rorateCell[3].row = cells[1].row - 1 * Cell.HEIGHT;
                rorateCell[3].col = cells[1].col + 1 * Cell.WIDTH;
                rorateCell[1].row = cells[1].row;
                rorateCell[1].col = cells[1].col;
                break;
        }
        if (isLegalChange(rorateCell)) {
            for (int i = 0; i < cells.length; i++) {
                cells[i].row = rorateCell[i].row;
                cells[i].col = rorateCell[i].col;
            }
            rorateCount += 1;
            rorateCount = rorateCount % 4;
        }
    }
}
