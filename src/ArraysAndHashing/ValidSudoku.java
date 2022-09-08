package ArraysAndHashing;

import java.util.ArrayList;
import java.util.HashSet;

// Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
//
// 1. Each row must contain the digits 1-9 without repetition.
// 2. Each column must contain the digits 1-9 without repetition.
// 3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
//
// Note:
//
// A Sudoku board (partially filled) could be valid but is not necessarily solvable.
// Only the filled cells need to be validated according to the mentioned rules.

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        // hashsets for storing the numbers in every row, column, and box
        ArrayList<HashSet<Integer>> rows = new ArrayList<>();
        ArrayList<HashSet<Integer>> columns = new ArrayList<>();
        ArrayList<ArrayList<HashSet<Integer>>> boxes = new ArrayList<>();

        // store this for easier re-use
        int boardSize = board.length;

        // create hashsets to store each row and column
        for (int i = 0; i < boardSize; i++) {
            rows.add(new HashSet<>());
            columns.add(new HashSet<>());
        }

        // create hashsets to store each box
        for (int i = 0; i < boardSize / 3; i++) {
            boxes.add(new ArrayList<>());
            for (int j = 0; j < boardSize / 3; j++) {
                boxes.get(i).add(new HashSet<>());
            }
        }

        // loop over every value on the board
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                int number;

                // if the square is not empty
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    number = board[i][j] - '0';

                    //ensure it is the only occurrence in the row, column, and box
                    if (!rows.get(i).add(number) ||
                        !columns.get(j).add(number) ||
                        !boxes.get(i / 3).get(j / 3).add(number)) return false;
                }
            }
        }
        return true;
    }


    // this solution simply re-uses the row hashset instead of creating one for each row
    // this is only possible as we are iterating row by row; the other two lists of sets are needed
    public boolean isValidSudokuImproved(char[][] board) {
        // hashset for storing the numbers in the current row
        HashSet<Integer> row = new HashSet<>();

        // lists of hashsets for storing the numbers in each column and box
        ArrayList<HashSet<Integer>> columns = new ArrayList<>();
        ArrayList<ArrayList<HashSet<Integer>>> boxes = new ArrayList<>();

        // store this for easier re-use
        int boardSize = board.length;

        // create hashsets to store each column
        for (int i = 0; i < boardSize; i++) {
            columns.add(new HashSet<>());
        }

        // create hashsets to store each box
        for (int i = 0; i < boardSize / 3; i++) {
            boxes.add(new ArrayList<>());
            for (int j = 0; j < boardSize / 3; j++) {
                boxes.get(i).add(new HashSet<>());
            }
        }

        // loop over every value on the board
        for (int i = 0; i < boardSize; i++) {

            // empty the row hashset as we are now on a new row
            row.clear();
            for (int j = 0; j < boardSize; j++) {
                int number;

                // if the square is not empty
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    number = board[i][j] - '0';

                    //ensure it is the only occurrence in the row, column, and box
                    if (!row.add(number) ||
                            !columns.get(j).add(number) ||
                            !boxes.get(i / 3).get(j / 3).add(number)) return false;
                }
            }
        }
        return true;
    }

}
