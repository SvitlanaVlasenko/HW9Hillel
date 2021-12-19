package com.company;

import java.util.Arrays;
import java.util.Scanner;


public class TicTacToe {

    private static final char EMPTY_SYMBOL = '-';
    public static final byte FIELD_SIZE = 3;
    private final Scanner scanner = new Scanner(System.in);

    public static char[][] field = {
            {EMPTY_SYMBOL, EMPTY_SYMBOL, EMPTY_SYMBOL},
            {EMPTY_SYMBOL, EMPTY_SYMBOL, EMPTY_SYMBOL},
            {EMPTY_SYMBOL, EMPTY_SYMBOL, EMPTY_SYMBOL},
    };



    public void start() {
        do {
            field = createField();
            CoordinateFinder playerMoveAction = new PlayerCoordinateFinder();
            CoordinateFinder aiMoveAction = new AICoordinateFinder();
            GameResult gameResult = new GameResult();
            drawField();
            doMove(playerMoveAction);
            doMove(aiMoveAction);

            while (!gameResult.isGameEnd(field)) {
                doMove(playerMoveAction);
                gameResult.isGameEnd(field);
                doMove(aiMoveAction);
                drawField();
            }
        }while (startNew());


    }

    private void doMove(CoordinateFinder coordinateFinder) {
        MoveResult moveResult;
        Coordinate coordinate;

        do {
            moveResult = coordinateFinder.findCoordinate();
            coordinate = moveResult.getCoordinate();
        } while (field[coordinate.getVertical()][coordinate.getHorizontal()] != EMPTY_SYMBOL);

        field[coordinate.getVertical()][coordinate.getHorizontal()] = moveResult.getSymbol();
    }

    private char[][] createField() {
            char[][] field = new char[FIELD_SIZE] [FIELD_SIZE];
            for (char[] chars : field) {
                Arrays.fill(chars, EMPTY_SYMBOL);
        }

        return field;
    }

    private void drawField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    protected boolean startNew(){

        return true;
    }



}
