package utn.mobile.comparacompras.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import utn.mobile.comparacompras.R
import utn.mobile.comparacompras.db.DbCart
import utn.mobile.comparacompras.ui.carts.products.CartProductsFragment

class CartProductsAdapter(private var productList: List<ProductMarketResponse>,
                          private var productMarketList: List<ProductMarketResponse>,
                          private val cartId: Long,
                          private val cartProductsFragment: CartProductsFragment) : RecyclerView.Adapter<CartProductsAdapter.MyViewHolder>()
{
    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    private lateinit var dbCart: DbCart
    private lateinit var customHolder: CartProductsAdapter.MyViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartProductsAdapter.MyViewHolder
    {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_cart_product, parent, false)

        dbCart = DbCart(parent.context)

        customHolder = CartProductsAdapter.MyViewHolder(view)
        return CartProductsAdapter.MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartProductsAdapter.MyViewHolder, position: Int)
    {
        holder.view.findViewById<TextView>(R.id.text_productName).text = productList[position].product.name

        val productImageView: ImageView = holder.view.findViewById(R.id.imageProduct)
        Picasso.get().load(productList[position].product.imageUrl).fit().into(productImageView)

        val product: ProductMarketResponse = productList[position]

        var amount = dbCart.getAmountOfProductFromCart(cartId,product.product.id)
        holder.view.findViewById<EditText>(R.id.ammount).setText(amount.toString())

        productMarketList.forEach {
                p -> p.totalPrice = p.price.toDouble() * amount
        }

        cartProductsFragment.updateSpinner()

        holder.itemView.setOnClickListener {
            val action = R.id.action_cartProductsFragment_to_productDetailsFragment
            val id = product.product.id
            val bundle = Bundle()
            bundle.putString("productId", id.toString())
            holder.itemView.findNavController().navigate(action, bundle)
        }

        holder.itemView.findViewById<ImageButton>(R.id.deleteCartProductButton).setOnClickListener {
            dbCart.deleteProductFromCart(cartId, product.product.id)
            productList = productList.filter { p -> p.product.id != product.product.id }
            productMarketList = productMarketList.filter { p -> p.product.id != product.product.id }
            notifyItemRemoved(position)
        }

        holder.itemView.findViewById<EditText>(R.id.ammount).addTextChangedListener { t ->
            println(t)
            if(t!!.isNotEmpty())
            {
                dbCart.editProductAmountOnCart(cartId, product.product.id, t.toString().toInt());

                //println(productMarketList.map { p -> p.price.toDouble() * t.toString().toInt() })

                productMarketList.forEach {
                    p -> p.totalPrice = p.price.toDouble() * t.toString().toInt()
                }

                cartProductsFragment.updateSpinner()
            }
        }
    }

    override fun getItemCount() = productList.size

    fun getTotals(): MutableList<Pair<String, Double>>
    {
        var totals = mutableListOf<Pair<String, Double>>()

        var products = productMarketList

        products!!.distinctBy { p -> p.imageUrl }.map{ p -> p.imageUrl}.forEach { m ->
            val pair = Pair<String, Double>(m, products.filter { p -> p.imageUrl == m }.sumOf { p -> p.totalPrice.toDouble() })
            totals.add(pair)
        }

        println(totals)

        return totals
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
    }

}
