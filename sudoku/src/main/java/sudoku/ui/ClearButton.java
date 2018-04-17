
package sudoku.ui;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import sudoku.domain.Solver;

public class ClearButton {
    
    public static Button getClearButton(GridPane sudokuGrid) {
        Button clear = new Button("clear");
        clear.setOnMousePressed(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                sudokuGrid.getChildren().stream().forEach(b -> {
                    NumberButton button = (NumberButton) b;
                    button.clearValue();
                });
            }
        });
        return clear;
    }
}
