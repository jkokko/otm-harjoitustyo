package sudoku.dao;

import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import sudoku.domain.User;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

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

    public List<String> getUsersBestTimes(User user) {
        //returns ten best times at key user.getUsername()
        ArrayList<String> bestTimes = jedis.zrevrange(user.getUsername(), 0, 10).
                stream().collect(Collectors.toCollection(ArrayList::new));
       
        return bestTimes;
    }

    public List<String> getAllTimeBestTimes() {
        ArrayList<String> bestTimes = new ArrayList<>();
        jedis.zrevrangeByScoreWithScores("allTimeBest", 0, 10).
                stream().forEach(tuple -> {
                    bestTimes.add(tuple.getElement() + ": " + 
                            timeAsString((long) tuple.getScore()));
                });
        
        return bestTimes;
    }
}
