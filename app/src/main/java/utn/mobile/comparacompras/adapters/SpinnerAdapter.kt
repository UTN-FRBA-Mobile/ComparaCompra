package utn.mobile.comparacompras.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import utn.mobile.comparacompras.R

class SpinnerAdapter(val mContext: Context, val mTotals: List<Pair<String, Double>>)
            : ArrayAdapter<Pair<String, Double>>(mContext, 0, mTotals)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View
    {
        var dropdownItemView = convertView

        if (dropdownItemView == null)
            dropdownItemView = LayoutInflater.from(mContext)
                .inflate(R.layout.custom_spinner_item, parent,false)

        val total = mTotals[position]

        val marketImage: ImageView = dropdownItemView!!.findViewById(R.id.spinnerImage)
        Picasso.get().load(total.first).fit().into(marketImage)

        val totalPrice: TextView = dropdownItemView.findViewById(R.id.spinnerTotal)
        ("$ " + total.second.toString()).also { totalPrice.text = it }

        return dropdownItemView
    }

    override fun getCount(): Int
    {
        return mTotals.count()
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View
    {
        var dropdownItemView = convertView

        if (dropdownItemView == null)
            dropdownItemView = LayoutInflater.from(mContext)
                .inflate(R.layout.custom_spinner_item, parent,false)

        val total = mTotals[position]

        val marketImage: ImageView = dropdownItemView!!.findViewById(R.id.spinnerImage)
        Picasso.get().load(total.first).fit().into(marketImage)

        val totalPrice: TextView = dropdownItemView.findViewById(R.id.spinnerTotal)
        ("$ " + total.second.toString()).also { totalPrice.text = it }

        return dropdownItemView
    }

    override fun getItem(position: Int): Pair<String, Double>?
    {
        return mTotals[position]
    }
}