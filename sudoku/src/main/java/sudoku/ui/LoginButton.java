
package sudoku.ui;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sudoku.domain.DatabaseService;
import sudoku.domain.User;

/**
 * When clicked, logs in a new user with username that is given in the
 * username textfield. Then changes the scene to the sudoku puzzle view.
 */
public class LoginButton extends Button {

    public LoginButton(Stage stage, DatabaseService db, TextField usernameField) {
        setText("Login");
        
        setOnMousePressed(new EventHandler<MouseEvent>() {
           public void handle(MouseEvent event) {
               db.logIn(new User(usernameField.getText()));
               
               Scene sudokuScene = UserInterface.getSudoku(db, stage);
               stage.setScene(sudokuScene);
           } 
        });
    }
}
