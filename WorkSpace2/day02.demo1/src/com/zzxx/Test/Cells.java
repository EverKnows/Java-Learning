package com.zzxx.Test;

public class Cells {
    public int x;
    public int y;
    public Cells(int row, int col) {
        this.x = row;
        this.y = col;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void moveLeft() {
        this.x -= 1;
    }

    public void moveRight() {
        this.x += 1;
    }

    public void drop() {
        this.y += 1;
    }
}
