package com.mobile.ComparaCompra.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User
{
    long id;
    String name;
    String address;
    double maxDistance;
    double latitude;
    double longitude;
}
