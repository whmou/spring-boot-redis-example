package com.sudin.redis.springbootredisexample.controllers;

import com.sudin.redis.springbootredisexample.model.User;
import com.sudin.redis.springbootredisexample.repositories.UserRepository;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;


@RestController
@RequestMapping("/rest/user")
public class UserResourceController {


    private UserRepository userRepository;

    public UserResourceController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/add/{firstName}")
    public Set<ZSetOperations.TypedTuple<String>> add(@PathVariable("firstName") final String firstName) {
        userRepository.save(new User(firstName));
        return userRepository.getAllByScores();
    }

    @GetMapping("/getAll")
    public Set<ZSetOperations.TypedTuple<String>> getAll() {
        return userRepository.getAllByScores();
    }

    @GetMapping("/delete/{firstName}")
    public Set<ZSetOperations.TypedTuple<String>> delete(@PathVariable("firstName") final String firstName) {
        userRepository.delete(new User(firstName));
        return userRepository.getAllByScores();
    }




//    @GetMapping("/update/{id}/{firstName}")
//    public Set<ZSetOperations.TypedTuple<String>> update(@PathVariable("firstName") final String firstName,
//                    @PathVariable("id") final String id) {
//        userRepository.update(new User(id,firstName,"Mavericks!!!"));
//        return userRepository.getAllByScores(id);
//    }

//    @GetMapping("/all")
//    public Map<String,User> all() {
//        return userRepository.findAll();
//    }






}
