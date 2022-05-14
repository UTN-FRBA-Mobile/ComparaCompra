package com.mobile.ComparaCompra.service;

import com.mobile.ComparaCompra.domain.Market;
import com.mobile.ComparaCompra.domain.Product;
import com.mobile.ComparaCompra.domain.ProductXMarket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Override
    public List<ProductXMarket> getAllProducts() {
        Product productA = new Product(1,"oreos");
        ProductXMarket AA = new ProductXMarket(productA,1,50);
        ProductXMarket AB = new ProductXMarket(productA,2,60);
        ProductXMarket AC = new ProductXMarket(productA,3,30);

        Market marketA = new Market(1,"coto",List.of(AA));
        Market marketB = new Market(2,"dia",List.of(AB));
        Market marketC = new Market(3,"carrefour",List.of(AC));

        return List.of(AA,AB,AC);
    }
}
