package utn.mobile.comparacompras.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import utn.mobile.comparacompras.R
import utn.mobile.comparacompras.adapters.ProductsAdapter
import utn.mobile.comparacompras.core.ProductsApi
import utn.mobile.comparacompras.databinding.FragmentSearchBinding
import utn.mobile.comparacompras.ui.scanner.ScannerFragment


class SearchFragment : Fragment(){

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

        val cameraButton = binding.cameraButton

        cameraButton.setOnClickListener {
            changeFragment(ScannerFragment())
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    interface OnFragmentInteractionListener {
        fun showFragment(fragment: Fragment)
    }

    private fun changeFragment(newFragment: Fragment) {
        val fragmentManager: FragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.hide(this)
        fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, newFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    fun setScannedValue(scannedValue: String) {
        _scannedValue = scannedValue
        // Si cambia el valor escaneado, debería hacer una búsqueda
        //search(scannedValue)
        Toast.makeText(requireContext(), "value- else", Toast.LENGTH_SHORT).show()
    }
}