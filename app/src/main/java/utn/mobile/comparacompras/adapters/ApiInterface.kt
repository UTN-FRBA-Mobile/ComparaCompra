package utn.mobile.comparacompras.adapters

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface
{
    @GET("all")
    fun getAllProducts() : Call<List<ProductMarketResponse>>
    @GET("{id}")
    fun getProduct(@Path("id") id: Long): Call<List<ProductMarketResponse>>

    companion object {

        //URL del localhost del emulador
        var BASE_URL = "https://api-comparacompras.azurewebsites.net/product/"

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