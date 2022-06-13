package utn.mobile.comparacompras.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import utn.mobile.comparacompras.R
import utn.mobile.comparacompras.databinding.FragmentMapsBinding


class MapsFragment : Fragment() {

    private var _binding: FragmentMapsBinding? = null
    private val binding get() = _binding!!

    private lateinit var userPosition: LatLng
    private val callback = OnMapReadyCallback { googleMap ->
        googleMap.addMarker(MarkerOptions().position(userPosition).title("Marker in Sydney"))
        //googleMap.moveCamera(CameraUpdateFactory.newLatLng(userPosition))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(userPosition, 5f))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMapsBinding.inflate(inflater, container, false)
        val root: View = binding.root

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