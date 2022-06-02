package utn.mobile.comparacompras.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import utn.mobile.comparacompras.R
import utn.mobile.comparacompras.adapters.ApiInterface
import utn.mobile.comparacompras.adapters.ProductMarketResponse
import utn.mobile.comparacompras.adapters.ProductsAdapter
import utn.mobile.comparacompras.databinding.FragmentSearchBinding


class SearchFragment : Fragment(R.layout.fragment_search)
{

    private var _binding: FragmentSearchBinding? = null

    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    private var _scannedValue = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val searchViewModel = ViewModelProvider(this)[SearchViewModel::class.java]

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textLogo
        searchViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val editText = binding.textSearch

        editText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.imageViewLogo.visibility = View.GONE
                binding.textLogo.visibility = View.GONE
                binding.rvProducts.visibility = View.VISIBLE
            }
        }

        val searchButton = binding.searchButton

        searchButton.setOnClickListener {
            binding.rvProducts.visibility = View.VISIBLE
            getAllProducts()
        }

        val scannedValue = arguments?.getString("ScannedValue")
        if (!scannedValue.isNullOrEmpty())
            binding.textSearch.setText(scannedValue)

        return root
    }

    private fun getAllProducts()
    {
        val apiInterface = ApiInterface.create().getAllProducts(binding.textSearch.text.toString())

        apiInterface.enqueue( object : Callback<List<ProductMarketResponse>> {
            override fun onResponse(call: Call<List<ProductMarketResponse>>?, response: Response<List<ProductMarketResponse>>?) {

                if(response?.body() != null)
                {
                    val viewManager = GridLayoutManager(context, 2)
                    val viewAdapter = ProductsAdapter(response.body()!!.distinctBy { p -> p.product.name.uppercase() })

                    recyclerView = binding.rvProducts.apply{
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
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cameraButton.setOnClickListener{
            val action = R.id.action_navigation_search_to_scannerFragment
            findNavController().navigate(action)
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    interface OnFragmentInteractionListener
    {
        fun showFragment(fragment: Fragment)
    }
}