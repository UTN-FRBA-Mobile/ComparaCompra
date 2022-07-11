package utn.mobile.comparacompras.ui.carts

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import utn.mobile.comparacompras.adapters.*
import utn.mobile.comparacompras.databinding.FragmentCartsBinding
import utn.mobile.comparacompras.db.DbCart
import utn.mobile.comparacompras.domain.Cart


class CartsFragment : Fragment()
{

    private var _binding: FragmentCartsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var dbCart: DbCart

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(CartsViewModel::class.java)

        _binding = FragmentCartsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        dbCart = DbCart(context)

        val searchButton = binding.searchButton

        searchButton.setOnClickListener {
            binding.rvCarts.visibility = View.VISIBLE
            getCartsByUser()
        }

        val floatingButton = binding.floating

        floatingButton.setOnClickListener{
            val currentContext = requireContext()
            val b: AlertDialog.Builder = AlertDialog.Builder(currentContext)
            val edittext =  EditText(currentContext);

            val sp = Spinner(currentContext)

            b.setTitle("Nombre del carrito")
            b.setView(edittext)

            b.setPositiveButton("Sí",
                DialogInterface.OnClickListener { dialog, whichButton ->

                    val cartName = edittext.text.toString()
                    var cart = Cart()
                    cart.name = cartName
                    cart.productList = emptyList()
                    dbCart.insertCart(cart)
                    getCartsByUser()

                })
            b.setNegativeButton("No", null)

            b.create().show()

        }
        getCartsByUser()

        return root
    }

    private fun getCartsByUser()
    {
        val carts = dbCart.carts

        val viewManager = LinearLayoutManager(context)
        val viewAdapter = CartsAdapter(carts)
        recyclerView = binding.rvCarts.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}