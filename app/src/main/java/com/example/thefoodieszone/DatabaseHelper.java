package com.example.thefoodieszone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "register";
    String TABLE_NAME = "register";
    String COL_1 = "id";
    String COL_2 = "name";
    String COL_3 = "pass";
    String COL_4 = "rpass";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+" " +
                "("+COL_1+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ""+COL_2+" TEXT,"+COL_3+" TEXT,"+COL_4+" TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }


    public boolean insertRecord(String nm,String pass, String rpass)
    {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COL_2,nm);
        cv.put(COL_3,pass);
        cv.put(COL_4,rpass);

        //db.execSQL("Insert into student (ID,NAME,SURNAME) values ("")");

        long result = db.insert(TABLE_NAME,null,cv);

        if(result==-1)
        {
            return  false;
        }
        else
        {
            return true;
        }
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public  Integer deleteRecord(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_NAME,"NAME =?",new String[] {name});
    }

    public  boolean updateData(String name,String surname, String add)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues c = new ContentValues();

        c.put(COL_2,name);
        c.put(COL_3,surname);
        c.put(COL_4,add);

        db.update(TABLE_NAME,c,"NAME =?",new String[] {name});

        return  true;
    }
}
