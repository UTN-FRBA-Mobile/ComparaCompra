package utn.mobile.comparacompras.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import utn.mobile.comparacompras.R
import utn.mobile.comparacompras.core.ProductPerMarket


class ProductsPerMarketAdapter(private val myDataset: MutableList<ProductPerMarket>) : RecyclerView.Adapter<ProductsPerMarketAdapter.MyViewHolder>() {

        class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

        override fun onCreateViewHolder(parent: ViewGroup,
                                        viewType: Int): MyViewHolder {
            val view : View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.fragment_product_per_market_details, parent, false)

            return MyViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.view.findViewById<ImageView>(R.id.imageMarket).setImageResource(myDataset[position].marketImage)
            holder.view.findViewById<TextView>(R.id.text_distance).text = myDataset[position].distance
            holder.view.findViewById<TextView>(R.id.text_productPrice).text = myDataset[position].price.toString()
        }

        override fun getItemCount() = myDataset.size
}