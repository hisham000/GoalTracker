package com.example.goaltracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class GoalsDB {
    public static final String KEY_ROWID = "_ID";
    public static final String KEY_ROWGN = "_GN";//Goal Name
    public static final String KEY_Category = "_category";
    public static final String KEY_DueDate = "due_date";
    public static final String KEY_Importance = "_importance";
    public static final String KEY_Description = "_description";
    public static final String KEY_ProgressPercentage = "progress_percentage";

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
                   KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                   KEY_ROWGN + " TEXT NOT NULL, " +
                   KEY_Category + " TEXT NOT NULL, " +
                   KEY_DueDate + " TEXT NOT NULL, " +
                   KEY_Importance + " TEXT NOT NULL, " +
                   KEY_ProgressPercentage + " TEXT NOT NULL, " +
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
        ourHelper = new DBHelper(ourContext);//goes to database name and version if database version diff than that on phone goes to ON upgrade
        ourDatabase = ourHelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        ourHelper.close();
    }
    public long createEntry(String GoalName, String Description, String Importance, String Category, String DueDate, String ProgressPercentage)
    {
        ContentValues cv = new ContentValues();
        cv.put(KEY_ROWGN, GoalName);
        cv.put(KEY_Category, Category);
        cv.put(KEY_Description, Description);
        cv.put(KEY_Importance, Importance);
        cv.put(KEY_DueDate, DueDate);
        cv.put(KEY_ProgressPercentage, ProgressPercentage);
        return ourDatabase.insert(DATABASE_TABLE, null, cv);

    }

    public ArrayList getNameList() {
        String[] columns = new String[]{KEY_ROWGN};//specify which columns to retrieve
        Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);//create a cursor to start at a certain position
        ArrayList<String> result = new ArrayList<String>();

        //Getting the index for every column:
        int iRowGN = c.getColumnIndex(KEY_ROWGN);

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            result.add(c.getString(iRowGN));
        }
        c.close();
        return result;
    }

        public ArrayList getDiscList()
        {
            String [] columns = new String[] {KEY_Description};//specify which columns to retrieve
            Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null,null,null,null);//create a cursor to start at a certain position
            ArrayList<String> result = new ArrayList<String>();

            //Getting the index for every column:
            int iDescription = c.getColumnIndex(KEY_Description);

            for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
                result.add(c.getString(iDescription));
            }
            c.close();
            return result;
    }
        public ArrayList<String> getImportanceList()
        {
            String[] columns = new String[]{KEY_Importance};//specify which columns to retrieve
            Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);//create a cursor to start at a certain position
            ArrayList<String> result = new ArrayList<String>();

            //Getting the index for every column:
            int iImportance = c.getColumnIndex(KEY_Importance);

            for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
                result.add(c.getString(iImportance));
            }
            c.close();
            return result;
        }
    public ArrayList<String> getCategoryList()
    {
        String[] columns = new String[]{KEY_Category};//specify which columns to retrieve
        Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);//create a cursor to start at a certain position
        ArrayList<String> result = new ArrayList<String>();

        //Getting the index for every column:
        int iCategory = c.getColumnIndex(KEY_Category);

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            result.add(c.getString(iCategory));
        }
        c.close();
        return result;
    }
    public ArrayList<String> getDueDateList()
    {
        String[] columns = new String[]{KEY_DueDate};//specify which columns to retrieve
        Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);//create a cursor to start at a certain position
        ArrayList<String> result = new ArrayList<String>();

        //Getting the index for every column:
        int iDueDate = c.getColumnIndex(KEY_DueDate);

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            result.add(c.getString(iDueDate));
        }
        c.close();
        return result;
    }
    public ArrayList<String> getPpList()//progress percentage
    {
        String[] columns = new String[]{KEY_ProgressPercentage};//specify which columns to retrieve
        Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);//create a cursor to start at a certain position
        ArrayList<String> result = new ArrayList<String>();

        //Getting the index for every column:
        int iProgessPercentage = c.getColumnIndex(KEY_ProgressPercentage);

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            result.add(c.getString(iProgessPercentage));
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
