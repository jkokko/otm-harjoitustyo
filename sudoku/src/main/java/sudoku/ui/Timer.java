package sudoku.ui;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;


public class Timer {

    
    public static AnimationTimer timeUpdater(Label timeLabel) {
        long startTime = System.currentTimeMillis();
        AnimationTimer timeUpdater = new AnimationTimer() {
            String minutes = "";
            String seconds = "";
            @Override
            public void handle(long now) {
                long elapsedSeconds = ((System.currentTimeMillis() - startTime) / 1000);
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
        };
        return timeUpdater;
    }
}

