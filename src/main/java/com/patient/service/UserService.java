package com.patient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.patient.DAO.UserRepository;

@Service
public class UserService
{
    @Autowired
    private UserRepository repository;

    public UserService(UserRepository userRepository)
    {
        this.repository = userRepository;
    }
    public void save(User user)
    {
        try
        {
            repository.save(user);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}