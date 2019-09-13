package com.bytetree.lintcode.array;

import java.util.HashSet;

/**
 * 389. Valid Sudoku
 * <p>
 * Determine whether a Sudoku is valid.
 * <p>
 * The Sudoku board could be partially filled, where empty cells are filled with the character ..
 * <p>
 * Clarification
 * What is Sudoku?
 * <p>
 * http://sudoku.com.au/TheRules.aspx
 * https://zh.wikipedia.org/wiki/數獨
 * https://en.wikipedia.org/wiki/Sudoku
 * http://baike.baidu.com/subview/961/10842669.htm
 * Example
 * Example 1:
 * <p>
 * Input:
 * ["53..7....","6..195...",".98....6.","8...6...3","4..8.3..1","7...2...6",".6....28.","...419..5","....8..79"]
 * Output: true
 * Explanation:
 * The sudoku is look like this. It's vaild.
 * Valid Sudoku
 * <p>
 * Example 2:
 * <p>
 * Input:
 * ["53..7j...","6..195...",".98....6.","8...6...3","4..8.3..1","7...2...6",".6....28.","...419..5","....8..79"]
 * Output: false
 * Explanation:
 * The sudoku is look like this. It's invaild because there are two '5' in the first row and the sixth line.
 * <p>
 * <a href="https://www.lintcode.com/problem/valid-sudoku/description">389. Valid Sudoku</a>
 * <p>
 * Created by vencial on 2019-09-13.
 */
public class ValidSudoku {

    /**
     * @param board: the board
     * @return: whether the Sudoku is valid
     */
    public boolean isValidSudoku(char[][] board) {
        // write your code here
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> columns = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !columns.add(board[j][i])) {
                    return false;
                }
                int rowIndex = 3 * (i / 3);
                int columnIndex = 3 * (i % 3);

                if (board[rowIndex + j / 3][columnIndex + j % 3] != '.' && !cube.add(board[rowIndex + j / 3][columnIndex + j % 3])) {
                    return false;
                }
            }
        }

        return true;
    }
}
