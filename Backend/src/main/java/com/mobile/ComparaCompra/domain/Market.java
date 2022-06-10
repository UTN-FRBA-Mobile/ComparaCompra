package com.mobile.ComparaCompra.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Market
{
    long id;
    String name;
    String imageUrl;

    double longitude;
    double latitude;
    List<ProductXMarket> products;

    public double getDistance(double lat, double lon)
    {
        return Math.sqrt(Math.pow((longitude - lon), 2) + Math.pow((latitude - lat), 2));
    }
}
