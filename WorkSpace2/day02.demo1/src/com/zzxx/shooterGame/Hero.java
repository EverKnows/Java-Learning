package com.zzxx.shooterGame;

import java.awt.image.BufferedImage;

public class Hero extends FlyingObject {
    public int doubleFire = 0;
    public int score = 0;
    public int bangImageSwitch = 0;

    public Hero() {
        this.image = Shootgame.HERO[0];
        this.x = 150;
        this.y = 400;
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.life = 100;
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
                   // life = life - 2.5;
                    bullets[i] = null;
                }
            }
        }
    }

    public boolean isBang(FlyingObject[] flyingObjects) {
        int topNodeX = (this.x + this.width / 2);  //这里只检测飞机图像的头是否碰撞到其他飞行物
        int topNodeY = this.y;
        boolean isBang = false;

        for (int i = 0; i < flyingObjects.length; i++) {
            if (flyingObjects[i] != null && flyingObjects[i].life > 0) {

                if ((topNodeX <= flyingObjects[i].x + flyingObjects[i].width)
                        && (topNodeX > flyingObjects[i].x)
                        && (topNodeY >= flyingObjects[i].y)
                        && (topNodeY <= flyingObjects[i].y + flyingObjects[i].height)) {
                    flyingObjects[i].life = 0;
                    this.bangImageSwitch = 1;
                    isBang = true;
                    break;
                }
            }
        }
        return isBang;
    }


    @Override
    public BufferedImage getImage() {
        if (this.life > 0 && this.bangImageSwitch == 0) {       // 正常飞行的动画效果
            this.imageSwitch = (this.imageSwitch + 1) % 30;
            return Shootgame.HERO[this.imageSwitch / 15];
        }

        if (this.life <= 0 && this.life > -100) {         // 英雄机首次死亡时，将其imageSwitch属性清零，方便绘出爆炸效果
            this.imageSwitch = 0;
            this.life = -999;
        }

        if (this.bangImageSwitch > 0 && this.life > 0) {      // 碰撞时的爆炸效果
            this.bangImageSwitch = (this.bangImageSwitch + 1) % 50;
            return Shootgame.HERO[this.bangImageSwitch / 10];
        }

        if (this.imageSwitch <= 49 && this.life <= 0)        //死亡时的动画效果
            return Shootgame.HERO[this.imageSwitch++ / 10 + 1];

        return null;
    }
}
