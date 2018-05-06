package sudoku.ui;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;


/**
 * An extension of AnimationTimer, keeps track of the time that the sudoku
 * puzzle has been active. Also useful for database purposes, as this class
 * allows for easy fetching of the elapsed time.
 * @author kuumotusmies
 */
public class Timer extends AnimationTimer {

    private String seconds;
    private String minutes;
    private long elapsedSeconds;
    private long startTime;
    private Label timeLabel;

    public Timer(Label label) {
        this.timeLabel = label;
        this.startTime = System.currentTimeMillis();
    }

    public void handle(long now) {
        elapsedSeconds = ((System.currentTimeMillis() - startTime) / 1000);
        long elapsedMinutes = Math.floorDiv(elapsedSeconds, 60);

        if (elapsedMinutes > 9) {
            minutes = "" + elapsedMinutes;
        } else {
            minutes = "0" + elapsedMinutes;
        }

        if (elapsedSeconds % 60 > 9) {
            seconds = "" + elapsedSeconds % 60;
        } else {
            seconds = "0" + elapsedSeconds % 60;
        }

        String time = minutes + ":" + seconds;

        timeLabel.setText(time);
    }
    
    public String getText() {
        return this.timeLabel.getText();
    }
    
    public long getElapsedSeconds() {
        return elapsedSeconds;
    }
    
    public void setStartTime() {
        this.startTime = System.currentTimeMillis();
    }
    
}
