package com.mobile.ComparaCompra.service;

import com.mobile.ComparaCompra.domain.Cart;

import java.util.List;

public interface CartService
{
    List<Cart> getCartsByUserAndName(long idUser, String cartName);
}
