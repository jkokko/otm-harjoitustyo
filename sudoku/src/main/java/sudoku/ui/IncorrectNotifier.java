
package sudoku.ui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * An extension of stage, containing a label with text "incorrect!".
 * This stage automatically shows itself when constructed.
 */
public class IncorrectNotifier extends Stage {
    
    public IncorrectNotifier() {
        Label incorrect = new Label("Incorrect!");
        BorderPane window = new BorderPane();
        window.setPadding(new Insets(10, 10, 10, 10));
        window.setPrefSize(200, 100);
        window.setCenter(incorrect);
        Scene scene = new Scene(window);
        this.setScene(scene);
        this.show();
    }
}
