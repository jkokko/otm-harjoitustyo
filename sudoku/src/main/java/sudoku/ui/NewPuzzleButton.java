package sudoku.ui;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class NewPuzzleButton extends Button {

    public NewPuzzleButton(BorderPane window, CheckButton check, ClearButton clear) {
        setText("New Puzzle");
        setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                GridPane newSudoku = SudokuGrid.createPuzzle();
                check.setSudoku(newSudoku);
                clear.setSudoku(newSudoku);
                window.setLeft(newSudoku);
            }
        });
    }
}