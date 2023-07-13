package com.crud.user.user.service;

import java.util.List;

import com.crud.user.user.model.User;


public interface IUserServices {
    public List<User> findAll();
    public List<User> findAllActive();
    public int save(User user);
    public int update(User user);
    public int delete(int id);
    public User findById(int id);
}
