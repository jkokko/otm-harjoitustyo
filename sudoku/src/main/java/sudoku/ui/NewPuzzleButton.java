
package sudoku.ui;


import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import sudoku.domain.Solver;
import sudoku.domain.Generator;

public class NewPuzzleButton {
    
    public static Button getClearButton(GridPane sudokuGrid) {
        Button newPuzzle = new Button("new puzzle");
        newPuzzle.setOnMousePressed(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                GridPane sudokuGrid = SudokuGrid.createPuzzle();
            }
        });
        return newPuzzle;
    }
}