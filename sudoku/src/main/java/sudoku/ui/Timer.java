package sudoku.ui;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;


public class Timer {

    
    public static AnimationTimer timeUpdater(Label timeLabel) {
        long startTime = System.currentTimeMillis();
        AnimationTimer timeUpdater = new AnimationTimer() {
            @Override
            public void handle(long now) {
                long elapsedSeconds = ((System.currentTimeMillis() - startTime)/1000);
                long elapsedMinutes = Math.floorDiv(elapsedSeconds, 60);
                String time = "0" + elapsedMinutes + ":" + elapsedSeconds%60;
                if (elapsedMinutes > 10) {
                    time = elapsedMinutes + ":" + elapsedSeconds;
                }
                timeLabel.setText(time);
            }
        };
        return timeUpdater;
    }
}

