package com.garen.demo.controller;

import com.garen.demo.domain.User;
import com.garen.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product/user")
public class ProducterUserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List list() {
        return userService.list();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable("id") Long id) {
        return userService.get(id);
    }

    @PostMapping
    public boolean add(@RequestBody User user) {
        return userService.add(user);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return userService.delete(id);
    }

    @PutMapping
    public boolean update(@RequestBody User user) {
        return userService.update(user);
    }
}
