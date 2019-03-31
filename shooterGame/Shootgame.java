package com.zzxx.shooterGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Date;
import java.util.TimerTask;
import java.util.Timer;

public class Shootgame extends JPanel {
    public static final int WIDTH = 400; // 面板宽
    public static final int HEIGHT = 654; // 面板
    public static BufferedImage BACKGROUND;
    public static BufferedImage START;
    public static BufferedImage PAUSE;
    public static BufferedImage GAMEOVER;
    public static BufferedImage[] HERO = new BufferedImage[6];
    public static BufferedImage[] AIRPLANE = new BufferedImage[5];
    public static BufferedImage[] BEE = new BufferedImage[5];
    public static BufferedImage[] BIGPLANE = new BufferedImage[5];
    public static BufferedImage BULLETS;
    public static int times = 0;
    public int state = 0;  //0:start_game  1:gaming   2:game_over    3:pause
    public int scoreThreshold = 40;   // 每当当前分数大于阈值，随机生成一个大飞机
    public Bullets[] bullets = new Bullets[100];
    public Hero hero = new Hero();
    public Bee bees = new Bee();
    public Airplane[] airplanes = new Airplane[8];
    public FlyingObject[] deadObject = new FlyingObject[0];

    static {
        try {
            BACKGROUND = ImageIO.read(Shootgame.class.getResource("shooter/background.png"));
            HERO[0] = ImageIO.read(Shootgame.class.getResource("shooter/hero0.png"));
            HERO[1] = ImageIO.read(Shootgame.class.getResource("shooter/hero1.png"));
            HERO[2] = ImageIO.read(Shootgame.class.getResource("shooter/hero_ember0.png"));
            HERO[3] = ImageIO.read(Shootgame.class.getResource("shooter/hero_ember1.png"));
            HERO[4] = ImageIO.read(Shootgame.class.getResource("shooter/hero_ember2.png"));
            HERO[5] = ImageIO.read(Shootgame.class.getResource("shooter/hero_ember3.png"));
            START = ImageIO.read(Shootgame.class.getResource("shooter/start.png"));
            PAUSE = ImageIO.read(Shootgame.class.getResource("shooter/pause.png"));
            GAMEOVER = ImageIO.read(Shootgame.class.getResource("shooter/gameover.png"));
            AIRPLANE[0] = ImageIO.read(Shootgame.class.getResource("shooter/airplane.png"));
            AIRPLANE[1] = ImageIO.read(Shootgame.class.getResource("shooter/airplane_ember0.png"));
            AIRPLANE[2] = ImageIO.read(Shootgame.class.getResource("shooter/airplane_ember1.png"));
            AIRPLANE[3] = ImageIO.read(Shootgame.class.getResource("shooter/airplane_ember2.png"));
            AIRPLANE[4] = ImageIO.read(Shootgame.class.getResource("shooter/airplane_ember3.png"));
            BIGPLANE[0] = ImageIO.read(Shootgame.class.getResource("shooter/bigplane.png"));
            BIGPLANE[1] = ImageIO.read(Shootgame.class.getResource("shooter/bigplane_ember0.png"));
            BIGPLANE[2] = ImageIO.read(Shootgame.class.getResource("shooter/bigplane_ember1.png"));
            BIGPLANE[3] = ImageIO.read(Shootgame.class.getResource("shooter/bigplane_ember2.png"));
            BIGPLANE[4] = ImageIO.read(Shootgame.class.getResource("shooter/bigplane_ember3.png"));
            BEE[0] = ImageIO.read(Shootgame.class.getResource("shooter/bee.png"));
            BEE[1] = ImageIO.read(Shootgame.class.getResource("shooter/bee_ember0.png"));
            BEE[2] = ImageIO.read(Shootgame.class.getResource("shooter/bee_ember1.png"));
            BEE[3] = ImageIO.read(Shootgame.class.getResource("shooter/bee_ember2.png"));
            BEE[4] = ImageIO.read(Shootgame.class.getResource("shooter/bee_ember3.png"));
            BULLETS = ImageIO.read(Shootgame.class.getResource("shooter/bullet.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init() {
        state = 0;
        times = 0;
        Hero heroNew = new Hero();
        Bee beesNew = new Bee();
        Airplane[] airplanesNew = new Airplane[8];
        FlyingObject[] deadObjectNew = new FlyingObject[0];
        hero = heroNew;
        bees = beesNew;
        airplanes = airplanesNew;
        deadObject = deadObjectNew;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        switch (state) {
            case 0:
                init();
                g.drawImage(START, 0, 0, null);
                break;
            case 1:
                g.drawImage(BACKGROUND, 0, 0, null);
                showScoreAndLife(g);
                paintHero(g);
                paintBee(g);
                paintAirplane(g);
                paintBullets(g);
                paintDeadObj(g);
                break;
            case 2:
                init();
                g.drawImage(GAMEOVER, 0, 0, null);
                break;
            case 3:
                g.drawImage(PAUSE, 0, 0, null);
            default:
                break;
        }
    }

    public void paintHero(Graphics g) {
        if (hero != null) {
            g.drawImage(hero.getImage(), hero.x, hero.y, null);
        }
    }

    public void paintBee(Graphics g) {
        if (bees != null)
            g.drawImage(bees.getImage(), bees.x, bees.y, null);
    }

    public void paintAirplane(Graphics g) {
        for (int i = 0; i < airplanes.length; i++) {
            if (airplanes[i] != null )
                g.drawImage(airplanes[i].getImage(), airplanes[i].x, airplanes[i].y, null);
        }
    }

    public void paintBullets(Graphics g) {
        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i] != null) {
                g.drawImage(BULLETS, bullets[i].x, bullets[i].y, null);
            }
        }
    }

    public void paintDeadObj(Graphics g) {
        for (int i = 0; i < deadObject.length && deadObject[i] != null; i++) {
            if (deadObject[i].getImage() != null) {
                g.drawImage(deadObject[i].getImage(), deadObject[i].x, deadObject[i].y, null);
            } else {
                if (!(deadObject[i] instanceof Award) && !(deadObject[i] instanceof Enemy))
                    state = 2;  // 说明英雄级已经完成爆炸效果，游戏结束
            }
        }



    }

    public void stepAciton() {
        if (times % 20 == 0) {
            for (int i = 0; i < airplanes.length; i++) {
                if (airplanes[i] != null)
                    airplanes[i].step();
            }

        }

        if (times % 2 == 0) {
            for (int i = 0; i < bullets.length; i++) {
                if (bullets[i] != null)
                    bullets[i].step();
            }
        }

        if (bees != null && times % 20 == 0)
            bees.step();
    }

    public void shootAction() {
        if (times % 50 == 0) {
            for (int i = 0; i < airplanes.length; i++) {
                if (airplanes[i] != null)
                    addToBullets(airplanes[i].shoot());
            }
        }
    }

    public void hitAndBangAction() {
        for (int i = 0; i < airplanes.length; i++) {
            if (airplanes[i] != null)
                airplanes[i].hitBy(bullets);
        }

        if (hero != null) {
            hero.hitBy(bullets);
            hero.isBang(airplanes);
        }

        if (bees != null)
            bees.hitBy(bullets);
    }

    public void rmAndAwardAciton() {
        for (int i = 0; i < airplanes.length; i++) {
            if (airplanes[i] != null && (airplanes[i].life <= 0.0 || airplanes[i].outOfBounds())) {
                hero.score += airplanes[i].getScore();
                addToDead(airplanes[i]);
                airplanes[i] = null;
            }
        }

        if (hero != null && hero.life <= 0.0) {
            addToDead(hero);
            hero = null;
        }

        if (hero != null && bees != null && bees.life <= 0) {

            switch(bees.getType()) {
                case 0:
                    hero.doubleFire += 20;
                    break;
                case 1:
                    hero.life += 1;
                    break;
                default:
                    break;
            }
            addToDead(bees);
            bees = null;
        }

        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i] != null)
                if (bullets[i].outOfBounds())
                    bullets[i] = null;
        }
    }


    public void genAciton() {
        if (hero.score > scoreThreshold) {
            scoreThreshold += 20;
            Airplane bigPlanes = new Airplane(BIGPLANE[0]);
            bigPlanes.SmallPlane = false;
            addToAirplanes(bigPlanes);
        }

        if (times % 50 == 0) {
            Airplane plane = new Airplane(AIRPLANE[0]);
            addToAirplanes(plane);
        }

        if (bees == null && times % 200 == 0)
           bees = new Bee();
    }

    public void addToBullets(Bullets[] bullet) {
        int count = 0;
        int length = bullets.length;
        for (int i = 0; i < bullets.length && count < bullet.length; i++) {
            if (bullets[i] == null) {
                bullets[i] = bullet[count++];
            }
        }
        if (count != bullet.length) {
            bullets = Arrays.copyOf(bullets, bullets.length + bullet.length - count);
            for (int i = count; i < bullet.length; i++) {
                bullets[length - 1] = bullet[count];
            }
        }

    }

    public void addToAirplanes(Airplane planes) {
        for (int i = 0; i < airplanes.length; i++) {
            if (airplanes[i] == null) {
                airplanes[i] = planes;
                break;
            }
        }
    }

    public void addToDead(FlyingObject deadObj) {
        int i = 0;
        for (i = 0; i < deadObject.length; i++) {
            if (deadObject[i].getImage() == null) {
                deadObject[i] = deadObj;
                break;
            }
        }
        if (i == deadObject.length) {
            deadObject = Arrays.copyOf(deadObject, deadObject.length + 1);
            deadObject[deadObject.length - 1] = deadObj;
        }
    }

    public void showScoreAndLife(Graphics g) {
        if (hero != null) {
            g.setColor(new Color(128, 128, 128));
            g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
            g.drawString("SCORE:" + hero.score, 10, 20);
            g.drawString("LIFE:" + hero.life, 10, 40);
        }
    }

    public void action() {
        MouseAdapter l = new MouseAdapter(){
            public void mouseMoved(MouseEvent e) {
                if (hero != null) {
                    hero.x = e.getX() - hero.width / 2; //获取鼠标的x坐标
                    hero.y = e.getY() - hero.height / 2; //获取鼠标的y坐标
                }
            }
            public void mouseClicked(MouseEvent e) {
                if (hero != null && e.getButton() == MouseEvent.BUTTON1) {
                    addToBullets(hero.shoot());
                }

                if (state == 0 && e.getButton() == MouseEvent.BUTTON2) {
                    state = 1;
                }

                if (state == 2 && e.getButton() == MouseEvent.BUTTON2) {
                    init();
                }
            }
            public void mouseExited(MouseEvent e) {
                if (state == 1) {
                    state = 3;
                }
            }

            public void mouseEntered(MouseEvent e) {
                if (state == 3) {
                    state = 1;
                }
            }
        };
        this.addMouseListener(l); //处理鼠标操作事件
        this.addMouseMotionListener(l); //处理鼠标滑动事件
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                times = (times + 1) % 200;
                switch (state) {
                    case 1:
                        genAciton();
                        stepAciton();
                        shootAction();
                        hitAndBangAction();
                        rmAndAwardAciton();
                        break;
                    default:
                        break;
                }
                repaint();
            }

        };
        Timer timer = new Timer();
        timer.schedule(task, new Date(), 10);
    }
}