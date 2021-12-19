package com.company;

import static com.company.PlayerCoordinateFinder.PLAYER_SYMBOL;

public class GameResult extends TicTacToe {
    private static String[] pole = new String[FIELD_SIZE * FIELD_SIZE];


    public static boolean isGameEnd(char[][] field) {
        int i, j;
        boolean bRowWin = false, bColWin = false;
        /**Проверка победы на колонках и столбиках*/
        for (i = 0; i < FIELD_SIZE; i++) {
            bRowWin = true;
            bColWin = true;
            for (j = 0; j < FIELD_SIZE-1; j++) {
                bRowWin &= (getXY(i,j) == getXY(i,j+1));
                bColWin &= (getXY(j,i) == getXY(j+1,i));
            }
            if (bColWin || bRowWin) {
                System.out.println("Победил игрок " + PLAYER_SYMBOL);
                return true;
            }
        }

        /**Проверка победы по диагоналям*/
        bRowWin = true;
        bColWin = true;
        for (i=0; i<FIELD_SIZE-1; i++) {
            bRowWin &= (getXY(i,i) == getXY(i+1,i+1));
            bColWin &= (getXY(i, FIELD_SIZE-i-1) == getXY(i+1, FIELD_SIZE-i-2));
        }
        if (bColWin || bRowWin) {
            System.out.println("Победил игрок " + PLAYER_SYMBOL);
            return true;
        }


        if (FIELD_SIZE*FIELD_SIZE <= i) {
            System.out.println("Ничья. Кончились ходы.");
            return true;
        }

        // Продолжаем игру
        return false;
    }
    /**
     * Получает значение координаты на поле
     * @return
     */
    private static String getXY(int x, int y) {
        return pole[x * FIELD_SIZE + y];
    }

    /**
     * Получает значение координаты на поле
     * @return
     */
    private static String getX(int x) {
        return pole[x];
    }

}
