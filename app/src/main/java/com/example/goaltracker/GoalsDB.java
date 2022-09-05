package com.example.goaltracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GoalsDB {
    public static final String KEY_ROWGN = "_GN";//Goal Name
    public static final String KEY_Category = "_category";
    public static final String KEY_DueDate = "due_date";
    public static final String Key_Importance = "_importance";
    public static final String Key_Description = "_description";

    private final String DATABASE_NAME = "GoalsDB";
    private final String DATABASE_TABLE = "GoalTable";
    private final int DATABASE_VERSION = 1;

    private DBHelper ourHelper;
    private final Context ourContext;
    private SQLiteDatabase ourDatabase;

    public GoalsDB (Context context)
    {
        ourContext = context;
    }
    private class DBHelper extends SQLiteOpenHelper
    {
        public DBHelper (Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
           String sqlCode = "CREATE TABLE " + DATABASE_TABLE + " (" +
                KEY_ROWGN + "TEXT PRIMARY KEY NOT NULL, " +
                   KEY_Category + " TEXT NOT NULL, " +
                   KEY_DueDate + " TEXT NOT NULL, " +
                   Key_Importance + " TEXT NOT NULL, " +
                   Key_Description + " TEXT NOT NULL);";

           db.execSQL(sqlCode);//As soon as we execute this our table will be created
            //On create only runs the first time the database is created

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
            //deletes whole table and creates a new one
        }
    }
    public GoalsDB open() throws SQLException//helps us open database to read/write from it
    {
        ourHelper = new DBHelper(ourContext);//goes to databse name and version if database version diff than that on phone goes to onupgrade
        ourDatabase = ourHelper.getWritableDatabase();
        return this;
    }
    public void close()//closes databse
    {
        ourHelper.close();
    }
    public long createEntry(String GoalName, String Description, String Importance, String Category, String DueDate)
    {
        ContentValues cv = new ContentValues();
        cv.put(KEY_ROWGN, GoalName);
        cv.put(KEY_Category, Category);
        cv.put(Key_Description, Description);

    }


}
