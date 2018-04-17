package sudoku.domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Generator {

    private static int k;
    private static int t;
    private static int[][] sudokuGrid = new int[9][9];
    private static ArrayList<Integer>[][] cellValues = new ArrayList[9][9];
    private static Solver solver = new Solver();
    
    public int[][] createValidFilledGrid() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                ArrayList<Integer> arvot = new ArrayList<>();
                for (int l = 1; l < 10; l++) {
                    arvot.add(l);
                }
                Collections.shuffle(arvot);
                cellValues[i][j] = arvot;
            }
        }
        fillGrid(0, 0);
        return sudokuGrid;
    }
    
    public boolean fillGrid(int x, int y) {
        if (y == 9) {
            return true;
        }
        if (x == 9) {
            return fillGrid(0, y + 1);
        }
        if (sudokuGrid[x][y] != 0) {
            return fillGrid(x + 1, y);
        }
        
        for (int i = 0; i < 9; i++) {
            sudokuGrid[x][y] = cellValues[x][y].get(i);
            if (check(x, y, sudokuGrid) == true) {
                if (fillGrid(x + 1, y)) {
                    return true;
                }
            }
            sudokuGrid[x][y] = 0;
        }
        return false;
    }
    
    public int[][] createValidGrid() {
        createValidFilledGrid();
        int[] lastRemovedValue = removeCellValue();
        int numberOfRemovedCells = 0;
        
        while (uniquelySolvable(sudokuGrid)) {
            lastRemovedValue = removeCellValue();
            numberOfRemovedCells++;
        }
        
        sudokuGrid[lastRemovedValue[0]][lastRemovedValue[1]] = lastRemovedValue[2];
        
//        if (numberOfRemovedCells > 63 || numberOfRemovedCells < 45) {
//            return createValidGrid();
//        }
        
        return sudokuGrid;
    }
    
    public int[] removeCellValue() {
        Random cellPicker = new Random();
        int row = cellPicker.nextInt(9);
        int col = cellPicker.nextInt(9);
        int arvo = sudokuGrid[row][col];
        sudokuGrid[row][col] = 0;
        return new int[] {row, col, arvo};
    }
    
    public int[][][] copiesOfGrid(int[][] sudoku) {
        int length = sudoku[0].length;
        int[][] firstCopy = new int[length][length];
        int[][] secondCopy = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                firstCopy[i][j] = sudoku[i][j];
                secondCopy[i][j] = sudoku[i][j];
            }
        }
        int[][][] copies = new int[2][length][length];
        copies[0] = firstCopy;
        copies[1] = secondCopy;
        return copies;
    }
    
    public boolean uniquelySolvable(int[][] sudoku) {
        int[][][] copies = copiesOfGrid(sudoku);
        int[][] firstSolution = solver.solve(copies[0]);
        int[][] secondSolution = solver.solveInReverseValueOrder(copies[1]);
        if (same(firstSolution, secondSolution)) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean same(int[][] firstSolution, int[][] secondSolution) {
        for (int i = 0; i < firstSolution[0].length; i++) {
            for (int j = 0; j < firstSolution[0].length; j++) {
                int first = firstSolution[i][j];
                int second = secondSolution[i][j];
                if (first != second) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean check(int x, int y, int[][] sudoku) {
        return solver.check(x, y, sudoku);
    }
    

}
