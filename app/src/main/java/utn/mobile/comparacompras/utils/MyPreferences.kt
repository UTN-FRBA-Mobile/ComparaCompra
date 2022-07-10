package utn.mobile.comparacompras.utils

import android.content.Context
import android.content.SharedPreferences

object MyPreferences {
    private val userLatitudeKey = "preference_user_latitude"
    private val userLongitudeKey = "preference_user_longitude"
    private val userMaxDistanceKey = "preference_user_max_distance"

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("preferences", Context.MODE_PRIVATE)
    }

    fun setUserLatitude(context: Context, value: Double) {
        getPreferences(context).edit().putString(userLatitudeKey, value.toString()).apply()
    }
    fun setUserLongitude(context: Context, value: Double) {
        getPreferences(context).edit().putString(userLongitudeKey, value.toString()).apply()
    }
    fun setUserMaxDistance(context: Context, value: Double) {
        getPreferences(context).edit().putString(userMaxDistanceKey, value.toString()).apply()
    }

    fun getUserLatitude(context: Context): Double {
        var userLatitudeStr = getPreferences(context).getString(userLatitudeKey, "")
        return userLatitudeStr?.toDouble() ?: 0.0
    }
    fun getUserLongitude(context: Context): Double {
        var userLongitudeStr = getPreferences(context).getString(userLongitudeKey, "")
        return userLongitudeStr?.toDouble() ?: 0.0
    }
    fun getUserMaxDistance(context: Context): Double {
        var userMaxDistanceStr = getPreferences(context).getString(userMaxDistanceKey, "")
        return userMaxDistanceStr?.toDouble() ?: 0.0
    }
}

