package com.bytetree.lintcode.array;

/**
 * 802. Sudoku Solver
 * <p>
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * Empty cells are indicated by the number 0.
 * <p>
 * You may assume that there will be only one unique solution.
 *
 * <a href="https://www.lintcode.com/problem/sudoku-solver/description">802. Sudoku Solver</a>
 * <p>
 * Created by vencial on 2019-09-16.
 */
public class SudokuSolver {

    /**
     * @param board: the sudoku puzzle
     * @return: nothing
     */
    public void solveSudoku(int[][] board) {
        // write your code here
        if (board == null || board.length == 0) return ;

        sudoku(board);

    }

    private boolean sudoku(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            if (sudoku(board)) {
                                return true;
                            } else {
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int[][] board, int row, int col, int value) {

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value) return false;
            if (board[i][col] == value) return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == value) return false;
        }

        return true;
    }
}
