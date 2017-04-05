package test.jakkit.restaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by KHAMMA on 04/06/2017.
 */

public class OrderTABLE {
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeDatabase, readDatabase;

    public static final String TABLE_ORDER = "orderTABLE";
    public static final String COLUMN_ID_ORDER = "_id";
    public static final String COLUMN_FOOD = "Food";
    public static final String COLUMN_PRICE = "Price";
    public static final String COLUMN_VOLUME = "Volume";

    public OrderTABLE(Context context) {
        objMyOpenHelper = new MyOpenHelper(context);
        writeDatabase = objMyOpenHelper.getWritableDatabase();
        readDatabase = objMyOpenHelper.getReadableDatabase();
    }
    public long addValueToOrder(String strNumFood, String strFood, String strPrice, String strVolume) {
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_ID_ORDER, strNumFood);
        objContentValues.put(COLUMN_FOOD, strFood);
        objContentValues.put(COLUMN_PRICE, strPrice);
        objContentValues.put(COLUMN_VOLUME, strVolume);
        return writeDatabase.insert(TABLE_ORDER, null, objContentValues);
    }
}
