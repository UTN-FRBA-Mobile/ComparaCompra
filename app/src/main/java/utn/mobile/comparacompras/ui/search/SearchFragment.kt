package utn.mobile.comparacompras.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import utn.mobile.comparacompras.R
import utn.mobile.comparacompras.adapters.ProductsAdapter
import utn.mobile.comparacompras.core.ProductsApi
import utn.mobile.comparacompras.databinding.FragmentSearchBinding


class SearchFragment : Fragment(R.layout.fragment_search){

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
            val myDataset = ProductsApi().getProducts()

            val viewManager = LinearLayoutManager(this.context)
            val viewAdapter = ProductsAdapter(myDataset)

            recyclerView = binding.rvProducts.apply {
                layoutManager = viewManager
                adapter = viewAdapter
            }
        }

        val scannedValue = arguments?.getString("ScannedValue")
        if (!scannedValue.isNullOrEmpty())
            binding.textSearch.setText(scannedValue)

        return root
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

    interface OnFragmentInteractionListener {
        fun showFragment(fragment: Fragment)
    }
}