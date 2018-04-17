
package sudoku.ui;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class UserInterface {
    
    public static Stage getSudoku() {
        Stage stage = new Stage();
        BorderPane window = new BorderPane();
        GridPane sudokuGrid = SudokuGrid.createPuzzle();
        VBox vboxi = new VBox();
        
        //new game button
        Button newGame = new Button("New Game");
        
        //clear button
        Button clear = ClearButton.getClearButton(sudokuGrid);
        
        //check button
        Button check = CheckButton.getCheckButton(sudokuGrid);
        
        //Timer
        Label timeLabel = new Label();
        AnimationTimer timeUpdater = Timer.timeUpdater(timeLabel);
        
        
        vboxi.getChildren().add(timeLabel);
        vboxi.getChildren().add(clear);
        vboxi.getChildren().add(check);
        
        window.setLeft(sudokuGrid);
        window.setRight(vboxi);

        Scene scene = new Scene(window);
        stage.setTitle("Sudoku");
        stage.setScene(scene);
        timeUpdater.start();
        return stage;
    }
    
}
