package utn.mobile.comparacompras.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utn.mobile.comparacompras.domain.Cart;
import utn.mobile.comparacompras.domain.Product;

public class DbCart extends DbHelper {

    Context context;
    public DbCart(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public long insertCart(Cart cart) {

        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("name", cart.getName());

            id = db.insert(TABLE_CARTS, null, values);

            if (!cart.getProductList().isEmpty()) {
                values = new ContentValues();

                for (Product p : cart.getProductList()) {
                    values.put("productId", p.getId());
                    values.put("cartId", cart.getId());
                }

                id = db.insert(TABLE_PRODUCTXCART, null, values);
            }

        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }


    public ArrayList<Cart> getCarts() {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Cart> cartList = new ArrayList<>();
        Cart cart;
        Cursor cartCursor;


        cartCursor = db.rawQuery("SELECT * FROM " + TABLE_CARTS , null);

        if (cartCursor.moveToFirst()) {
            do {
                cart = new Cart();
                cart.setId(cartCursor.getInt(0));
                cart.setName(cartCursor.getString(1));
                cart.setProductList(new ArrayList<>());
                Cursor productCursor = db.rawQuery("SELECT * FROM " + TABLE_PRODUCTXCART + " WHERE cartId = " +cart.getId(), null);
                if (productCursor.moveToFirst()) {
                    do {
                        Product product = new Product();
                        product.setId(productCursor.getInt(1));
                        cart.addProduct(product);
                    } while (productCursor.moveToNext());
                }
                productCursor.close();
                cartList.add(cart);
            } while (cartCursor.moveToNext());
        }

        cartCursor.close();

        return cartList;
    }

    public Cart getCart(int id) {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();


        Cart cart = null;
        Cursor cartCursor;


        cartCursor = db.rawQuery("SELECT * FROM " + TABLE_CARTS + " WHERE id = " + id + " LIMIT 1" , null);

        if (cartCursor.moveToFirst()) {
            cart = new Cart();
            cart.setId(cartCursor.getInt(0));
            cart.setName(cartCursor.getString(1));
            Cursor productCursor = db.rawQuery("SELECT * FROM " + TABLE_PRODUCTXCART + " WHERE cartId = " +cart.getId(), null);
            if (productCursor.moveToFirst()) {
                do {
                    Product product = new Product();
                    product.setId(productCursor.getInt(1));
                    cart.getProductList().add(product);
                } while (productCursor.moveToNext());
            }
            productCursor.close();
        }

        cartCursor.close();

        return cart;
    }

    public void addProductToCart(long cartId, long productId){
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("cartId", cartId);
            values.put("productId", productId);

            db.insert(TABLE_PRODUCTXCART, null, values);


        } catch (Exception ex) {
            ex.toString();
        }
    }

    public boolean  deleteProductFromCart(Long cartId, Long productId){
        boolean correct;
        DbHelper dbHelper = new DbHelper(context);

        try (SQLiteDatabase db = dbHelper.getWritableDatabase()) {
            db.execSQL("DELETE FROM " + TABLE_PRODUCTXCART + " WHERE cartId = " + cartId + " AND productId = " + productId);
            correct = true;
        } catch (Exception ex) {
            ex.toString();
            correct = false;
        }
        return correct;
    }

    public boolean editCartName(int id, String name) {

        boolean correct;

        DbHelper dbHelper = new DbHelper(context);

        try (SQLiteDatabase db = dbHelper.getWritableDatabase()) {
            db.execSQL("UPDATE " + TABLE_CARTS + " SET name = '" + name + "' WHERE id='" + id);
            correct = true;
        } catch (Exception ex) {
            ex.toString();
            correct = false;
        }

        return correct;
    }

    public boolean deleteCart(int id) {

        boolean correct;

        DbHelper dbHelper = new DbHelper(context);

        try (SQLiteDatabase db = dbHelper.getWritableDatabase()) {
            db.execSQL("DELETE FROM " + TABLE_PRODUCTXCART + " WHERE cartId = '" + id + "'");
            db.execSQL("DELETE FROM " + TABLE_CARTS + " WHERE id = '" + id + "'");
            correct = true;
        } catch (Exception ex) {
            ex.toString();
            correct = false;
        }

        return correct;
    }


}
