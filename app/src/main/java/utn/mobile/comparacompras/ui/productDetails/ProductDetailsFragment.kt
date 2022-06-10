package utn.mobile.comparacompras.ui.productDetails

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
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
import utn.mobile.comparacompras.utils.User
import java.lang.Exception


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

        val apiInterface = ApiInterface.create().getProduct(scannedValue!!.toLong(), User.latitude, User.longitude, User.maxDistance)

        apiInterface.enqueue( object : Callback<List<ProductMarketResponse>>
        {
            override fun onResponse(
                call: Call<List<ProductMarketResponse>>,
                response: Response<List<ProductMarketResponse>>
            ) {

                if(response.body() != null)
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

            override fun onFailure(call: Call<List<ProductMarketResponse>>, t: Throwable)
            {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
            }
        })

        val addToCartButton = binding.addToCartButton
        val carts = arrayOf<CharSequence>("Carrito 1", "Carrito 2", "Carrito 3")
        var selectedCart = carts[0]
        print(selectedCart)
        val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(
            requireContext(),
            android.R.layout.simple_spinner_item,
            carts
        )
        ad.setDropDownViewResource(
            android.R.layout
                .simple_spinner_dropdown_item)

        addToCartButton.setOnClickListener {
            val currentContext = requireContext()
            val b: AlertDialog.Builder = AlertDialog.Builder(currentContext)

            val sp = Spinner(currentContext)
            sp.adapter = ad
            sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    selectedCart = carts[position]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    throw Exception("Tiene que haber un carrito seleccionado")
                }
            }

            b.setTitle("Elegir Carrito")
                .setPositiveButton("Aceptar"
                ) { dialog, id ->
                    print(dialog)
                    print(id)
                    // selectedCart.addProduct(product)
                }
                .setNegativeButton("Cancelar",null)

            b.setView(sp)
            b.create().show()

        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}