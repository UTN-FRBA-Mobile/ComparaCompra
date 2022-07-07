package com.mobile.ComparaCompra.service;

import com.mobile.ComparaCompra.domain.ProductXMarket;

import java.util.List;

public interface ProductService
{
    List<ProductXMarket> getAllProducts(String productName, double lat, double lon, double maxDistance);
    List<ProductXMarket> getProduct(long idProduct, double lat, double lon, double maxDistance);
    List<ProductXMarket> getProducts(List<Long> idProductList);
}
