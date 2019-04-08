package com.zzxx.Teris;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TerisGame extends JPanel {
    public static BufferedImage BACKGROUND;
    public static BufferedImage CELL_I;
    public static BufferedImage CELL_J;
    public static BufferedImage CELL_L;
    public static BufferedImage CELL_O;
    public static BufferedImage CELL_S;
    public static BufferedImage CELL_Z;
    public static BufferedImage CELL_T;
    public static BufferedImage PAUSE;
    public static BufferedImage GAMEOVER;
    public int score = 0;
    public Tetromino block = null;
    public Tetromino nextBlock = null;
    public static Cell[][] cellArr = new Cell[18][9];
    public int HEIGHT;
    public int WIDTH;
    public static int times = 0;
    /*
    *  state = 1 --- running
    *  state = 2 --- pause
    *  state = 3 --- gameover
    */
    private int state = 1;

    static {
        try {
            CELL_I = ImageIO.read(TerisGame.class.getResource("teris/I.png"));
            CELL_J = ImageIO.read(TerisGame.class.getResource("teris/J.png"));
            CELL_L = ImageIO.read(TerisGame.class.getResource("teris/L.png"));
            CELL_S = ImageIO.read(TerisGame.class.getResource("teris/S.png"));
            CELL_Z = ImageIO.read(TerisGame.class.getResource("teris/Z.png"));
            CELL_O = ImageIO.read(TerisGame.class.getResource("teris/O.png"));
            CELL_T = ImageIO.read(TerisGame.class.getResource("teris/T.png"));
            BACKGROUND = ImageIO.read(TerisGame.class.getResource("teris/tetris.png"));
            GAMEOVER = ImageIO.read(TerisGame.class.getResource("teris/game-over.png"));
            PAUSE = ImageIO.read(TerisGame.class.getResource("teris/pause.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TerisGame() {
        this.HEIGHT = BACKGROUND.getHeight();
        this.WIDTH = BACKGROUND.getWidth();
        init();
    }

    public void init() {
        block = Tetromino.genRandomTetro(0, 3 * Cell.WIDTH);
        nextBlock = Tetromino.genRandomTetro(0, 3 * Cell.WIDTH);
        score = 0;
        for (int i = 0; i < cellArr.length; i++) {
            for (int j = 0; j < cellArr[0].length; j++) {
                cellArr[i][j] = null;
            }
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        switch (state) {
            case 1:
                paintBackGround(g);
                g.translate(15, 15);
                paintBlock(g);
                paintCellsArr(g);
                paintScore(g);
                paintNextBlock(g);
                break;
            case 2:
                g.drawImage(PAUSE, 0, 0, null);
                break;
            case 3:
                g.drawImage(GAMEOVER, 0, 0, null);
                init();
            default:
                break;

        }

    }

    public void paintNextBlock(Graphics g) {
        Cell[] nextCells = new Cell[4];
        for (int i = 0; i < 4; i++) {
            nextCells[i] = new Cell(nextBlock.cells[i].row + 20
                     , nextBlock.cells[i].col +  8 * Cell.WIDTH + 20);
            nextCells[i].image = nextBlock.image;
            g.drawImage(nextCells[i].image, nextCells[i].col, nextCells[i].row, null);
        }


    }

    public void paintBlock(Graphics g) {
        if (block != null) {
            block.paintCells(g);
        }
    }

    public void paintCellsArr(Graphics g) {
        for (int i = 0; i < cellArr.length; i++) {
            for (int j = 0; j < cellArr[0].length; j++) {
                if (cellArr[i][j] != null)
                    g.drawImage(cellArr[i][j].image, j * Cell.WIDTH, i * Cell.HEIGHT, null);
            }
        }
    }

    public void paintBackGround(Graphics g) {
        g.drawImage(BACKGROUND, 0, 0, null);
    }

    public void paintScore(Graphics g) {
        g.setColor(new Color(128, 128, 128));
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        g.drawString("SCORE:" + score, 12 * Cell.WIDTH - 10, 9 * Cell.HEIGHT + 10);
    }
    public void blockLandAction() {
        int x;
        int y;
        if (block.isBlockLand()) {
            for (int i = 0; i < block.cells.length; i++) {
                x = block.cells[i].row / Cell.HEIGHT;
                y = block.cells[i].col / Cell.WIDTH;
                cellArr[x][y] = block.cells[i];
                cellArr[x][y].image = block.image;
            }
        }
    }

    public void detecdFullRow() {
        int nullCount = 0;
        for (int i = 0; i < cellArr.length; i++) {
            for (int j = 0; j < cellArr[0].length; j++) {
                if (cellArr[i][j] != null)
                    nullCount++;
            }
           // System.out.println(nullCount);
            if (nullCount == cellArr[0].length) {
                rmAndAwardAction(i);
            }
            nullCount = 0;
        }
    }

    public void rmAndAwardAction(int row) {
        score += 100;
        for (int i = row - 1; i >= 0; i--) {
            cellArr[i + 1] = cellArr[i];
        }
        for (int i = 0; i < cellArr[0].length; i++) {
            cellArr[0][i] = null;
        }
    }
    public void genAction() {
        if (block.isBlockLand() && state == 1) {
            block = nextBlock;
            nextBlock = Tetromino.genRandomTetro(0, 3 * Cell.WIDTH);
        }
    }

    public void blockDropAction() {
        block.Drop();
    }

    public void isGameOver() {
        int count = 0;
        int x;
        int y;
        for (int i = 0; i < block.cells.length; i++) {
            x = block.cells[i].row / Cell.HEIGHT;
            y = block.cells[i].col / Cell.WIDTH;
            if (cellArr[x][y] != null) {
                state = 3;
                return;
            }
        }
        for (int i = 0; i < cellArr[0].length; i++) {
            for (int j = 0; j < cellArr.length; j++) {
                if (cellArr[j][i] != null) {
                    ++count;
                }
            }
            if (count >= cellArr.length - 1) {
                state = 3;
                return;
            }
            count = 0;

        }
    }


    public void action() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_Z) {
                    block.rorate();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    block.Drop();
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    block.moveToLeft();
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    block.moveToRight();
                }
                if (e.getKeyCode() == KeyEvent.VK_P) {
                    state = 2;
                }
                if (e.getKeyCode() == KeyEvent.VK_C) {
                    state = 1;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    block.fastDrop();
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    if (state == 3) {
                        state = 1;
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_Q) {
                    init();
                    System.exit(0);
                }

            }
        });

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (state == 1) {
                    isGameOver();
                    if (times % 100 == 0)
                        blockDropAction();
                    blockLandAction();
                    detecdFullRow();
                    genAction();
                }
                repaint();

                times++;
            }

        };
        java.util.Timer timer = new Timer();
        timer.schedule(task, new Date(), 10);
    }

}
