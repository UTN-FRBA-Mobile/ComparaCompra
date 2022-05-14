package com.mobile.ComparaCompra.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Market {
    long id;
    String name;

    List<ProductXMarket> products;
}
