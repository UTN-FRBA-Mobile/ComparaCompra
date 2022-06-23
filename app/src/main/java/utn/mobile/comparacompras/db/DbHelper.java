package utn.mobile.comparacompras.db;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NOMBRE = "carts.db";
    public static final String TABLE_CARTS = "t_carts";
    public static final String TABLE_PRODUCTXCART = "t_products";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PRODUCTXCART + "(" +
                "cartId int NOT NULL," +
                "productId int NOT NULL," +
                "amount int NOT NULL," +
                "    CONSTRAINT PK_Person PRIMARY KEY (cartId,productId))"
        );

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CARTS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_PRODUCTXCART);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_CARTS);
        onCreate(sqLiteDatabase);

    }
}