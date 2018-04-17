package sudoku.ui;

import javafx.scene.control.Button;


public class NumberButton extends Button {
    
    private boolean givenCellValue;
    private int value;

    public NumberButton(Integer value) {
        givenCellValue = false;
        this.value = value;
        insertStringValueAsButtonText(value.toString());
    }

    public void insertStringValueAsButtonText(String value) {
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
    
    public void insertIntValueAsButtonText(Integer value) {
        this.value = value;
        setText(Integer.toString(value));
    }
    
    public void clearNonGivenValue() {
        if (givenCellValue == false) {
            this.setText("");
            this.value = 0;
        }
    }
    
    public void clearValue() {
        this.setText("");
        this.value = 0;
        this.givenCellValue = false;
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