package utn.mobile.comparacompras

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import utn.mobile.comparacompras.databinding.ActivityMainBinding
import utn.mobile.comparacompras.utils.MyPreferences

class MainActivity : AppCompatActivity()
{

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    private val requestCodeLocationPermission = 1002
    lateinit var locationManager: LocationManager

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        //val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        /*val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_carts, R.id.navigation_search, R.id.navigation_notifications
            )
        )*/

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION),requestCodeLocationPermission)
        }else
        {
            getLocation()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray)
    {
        when (requestCode) {
            requestCodeLocationPermission -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // tenemos permiso, continuar con la tarea
                    getLocation()

                } else {
                    // Controlar que no nos dieron permiso, por ejemplo mostrando un Toast
                    Toast.makeText(
                        this,
                        resources.getString(R.string.no_tienes_permiso_ubicacion),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                return
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    @SuppressLint("MissingPermission")
    private fun getLocation()
    {
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        val hasGps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        val hasNetwork = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

        if (!MyPreferences.isLocationConfigured(this)) {
            if (hasGps || hasNetwork)
            {
                if (hasGps)
                {
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3600000, 0F)
                    { p0 ->
                        MyPreferences.setUserLongitude(this, p0.longitude)
                        MyPreferences.setUserLatitude(this, p0.latitude)
                        println("Lat: " + p0.latitude + " Lon: " + p0.longitude)
                    }
                    val localGpsLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                    if (localGpsLocation != null)
                    {
                        MyPreferences.setUserLongitude(this, localGpsLocation.longitude)
                        MyPreferences.setUserLatitude(this, localGpsLocation.latitude)
                        println("Lat: " + localGpsLocation.latitude + " Lon: " + localGpsLocation.longitude)
                    }

                }
                if (hasNetwork)
                {
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 3600000, 0F
                    ) { p0 ->
                        MyPreferences.setUserLongitude(this, p0.longitude)
                        MyPreferences.setUserLatitude(this, p0.latitude)
                        println("Lat: " + p0.latitude + " Lon: " + p0.longitude)
                    }
                    val localNetworkLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                    if (localNetworkLocation != null)
                    {
                        MyPreferences.setUserLongitude(this, localNetworkLocation.longitude)
                        MyPreferences.setUserLatitude(this, localNetworkLocation.latitude)
                        println("Lat: " + localNetworkLocation.latitude + " Lon: " + localNetworkLocation.longitude)
                    }
                }
            }
            else {
                MyPreferences.setUserLatitude(this, -34.603683)
                MyPreferences.setUserLongitude(this, -58.381557)
                println("Lat: " + "0" + " Lon: " + "0")
            }
        }
        if (MyPreferences.getUserMaxDistance(this) == 0.0)
            MyPreferences.setUserMaxDistance(this, 0.5)
    }
}