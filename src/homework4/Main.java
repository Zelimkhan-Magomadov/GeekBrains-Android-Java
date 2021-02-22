package homework4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int MAP_SIZE;
    private static char[][] MAP;

    private static final char EMPTY = '•';
    private static final char USER = 'x';
    private static final char AI = '0';

    private static int LAST_ROW_INPUT;
    private static int LAST_COLUMN_INPUT;
    private static int LAST_PLAYER;
    private static int MOVE_COUNTER = 0;
    private static int VICTORY_POINTS;

    private static boolean IN_GAME = true;
    private static boolean USER_WINNER = false;
    private static boolean AI_WINNER = false;

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showGameRules();
        startInit();
        showMap();

        while (IN_GAME) {
            userMove();
            showMap();
            IN_GAME = checkGameEnd();
            if (!IN_GAME) break; // Костыль чтобы успеть в срок, осталось 3 минуты(

            computerMove();
            showMap();
            IN_GAME = checkGameEnd();
        }

        if (USER_WINNER)
            System.out.println("Вы победили!");
        else if (AI_WINNER)
            System.out.println("Вы проиграли!");
        else
            System.out.println("Ничья!");
    }

    private static void showGameRules() {
        System.out.println("Привет! Это игра - Крестики-нолики");
        System.out.println("Вам необходимо первым выстроить в ряд свои фигуры по вертикали, горизонтали или диагонали");
        System.out.println("Количество фигур в ряд зависит от размера поля(3-5 -> 3ф. 6-9 -> 4ф. 10+ -> 5ф.");
        System.out.println("Первый ход делает игрок.");
        System.out.println();
    }

    private static void startInit() {
        userSelectMapSize();
        initMap();
        setVictoryPoints();
    }

    private static void userSelectMapSize() {
        int size;
        do {
            size = getNumber("Введите размер игрового поля(> 3): ");
        } while (size < 3);
        MAP_SIZE = size;
    }

    private static int getNumber(String message) {
        do {
            System.out.print(message);
            if (scanner.hasNextInt())
                return scanner.nextInt();
            else
                scanner.nextLine();
        } while (true);
    }

    private static void initMap() {
        MAP = new char[MAP_SIZE][MAP_SIZE];
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                MAP[i][j] = EMPTY;
            }
        }
    }

    private static void setVictoryPoints() {
        if (MAP_SIZE <= 5)
            VICTORY_POINTS = 3;
        else if (MAP_SIZE <= 9)
            VICTORY_POINTS = 4;
        else
            VICTORY_POINTS = 5;
    }

    private static void showMap() {
        drawMapHeader();
        drawMapBody();
    }

    private static void drawMapHeader() {
        System.out.printf("%n  ");
        for (int i = 0; i < MAP_SIZE; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
    }

    private static void drawMapBody() {
        for (int i = 0; i < MAP_SIZE; i++) {
            System.out.print(i + 1);

            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(" " + MAP[i][j]);
            }
            System.out.println();
        }
    }

    private static void userMove() {
        System.out.println("\nВаш ход");

        do {
            LAST_ROW_INPUT = getNumber("Введите номер строки: ") - 1;
            LAST_COLUMN_INPUT = getNumber("Введите номер столбца: ") - 1;
        } while (!checkCorrectMove());

        MAP[LAST_ROW_INPUT][LAST_COLUMN_INPUT] = USER;
        LAST_PLAYER = USER;
        MOVE_COUNTER++;
    }

    private static boolean checkCorrectMove() {
        if (!checkRange(LAST_ROW_INPUT, LAST_COLUMN_INPUT)) {
            System.out.println("Выход за пределы!");
            return false;
        }
        if (!checkEmpty(LAST_ROW_INPUT, LAST_COLUMN_INPUT)) {
            System.out.println("Место занято!");
            return false;
        }
        return true;
    }

    private static boolean checkRange(int row, int column) {
        return row >= 0 && column >= 0 && row < MAP_SIZE && column < MAP_SIZE;
    }

    private static boolean checkEmpty(int row, int column) {
        return MAP[row][column] == EMPTY;
    }

    private static boolean checkGameEnd() {
        if (checkRows() || checkColumns() || checkLeftDiagonal() || checkRightDiagonal()) {
            victory();
            return false;
        }
        return !checkDraw();
    }

    private static boolean checkRows() {
        int upMoves = getUpMoves();
        int downMoves = getDownMoves();

        boolean upOrDownMoves = (upMoves + 1) >= VICTORY_POINTS || (downMoves + 1) >= VICTORY_POINTS;
        boolean allMovesTogether = (upMoves + 1 + downMoves) >= VICTORY_POINTS;

        return upOrDownMoves || allMovesTogether;
    }

    private static int getUpMoves() {
        int points = 0;
        for (int row = LAST_ROW_INPUT - 1; row >= 0; row--) {
            if (MAP[row][LAST_COLUMN_INPUT] == LAST_PLAYER)
                points++;
            else
                break;
        }
        return points;
    }

    private static int getDownMoves() {
        int points = 0;
        for (int row = LAST_ROW_INPUT + 1; row < MAP_SIZE; row++) {
            if (MAP[row][LAST_COLUMN_INPUT] == LAST_PLAYER)
                points++;
            else
                break;
        }
        return points;
    }

    private static boolean checkColumns() {
        int rightMoves = getRightMoves();
        int leftMoves = getLeftMoves();

        boolean rightOrLeftMoves = (rightMoves + 1) >= VICTORY_POINTS ||
                                   (leftMoves + 1) >= VICTORY_POINTS;
        boolean allMovesTogether = (rightMoves + 1 + leftMoves) >= VICTORY_POINTS;

        return rightOrLeftMoves || allMovesTogether;
    }

    private static int getRightMoves() {
        int points = 0;
        for (int column = LAST_COLUMN_INPUT + 1; column < MAP_SIZE; column++) {
            if (MAP[LAST_ROW_INPUT][column] == LAST_PLAYER)
                points++;
            else
                break;
        }
        return points;
    }

    private static int getLeftMoves() {
        int points = 0;
        for (int column = LAST_COLUMN_INPUT - 1; column >= 0; column--) {
            if (MAP[LAST_ROW_INPUT][column] == LAST_PLAYER)
                points++;
            else
                break;
        }
        return points;
    }

    private static boolean checkLeftDiagonal() {
        int belowLeftDiagonalMoves = getBelowLeftDiagonalMoves();
        int aboveLeftDiagonalMoves = getAboveLeftDiagonalMoves();

        boolean belowOrAboveMoves = (belowLeftDiagonalMoves + 1) >= VICTORY_POINTS ||
                                    (aboveLeftDiagonalMoves + 1) >= VICTORY_POINTS;
        boolean allMovesTogether = (belowLeftDiagonalMoves + 1 + aboveLeftDiagonalMoves) >= VICTORY_POINTS;

        return belowOrAboveMoves || allMovesTogether;
    }

    private static int getBelowLeftDiagonalMoves() {
        int points = 0;
        int row = LAST_ROW_INPUT + 1;
        int column = LAST_COLUMN_INPUT + 1;

        while (row < MAP_SIZE && column < MAP_SIZE) {
            if (MAP[row++][column++] == LAST_PLAYER)
                points++;
            else
                break;
        }
        return points;
    }

    private static int getAboveLeftDiagonalMoves() {
        int points = 0;
        int row = LAST_ROW_INPUT - 1;
        int column = LAST_COLUMN_INPUT - 1;

        while (row >= 0 && column >= 0) {
            if (MAP[row--][column--] == LAST_PLAYER)
                points++;
            else
                break;
        }
        return points;
    }

    private static boolean checkRightDiagonal() {
        int belowRightDiagonalMoves = getBelowRightDiagonalMoves();
        int aboveRightDiagonalMoves = getAboveRightDiagonalMoves();

        boolean belowOrAboveMoves = (belowRightDiagonalMoves + 1) >= VICTORY_POINTS ||
                                    (aboveRightDiagonalMoves + 1) >= VICTORY_POINTS;
        boolean allMovesTogether = (belowRightDiagonalMoves + 1 + aboveRightDiagonalMoves) >= VICTORY_POINTS;

        return belowOrAboveMoves || allMovesTogether;
    }

    private static int getBelowRightDiagonalMoves() {
        int points = 0;
        int row = LAST_ROW_INPUT + 1;
        int column = LAST_COLUMN_INPUT - 1;

        while (row < MAP_SIZE && column >= 0) {
            if (MAP[row++][column--] == LAST_PLAYER)
                points++;
            else
                break;
        }
        return points;
    }

    private static int getAboveRightDiagonalMoves() {
        int points = 0;
        int row = LAST_ROW_INPUT - 1;
        int column = LAST_COLUMN_INPUT + 1;

        while (row >= 0 && column < MAP_SIZE) {
            if (MAP[row--][column++] == LAST_PLAYER)
                points++;
            else
                break;
        }
        return points;
    }

    private static void victory() {
        if (LAST_PLAYER == USER)
            USER_WINNER = true;
        else if (LAST_PLAYER == AI) {
            AI_WINNER = true;
        }
    }

    private static boolean checkDraw() {
        return MOVE_COUNTER == MAP_SIZE * MAP_SIZE;
    }

    private static void computerMove() {
        Random random = new Random();

        if (checkDraw())
            return;

        do {
            LAST_ROW_INPUT = random.nextInt(MAP_SIZE);
            LAST_COLUMN_INPUT = random.nextInt(MAP_SIZE);
        } while (!checkEmpty(LAST_ROW_INPUT, LAST_COLUMN_INPUT));

        MAP[LAST_ROW_INPUT][LAST_COLUMN_INPUT] = AI;
        LAST_PLAYER = AI;
        MOVE_COUNTER++;
    }
}