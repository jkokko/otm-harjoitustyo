package sudoku.ui;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Timer {

    private Duration duration;
    private ChronoUnit timer;
    private Instant timeCreated;
    private EventHandler eventHandler;
    private Timeline timeline;

    public Timer() {

    }

    public Label getTime() {
        Label timerLabel = new Label();
        timeCreated = Instant.now();
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        eventHandler = new EventHandler() {
            public void handle(ActionEvent event) {

                timerLabel.setText(timeSeconds.toString());
                timeline = new Timeline();
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(1),
                                new EventHandler() {
                            // KeyFrame event handler
                            public void handle(ActionEvent event) {
                                timeSeconds--;
                                // update timerLabel
                                timerLabel.setText(
                                        timeSeconds.toString());
                                if (timeSeconds <= 0) {
                                    timeline.stop();
                                }
                            }
                        }));
                timeline.playFromStart();
            }
        }
    }

//    public double getTime() {
//        Instant current = Instant.now();
//        double time = ChronoUnit.MILLIS.between(timeCreated, current);
//        return time;
//    }
}
