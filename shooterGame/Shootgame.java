package com.zzxx.shooterGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Date;
import java.util.TimerTask;
import java.util.Timer;

public class Shootgame extends JPanel {
    public static final String baseIndex = "E:\\WorkSpace2\\day02.demo1\\src\\com\\zzxx\\shooterGame\\shooter\\";
    public static final int WIDTH = 400; // 面板宽
    public static final int HEIGHT = 654; // 面板
    public static BufferedImage background;
    public static BufferedImage start;
    public static BufferedImage pause;
    public static BufferedImage gameover;
    public static BufferedImage hero0;
    public static BufferedImage hero1;
    public static BufferedImage airplane;
    public static BufferedImage bee;
    public static BufferedImage bullet;
    public int times = 0;
    public int state = 0;  //0:start_game  1:gaming   2:game_over    3:pause
    public Bullets[] bullets = new Bullets[100];
    public Hero hero = new Hero();
    public Bee bees = new Bee();
    public Airplane[] airplanes = new Airplane[5];

    static {
        try {

            background = ImageIO.read(new File(baseIndex + "background.png"));
            hero0 = ImageIO.read(new File(baseIndex + "hero0.png"));
            start = ImageIO.read(new File(baseIndex + "start.png"));
            pause = ImageIO.read(new File(baseIndex + "pause.png"));
            gameover = ImageIO.read(new File(baseIndex + "gameover.png"));
            hero1 = ImageIO.read(new File(baseIndex + "hero1.png"));
            airplane = ImageIO.read(new File(baseIndex + "airplane.png"));
            bee = ImageIO.read(new File(baseIndex + "bee.png"));
            bullet = ImageIO.read(new File(baseIndex + "bullet.png"));


        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void init() {
        state = 0;
        times = 0;

        for (int i = 0; i < bullets.length; i++) {
            bullets[i] = null;
        }

        for (int i = 0; i < airplanes.length; i++) {
            airplanes[i] = null;
        }

        hero = new Hero();
        bees = new Bee();

    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        switch (state) {
            case 0:
                g.drawImage(start, 0, 0, null);
                break;
            case 1:
                g.drawImage(background, 0, 0, null);
                showScoreAndLife(g);
                paintHero(g);
                paintBee(g);
                paintAirplane(g);
                paintBullets(g);
                break;
            case 2:
                g.drawImage(gameover, 0, 0, null);
                break;
            case 3:
                g.drawImage(pause, 0, 0, null);
            default:
                break;
        }
    }

    public void paintHero(Graphics g) {
        if (hero != null)
            g.drawImage(hero.image, hero.x, hero.y, null);
    }

    public void paintBee(Graphics g) {
        if (bees != null)
            g.drawImage(bees.image, bees.x, bees.y, null);
    }

    public void paintAirplane(Graphics g) {
        for (int i = 0; i < airplanes.length; i++) {
            if (airplanes[i] != null)
                g.drawImage(airplane, airplanes[i].x, airplanes[i].y, null);
        }
    }

    public void paintBullets(Graphics g) {


        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i] != null) {
                g.drawImage(bullet, bullets[i].x, bullets[i].y, null);
            }
        }
    }

    public void addToBullets(Bullets[] bullet) {
        int length = bullets.length;
        boolean flag = false;
        int index = 0;
        int count = 0;

        while (count < bullet.length) {
            for (int i = 0; i < length; i++) {
                if (bullets[i] == null) {
                    flag = true;
                    index = i;
                }
            }
            if (flag) {
                bullets[index] = bullet[count];
                ++count;
            } else {
                bullets = new Bullets[length + 1];
                bullets[length] = bullet[count];
                ++count;
            }
        }
    }

    public void stepAciton() {
        if (times % 20 == 0) {
            for (int i = 0; i < airplanes.length; i++) {
                if (airplanes[i] != null) {
                    airplanes[i].step();
                }
            }

        }

        if (times % 2 == 0) {
            for (int i = 0; i < bullets.length; i++) {
                if (bullets[i] != null) {
                    bullets[i].step();
                }
            }
        }

        if (bees != null && times % 20 == 0)
            bees.step();
    }

    public void shootAction() {
        times = (times + 1) % 100;
        for (int i = 0; i < airplanes.length; i++) {
            if (airplanes[i] != null && times == 0) {
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
            hero.Bang(airplanes, bees);
        }

        if (bees != null)
            bees.hitBy(bullets);
    }

    public void rmAndAwardAciton() {
        for (int i = 0; i < airplanes.length; i++) {
            if (airplanes[i] != null && airplanes[i].life <= 0.0) {
                airplanes[i] = null;
                hero.score += 2;
            }
        }

        if (hero != null && hero.life <= 0.0) {
            hero = null;
            state = 2;
        }

        if (hero != null &&bees != null && bees.life <= 0) {

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
            bees = null;
        }

        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i] != null)
                if (bullets[i].outOfBounds()){
                    bullets[i] = null;

                }

        }
    }


    public void genAciton() {
        if (times % 1000 == 0) {
            for (int i = 0; i < airplanes.length; i++) {
                if (airplanes[i] == null) {
                    Airplane plane = new Airplane();
                    airplanes[i] = plane;
                }
            }
        }
        if (bees == null) {
           bees = new Bee();
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

/*KeyAdapter lr = new KeyAdapter() {
            boolean left = false;
            boolean right = false;
            boolean up = false;
            boolean down = false;
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (hero != null) {
                    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                        down = true;

                    } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                        up = true;

                    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        right = true;

                    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        left = true;

                    } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                        addToBullets(hero.shoot());
                    }

                    if (right && up) {
                        hero.setX(hero.getX() + 20);
                        hero.setY(hero.getY() - 20);

                    }
                    if (right && down) {
                        hero.setX(hero.getX() + 20);
                        hero.setY(hero.getY() + 10);

                    }
                    if (left && down) {
                        hero.setX(hero.getX() - 20);
                        hero.setY(hero.getY() + 10);

                    }
                    if (left && up) {
                        hero.setX(hero.getX() - 20);
                        hero.setY(hero.getY() - 10);

                    }
                    if (up && !right && !left && !down) {
                        hero.setY(hero.getY() - 10);

                    }
                    if (!up && right & !left && !down) {
                        hero.setX(hero.getX() + 20);

                    }
                    if (!up && !right && left && !down) {
                        hero.setX(hero.getX() - 20);

                    }
                    if (!up && !right && !left && down) {
                        hero.setY(hero.getY() + 10);

                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (hero != null) {
                    if (e.getKeyCode() == KeyEvent.VK_UP) {
                        up = false;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        right = false;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                        down = false;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        left = false;
                    }
                }
            }
        };
        this.addKeyListener(lr);*/