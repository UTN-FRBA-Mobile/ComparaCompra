package utn.mobile.comparacompras.ui.map

import android.R
import android.content.Context
import android.graphics.Typeface
import android.support.annotation.NonNull
import android.text.style.CharacterStyle
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.AutocompleteSessionToken
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.net.*
import kotlinx.coroutines.NonDisposableHandle.parent
import java.util.*
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException
import kotlin.collections.ArrayList


class PlacesAutoCompleteAdapter(private val mContext: Context) :
    RecyclerView.Adapter<PlacesAutoCompleteAdapter.PredictionHolder>(), Filterable {
    private var mResultList: ArrayList<PlaceAutocomplete>? = ArrayList()
    private val STYLE_BOLD: CharacterStyle
    private val STYLE_NORMAL: CharacterStyle
    private val placesClient: PlacesClient
    private var clickListener: ClickListener? = null
    fun setClickListener(context: Context) {
        this.clickListener = clickListener
    }

    interface ClickListener {
        fun click(place: Place?)
    }

    public fun getPredictions(constraint: CharSequence): ArrayList<PlaceAutocomplete> {
        val resultList: ArrayList<PlaceAutocomplete> = ArrayList()

        val token = AutocompleteSessionToken.newInstance()

        val request =
            FindAutocompletePredictionsRequest.builder()
                .setSessionToken(token)
                .setQuery(constraint.toString())
                .build()
        val autocompletePredictions: Task<FindAutocompletePredictionsResponse> =
            placesClient.findAutocompletePredictions(request)

        var thread = Thread {Tasks.await<FindAutocompletePredictionsResponse>(autocompletePredictions, 60, TimeUnit.SECONDS) }

        try {
            thread.start()
        } catch (e: ExecutionException) {
            e.printStackTrace()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } catch (e: TimeoutException) {
            e.printStackTrace()
        }
        return if (autocompletePredictions.isSuccessful()) {
            val findAutocompletePredictionsResponse: FindAutocompletePredictionsResponse =
                autocompletePredictions.getResult()
            if (findAutocompletePredictionsResponse != null) for (prediction in findAutocompletePredictionsResponse.autocompletePredictions) {
                resultList.add(
                    PlaceAutocomplete(
                        prediction.placeId,
                        prediction.getPrimaryText(STYLE_NORMAL).toString(),
                        prediction.getFullText(STYLE_BOLD).toString()
                    )
                )
            }
            resultList
        } else {
            resultList
        }
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull viewGroup: ViewGroup, i: Int): PredictionHolder {
        val layoutInflater =
            mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return PredictionHolder(View(mContext))
    }

    override fun onBindViewHolder(@NonNull mPredictionHolder: PredictionHolder, i: Int) {
        mPredictionHolder.address.text = mResultList!![i].address
        mPredictionHolder.area.text = mResultList!![i].area
    }

    override fun getItemCount(): Int {
        return mResultList!!.size
    }

    fun getItem(position: Int): PlaceAutocomplete {
        return mResultList!![position]
    }

    inner class PredictionHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val address: TextView
        val area: TextView
        private val mRow: LinearLayout
        override fun onClick(v: View) {
            val item = mResultList!![adapterPosition]
            if (v.getId() === R.id.edit) {
                val placeId = item.placeId.toString()
                val placeFields: List<Place.Field> = Arrays.asList(
                    Place.Field.ID,
                    Place.Field.NAME,
                    Place.Field.LAT_LNG,
                    Place.Field.ADDRESS
                )
                val request = FetchPlaceRequest.builder(placeId, placeFields).build()
                placesClient.fetchPlace(request).addOnSuccessListener { response ->
                    val place = response.place
                    clickListener!!.click(place)
                }.addOnFailureListener { exception ->
                    if (exception is ApiException) {
                        Toast.makeText(mContext, exception.message + "", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        init {
            area = itemView.findViewById(R.id.cut)
            address = itemView.findViewById(R.id.paste)
            mRow = itemView.findViewById(R.id.copy)
            itemView.setOnClickListener(this)
        }
    }

    inner class PlaceAutocomplete internal constructor(
        var placeId: CharSequence,
        var area: CharSequence,
        var address: CharSequence
    ) {
        override fun toString(): String {
            return area.toString()
        }
    }

    companion object {
        private const val TAG = "PlacesAutoAdapter"
    }

    init {
        STYLE_BOLD = StyleSpan(Typeface.BOLD)
        STYLE_NORMAL = StyleSpan(Typeface.NORMAL)
        placesClient = Places.createClient(mContext)
    }

    override fun getFilter(): Filter {
        TODO("Not yet implemented")
    }
}