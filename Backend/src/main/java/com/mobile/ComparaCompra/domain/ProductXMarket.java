package com.mobile.ComparaCompra.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class ProductXMarket
{
    Product product;
    long idMarket;
    double price;
    String imageUrl;
    double distance;
}
