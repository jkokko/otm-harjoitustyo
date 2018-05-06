package sudoku.main;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sudoku.dao.RedisUserDao;
import sudoku.dao.UserDao;
import sudoku.domain.DatabaseService;
import sudoku.ui.UserInterface;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        UserDao userDao = new RedisUserDao();
        DatabaseService db = new DatabaseService(userDao);
        
        Scene loginscene = UserInterface.getLogInScreen(db, stage);
        stage.setScene(loginscene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(MainApplication.class);
    }
}
