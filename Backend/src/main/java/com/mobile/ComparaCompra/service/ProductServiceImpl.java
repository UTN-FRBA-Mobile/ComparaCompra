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
    List<Market> marketList = new ArrayList<>();

    @Autowired
    public ProductServiceImpl()
    {
        Product productA = new Product(1,"Galletitas Oreo 118 Gr.", "https://ardiaprod.vteximg.com.br/arquivos/ids/223498-1000-1000/Galletitas-Oreo-118-Gr-_1.jpg?v=637861404024700000", "111111111");
        Product productB = new Product(2,"Papas fritas DIA Original 150 Gr.", "https://ardiaprod.vteximg.com.br/arquivos/ids/220181-1000-1000/Papas-Fritas-Tubo-DIA-Sabor-Original-150-Gr-_1.jpg?v=637793946215730000", "222222222");

        ProductXMarket AA = new ProductXMarket(productA,1,50,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket AB = new ProductXMarket(productA,2,60,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket AC = new ProductXMarket(productA,3,70,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);

        ProductXMarket BA = new ProductXMarket(productB,1,70,"https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", 0);
        ProductXMarket BB = new ProductXMarket(productB,2,40,"http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", 0);
        ProductXMarket BC = new ProductXMarket(productB,3,30,"http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 0);

        Market marketA = new Market(1,"coto","https://images.rappi.com.ar/marketplace/coto-1599858972.png?d=200x200&e=webp", -130.0, 40.0, List.of(AA, BA));
        Market marketB = new Market(2,"dia","http://assets.stickpng.com/thumbs/5a0c729d9642de34b6b65cec.png", -300.0, 50.0, List.of(AB, BB));
        Market marketC = new Market(3,"carrefour","http://assets.stickpng.com/images/5a0c72729642de34b6b65ce7.png", 150.0, 40.0, List.of(AC, BC));

        productList = List.of(AA,AB,AC, BA, BB, BC);
        marketList = List.of(marketA, marketB, marketC);
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
    public List<ProductXMarket> getProduct(long idProduct, double lat, double lon, double maxDistance)
    {
        List<ProductXMarket> productXMarketsList = productList.stream().filter(p -> p.getProduct().getId() == idProduct
                && marketList.stream().filter(m -> m.getId() == p.getIdMarket()).collect(Collectors.toList()).get(0).getDistance(lat, lon) <= maxDistance)
                .collect(Collectors.toList());

        productXMarketsList.forEach(p -> p.setDistance(marketList.stream().filter(m -> m.getId() == p.getIdMarket()).collect(Collectors.toList()).get(0).getDistance(lat, lon)));

        return productXMarketsList;
    }

    @Override
    public List<ProductXMarket> getProducts(List<Long> idProductList)
    {
        return productList.stream().filter(p -> idProductList.contains(p.getProduct().getId())).collect(Collectors.toList());
    }

}
