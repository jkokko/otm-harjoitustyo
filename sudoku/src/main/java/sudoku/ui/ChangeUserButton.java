
package sudoku.ui;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sudoku.domain.DatabaseService;
import sudoku.domain.User;

/**
 * Button which sets the scene into the login scene. Logs out the
 * current user.
 * 
 */
public class ChangeUserButton extends Button {
    
    private DatabaseService db;

    public ChangeUserButton(Stage stage, DatabaseService db) {
        this.db = db;
        setText("Change user");
        
        setOnMousePressed(new EventHandler<MouseEvent>() {
           public void handle(MouseEvent event) {
               db.logOut();
               Scene loginScene = UserInterface.getLogInScreen(db, stage);
               stage.setScene(loginScene);
           } 
        });
    }
    
}
