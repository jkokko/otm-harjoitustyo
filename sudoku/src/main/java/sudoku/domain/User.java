
package sudoku.domain;

import java.util.ArrayList;


public class User {
    private String username;
    private ArrayList<String> bestTimes;
    
    public User(String username) {
        this.username = username;
        bestTimes = new ArrayList<>();
    }

    public ArrayList<String> getBestTimes() {
        return bestTimes;
    }

    public String getUsername() {
        return username;
    }
}
