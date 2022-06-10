package com.mobile.ComparaCompra.controller;


import com.mobile.ComparaCompra.domain.ProductXMarket;
import com.mobile.ComparaCompra.service.ProductService;
import com.mobile.ComparaCompra.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/product")
public class ProductController
{
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<ProductXMarket>> getProducts(@RequestParam(required = false) String productName)
    {
        List<ProductXMarket> allProducts = productService.getAllProducts(productName);
        return new ResponseEntity<>(allProducts,HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ProductXMarket>> getProduct(@PathVariable Long id, @RequestParam(name = "lat") double lat, @RequestParam(name="lon") double lon, @RequestParam(name = "maxDistance") double maxDistance)
    {
        List<ProductXMarket> productMarkets = productService.getProduct(id, lat, lon, maxDistance);
        return new ResponseEntity<>(productMarkets, HttpStatus.OK);
    }
}
