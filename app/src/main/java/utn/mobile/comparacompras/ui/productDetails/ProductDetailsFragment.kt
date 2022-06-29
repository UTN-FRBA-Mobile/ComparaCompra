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
import utn.mobile.comparacompras.adapters.*
import utn.mobile.comparacompras.databinding.FragmentProductDetailsBinding
import utn.mobile.comparacompras.db.DbCart
import utn.mobile.comparacompras.db.DbHelper
import utn.mobile.comparacompras.domain.Cart
import utn.mobile.comparacompras.utils.User


class ProductDetailsFragment : Fragment() {

    private var _binding: FragmentProductDetailsBinding? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var cartsList: MutableList<Cart>
    private var scannedValue: String? = null
    private lateinit var dbCart: DbCart
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

        scannedValue = arguments?.getString("productId")

        val apiInterface = ApiInterface.create().getProduct(scannedValue!!.toLong(), User.latitude, User.longitude, User.maxDistance)
        dbCart = DbCart(context)

        apiInterface.enqueue( object : Callback<List<ProductMarketResponse>>
        {
            override fun onResponse(call: Call<List<ProductMarketResponse>>?, response: Response<List<ProductMarketResponse>>?) {

                if (response?.body() != null)
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

        controllAddProductToCartButton()

        return root
    }

    private fun controllAddProductToCartButton()
    {
        /*
        //TODO: Para testear, después borrar
        var carrito = Cart(1, "carrito", emptyList())
        dbCart.insertCart(carrito)*/
        cartsList = dbCart.getCarts()
        controlAddToCart()
    }

    private fun controlAddToCart()
    {
        val addToCartButton = binding.addToCartButton
        //val carts = arrayOf<CharSequence>("Carrito 1", "Carrito 2", "Carrito 3")
        var selectedCart: Cart? = null
        if (cartsList.size > 0)
        {
            selectedCart = cartsList[0]
        }
        val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(
            requireContext(),
            android.R.layout.simple_spinner_item,
            cartsList.map { cart -> cart.name }
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
                    selectedCart = cartsList[position]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    throw Exception("Tiene que haber un carrito seleccionado")
                }
            }

            b.setTitle("Elegir Carrito")
                .setPositiveButton("Aceptar"
                ) { dialog, id ->

                    if (selectedCart != null)
                        dbCart.addProductToCart(selectedCart!!.id, scannedValue!!.toLong(),1)

                }
                .setNegativeButton("Cancelar",null)

            b.setView(sp)
            b.create().show()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}