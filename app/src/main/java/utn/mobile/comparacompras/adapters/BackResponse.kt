package utn.mobile.comparacompras.core.backEndAdapter

class ProductResponse(val id: Long, val name: String)

class ProductxMarketResponse(val product: ProductResponse, val idMarket: Long, val price: Number)
