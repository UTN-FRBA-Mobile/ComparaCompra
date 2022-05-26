package utn.mobile.comparacompras.adapters

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface
{
    @GET("all")
    fun getAllProducts() : Call<List<ProductMarketResponse>>

    companion object {

        //URL del localhost del emulador
        var BASE_URL = "http://10.0.2.2:8080/product/"

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