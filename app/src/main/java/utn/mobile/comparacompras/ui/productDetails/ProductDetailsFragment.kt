package utn.mobile.comparacompras.ui.productDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import utn.mobile.comparacompras.adapters.ApiInterface
import utn.mobile.comparacompras.adapters.ProductMarketResponse
import utn.mobile.comparacompras.adapters.ProductsPerMarketAdapter
import utn.mobile.comparacompras.databinding.FragmentProductDetailsBinding

class ProductDetailsFragment : Fragment() {

    private var _binding: FragmentProductDetailsBinding? = null
    private lateinit var recyclerView: RecyclerView

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProductDetailsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val scannedValue = arguments?.getString("productId")

        val apiInterface = ApiInterface.create().getProduct(scannedValue!!.toLong())

        apiInterface.enqueue( object : Callback<List<ProductMarketResponse>>
        {
            override fun onResponse(call: Call<List<ProductMarketResponse>>?, response: Response<List<ProductMarketResponse>>?) {

                if(response?.body() != null)
                {
                    binding.textProductName.text = response.body()!![0].product.name
                    Picasso.get().load(response.body()!![0].product.imageUrl).fit().into(binding.imageProductDetails)

                    val viewManager = LinearLayoutManager(context)
                    val viewAdapter = ProductsPerMarketAdapter(response.body()!!)

                    recyclerView = binding.rvProductPerMarketDetails.apply {
                        layoutManager = viewManager
                        adapter = viewAdapter
                    }
                }
            }

            override fun onFailure(call: Call<List<ProductMarketResponse>>?, t: Throwable?)
            {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}