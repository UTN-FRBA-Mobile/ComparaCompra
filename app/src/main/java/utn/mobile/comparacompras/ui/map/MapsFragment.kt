package utn.mobile.comparacompras.ui.map

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.GoogleMap
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.LocationBias
import utn.mobile.comparacompras.R
import utn.mobile.comparacompras.databinding.FragmentMapsBinding
import java.util.*
import android.text.TextWatcher
import android.widget.Adapter
import android.widget.ListAdapter
import android.widget.Spinner
import androidx.appcompat.view.menu.MenuView
import androidx.core.widget.addTextChangedListener
import utn.mobile.comparacompras.adapters.CartsAdapter
import kotlin.collections.ArrayList

class MapsFragment : Fragment() {

    private var _binding: FragmentMapsBinding? = null
    private val binding get() = _binding!!

    private lateinit var userPosition: LatLng
    private val callback = OnMapReadyCallback { googleMap ->
        googleMap.setOnMapClickListener(GoogleMap.OnMapClickListener { latLng ->
            googleMap.clear()
            googleMap.addMarker(MarkerOptions().position(latLng))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18f), 2000, null)
            userPosition = latLng
        })
        googleMap.addMarker(MarkerOptions().position(userPosition).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(userPosition))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(userPosition, 18f), 2000, null)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMapsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        var rectangularBounds: LocationBias? = null

        val searchBar: EditText = binding.textSearch
        Places.initialize(requireContext(), getResources().getString("AIzaSyDzPZqoCT9VURs5p7s-9YxFNWyUkIl4390"));

        searchBar.addTextChangedListener { text -> autocomplete(searchBar.text) }

        // Caso default: pongo la posicion de Sydney
        userPosition = LatLng(-34.0, 151.0)

        val userLatitude = arguments?.getDouble("UserLatitude")
        val userLongitude = arguments?.getDouble("UserLongitude")
        if (userLatitude != null && userLongitude != null)
            userPosition = LatLng(userLatitude, userLongitude)

        return root
    }

    private fun autocomplete(text: Editable?) {
        var suggestions: ArrayList<PlacesAutoCompleteAdapter.PlaceAutocomplete> = ArrayList<PlacesAutoCompleteAdapter.PlaceAutocomplete>()
        var mAutoCompleteAdapter = PlacesAutoCompleteAdapter(requireContext())
        if (text != null) {
            //suggestions = mAutoCompleteAdapter.getPredictions(text)
            var addressSuggestions: ArrayList<String> = ArrayList<String>()
            for (suggestion in suggestions) {
                addressSuggestions.add(suggestion.address.toString())
            }

            var addressList: RecyclerView = binding.addressList
            var adapter = MyListAdapter(requireContext(), addressSuggestions)
            addressList.adapter = adapter
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}

class MyListAdapter(context: Context, list: ArrayList<String>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var context: Context
    lateinit var list: ArrayList<String>

    init {
        this.context = context
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}

private fun Resources.getString(s: String): String {
    return "AIzaSyDzPZqoCT9VURs5p7s-9YxFNWyUkIl4390"
}
