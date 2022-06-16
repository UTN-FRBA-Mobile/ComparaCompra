package utn.mobile.comparacompras.domain;

import java.util.List;

public class Cart {
    long id;
    String name;
    List<Product> productList;

    public Cart(long id, String name, List<Product> productList) {
        this.id = id;
        this.name = name;
        this.productList = productList;
    }



    public Cart(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }
}
