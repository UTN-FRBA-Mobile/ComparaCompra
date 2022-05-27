package utn.mobile.comparacompras.adapters

class ProductResponse(val id: Long, val name: String, val imageUrl: String)

class ProductMarketResponse(val product: ProductResponse, val idMarket: Long, val price: Number, val imageUrl: String)
