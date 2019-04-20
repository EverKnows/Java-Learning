package com.zzxx.shooterGame;

import java.awt.image.BufferedImage;

public abstract class FlyingObject {
    protected int x;  //横坐标
    protected int y;  //纵坐标
    protected int width;  //飞行物体的宽
    protected int height; //飞行物体的高
    protected static BufferedImage image;  //飞行物体的图片
    public int imageSwitch = 0;
    public double life = 0;

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y =y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public boolean outOfBounds() {
        return this.x < 0 || this.y < 0
                || this.y + this.height > Shootgame.HEIGHT
                || this.x + this.width > Shootgame.WIDTH;
    }

    public boolean shootBy() {
        return true;
    }

    public abstract void step();

}
