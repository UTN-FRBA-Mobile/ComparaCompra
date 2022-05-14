package com.mobile.ComparaCompra.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ProductXMarket {
    Product product;
    long idMarket;
    long price;

}
