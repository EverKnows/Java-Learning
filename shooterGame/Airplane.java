package com.zzxx.shooterGame;

import java.awt.image.BufferedImage;

public class Airplane extends FlyingObject implements Enemy {
    protected int speed = 4;
    protected int fireSpeed = 2;
    protected boolean SmallPlane = true;

    public Airplane(BufferedImage image) {
        this.image = image;
        this.width = this.image.getWidth();
        this.height = this.image.getHeight();
        this.x = (int) (Math.random() * (Shootgame.WIDTH - width));
        this.y = (int) (Math.random() * (Shootgame.HEIGHT / 3));
        this.life = 1;
    }

    @Override
    public int getScore() {
        if (SmallPlane)
            return 2;
        return 10;
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
                if ((bullets[i].x <= (this.x + this.width))
                        && (bullets[i].x >= this.x)
                        && (bullets[i].y <= (this.y + this.height))
                        && (bullets[i].y >= this.y)) {
                    life = life - 0.5;
                    bullets[i] = null;
                }
            }
        }
    }

    @Override
    public BufferedImage getImage() {
        if (SmallPlane) {
            if (life > 0)
                return Shootgame.AIRPLANE[0];
            if (this.imageSwitch <= 49)
                return Shootgame.AIRPLANE[this.imageSwitch++ / 10];
        } else {
            if (life > 0)
                return Shootgame.BIGPLANE[0];
            if (this.imageSwitch <= 49)
                return Shootgame.BIGPLANE[this.imageSwitch++ / 10];
        }

        return null;
    }
}
