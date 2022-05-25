package utn.mobile.comparacompras.core

import utn.mobile.comparacompras.R

class ProductsApi {
    fun getProducts(): MutableList<Product> {
        val dataset = mutableListOf<Product>()
        for (i in 0..30) {
            if (i % 2 == 0)
            //even
                dataset.add(Product(R.drawable.oreos, "Producto $i", R.drawable.dia, 97.5))
            else
            //odd
                dataset.add(Product(R.drawable.ic_baseline_child_friendly_24, "Producto $i", R.drawable.dia, 1123.5))
        }
        return dataset
    }

    fun getProductsPerMarketDetails(): MutableList<ProductPerMarket> {
        val dataset = mutableListOf<ProductPerMarket>()
        for (i in 0..5) {
            if (i % 2 == 0)
            //even
                dataset.add(ProductPerMarket( R.drawable.dia,  "300 m",100))
            else
            //odd
                dataset.add(ProductPerMarket( R.drawable.dia,  "300 m",150))
        }
        return dataset
    }
}