package utn.mobile.comparacompras.ui.carts.products

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import utn.mobile.comparacompras.R
import utn.mobile.comparacompras.adapters.ApiInterface
import utn.mobile.comparacompras.adapters.CartProductsAdapter
import utn.mobile.comparacompras.adapters.ProductMarketResponse
import utn.mobile.comparacompras.adapters.SpinnerAdapter
import utn.mobile.comparacompras.databinding.FragmentCartProductsBinding
import utn.mobile.comparacompras.db.DbCart

class CartProductsFragment : Fragment()
{
    private var _binding: FragmentCartProductsBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var dbCart: DbCart
    private lateinit var recyclerView: RecyclerView

    private var productList: IntArray? = null
    private lateinit var cartName: String
    private var cartId: Long? = null

    private lateinit var globalViewAdapter: CartProductsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View
    {
        _binding = FragmentCartProductsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        productList = arguments?.getIntArray("productList")
        cartName = requireArguments().getString("cartName").toString()
        cartId = requireArguments().getLong("cartId")

        dbCart = DbCart(context)

        binding.cartName.text = cartName

        binding.renameButton.setOnClickListener {
            val b: AlertDialog.Builder = AlertDialog.Builder(context)
            val edittext =  EditText(context);
            b.setTitle(getString(R.string.title_renombrar_carrito))
                .setView(edittext)
                .setPositiveButton(
                    getString(R.string.aceptar)
                ) { dialog, id ->
                    print(dialog)
                    print(id)
                    val newCartName = edittext.text.toString()
                    dbCart.editCartName(cartId!!, newCartName)
                    cartName = newCartName
                    binding.cartName.text = newCartName
                }
                .setNegativeButton(getString(R.string.cancelar), null)

            b.create().show()
        }

        if(productList!!.isNotEmpty())
        {
            val apiInterface = ApiInterface.create().getCartProducts(productList!!.toList())

            apiInterface.enqueue( object : Callback<List<ProductMarketResponse>>
            {
                override fun onResponse(call: Call<List<ProductMarketResponse>>?, response: Response<List<ProductMarketResponse>>?) {

                    if(response?.body() != null)
                    {
                        val viewManager = LinearLayoutManager(context)
                        val viewAdapter = CartProductsAdapter(response.body()!!.distinctBy { p -> p.product.name.uppercase() },
                            response.body()!!, cartId!!, this@CartProductsFragment
                        )

                        recyclerView = binding.cartProducts.apply {
                            layoutManager = viewManager
                            adapter = viewAdapter
                        }

                        globalViewAdapter = viewAdapter

                        var totals = viewAdapter.getTotals()

                        val adapter = SpinnerAdapter(context!!, totals)

                        val spinner = binding.marketsSpinner

                        spinner.adapter = adapter
                    }
                }

                override fun onFailure(call: Call<List<ProductMarketResponse>>?, t: Throwable?)
                {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                }
            })
        }

        return root
    }

    fun updateSpinner()
    {
        var totals = globalViewAdapter.getTotals()

        val adapter = SpinnerAdapter(requireContext(), totals)

        val spinner = binding.marketsSpinner

        spinner.adapter = adapter
    }
}