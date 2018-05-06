
package sudoku.ui;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * Clears the puzzle of all user given numbers, leaving the clues in place.
 * @author kuumotusmies
 */
public class ClearButton extends Button {
    
    private GridPane sudoku;

    public ClearButton(GridPane sudoku) {
        setText("Clear!");
        this.sudoku = sudoku;
        setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                getSudoku().getChildren().stream().forEach(b -> {
                    NumberButton button = (NumberButton) b;
                    button.clearNonGivenValue();
                });
            }
        });
    }

    public GridPane getSudoku() {
        return sudoku;
    }

    public void setSudoku(GridPane sudoku) {
        this.sudoku = sudoku;
    }
}
