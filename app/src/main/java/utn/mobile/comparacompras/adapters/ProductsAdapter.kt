package utn.mobile.comparacompras.adapters
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.RecyclerView
import utn.mobile.comparacompras.R
import utn.mobile.comparacompras.core.Product


class ProductsAdapter(private val myDataset: MutableList<Product>) : RecyclerView.Adapter<ProductsAdapter.MyViewHolder>() {

        class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

        override fun onCreateViewHolder(parent: ViewGroup,
                                        viewType: Int): MyViewHolder {
            val view : View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.fragment_product, parent, false)

            return MyViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.view.findViewById<ImageView>(R.id.imageProduct).setImageResource(myDataset[position].image)
            holder.view.findViewById<TextView>(R.id.text_productName).text = myDataset[position].name
            holder.view.findViewById<ImageView>(R.id.imageMarket).setImageResource(myDataset[position].marketImage)
            holder.view.findViewById<TextView>(R.id.text_productPrice).text = myDataset[position].price.toString()

            val product: Product = myDataset[position]
            holder.itemView.setOnClickListener {
                val action = R.id.action_navigation_search_to_productDetailsFragment
                //esto cambiarlo a un id despues
                val id = product.name
                val bundle = Bundle()
                bundle.putString("productId", id)
                holder.itemView.findNavController().navigate(action, bundle)
            }
        }

        override fun getItemCount() = myDataset.size
}