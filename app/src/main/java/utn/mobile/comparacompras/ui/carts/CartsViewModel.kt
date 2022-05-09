package utn.mobile.comparacompras.ui.carts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CartsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Carts Fragment"
    }
    val text: LiveData<String> = _text
}