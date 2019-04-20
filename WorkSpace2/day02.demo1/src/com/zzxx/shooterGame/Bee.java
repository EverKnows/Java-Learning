package com.zzxx.shooterGame;

import java.awt.image.BufferedImage;

public class Bee extends FlyingObject implements Award {
    protected  int speedY = 2;
    protected  int speedX = 1;
    protected int awardType;

    public Bee() {
        this.awardType = (int)(Math.random() * 2);  //0 = doublefire    1 = life + 1
        this.image = Shootgame.BEE[0];
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.x = Shootgame.WIDTH;
        this.y = (int)(Math.random() * (Shootgame.HEIGHT - this.height) * 0.5);
        this.life = 4;
    }

    @Override
    public void step() {
        int guideNum = (int)(Math.random() * 2);
        this.x = this.x - this.speedX;
        if (guideNum == 1) {
            this.y = this.y + this.speedY;
        } else {
            this.y = this.y - this.speedY;
        }
    }


    @Override
    public int getType() {
        return awardType;
    }

    public void hitBy(Bullets[] bullets) {
        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i] != null && bullets[i].flag == 1) {
                if ((bullets[i].x <= (this.x + this.width)) && (bullets[i].x >= this.x)
                        && (bullets[i].y <= (this.y + this.height)) && (bullets[i].y >= this.y)) {
                    bullets[i] = null;
                    life -= 2;
                }
            }
        }
    }

    @Override
    public BufferedImage getImage() {
        if (life > 0)
            return Shootgame.BEE[0];

        if (this.imageSwitch <= 49)
            return Shootgame.BEE[this.imageSwitch++ / 10];
        return null;
    }

    public boolean finallyDead() {
        return this.imageSwitch > 49;
    }
}
