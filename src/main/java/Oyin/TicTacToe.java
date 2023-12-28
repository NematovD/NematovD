package Oyin;

import java.util.Scanner;

public class TicTacToe {
    private static final int BOARD_SIZE = 3;
    private static final char EMPTY_CELL = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    private static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
    private static boolean isPlayerXTurn = true;

    public static void main(String[] args) {
        initializeBoard();
        displayBoard();

        while (!isGameFinished()) {
            makeMove();
            displayBoard();
            switchPlayer();
        }

        displayResult();
    }

    private static void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY_CELL;
            }
        }
    }

    private static void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static void makeMove() {
        int row, col;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter row (1-" + BOARD_SIZE + "): ");
            row = scanner.nextInt() - 1;
            System.out.print("Enter column (1-" + BOARD_SIZE + "): ");
            col = scanner.nextInt() - 1;
        } while (!isValidMove(row, col));

        board[row][col] = isPlayerXTurn ? PLAYER_X : PLAYER_O;
    }

    private static boolean isValidMove(int row, int col) {
        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE || board[row][col] != EMPTY_CELL) {
            System.out.println("Invalid move! Try again.");
            return false;
        }
        return true;
    }

    private static void switchPlayer() {
        isPlayerXTurn = !isPlayerXTurn;
    }

    private static boolean isGameFinished() {
        return hasContestantWon(PLAYER_X) || hasContestantWon(PLAYER_O) || isBoardFull();
    }

    private static boolean hasContestantWon(char symbol) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }

        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
               (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == EMPTY_CELL) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void displayResult() {
        if (hasContestantWon(PLAYER_X)) {
            System.out.println("Player X wins!");
        } else if (hasContestantWon(PLAYER_O)) {
            System.out.println("Player O wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
