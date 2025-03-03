package com.example.project_management;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler_Signed extends SQLiteOpenHelper {
    // Database constants
    private static final String DB_NAME = "ProjectWave1";
    private static final int DB_VERSION = 1;

    // Table and column constants
    private static final String TABLE_NAME = "signed_document";
    private static final String COL_GROUP_NAME = "group_name";
    private static final String COL_FEEDBACK_ITERATION = "feedback_ite";
    public DBHandler_Signed(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL query to create the book table
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " ("
                + COL_GROUP_NAME + " VARCHAR(50) , "
                + COL_FEEDBACK_ITERATION + " VARCHAR(10) PRIMARY KEY)";

        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop the existing table and recreate it on upgrade
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Method to upload a document to the database
    public void uploadDocument(String groupName, String feedbackIte) {
        SQLiteDatabase db = null;
        try {
            db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            // Populate the values with the document details
            values.put(COL_GROUP_NAME, groupName);
            values.put(COL_FEEDBACK_ITERATION, feedbackIte);

            // Insert the document into the table
            db.insert(TABLE_NAME, null, values);
        } finally {
            // Close the database connection
            if (db != null) {
                db.close();
            }
        }
    }

}

