package com.mobile.ComparaCompra.controller;


import com.mobile.ComparaCompra.domain.Cart;
import com.mobile.ComparaCompra.service.CartService;
import com.mobile.ComparaCompra.service.CartServiceImpl;
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
@RequestMapping("/cart")
public class CartController
{
    @Autowired
    CartService cartService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Cart>> getCartsByUserAndName(@PathVariable Long id, @RequestParam(required = false) String cartName)
    {
    	List<Cart> cart = cartService.getCartsByUserAndName(id, cartName);
        return new ResponseEntity<List<Cart>>(cart, HttpStatus.OK);
    }
}
