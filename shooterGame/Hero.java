package com.zzxx.shooterGame;

import com.zzxx.shooterGame.Bullets;
import com.zzxx.shooterGame.FlyingObject;
import com.zzxx.shooterGame.Shootgame;

public class Hero extends FlyingObject {
    public int doubleFire = 0;
    public double life = 100;
    public int score = 0;

    public Hero() {
        this.image = Shootgame.hero0;
        this.x = 150;
        this.y = 400;
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    @Override
    public void setX(int x) {
        if (x + this.width > Shootgame.WIDTH) {
            this.x = Shootgame.WIDTH - this.width;

        } else if (x < 0) {
            this.x = 0;

        } else {
            this.x = x;

        }

    }

    @Override
    public void setY(int y) {
        if (y + this.height > Shootgame.HEIGHT) {
            this.y = Shootgame.HEIGHT - this.height;

        } else if (y < 0) {
            this.y = 0;

        } else {
            this.y = y;

        }
    }

    @Override
    public void step() {}

    public Bullets[] shoot() {
        Bullets[] bulletArr;
        if (this.doubleFire > 0) {
            Bullets bulletLeft = new Bullets(1,30, this.x + 12, this.y + 50);
            Bullets bulletRight = new Bullets(1, 30, this.x + this.width - 20, this.y + 50);
            bulletArr = new Bullets[]{bulletLeft, bulletRight};
            this.doubleFire -= 1;
        } else {
            Bullets bulletMid = new Bullets(1, 30, this.x + this.width / 2, this.y +20);
            bulletArr = new Bullets[]{bulletMid};
        }
        return bulletArr;

    }

    @Override
    public boolean outOfBounds() {
        return false;
    }

    public void hitBy(Bullets[] bullets) {
        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i] != null && bullets[i].flag == 0) {
                if ((bullets[i].x <= this.x + this.width) && (bullets[i].x >= this.x)
                        && (bullets[i].y <= this.y + this.height) && (bullets[i].y >= this.y)) {
                    life = life - 2.5;
                    bullets[i] = null;
                }
            }
        }

    }

    public void Bang(Airplane[] airplanes, Bee bees) {
        boolean isBang = false;
        int topNodeX = (this.x + this.width / 2);
        int topNodeY = this.y;
        for (int i = 0; i < airplanes.length; i++) {
            if (airplanes[i] != null && airplanes[i].life > 0) {
                isBang = (topNodeX <= airplanes[i].x + airplanes[i].width) && (topNodeX > airplanes[i].x)
                        && (topNodeY >= airplanes[i].y) && (topNodeY <= airplanes[i].y + airplanes[i].height);
                if (isBang) {
                    this.life -= 5;
                    airplanes[i].life = 0;
                }
            }
            isBang = false;
        }

        if (bees != null && bees.life > 0) {
            isBang = (topNodeX <= bees.x + bees.width) && (topNodeX > bees.x)
                    && (topNodeY >= bees.y) && (topNodeY <= bees.y + bees.height);
            if (isBang) {
                this.life -= 5;
                bees.life = 0;
            }
        }
    }
}
