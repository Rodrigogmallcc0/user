package com.crud.user.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.user.user.model.User;
import com.crud.user.user.repository.IUserRepository;

@Service
public class UserServicesImpl implements IUserServices {

    @Autowired
    private IUserRepository iUserRepository;
    // CRUD Operations for Users
    @Override
    public List<User> findAll() {
        List<User> list;
        try {
            list = iUserRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
        return list;
    }

    @Override
    public List<User> findAllActive() {
        List<User> list;
        try {
            list = iUserRepository.findAllActive();
        } catch (Exception e) {
            throw e;
        }
        return list;
    }

    @Override
    public int save(User user) {
        int row;
        try {
            row = iUserRepository.save(user);
        } catch (Exception e) {
            throw e;
        }
        return row;
    }

    @Override
    public int update(User user) {
        int row;
        try {
            row = iUserRepository.save(user);
        } catch (Exception e) {
            throw e;
        }
        return row;
    }

    @Override
    public int delete(int id) {
       int row;
        try {
            row = iUserRepository.delete(id);
        } catch (Exception e) {
            throw e;
        }
        return row;
    }

    @Override
    public User findById(int id) {
        User list;
        try {
            list = iUserRepository.findById(id);
        } catch (Exception e) {
            throw e;
        }
        return list;
    }
    
}
