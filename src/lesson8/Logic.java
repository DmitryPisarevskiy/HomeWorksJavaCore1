package lesson8;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Logic {
    static int SIZEX = 3;
    static int SIZEY = 3;
    static int DOTS_TO_WIN = 3;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';
    static final int MESSAGE_HEIGHT=100;
    static final int MESSAGE_WIDTH=200;

    static char[][] map;
    static boolean gameFinished = false;
    static boolean someOneWon=false;
    static int x1Finished;
    static int y1Finished;
    static int x2Finished;
    static int y2Finished;

    static Random random = new Random();

    public static void go() {
        gameFinished = true;

        printMap();

        if (checkWinLines(DOT_X)) {
            System.out.println("Ты победил!");
            someOneWon=true;
            showMessage("YOU WON!");
            return;
        }

        if (isFull()) {
            System.out.println("Ничья");
            showMessage("DRAW!");
            return;
        }

        aiTurn();
        printMap();

        if (checkWinLines(DOT_O)) {
            System.out.println("Компьютер победил!");
            someOneWon=true;
            showMessage("COMPUTER WON!");
            return;
        }

        if (isFull()) {
            System.out.println("Ничья");
            showMessage("DRAW!");
            return;
        }

        gameFinished = false;
    }

    public static void showMessage(String text) {
        JDialog dialog=new JDialog(Main.gameWindow, "Game over");
        dialog.setBounds(Main.gameWindow.WINDOW_POS_X+Main.gameWindow.WINDOW_WIDTH/2-MESSAGE_WIDTH/2, Main.gameWindow.WINDOW_POS_Y+Main.gameWindow.WINDOW_HEIGHT/2-MESSAGE_HEIGHT/2,MESSAGE_WIDTH, MESSAGE_HEIGHT);
        dialog.setVisible(true);
        JLabel label=new JLabel(text);
        dialog.add(label);
        label.setOpaque(true);
        label.setBackground(Color.lightGray);
    }

    public static void initMap() {
        map = new char[SIZEY][SIZEX];
        for (int i = 0; i < SIZEY; i++) {
            for (int j = 0; j < SIZEX; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZEX; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZEY; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZEX; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void setHumanCoords(int x, int y) {
        if (isCellValid(y, x)) {
            map[y][x] = DOT_X;
            go();
        }

    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZEX || y >= SIZEY) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static void aiTurn() {
        int x, y;

        for (int i = 0; i < SIZEY; i++) {
            for (int j = 0; j < SIZEX; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkWinLines(DOT_O)) {
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        for (int i = 0; i < SIZEY; i++) {
            for (int j = 0; j < SIZEX; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWinLines(DOT_X)) {
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        do {
            x = random.nextInt(SIZEX);
            y = random.nextInt(SIZEY);
        } while (!isCellValid(y, x));
        map[y][x] = DOT_O;
    }

    public static boolean isFull() {
        for (int i = 0; i < SIZEY; i++) {
            for (int j = 0; j < SIZEX; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }


    static boolean checkLine(int cy, int cx, int vy, int vx, char dot) {
        if (cx + vx * (DOTS_TO_WIN - 1) > SIZEX - 1 || cy + vy * (DOTS_TO_WIN - 1) > SIZEY - 1 || cy + vy * (DOTS_TO_WIN - 1) < 0) {
            return false;
        }

        for (int i = 0; i < DOTS_TO_WIN; i++) {
            if (map[cy + i * vy][cx + i * vx] != dot) {
                return false;
            }
        }
        x1Finished=cx;
        y1Finished=cy;
        x2Finished=cx + vx * (DOTS_TO_WIN - 1);
        y2Finished=cy + vy * (DOTS_TO_WIN - 1);
        return true;
    }

    static boolean checkWinLines(char dot) {
        for (int i = 0; i < SIZEY; i++) {
            for (int j = 0; j < SIZEX; j++) {
                if (checkLine(i, j, 0, 1, dot) || checkLine(i, j, 1, 0, dot) ||
                        checkLine(i, j, 1, 1, dot) || checkLine(i, j, -1, 1, dot)) {
                    return true;
                }
            }
        }
        return false;
    }

}
