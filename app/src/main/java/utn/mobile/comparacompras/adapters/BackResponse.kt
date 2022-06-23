package utn.mobile.comparacompras.adapters

class ProductResponse(val id: Long, val name: String, val imageUrl: String)

class ProductMarketResponse(val product: ProductResponse, val idMarket: Long, var price: Number, val imageUrl: String, val distance: Double, var totalPrice: Double)

class UserResponse(val id: Long, val name: String, val address: String, val maxDistance: Double, val latitude: Double, val longitude: Double)

class CartResponse(val id: Long, val name: String, var products: List<ProductResponse>, var user: UserResponse)