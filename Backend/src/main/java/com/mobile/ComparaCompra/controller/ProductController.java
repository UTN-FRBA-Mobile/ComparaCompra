package com.mobile.ComparaCompra.controller;


import com.mobile.ComparaCompra.domain.ProductXMarket;
import com.mobile.ComparaCompra.service.ProductService;
import com.mobile.ComparaCompra.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<ProductXMarket>> getProducts(){
        List<ProductXMarket> allProducts = productService.getAllProducts();
        return new ResponseEntity<>(allProducts,HttpStatus.OK);
    }
}
