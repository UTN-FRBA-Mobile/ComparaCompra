package utn.mobile.comparacompras.adapters

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface
{
    @GET("product/all")
    fun getAllProducts(@Query("productName") productName: String) : Call<List<ProductMarketResponse>>
    @GET("product/{id}")
    fun getProduct(@Path("id") id: Long, @Query("lat") lat: Double, @Query("lon") lon: Double,
                   @Query("maxDistance") maxDistance: Double): Call<List<ProductMarketResponse>>
    @GET("user/{id}")
    fun getUser(@Path("id") id: Long): Call<UserResponse>
    @GET("cart/user/{id}")
    fun getCartsByUserAndName(@Path("id") id: Long, @Query("cartName") cartName: String): Call<List<CartResponse>>

    companion object {

        private var BASE_URL = "https://api-comparacompras.azurewebsites.net/"
        //private var BASE_URL = "http://127.0.0.1:8080/"

        fun create() : ApiInterface
        {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}