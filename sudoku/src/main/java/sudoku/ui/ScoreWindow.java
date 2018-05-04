
package sudoku.ui;

import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import sudoku.domain.DatabaseService;

public class ScoreWindow extends BorderPane {
    
    private DatabaseService db;
    
    public ScoreWindow(DatabaseService db) {
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
        setCenter(scoresLabel);
    }
    
    
}
