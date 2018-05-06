
package sudoku.ui;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sudoku.domain.DatabaseService;
import sudoku.domain.User;

/**
 * The button in scores window. Generates a new sudoku view and
 * sets that as the new scene.
 */
public class NewPuzzleAfterScoresButton extends Button {
    
    public NewPuzzleAfterScoresButton(Stage stage, DatabaseService db) {
        setText("New Game?");
        
        setOnMousePressed(new EventHandler<MouseEvent>() {
           public void handle(MouseEvent event) {
               stage.setScene(UserInterface.getSudoku(db, stage));
           } 
        });
    }
}
