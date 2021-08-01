package com.sudin.redis.springbootredisexample.repositories;

import com.sudin.redis.springbootredisexample.model.User;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Set;


@Repository
public class UserRepositoryImpl implements UserRepository {

    private RedisTemplate<String, User> redisTemplate;

//    private HashOperations hashOperations;
//    private ValueOperations valueOperations;
    private ZSetOperations zSetOperations;

    public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;
//        hashOperations = redisTemplate.opsForHash();
//        valueOperations = redisTemplate.opsForValue();
        zSetOperations = redisTemplate.opsForZSet();
    }

    @Override
    public void save(User user) {
        zSetOperations.incrementScore("freq", user.getFirstName(), 1);
    }


    @Override
    public Set<ZSetOperations.TypedTuple<String>> getAllByScores() {
        return  zSetOperations.reverseRangeByScoreWithScores("freq", 0, Long.MAX_VALUE, 0, 3);
    }

    @Override
    public void delete(User user) {
        zSetOperations.remove("freq", user.getFirstName());
    }
}
