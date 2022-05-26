package utn.mobile.comparacompras.core

import utn.mobile.comparacompras.R

class ProductsApi {
    fun getProductsPerMarketDetails(): MutableList<ProductPerMarket>
    {
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