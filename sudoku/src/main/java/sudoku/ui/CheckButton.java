package sudoku.ui;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sudoku.domain.DatabaseService;
import sudoku.domain.Solver;

/**
 * Clicking this button checks if the sudoku is solved. If it is solved,
 * changes the scene to the score window, else creates a new IncorrectNotifier.
 */ 
public class CheckButton extends Button {

    private static Solver solver = new Solver();
    private GridPane sudoku;

    public CheckButton(GridPane sudoku, Stage stage, DatabaseService db, Timer timer) {
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

                if (solver.testiCompleted(currentGrid)) {
                    try {
                        db.createNewTime(timer.getElapsedSeconds());
                    } catch (Exception e) {
                        
                    }
                    ScoreWindow scoreWindow = new ScoreWindow(stage, db);
                    Scene scoreScene = new Scene(scoreWindow);
                    stage.setScene(scoreScene);
                    System.out.println("ratkaistu!");
                } else {
                    System.out.println("ei ratkaistu!");
                    IncorrectNotifier incorrect = new IncorrectNotifier();
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
