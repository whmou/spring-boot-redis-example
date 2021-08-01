package com.sudin.redis.springbootredisexample.repositories;

import com.sudin.redis.springbootredisexample.model.User;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Map;
import java.util.Set;

public interface UserRepository {

    void save(User user);

    Set<ZSetOperations.TypedTuple<String>> getAllByScores();

    void delete(User user);

}
