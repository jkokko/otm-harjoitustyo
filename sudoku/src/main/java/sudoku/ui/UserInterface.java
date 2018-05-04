
package sudoku.ui;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sudoku.dao.RedisUserDao;
import sudoku.dao.UserDao;
import sudoku.domain.DatabaseService;
import sudoku.domain.User;


public class UserInterface {
      
    public static Stage getSudoku() {
        UserDao userDao = new RedisUserDao();
        DatabaseService db = new DatabaseService(userDao);
        db.logIn(new User("jussa4"));
        Stage stage = new Stage();
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
        
        
        
        vboxi.getChildren().add(timeLabel);
        vboxi.getChildren().add(clearButton);
        vboxi.getChildren().add(checkButton);
        vboxi.getChildren().add(newPuzzleButton);
        
        window.setLeft(sudokuGrid);
        window.setRight(vboxi);

        Scene scene = new Scene(window);
        stage.setTitle("Sudoku");
        stage.setScene(scene);
        timer.start();
        return stage;
    }
    
}
