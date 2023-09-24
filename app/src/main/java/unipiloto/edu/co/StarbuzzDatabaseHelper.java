package unipiloto.edu.co;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class StarbuzzDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "starbuzz";
    private static final int DB_VERSION = 1;

    StarbuzzDatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE DRINK ("
                +"_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                +"NAME TEXT, "
                +"DESCRIPTION TEXT, "
                +"IMAGE_RESOURCE_ID INTEGER);");

        ContentValues drinkValues = new ContentValues();
        drinkValues.put("NAME", "Latte");
        drinkValues.put("DESCRIPTION", "Una taza de cafe expreso con leche al vapor");
        drinkValues.put("IMAGE_RESOURCE_ID", R.drawable.latte);
        sqLiteDatabase.insert("DRINK", null, drinkValues);

        drinkValues = new ContentValues();
        drinkValues.put("NAME", "Cappuccino");
        drinkValues.put("DESCRIPTION", "Espresso, leche caliente y una espuma de leche al vapor");
        drinkValues.put("IMAGE_RESOURCE_ID", R.drawable.cappuccino);
        sqLiteDatabase.insert("DRINK", null, drinkValues);

        drinkValues = new ContentValues();
        drinkValues.put("NAME", "Filter");
        drinkValues.put("DESCRIPTION", "Cafe elaborado con granos de la más alta calidad tostados y elaborados en fresco");
        drinkValues.put("IMAGE_RESOURCE_ID", R.drawable.filter);
        sqLiteDatabase.insert("DRINK", null, drinkValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS DRINK");
        onCreate(sqLiteDatabase);
    }

    public void initData() {
        SQLiteDatabase db = this.getWritableDatabase();
        onUpgrade(db, 1, 1);
    }

    public boolean insertData(Drink drink) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("NAME", drink.getName());
        contentValues.put("DESCRIPTION", drink.getDescription());
        contentValues.put("IMAGE_RESOURCE_ID", drink.getImageResourceId());


        long result = db.insert("DRINK", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from DRINK", null);
        return result;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from DRINK where id="+id+"", null);
        return res;
    }

    public Cursor findDataByName(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from DRINK where NAME= '"+name+"'", null);
        return res;
    }
}
