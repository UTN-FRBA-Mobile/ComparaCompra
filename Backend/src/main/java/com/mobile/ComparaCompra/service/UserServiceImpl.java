package com.mobile.ComparaCompra.service;

import com.mobile.ComparaCompra.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService
{
    List<User> userList = new ArrayList<>();

    @Autowired
    public UserServiceImpl()
    {
    	User userA = new User(1, "Juan Carlos", "Alvarez Thomas 2943", 2, -34.603683, -58.381557);
    	User userB = new User(2, "Marcelo", "Av. Rivadavia 4521", 0.5, -34.615257, -58.429573);

    	userList = List.of(userA, userB);
    }

    @Override
    public User getUser(long id)
    {
        return userList.stream().filter(p -> p.getId() == id).collect(Collectors.toList()).get(0);
    }

}
