package com.andrii.moneymanager.controllers;

import com.andrii.moneymanager.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    //todo remove to db
    private final List<User> users = Stream.of(
                    new User(1L, "Andrii", "Kobryn"),
                    new User(2L, "Mykhailo", "Perdun"),
                    new User(3L, "Pavlo", "Bezbrov"))
            .toList();

    @GetMapping("/get-all")
    public List<User> getAll() {
        return users;
    }

    @GetMapping("/{id}/get-user")
    public User getUser(@PathVariable Long id) {
        return users.stream()
                .filter(el -> el.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
