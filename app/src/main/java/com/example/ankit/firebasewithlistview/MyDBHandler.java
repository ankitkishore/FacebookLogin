/*
package com.example.ankit.firebasewithlistview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

*/
/**
 * Created by ankit on 12/20/2017.
 *//*


public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "vocabulary.db";
    public static final String TABLE_PRODUCTS = "vocabula";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_WORD = "word";
    public static final String COLUMN_MEANING = "meaning";

    //We need to pass database information along to superclass
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+ TABLE_PRODUCTS + "( "+ COLUMN_ID +" INTEGER PRIMARY KEY, "+COLUMN_WORD+"TEXT, "+ COLUMN_MEANING +"course TEXT)";
        */
/*String query = "CREATE TABLE " + TABLE_PRODUCTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_WORD + " TEXT, " + COLUMN_MEANING + " TEXT " +
                ");";
        *//*
db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }

    //Add a new row to the database
    public void addWord(Vocabulary vocabulary){
        ContentValues values = new ContentValues();
        values.put(COLUMN_WORD, vocabulary.getWord());
        values.put(COLUMN_MEANING, vocabulary.getMeaning());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS, null, values);
        db.close();
    }

    public ArrayList<Vocabulary> databaseToList(){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE 1";
        Vocabulary db_voc = new Vocabulary();
        ArrayList<Vocabulary> vocabulary = new ArrayList<>();
        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("word")) != null) {
                db_voc.setWord(c.getString(c.getColumnIndex("word")));
                db_voc.setMeaning(c.getString(c.getColumnIndex("meaning")));
                vocabulary.add(db_voc);
            }
            c.moveToNext();
        }
        db.close();
        return vocabulary;
    }
}
*/
