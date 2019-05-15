package com.garen.demo.dao;

import com.garen.demo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao {
    private Map<Long, User> users = new HashMap<>();

    public User queryById(Long id) {
        return users.get(id);
    }

    public List queryAll() {
        return Arrays.asList(users.values().toArray());
    }

    public boolean insert(User user) {
        return user.getId() != null && users.put(user.getId(), user) != null;
    }

    public boolean update(User user) {
        return user.getId() != null && users.put(user.getId(), user) != null;
    }

    public boolean delete(Long id) {
        return id != null && users.remove(id) != null;
    }
}
