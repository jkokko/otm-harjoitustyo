
package sudoku.domain;


public class User {
    private String username;
    
    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
    
    public String toString() {
        return this.username;
    }
}
