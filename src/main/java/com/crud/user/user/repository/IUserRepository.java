package com.crud.user.user.repository;

import java.util.List;

import com.crud.user.user.model.User;


public interface IUserRepository {
    public List<User> findAll();
    public List<User> findAllActive();
    public int save(User user);
    public int update(User user);
    public int delete(int id);
    public User findById(int id);

}
