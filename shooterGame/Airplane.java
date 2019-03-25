package com.zzxx.shooterGame;

import java.awt.image.BufferedImage;
import java.sql.BatchUpdateException;

public class Airplane extends FlyingObject implements Enemy {
    protected int speed = 4;
    protected double life = 1.0;
    protected  int fireSpeed = 2;

    public Airplane() {
       // this.image = Shootgame.airplane;
        this.width = Shootgame.airplane.getWidth();
        this.height = Shootgame.airplane.getHeight();
        this.x = (int)(Math.random() * (Shootgame.WIDTH - width));
        this.y = 0;
    }

    @Override
    public int getScore() {
        return 2;
    }

    @Override
    public void step() {
        this.y = this.y + this.speed;
    }
    public Bullets[] shoot() {
        int bulletX = (int)(this.width / 2 + this.x);
        Bullets[] bulletArr = new Bullets[1];
        Bullets bulletMid = new Bullets(0, this.fireSpeed, bulletX, this.y + this.height);
        bulletArr[0] = bulletMid;
        return bulletArr;
    }

    public void hitBy(Bullets[] bullets) {
        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i] != null && bullets[i].flag == 1) {
                if ((bullets[i].x <= (this.x + this.width)) && (bullets[i].x >= this.x)
                        && (bullets[i].y <= (this.y + this.height)) && (bullets[i].y >= this.y)) {
                    life = life - 0.5;
                    bullets[i] = null;
                   // return true;
                }
            }
        }
        //return false;
    }

}
