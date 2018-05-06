
package sudoku.domain;

import java.util.ArrayList;
import java.util.List;
import sudoku.dao.UserDao;


public class DatabaseService {
    
    private UserDao userDao;
    private User loggedIn;
    
    public DatabaseService(UserDao userDao) {
        this.userDao = userDao;
        loggedIn = null;
    }
    
    public void logIn(User user) {
        this.loggedIn = user;
    }
    
    public void logOut() {
        this.loggedIn = null;
    }

    public User getUser() {
        return loggedIn;
    }
    
    public void createNewTime(long time) throws Exception {
        this.userDao.createNewTime(loggedIn, time);
    }
    
    public List<String> getUsersBestTimes(User user) {
        return userDao.getUsersBestTimes(user);
    }
    
    public List<String> getAllTimeBestTimes() {
        return userDao.getAllTimeBestTimes();
    }
}
