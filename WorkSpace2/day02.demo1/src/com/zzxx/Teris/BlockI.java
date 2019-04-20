package com.zzxx.Teris;

public class BlockI extends Tetromino {
    private int rorateCount = 0;
    public BlockI(int row, int col) {
        this.image = TerisGame.CELL_I;

        cells[0] = new Cell(row, col);
        cells[1] = new Cell(row, col + Cell.WIDTH);
        cells[2] = new Cell(row, col + 2 * Cell.WIDTH);
        cells[3] = new Cell(row, col + 3 * Cell.WIDTH);
    }

    @Override
    public void rorate() {
        Cell[] rorateCell = new Cell[4];
        for (int i = 0; i < cells.length; i++) {
            rorateCell[i] = new Cell(0, 0);
        }
        switch((rorateCount + 1) % 4) {
            case 0:
                rorateCell[0].row = cells[2].row;
                rorateCell[0].col = cells[2].col - 2 * Cell.WIDTH;
                rorateCell[1].row = cells[2].row;
                rorateCell[1].col = cells[2].col - 1 * Cell.WIDTH;
                rorateCell[3].row = cells[2].row;
                rorateCell[3].col = cells[2].col + 1 * Cell.WIDTH;
                rorateCell[2].row = cells[2].row;
                rorateCell[2].col = cells[2].col;
                break;
            case 1:
                rorateCell[0].row = cells[2].row - 2 * Cell.HEIGHT;
                rorateCell[0].col = cells[2].col;
                rorateCell[1].row = cells[2].row - 1 * Cell.HEIGHT;
                rorateCell[1].col = cells[2].col;
                rorateCell[3].row = cells[2].row + 1 * Cell.HEIGHT;
                rorateCell[3].col = cells[2].col;
                rorateCell[2].row = cells[2].row;
                rorateCell[2].col = cells[2].col;
                break;
            case 2:
                rorateCell[0].row = cells[2].row;
                rorateCell[0].col = cells[2].col + 2 * Cell.WIDTH;
                rorateCell[1].row = cells[2].row;
                rorateCell[1].col = cells[2].col + 1 * Cell.WIDTH;
                rorateCell[3].row = cells[2].row;
                rorateCell[3].col = cells[2].col - 1 * Cell.WIDTH;
                rorateCell[2].row = cells[2].row;
                rorateCell[2].col = cells[2].col;
                break;
            case 3:
                rorateCell[0].row = cells[2].row + 2 * Cell.HEIGHT;
                rorateCell[0].col = cells[2].col;
                rorateCell[1].row = cells[2].row + 1 * Cell.HEIGHT;
                rorateCell[1].col = cells[2].col;
                rorateCell[3].row = cells[2].row - 1 * Cell.HEIGHT;
                rorateCell[3].col= cells[2].col;
                rorateCell[2].row = cells[2].row;
                rorateCell[2].col = cells[2].col;
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
