package sudoku.ui;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sudoku.domain.DatabaseService;

public class PassButtonForDatabaseTesting extends Button {

    public PassButtonForDatabaseTesting(GridPane sudoku, Stage stage, DatabaseService db, Timer timer) {
        setText("Passes the sudoku");
        setOnMousePressed(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                try {
                    db.createNewTime(timer.getElapsedSeconds());
                } catch (Exception e) {

                }
                ScoreWindow scoreWindow = new ScoreWindow(stage, db);
                Scene scoreScene = new Scene(scoreWindow);
                stage.setScene(scoreScene);
            }
        });
    }
}
