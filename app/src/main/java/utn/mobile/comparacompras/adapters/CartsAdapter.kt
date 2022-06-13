package utn.mobile.comparacompras.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import utn.mobile.comparacompras.R


class CartsAdapter(private val cartList: List<CartResponse>) : RecyclerView.Adapter<CartsAdapter.MyViewHolder>()
{
        class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
        {
            val view : View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item_cart, parent, false)

            return MyViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int)
        {
            val cart: CartResponse = cartList[position]
            holder.view.findViewById<TextView>(R.id.text_cartName).text = cart.name
            holder.view.findViewById<ImageButton>(R.id.menuButton).setOnClickListener {
                //TODO: Abrir menú del carrito con las opciones "Borrar", "Editar", "Renombrar"
            }
        }

        override fun getItemCount() = cartList.size
}