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
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void filledGridIsValid() {
        int[][] newGrid = generator.createValidFilledGrid();
        assertEquals(true, solver.completed(newGrid));
    }
}
