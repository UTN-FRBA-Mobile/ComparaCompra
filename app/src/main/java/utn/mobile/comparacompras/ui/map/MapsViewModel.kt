package utn.mobile.comparacompras.ui.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MapsViewModel {
    private val _text = MutableLiveData<String>().apply {
        value = "Maps Fragment"
    }
    val text: LiveData<String> = _text
}