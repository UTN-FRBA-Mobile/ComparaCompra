package utn.mobile.comparacompras.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import utn.mobile.comparacompras.R
import kotlin.random.Random


class ProductsPerMarketAdapter(private val myDataset: List<ProductMarketResponse>) : RecyclerView.Adapter<ProductsPerMarketAdapter.MyViewHolder>() {

        class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

        override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): MyViewHolder
        {
            val view : View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_product_per_market_details, parent, false)

            return MyViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int)
        {
            val productImageView: ImageView = holder.view.findViewById(R.id.imageMarket)
            Picasso.get().load(myDataset[position].imageUrl).fit().into(productImageView)

            holder.view.findViewById<TextView>(R.id.text_distance).text = "${Random(100).nextInt(5, 100)} mts"
            holder.view.findViewById<TextView>(R.id.text_productPrice).text = "$${myDataset[position].price}"
        }

        override fun getItemCount() = myDataset.size
}