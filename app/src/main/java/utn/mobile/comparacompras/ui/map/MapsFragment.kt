package utn.mobile.comparacompras.ui.map

import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.room.vo.Fields
import com.android.volley.Response
import com.google.android.gms.location.places.Place
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.GoogleMap
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.LocationBias
import com.google.android.libraries.places.api.model.RectangularBounds
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import com.google.android.material.bottomnavigation.BottomNavigationView
import utn.mobile.comparacompras.R
import utn.mobile.comparacompras.databinding.FragmentMapsBinding
import java.util.*
import java.util.Arrays.asList

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
        Places.initialize(requireContext(), "AIzaSyDzPZqoCT9VURs5p7s-9YxFNWyUkIl4390");
        var placesClient = Places.createClient(requireContext());
        var request = FindAutocompletePredictionsRequest.builder().setLocationBias(rectangularBounds).setQuery(searchBar.text.toString()).build();
        placesClient.findAutocompletePredictions(request).addOnSuccessListener({ response: Response<Places> ->
            for (prediction in response.getAutocompletePredictions()) {
            Log.i(TAG, prediction.getPlaceId())
            Log.i(TAG, prediction.getPrimaryText(null).toString())
        }
        placesClient.findAutocompletePredictions(request).addOnSuccessListener((response) -> {
            for (AutocompletePrediction prediction : response.getAutocompletePredictions()) {
                Log.i(TAG, prediction.getPlaceId());
                Log.i(TAG, prediction.getPrimaryText(null).toString());
            }
        })
        // Caso default: pongo la posicion de Sydney
        userPosition = LatLng(-34.0, 151.0)

        val userLatitude = arguments?.getDouble("UserLatitude")
        val userLongitude = arguments?.getDouble("UserLongitude")
        if (userLatitude != null && userLongitude != null)
            userPosition = LatLng(userLatitude, userLongitude)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}
