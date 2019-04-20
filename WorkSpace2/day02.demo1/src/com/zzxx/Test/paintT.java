package com.zzxx.Test;

public class paintT {
    public Cells[] cells = new Cells[4];
    public paintT(int row, int col) {
        cells[0] = new Cells(row, col);
        cells[1] = new Cells(row, col + 1);
        cells[2] = new Cells(row, col + 2);
        cells[3] = new Cells(row + 1, col + 1);
    }
    public void paint() {
        boolean flag = false;

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                flag = false;
                for (int k = 0; k < 4; k++) {
                    if (cells[k].getX() == i && cells[k].getY() == j) {
                        System.out.print("*");
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        paintT t = new paintT(2, 3);
        t.paint();
    }
}
