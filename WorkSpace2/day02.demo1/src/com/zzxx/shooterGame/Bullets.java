package com.zzxx.shooterGame;

public class Bullets extends FlyingObject {
    public int speed;
    public int flag = -1;

    public Bullets(int flag, int fireSpeed, int x, int y) {
        this.height = Shootgame.BULLETS.getHeight();
        this.width = Shootgame.BULLETS.getWidth();
        this.flag = flag;
        this.speed = fireSpeed;
        this.x = x;
        this.y = y;
    }

    @Override
    public void step() {
        if (flag == 0)
            this.y = this.y + speed;
        if (flag == 1)
            this.y = this.y - speed;
    }



}
