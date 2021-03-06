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
    fun getAllProducts(@Query("productName") productName: String, @Query("lat") lat: Double, @Query("lon") lon: Double,
                       @Query("maxDistance") maxDistance: Double) : Call<List<ProductMarketResponse>>

    @GET("product/{id}")
    fun getProduct(@Path("id") id: Long, @Query("lat") lat: Double, @Query("lon") lon: Double,
                   @Query("maxDistance") maxDistance: Double): Call<List<ProductMarketResponse>>

    @GET("user/{id}")
    fun getUser(@Path("id") id: Long): Call<UserResponse>

    @GET("product/search")
    fun getCartProducts(@Query("idList") idList: List<Int>): Call<List<ProductMarketResponse>>

    companion object {

        private var BASE_URL = "https://api-comparacompras.azurewebsites.net/"
        //private var BASE_URL = "http://10.0.2.2:8080/"

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