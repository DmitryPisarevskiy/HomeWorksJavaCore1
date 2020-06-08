package lesson8;

import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleMap extends JPanel {
    private GameWindow gameWindow;

    private int gameMode;
    private int fieldSizeX;
    private int fieldSizeY;
    private int dotsToWin;

    private int cellHeight;
    private int cellWidth;

    private boolean isInit = false;
    private final int PADDING = 17;

    public BattleMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.lightGray);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (isInit) {
                    mouseReleasedUpdate(e);
                }
            }
        });
    }

    private void mouseReleasedUpdate(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        if (!Logic.gameFinished) {
            Logic.setHumanCoords(cellX, cellY);
        }


        System.out.printf("cellX: %d  cellY: %d \n", cellX, cellY);

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }


        for (int i = 0; i < Logic.SIZEY; i++) {
            for (int j = 0; j < Logic.SIZEX; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, j, i);
                } else if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, j, i);
                }
            }
        }

        if (Logic.gameFinished && Logic.someOneWon) {
            drawLine(g, Logic.x1Finished, Logic.y1Finished, Logic.x2Finished, Logic.y2Finished);
        }
    }

    private void drawX(Graphics g, int cellX, int cellY) {
        g = (Graphics2D) g;
        ((Graphics2D) g).setStroke(new BasicStroke(10.0f));
        g.setColor(Color.blue);
        g.drawLine(cellX * cellWidth + PADDING, cellY * cellHeight + PADDING,
                (cellX + 1) * cellWidth - PADDING, (cellY + 1) * cellHeight - PADDING);
        g.drawLine(cellX * cellWidth + PADDING, (cellY + 1) * cellHeight - PADDING,
                (cellX + 1) * cellWidth - PADDING, cellY * cellHeight + PADDING);
    }

    private void drawO(Graphics g, int cellX, int cellY) {
        g = (Graphics2D) g;
        ((Graphics2D) g).setStroke(new BasicStroke(10.0f));
        g.setColor(Color.red);
        g.drawOval(cellX * cellWidth + PADDING, cellY * cellHeight + PADDING,
                cellWidth - 2 * PADDING, cellHeight - 2 * PADDING);
    }

    private void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
        g = (Graphics2D) g;
        ((Graphics2D) g).setStroke(new BasicStroke(8.0f));
        g.setColor(Color.GREEN);
        g.drawLine(x1* cellWidth+cellWidth/2, y1 * cellHeight +cellHeight/2,
                x2* cellWidth+cellWidth/2, y2 * cellHeight +cellHeight/2);
    }

    public void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int dotsToWin) {
        this.gameMode = gameMode;
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.dotsToWin = dotsToWin;

        isInit = true;
        repaint();
    }

}
