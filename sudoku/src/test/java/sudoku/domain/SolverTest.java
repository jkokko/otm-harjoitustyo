package sudoku.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SolverTest {
    
    Solver solver;
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
//        correct = new int[3][3];
//        int t = 1;
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                correct[i][j] = t;
//                t++;
//            }
//        }
//        
//        wrong = new int[3][3];
    }
    
    @After
    public void tearDown() {
    }

    
}
