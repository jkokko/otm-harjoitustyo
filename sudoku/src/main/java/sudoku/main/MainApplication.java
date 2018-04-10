package sudoku.main;

import sudoku.domain.Solver;
import sudoku.ui.SudokuGrid;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sudoku.ui.CheckButton;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane ikkuna = new BorderPane();
        Solver solver = new Solver();
        GridPane sudokuGrid = SudokuGrid.createPuzzle();
        VBox vboxi = new VBox();
        
        //new game button
        Button newGame = new Button("New Game");
        
        //clear button
        Button clear = new Button("clear");
        
        //check button
        Button check = CheckButton.getCheckButton(sudokuGrid);
        
        vboxi.getChildren().add(new Label("aika"));
        vboxi.getChildren().add(clear);
        vboxi.getChildren().add(check);
        ikkuna.setRight(vboxi);
        ikkuna.setLeft(sudokuGrid);

        Scene scene = new Scene(ikkuna);
        stage.setScene(scene);
        stage.setTitle("Sudoku");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(MainApplication.class);
    }
}
