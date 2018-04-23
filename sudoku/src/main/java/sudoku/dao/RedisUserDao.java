package sudoku.dao;

import java.util.List;
import java.util.Set;
import sudoku.domain.User;
import redis.clients.jedis.Jedis;

public class RedisUserDao implements UserDao {

    private Jedis jedis;

    public RedisUserDao() {
        this.jedis = new Jedis("localhost");
    }

    public User createNewTime(User user, long time) {
        //zadd adds the key to a sorted set, first paremeter key is automatically
        //created if no such key exists beforehand
        //Times saved as seconds
        jedis.zadd("allTimeBest", time, user.getUsername());
        
        String timeAsString = timeAsString(time);
        jedis.zadd(user.getUsername(), time, timeAsString);
        return user;
    }

    public String timeAsString(long time) {
        String minutes = "";
        String seconds = "";
        long elapsedMinutes = Math.floorDiv(time, 60);
        if (elapsedMinutes > 9) {
            minutes = "" + elapsedMinutes;
        } else {
            minutes = "0" + elapsedMinutes;
        }

        if (time % 60 > 9) {
            seconds = "" + time % 60;
        } else {
            seconds = "0" + time % 60;
        }

        return minutes + ":" + seconds;
    }

    public User findByUsername(String username) {
        return null;
    }

    public List<String> getUsersBestTimes(User user) {
        //returns ten best times at key user.getUsername()
        Set bestTimes = jedis.zrangeByScoreWithScores(user.getUsername(), 0, 10);
        
        return null;
    }

    public List<String> getAllTimeBestTimes() {
        return null;
    }
}
