package utn.mobile.comparacompras.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import utn.mobile.comparacompras.R

class CartProductsAdapter(private val productList: List<ProductMarketResponse>) : RecyclerView.Adapter<CartProductsAdapter.MyViewHolder>()
{
    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartProductsAdapter.MyViewHolder
    {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_cart_product, parent, false)

        return CartProductsAdapter.MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartProductsAdapter.MyViewHolder, position: Int)
    {
        holder.view.findViewById<TextView>(R.id.text_productName).text = productList[position].product.name

        val productImageView: ImageView = holder.view.findViewById(R.id.imageProduct)
        Picasso.get().load(productList[position].product.imageUrl).fit().into(productImageView)

        val product: ProductMarketResponse = productList[position]

        holder.itemView.setOnClickListener {
            val action = R.id.action_cartProductsFragment_to_productDetailsFragment
            val id = product.product.id
            val bundle = Bundle()
            bundle.putString("productId", id.toString())
            holder.itemView.findNavController().navigate(action, bundle)
        }
    }

    override fun getItemCount() = productList.size

}