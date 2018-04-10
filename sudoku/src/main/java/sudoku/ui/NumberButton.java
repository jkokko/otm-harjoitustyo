package sudoku.ui;

import javafx.scene.control.Button;


public class NumberButton extends Button {
    
    private boolean givenCellValue;

    public NumberButton(Integer value) {
        givenCellValue = false;
        insertValue(value.toString());
    }

    public void insertValue(String value) {
        int valueAsInt = Integer.parseInt(value);
        if (getGivenCellValue() == true) {
            return;
        }
        if (valueAsInt > 9 || valueAsInt < 1) {
            return;
        } else {
            setText(value);
        }
    }

    public void setGivenCellValueTrue() {
        this.givenCellValue = true;
    }
    
    public boolean getGivenCellValue() {
        return this.givenCellValue;
    } 
}