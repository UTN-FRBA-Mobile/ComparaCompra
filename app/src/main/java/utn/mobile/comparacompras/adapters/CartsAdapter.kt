package utn.mobile.comparacompras.adapters
import android.app.AlertDialog
import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import utn.mobile.comparacompras.R
import utn.mobile.comparacompras.db.DbCart
import utn.mobile.comparacompras.domain.Cart
import java.lang.Exception


class CartsAdapter(private var cartList: List<Cart>) : RecyclerView.Adapter<CartsAdapter.MyViewHolder>()
{
        private lateinit var mCtx: Context
        private lateinit var mResources: Resources
        private lateinit var dbCart: DbCart
        class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
        {
            dbCart = DbCart(parent.context)
            mCtx = parent.context
            mResources = parent.resources
            val view : View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item_cart, parent, false)

            return MyViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int)
        {
            val cart: Cart = cartList[position]
            holder.view.findViewById<TextView>(R.id.text_cartName).text = cart.name
            val imageButton = holder.view.findViewById<ImageButton>(R.id.menuButton)
            val dropDownMenu = createCartDropdownMenu(imageButton, cart, position, holder)

            holder.view.findViewById<ImageButton>(R.id.menuButton).setOnClickListener {
                dropDownMenu.show();
            }

            holder.itemView.setOnClickListener {

                val action = R.id.action_navigation_carts_to_cartProductsFragment
                val productList = cartList[position].productList.map { p -> p.id.toInt() }.toIntArray()
                val bundle = Bundle()
                bundle.putIntArray("productList", productList)
                bundle.putString("cartName", cart.name)
                bundle.putLong("cartId", cart.id)

                holder.itemView.findNavController().navigate(action, bundle)
            }
        }

    private fun createCartDropdownMenu(imageButton: ImageButton, cart: Cart, position: Int, holder: MyViewHolder): PopupMenu {
        val dropDownMenu = PopupMenu(mCtx, imageButton);
        val menu : Menu = dropDownMenu.menu;
        menu.add(0, 0, 0, mResources.getString(R.string.menu_item_borrar));
        menu.add(0, 1, 0, mResources.getString(R.string.menu_item_editar));
        menu.add(0, 2, 0, mResources.getString(R.string.menu_item_renombrar));
        val b: AlertDialog.Builder = AlertDialog.Builder(mCtx)
        dropDownMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                0 ->
                {
                    b.setTitle(mResources.getString(R.string.confirmacion_borrar_carrito))
                        .setPositiveButton(
                            mResources.getString(R.string.aceptar)
                        ) { dialog, id ->
                            print(dialog)
                            print(id)
                            dbCart.deleteCart(cart.id)
                            cartList = cartList.filter { c -> c.id != cart.id }
                            notifyItemRemoved(position)
                        }
                        .setNegativeButton(mResources.getString(R.string.cancelar), null)

                    b.create().show()
                }
                1 ->
                {
                    val sp = Spinner(mCtx)

                    b.setTitle(mResources.getString(R.string.title_editar_carrito))

                        .setPositiveButton(
                            mResources.getString(R.string.aceptar)
                        ) { dialog, id ->
                            print(dialog)
                            print(id)

                        }
                        .setNegativeButton(mResources.getString(R.string.cancelar), null)

                    b.setView(sp)
                    b.create().show()
                }
                2 -> {

                    val edittext =  EditText(mCtx);
                    b.setTitle(mResources.getString(R.string.title_renombrar_carrito))
                        .setView(edittext)
                        .setPositiveButton(
                            mResources.getString(R.string.aceptar)
                        ) { dialog, id ->
                            print(dialog)
                            print(id)
                            val cartName = edittext.text.toString()
                            dbCart.editCartName(cart.id, cartName)
                            cartList[position].name = cartName
                            holder.view.findViewById<TextView>(R.id.text_cartName).text = cartName
                        }
                        .setNegativeButton(mResources.getString(R.string.cancelar), null)


                    b.create().show()
                }
            }
            false
        }
        return dropDownMenu
    }

    override fun getItemCount() = cartList.size
}