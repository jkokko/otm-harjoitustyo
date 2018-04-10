
package sudoku.ui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import sudoku.domain.Generator;

public class SudokuGrid {
    
    public static GridPane createPuzzle() {
        Generator generator = new Generator();
        int[][] sudokuPuzzle = generator.createValidGrid();

        final GridPane sudokuGrid = new GridPane();
        sudokuGrid.setPadding(new Insets(10, 10, 10, 10));
        sudokuGrid.setPrefSize(300, 300);
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                int puzzleCellValue = sudokuPuzzle[i - 1][j - 1];
                final NumberButton button = new NumberButton(puzzleCellValue);
                if (puzzleCellValue != 0) {
                    button.setGivenCellValueTrue();
                    button.setStyle("-fx-font-weight: bold;");
                }
                button.setPrefSize(35, 35);
                button.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent event) {
                        if (button.getGivenCellValue() == true) {
                            return;
                        }
                        if (event.getText().matches("1|2|3|4|5|6|7|8|9")) {
                            button.insertValueAsButtonText(event.getText());
                        }
                        if (event.getCode() == KeyCode.BACK_SPACE) {
                            button.setText("");
                        }
                    }
                });

                sudokuGrid.addRow(i, button);
            }
        }
        return sudokuGrid;
    }
}
