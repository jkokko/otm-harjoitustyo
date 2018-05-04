package sudoku.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SolverTest {
    
    Solver solver;
    Generator generator;
    int[][] correct;
    int[][] wrong;
    
    public SolverTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solver = new Solver();
        generator = new Generator();
        correct = new int[3][3];
        int k = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                correct[i][j] = k;
                k++;
            }
        }
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void completedReturnsTrueIfPuzzleIsCompleted() {
        int[][] sudoku = generator.createValidFilledGrid();
        assertEquals(true, solver.completed(sudoku));
    }
    
    @Test
    public void checkBoxReturnsTrueIfBoxIsStillValid() {
        //simulating the situation where we have just added a new value to
        //sudoku[1][1] which is 5
        assertEquals(true, solver.checkBox(1, 1, correct));
    }
    
    @Test
    public void checkBoxReturnsFalseIfBoxContainsTheSameValue() {
        //simulating the situation where we have just added a new value to
        //sudoku[1][1] which is 5, and also sudoku[2][0] is 5.
        correct[2][0] = 5;
        assertEquals(false, solver.checkBox(1, 1, correct));
    }

    
}
