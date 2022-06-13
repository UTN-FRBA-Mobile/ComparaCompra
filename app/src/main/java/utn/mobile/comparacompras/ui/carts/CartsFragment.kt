package utn.mobile.comparacompras.ui.carts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import utn.mobile.comparacompras.adapters.*
import utn.mobile.comparacompras.databinding.FragmentCartsBinding

class CartsFragment : Fragment() {

    private var _binding: FragmentCartsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(CartsViewModel::class.java)

        _binding = FragmentCartsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val searchButton = binding.searchButton

        searchButton.setOnClickListener {
            binding.rvCarts.visibility = View.VISIBLE
            getCartsByUser()
        }


        return root
    }

    private fun getCartsByUser()
    {
        val apiInterface = ApiInterface.create().getCartsByUserAndName(1, binding.textSearch.text.toString())

        apiInterface.enqueue( object : Callback<List<CartResponse>> {
            override fun onResponse(call: Call<List<CartResponse>>?, response: Response<List<CartResponse>>?) {

                if(response?.body() != null)
                {
                    val viewManager = LinearLayoutManager(context)
                    val viewAdapter = CartsAdapter(response.body()!!.distinctBy { p -> p.id })

                    recyclerView = binding.rvCarts.apply{
                        layoutManager = viewManager
                        adapter = viewAdapter
                    }
                }
            }

            override fun onFailure(call: Call<List<CartResponse>>?, t: Throwable?)
            {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}