package com.mobile.ComparaCompra.controller;


import com.mobile.ComparaCompra.domain.User;
import com.mobile.ComparaCompra.service.UserService;
import com.mobile.ComparaCompra.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController
{
    @Autowired
    UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable Long id)
    {
    	User user = userService.getUser(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
