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

    double latitude;
    double longitude;
    List<ProductXMarket> products;

    // Uso fórmula de semiverseno (o haversine en inglés)
    public double getDistance(double lat, double lon)
    {
        var R = 6371.0710 * Math.pow(10, 3); // Radio de la Tierra en metros
        var rlat1 = lat * (Math.PI / 180); // Convierto grados a radianes
        var rlat2 = latitude * (Math.PI / 180); // Convierto grados a radianes
        var difflat = rlat2 - rlat1; // Diferencia de radianes (latitudes)
        var difflon = (longitude - lon) * (Math.PI / 180); // Diferencia de radianes (longitudes)

        // Calculo la distancia entre las longitudes en metros
        var d = 2 * R * Math.asin(Math.sqrt(Math.sin(difflat/2) * Math.sin(difflat/2) + Math.cos(rlat1) * Math.cos(rlat2) * Math.sin(difflon/2) * Math.sin(difflon/2)));
        return d;
    }
}
