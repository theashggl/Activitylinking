package com.theashggl.activitylinking;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class databases extends SQLiteOpenHelper {
    public static final String data="student.db";
    public static final String TABLE_NAME="Student_TABLE";
    public static final String COL_1="Fname";
    public static final String COL_2="sname";
    public static final String COL_3="Fathers_name";
    public static final String COL_4="Roll";
    public databases(Context context) {
        super(context, data,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase dbAAA) {
        dbAAA.execSQL("create table " + TABLE_NAME +" (Fname TEXT,sname TEXT,Fathers_name TEXT,Roll INTEGER PRIMARY KEY)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }
    public long insertdata(String first,String second,String fathers,Integer roll)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentv=new ContentValues();
        contentv.put(COL_1,first);
        contentv.put(COL_2,second);
        contentv.put(COL_3,fathers);
        contentv.put(COL_4,roll);
        long result=db.insert(TABLE_NAME,null,contentv);
        return result;
    }

    public boolean update(String first,String second,String fathers,String roll)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentv=new ContentValues();
        contentv.put(COL_1,first);
        contentv.put(COL_2,second);
        contentv.put(COL_3,fathers);
        contentv.put(COL_4,roll);
        db.update(TABLE_NAME,contentv,"roll = ?",new String[] { roll });
        return true;
    }
}
