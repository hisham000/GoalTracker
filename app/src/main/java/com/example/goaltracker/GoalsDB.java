package com.example.goaltracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GoalsDB {
    public static final String KEY_ROWGN = "_GN";//Goal Name
    public static final String KEY_Category = "_category";
    public static final String KEY_DueDate = "due_date";
    public static final String KEY_Importance = "_importance";
    public static final String KEY_Description = "_description";

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
                   KEY_Importance + " TEXT NOT NULL, " +
                   KEY_Description + " TEXT NOT NULL);";

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
        cv.put(KEY_Description, Description);
        cv.put(KEY_Importance, Importance);
        cv.put(KEY_DueDate, DueDate);
        return ourDatabase.insert(DATABASE_TABLE, null, cv);

    }
    public String getData()
    {
        String [] columns = new String[] {KEY_ROWGN, KEY_Description, KEY_DueDate, KEY_Category, KEY_Importance};
        Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null,null,null,null);
        String result = "";

        int iRowGN = c.getColumnIndex(KEY_ROWGN);
        int iDescription = c.getColumnIndex(KEY_Description);
        int iImportance = c.getColumnIndex(KEY_Importance);
        int iCategory = c.getColumnIndex(KEY_Category);
        int iDueDate = c.getColumnIndex(KEY_DueDate);

        for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
            result = result + c.getString(iRowGN) + ": " + c.getString(iDescription) + " "+
                    c.getString(iImportance) + " " + c.getString(iCategory) + " " + c.getString(iDueDate);
        }
        c.close();
        return result;
    }
    public long deleteEntry(String rowGN)
    {
        return ourDatabase.delete(DATABASE_TABLE, KEY_ROWGN + "=?",new String[]{rowGN});

    }
    public long updateEntry(String rowGN, String Description, String Importance, String Category, String DueDate)
    {
        ContentValues cv = new ContentValues();
        cv.put(KEY_ROWGN, rowGN);
        cv.put(KEY_Description, Description);
        cv.put(KEY_Category, Category);
        cv.put(KEY_DueDate, DueDate);
        cv.put(KEY_Importance, Importance);

        return ourDatabase.update(DATABASE_TABLE, cv, KEY_ROWGN + "=?",new String[]{rowGN});
    }
}
