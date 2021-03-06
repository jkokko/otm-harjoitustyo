
package sudoku.dao;

import java.util.List;
import sudoku.domain.User;


public interface UserDao {
    
    User createNewTime(User user, long time) throws Exception;
    List<String> getUsersBestTimes(User user);
    List<String> getAllTimeBestTimes();

}
