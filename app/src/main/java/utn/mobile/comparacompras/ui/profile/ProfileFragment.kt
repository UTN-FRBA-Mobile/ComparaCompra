package utn.mobile.comparacompras.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import utn.mobile.comparacompras.adapters.ApiInterface
import utn.mobile.comparacompras.adapters.ProductMarketResponse
import utn.mobile.comparacompras.adapters.ProductsAdapter
import utn.mobile.comparacompras.adapters.UserResponse
import utn.mobile.comparacompras.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root
        getUser()
        return root
    }

    private fun getUser() {
        val apiInterface = ApiInterface.create().getUser(1)

        apiInterface.enqueue( object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>?, response: Response<UserResponse>?) {

                if(response?.body() != null)
                {
                    val user = response.body()!!;
                    binding.userName.text = user.name;
                    binding.userAddress.setText(user.address)
                    binding.maxDistanceField.setText(user.maxDistance.toString())
                }
            }

            override fun onFailure(call: Call<UserResponse>?, t: Throwable?)
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