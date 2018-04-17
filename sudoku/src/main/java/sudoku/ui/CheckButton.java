package sudoku.ui;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import sudoku.domain.Solver;

public class CheckButton extends Button {

    private static Solver solver = new Solver();
    private GridPane sudoku;

    public CheckButton(GridPane sudoku) {
        setText("Check!");
        this.sudoku = sudoku;
        setOnMousePressed(new EventHandler<MouseEvent>() {
            int[][] currentGrid = new int[9][9];
            int x = 0;
            int y = 0;
            public void handle(MouseEvent event) {
                getSudoku().getChildren().stream().forEach(b -> {
                    if (x == 9) {
                        x = 0;
                        y = y + 1;
                    }
                    NumberButton button = (NumberButton) b;
                    currentGrid[y][x] = button.getValue();
                    x++;
                });

                x = 0;
                y = 0;

                if (solver.completed(currentGrid)) {
                    System.out.println("ratkaistu!");
                } else {
                    System.out.println("ei ratkaistu!");
                }
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
