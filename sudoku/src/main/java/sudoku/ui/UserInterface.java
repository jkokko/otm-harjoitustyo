
package sudoku.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sudoku.domain.Solver;


public class UserInterface {
    
    public static Stage getSudoku() {
        Stage stage = new Stage();
        BorderPane ikkuna = new BorderPane();
        Solver solver = new Solver();
        GridPane sudokuGrid = SudokuGrid.createPuzzle();
        VBox vboxi = new VBox();
        
        //new game button
        Button newGame = new Button("New Game");
        
        //clear button
        Button clear = ClearButton.getClearButton(sudokuGrid);
        
        //check button
        Button check = CheckButton.getCheckButton(sudokuGrid);
        
        //Timer
        Timer timer = new Timer();
        Label time = new Label(Double.toString(timer.getTime()));
        
        vboxi.getChildren().add(time);
        vboxi.getChildren().add(clear);
        vboxi.getChildren().add(check);
        ikkuna.setRight(vboxi);
        ikkuna.setLeft(sudokuGrid);

        Scene scene = new Scene(ikkuna);
        stage.setScene(scene);
        stage.setTitle("Sudoku");
        stage.setScene(scene);
        return stage;
    }
    
}
