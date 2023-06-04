package com.Microservice.Service;

import com.Microservice.Entities.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);

    public List<User> getAllUser();

    public User getUser(String userId);

    public User updateUser(String uid,User user);

    public void deleteUser(String uid);

}
