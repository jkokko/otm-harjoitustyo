package sudoku.main;
import sudoku.domain.Generator;
import sudoku.domain.Solver;
import sudoku.ui.NumberButton;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        Solver solver = new Solver();
        Generator generator = new Generator();
        int[][] sudokuPuzzle = generator.createValidGrid();     

        BorderPane ikkuna = new BorderPane();
        final GridPane sudokuGrid = new GridPane();
        ColumnConstraints column = new ColumnConstraints(300);
        sudokuGrid.setPadding(new Insets(10, 10, 10, 10));
        sudokuGrid.setPrefSize(300, 300);
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                int puzzleCellValue = sudokuPuzzle[i - 1][j - 1];
                final NumberButton button = new NumberButton(puzzleCellValue);
                if (puzzleCellValue != 0) {
                    button.setGivenCellValueTrue();
                    button.setStyle("-fx-font-weight: bold;");
                }
                button.setPrefSize(35, 35);
                button.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent event) {
                        if (button.getGivenCellValue() == true) {
                            return;
                        }
                        if (event.getText().matches("1|2|3|4|5|6|7|8|9")) {
                            button.insertValue(event.getText());
                        }
                    }
                });
                
                sudokuGrid.addRow(i, button);
            }
        }
        
        
        VBox vboxi = new VBox();
        Button newGame = new Button("New Game");
        Button clear = new Button("clear");
        Button check = new Button("check");
        check.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                //kesken
            }
        });
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
        launch(Main.class);
    }
}
