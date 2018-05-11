
package sudoku.ui;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sudoku.dao.UserDao;
import sudoku.domain.DatabaseService;
import sudoku.domain.User;

/**
 * Has two static methods to return either login screen or the sudoku
 * puzzle view.
 */
public class UserInterface {
    
    public static Scene getLogInScreen(DatabaseService db, Stage stage) {
        
        BorderPane window = new BorderPane();
        
        VBox vbox = new VBox();
        vbox.getChildren().add(new Label("Username:"));
        
        TextField usernameField = new TextField();
        vbox.getChildren().add(usernameField);
        
        LoginButton loginButton = new LoginButton(stage, db, usernameField);
        vbox.getChildren().add(loginButton);
        window.setCenter(vbox);
        Scene scene = new Scene(window);
        
        return scene;
    }
      
    public static Scene getSudoku(DatabaseService db, Stage stage) {
        
        
        BorderPane window = new BorderPane();
        GridPane sudokuGrid = SudokuGrid.createPuzzle();
        VBox vboxi = new VBox();
        
        
        //clear button
        ClearButton clearButton = new ClearButton(sudokuGrid);
        
        //Timer
        Label timeLabel = new Label();
        Timer timer = new Timer(timeLabel);
        
        //check button
        CheckButton checkButton = new CheckButton(sudokuGrid, stage, db, timer);
        
        
        //new game button
        NewPuzzleButton newPuzzleButton = new NewPuzzleButton(window, checkButton, clearButton,
                                            timer);
        
        //change user button
        ChangeUserButton changeUser = new ChangeUserButton(stage, db);
        
        //pass button for database testing purposes
        PassButtonForDatabaseTesting pass = new PassButtonForDatabaseTesting(
                sudokuGrid, stage, db, timer);
        
        vboxi.getChildren().add(timeLabel);
        vboxi.getChildren().add(clearButton);
        vboxi.getChildren().add(checkButton);
        vboxi.getChildren().add(newPuzzleButton);
        vboxi.getChildren().add(changeUser);
        vboxi.getChildren().add(pass);
        
        window.setLeft(sudokuGrid);
        window.setRight(vboxi);

        Scene scene = new Scene(window);
        timer.start();
        return scene;
    }
    
}
