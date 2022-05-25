package utn.mobile.comparacompras.ui.productDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import utn.mobile.comparacompras.adapters.ProductsPerMarketAdapter
import utn.mobile.comparacompras.core.ProductsApi
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
        if (!scannedValue.isNullOrEmpty())
            binding.textProductName.text = scannedValue

        val myDataset = ProductsApi().getProductsPerMarketDetails()

        val viewManager = LinearLayoutManager(this.context)
        val viewAdapter = ProductsPerMarketAdapter(myDataset)

        recyclerView = binding.rvProductPerMarketDetails.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}