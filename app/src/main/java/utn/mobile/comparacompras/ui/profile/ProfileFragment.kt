package utn.mobile.comparacompras.ui.profile

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import utn.mobile.comparacompras.R
import utn.mobile.comparacompras.adapters.ApiInterface
import utn.mobile.comparacompras.adapters.UserResponse
import utn.mobile.comparacompras.databinding.FragmentMapsBinding
import utn.mobile.comparacompras.databinding.FragmentProfileBinding
import utn.mobile.comparacompras.utils.MyPreferences

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private var _mapsBinding: FragmentMapsBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    var button: TextView? = null

    private var _userLatitude : Double = 0.0
    private var _userLongitude : Double = 0.0
    private var _userMaxDistance : Double = 0.0

    private val callback = OnMapReadyCallback { googleMap ->
        googleMap.addMarker(MarkerOptions().position(LatLng(_userLatitude, _userLongitude)))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(_userLatitude, _userLongitude)))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(_userLatitude, _userLongitude), 18f), 2000, null)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        _mapsBinding = FragmentMapsBinding.inflate(inflater, container, false)
        button = binding.vistaCompleta
        val root: View = binding.root
        button!!.setOnClickListener() {
            val bundle = bundleOf("UserLatitude" to MyPreferences.getUserLatitude(requireContext()), "UserLongitude" to MyPreferences.getUserLongitude(requireContext()))
            val action = R.id.action_navigation_notifications_to_mapsFragment
            findNavController().navigate(action, bundle)
        }

        _userLatitude = MyPreferences.getUserLatitude(requireContext())
        _userLongitude = MyPreferences.getUserLongitude(requireContext())
        _userMaxDistance = MyPreferences.getUserMaxDistance(requireContext())

        binding.maxDistanceField.setText(_userMaxDistance.toString())

        binding.maxDistanceField.addTextChangedListener { object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun afterTextChanged(p0: Editable?) {
                    MyPreferences.setUserMaxDistance(requireContext(), p0.toString().toDouble())
                    _userMaxDistance = p0.toString().toDouble()
                }
            }
        }

        val mapView = childFragmentManager.findFragmentById(R.id.tinyMap) as SupportMapFragment?
        mapView?.getMapAsync(callback)
        return root
    }

    private fun getUser() {
        val apiInterface = ApiInterface.create().getUser(1)

        apiInterface.enqueue( object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>?, response: Response<UserResponse>?) {
                if(response?.body() != null) {
                    val user = response.body()!!
                    binding.userName.text = user.name
                    binding.maxDistanceField.setText(user.maxDistance.toString())
                    val mapView = childFragmentManager.findFragmentById(R.id.tinyMap) as SupportMapFragment?
                    mapView?.getMapAsync(callback)
                }
            }

            override fun onFailure(call: Call<UserResponse>?, t: Throwable?) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
