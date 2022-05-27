package com.mobile.ComparaCompra.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product
{
    long id;
    String name;
    String imageUrl;
}
