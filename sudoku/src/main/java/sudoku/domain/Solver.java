package sudoku.domain;

import java.util.ArrayList;
import java.util.Collections;

public class Solver {

    private static ArrayList<Integer>[][] cellValues = new ArrayList[9][9];
    private static int[][] sudoku;
    
    /**
     * Fills the given sudoku puzzle in a valid manner. Uses brute force,
     * trying a new number for every slot beginning from number 1 up to number 9.
     * @param sudoku int[][] Sudoku to be filled
     * @return The completed sudoku.
     */
    public int[][] solve(int[][] sudoku) {
        Solver.sudoku = sudoku;
        solveRecursively(0, 0);
        return sudoku;
    }
    
    /**
     * Fills the given sudoku puzzle in a valid manner. Same as method
     * solve (see link below), except fills numbers from 9 -> 1.
     * @see sudoku.domain.Solver#solve(int[][]) 
     * @param sudoku int[][] sudoku to be filled
     * @return The completed sudoku.
     */
    public int[][] solveInReverseValueOrder(int[][] sudoku) {
        Solver.sudoku = sudoku;
        solveRecursivelyInReverseValueOrder(0, 0);
        return sudoku;
    }
    
    public boolean solveRecursively(int x, int y) {
        if (y == 9) {
            return true;
        }
        if (x == 9) {
            return solveRecursively(0, y + 1);
        }
        if (sudoku[x][y] != 0) {
            return solveRecursively(x + 1, y);
        }
        for (int i = 1; i <= 9; i++) {
            sudoku[x][y] = i;
            if (check(x, y, sudoku) == true) {
                if (solveRecursively(x + 1, y)) {
                    return true;
                }
            }
            sudoku[x][y] = 0;
        }
        return false;
    }

    public boolean solveRecursivelyInReverseValueOrder(int x, int y) {
        if (y == 9) {
            return true;
        }
        if (x == 9) {
            return solveRecursively(0, y + 1);
        }
        if (sudoku[x][y] != 0) {
            return solveRecursively(x + 1, y);
        }
        for (int i = 9; i > 0; i--) {
            sudoku[x][y] = i;
            if (check(x, y, sudoku) == true) {
                if (solveRecursively(x + 1, y)) {
                    return true;
                }
            }
            sudoku[x][y] = 0;
        }
        return false;
    }
    
    /**
     * Checks that the number in given coordinates in given sudoku is valid.
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @param sudoku The sudoku being filled.
     * @return True if given number is valid, false if it is not valid.
     */
    public boolean check(int x, int y, int[][] sudoku) {

        //saman rivin arvot tarkistus
        if (!checkRow(x, y, sudoku)) {
            return false;
        }

        //saman sarakkeen arvot tarkistus
        if (!checkColumn(x, y, sudoku)) {
            return false;
        }

        //saman laatikon arvot tarkistus
        if (!checkBox(x, y, sudoku)) {
            return false;
        }

        return true;
    }

    public boolean checkRow(int x, int y, int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            if (i == x) {
                continue;
            }
            if (sudoku[x][y] == sudoku[i][y]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkColumn(int x, int y, int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            if (i == y) {
                continue;
            }
            if (sudoku[x][y] == sudoku[x][i]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Gives the upper limit of x-coordinate of the sudokubox that given
     * coordinate belongs in.
     * @param x Coordinate of whose box is queried.
     * @return Upper limit of x-coordinate of given parameters sudokubox
     */
    public int boxNumberX(int x) {
        int k;
        if (x < 3) {
            k = 2;
        } else if (x < 6) {
            k = 5;
        } else {
            k = 8;
        }
        return k; 
    }
    
    /**
     * Gives the upper limit of y-coordinate of the sudokubox that given
     * coordinate belongs in.
     * @param y Coordinate of whose box is queried.
     * @return Upper limit of y-coordinate of given parameters sudokubox
     */
    public int boxNumberY(int y) {
        int t;
        if (y < 3) {
            t = 2;
        } else if (y < 6) {
            t = 5;
        } else {
            t = 8;
        }
        return t;
    }
    
    /**
     * Checks if the number in given coordinates is valid for it's own
     * 3x3 sudokubox
     * @param x given x-coordinate
     * @param y given y-coordinate
     * @param sudoku the sudoku in question
     * @return true if given number is valid, false if not valid
     */
    public boolean checkBox(int x, int y, int[][] sudoku) {
        int k = boxNumberX(x);
        int t = boxNumberY(y);
        for (int i = k - 2; i <= k; i++) {
            for (int j = t - 2; j <= t; j++) {
                if (i == x && j == y) {
                    continue;
                }
                if (sudoku[i][j] == sudoku[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Checks if the sudoku is completed in a valid manner
     * @param sudoku The sudoku in question.
     * @return True if sudoku is completed in a valid way, else false.
     */
    public boolean completed(int[][] sudoku) {
        for (int i = 0; i < sudoku[0].length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                if (!check(i, j, sudoku)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean testiCompleted(int[][] sudoku) {
        return true;
    }

}
