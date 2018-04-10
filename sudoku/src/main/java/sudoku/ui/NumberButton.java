package sudoku.ui;

import javafx.scene.control.Button;


public class NumberButton extends Button {
    
    private boolean givenCellValue;
    private int value;

    public NumberButton(Integer value) {
        givenCellValue = false;
        this.value = value;
        insertValueAsButtonText(value.toString());
    }

    public void insertValueAsButtonText(String value) {
        int valueAsInt = Integer.parseInt(value);
        if (getGivenCellValue() == true) {
            return;
        }
        if (valueAsInt > 9 || valueAsInt < 1) {
            return;
        } else {
            setText(value);
            this.value = valueAsInt;
        }
    }

    public int getValue() {
        return value;
    }
    
    public void setGivenCellValueTrue() {
        this.givenCellValue = true;
    }
    
    public boolean getGivenCellValue() {
        return this.givenCellValue;
    }
    
    
}