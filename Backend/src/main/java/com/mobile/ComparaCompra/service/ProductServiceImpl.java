package com.mobile.ComparaCompra.service;

import com.mobile.ComparaCompra.domain.Market;
import com.mobile.ComparaCompra.domain.Product;
import com.mobile.ComparaCompra.domain.ProductXMarket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService
{
    List<ProductXMarket> productList = new ArrayList<>();

    @Autowired
    public ProductServiceImpl()
    {
        Product productA = new Product(1,"Galletitas Oreo 118 Gr.", "https://ardiaprod.vteximg.com.br/arquivos/ids/223498-1000-1000/Galletitas-Oreo-118-Gr-_1.jpg?v=637861404024700000", "111111111");
        ProductXMarket AA = new ProductXMarket(productA,1,50,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp");
        ProductXMarket AB = new ProductXMarket(productA,2,60,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png");
        ProductXMarket AC = new ProductXMarket(productA,3,30,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png");

        Market marketA = new Market(1,"coto","https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", List.of(AA));
        Market marketB = new Market(2,"dia","http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", List.of(AB));
        Market marketC = new Market(3,"carrefour","http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", List.of(AC));

        productList = List.of(AA,AB,AC);
    }

    @Override
    public List<ProductXMarket> getAllProducts(String productName)
    {
        if(productName == null)
        {
            return productList;
        }
        return productList.stream().filter(p -> p.getProduct().getName().toUpperCase().contains(productName.toUpperCase()) || p.getProduct().getBarcode().toUpperCase().contains(productName.toUpperCase())).collect(Collectors.toList());
    }

    @Override
    public List<ProductXMarket> getProduct(long idProduct)
    {
        return productList.stream().filter(p -> p.getProduct().getId() == idProduct).collect(Collectors.toList());
    }

}
