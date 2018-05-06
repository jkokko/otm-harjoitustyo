
package sudoku.ui;

import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sudoku.domain.DatabaseService;

/**
 * The score window that displays all the best times/scores.
 */
public class ScoreWindow extends BorderPane {
    
    private DatabaseService db;
    
    public ScoreWindow(Stage stage, DatabaseService db) {
        this.db = db;
        setPadding(new Insets(10, 10, 10, 10));
        setPrefSize(400, 400);
        
        
        Label correct = new Label("Correct!\nBest times:");
        setTop(correct);
        
        Label scoresLabel = new Label();
        StringBuilder scores = new StringBuilder();
        List<String> scoresList = db.getAllTimeBestTimes();
        scoresList.stream().forEach(time -> {
            scores.append(time + "\n");
        });
        scoresLabel.setText(scores.toString());
        setLeft(scoresLabel);
        
        
        Label usersScoresLabel = new Label();
        StringBuilder usersScores = new StringBuilder();
        List<String> usersScoresList = db.getUsersBestTimes(db.getUser());
        usersScoresList.stream().forEach(time -> {
            usersScores.append(time + "\n");
        });
        usersScoresLabel.setText(scores.toString());
        setRight(usersScoresLabel);
        
        NewPuzzleAfterScoresButton button = new NewPuzzleAfterScoresButton(stage, db);
        setBottom(button);
    }
}
