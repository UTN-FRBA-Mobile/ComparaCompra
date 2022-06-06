package com.mobile.ComparaCompra.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Cart
{
    long id;
    String name;
    List<Product> products;
    User user;    
}
