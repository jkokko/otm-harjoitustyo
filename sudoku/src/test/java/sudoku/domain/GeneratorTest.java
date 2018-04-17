package sudoku.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class GeneratorTest {
    
    Solver solver;
    Generator generator;
    int[][] testArrayOne;
    int[][] testArrayTwo;
    
    public GeneratorTest() {
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
        
        testArrayOne = new int[3][3];
        testArrayTwo = new int[3][3];
        
        int k = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                testArrayOne[i][j] = k;
                testArrayTwo[i][j] = k;
                k++;
            }
        }
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void filledGridIsValid() {
        int[][] newGrid = generator.createValidFilledGrid();
        assertEquals(true, solver.completed(newGrid));
    }
    
    @Test
    public void sameReturnsFalseIfTwoArraysAreNotIdentical() {
        testArrayTwo[2][0] = 9;
        assertEquals(false, generator.same(testArrayOne, testArrayTwo));
    }
    
    @Test
    public void sameReturnsTrueArraysAreIdentical() {
        assertEquals(true, generator.same(testArrayOne, testArrayTwo));
    }
    
    @Test
    public void copiesOfGridReturnsTwoIdenticalArraysToOriginal() {
        int[][][] copies = generator.copiesOfGrid(testArrayOne);
        assertEquals(true, generator.same(copies[0], copies[1]));
    }
}
