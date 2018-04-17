package sudoku.main;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import sudoku.ui.UserInterface;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        stage = UserInterface.getSudoku();
        stage.show();
    }

    public static void main(String[] args) {
        launch(MainApplication.class);
    }
}
