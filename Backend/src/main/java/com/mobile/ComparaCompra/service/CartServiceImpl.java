package com.mobile.ComparaCompra.service;

import com.mobile.ComparaCompra.domain.Cart;
import com.mobile.ComparaCompra.domain.Product;
import com.mobile.ComparaCompra.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService
{    
    List<Cart> cartsList = new ArrayList<>();

    @Autowired
    public CartServiceImpl()
    {
    	User userA = new User(1, "Juan Carlos", "Alvarez Thomas 2943", 2, -34.603683, -58.381557);
        List<Product> productList = new ArrayList<>();
        Product productA = new Product(1,"Galletitas Oreo 118 Gr.", "https://ardiaprod.vteximg.com.br/arquivos/ids/223498-1000-1000/Galletitas-Oreo-118-Gr-_1.jpg?v=637861404024700000", "111111111");
    	productList = List.of(productA);
        
    	Cart cartA = new Cart(1, "Carrito test", productList, userA);

		cartsList = List.of(cartA);
    }

    @Override
    public List<Cart> getCartsByUserAndName(long idUser, String cartName)
    {
    	List<Cart> carts = cartsList;
    	if (cartName != null && !cartName.isEmpty())
    	{
    		carts = carts.stream().filter(c -> c.getName().contains(cartName)).collect(Collectors.toList());
    	}
    		
        return carts.stream().filter(c -> c.getUser().getId() == idUser).collect(Collectors.toList());
    }

}
