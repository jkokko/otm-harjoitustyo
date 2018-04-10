package sudoku.domain;

import java.util.ArrayList;
import java.util.Collections;

public class Solver {
    
    private static int k;
    private static int t;
    private static ArrayList<Integer>[][] cellValues = new ArrayList[9][9];
    private static int[][] sudoku;
    
    public int[][] solve(int[][] sudoku) {
        Solver.sudoku = sudoku;
        solveRecursively(0, 0);
        return sudoku;
    }
    
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
    
    public boolean check(int x, int y, int[][] sudoku) {
        
        //saman rivin arvot tarkistus
        for (int i = 0; i < 9; i++) {
            if (i == x) {
                continue;
            }
            if (sudoku[x][y] == sudoku[i][y]) {
                return false;
            }
        }

        //saman sarakkeen arvot tarkistus
        for (int i = 0; i < 9; i++) {
            if (i == y) {
                continue;
            }
            if (sudoku[x][y] == sudoku[x][i]) {
                return false;
            }
        }

        //saman laatikon arvot tarkistus
        if (x < 3) {
            k = 2;
        } else if (x < 6) {
            k = 5;
        } else {
            k = 8;
        }
        if (y < 3) {
            t = 2;
        } else if (y < 6) {
            t = 5;
        } else {
            t = 8;
        }

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
    
    public boolean completed(int[][] sudoku) {
        for (int i = 0; i < sudoku[0].length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                if(!check(i, j, sudoku)) {
                    return false;
                }
            }
        }
        return true;
    }
    
}
