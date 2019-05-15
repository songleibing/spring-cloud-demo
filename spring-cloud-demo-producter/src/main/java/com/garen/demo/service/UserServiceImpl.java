package com.garen.demo.service;

import com.garen.demo.dao.UserDao;
import com.garen.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean add(User user) {
        return userDao.insert(user);
    }

    @Override
    public boolean delete(Long id) {
        return userDao.delete(id);
    }

    @Override
    public boolean update(User user) {
        return userDao.update(user);
    }

    @Override
    public User get(Long id) {
        return userDao.queryById(id);
    }

    @Override
    public List list() {
        return userDao.queryAll();
    }


}
