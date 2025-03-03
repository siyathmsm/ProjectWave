package com.example.project_management;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DBHandler_AddFeedback extends SQLiteOpenHelper {
    // Database constants
    private static final String DB_NAME = "ProjectWave1";
    private static final int DB_VERSION = 1;

    // Table and column constants
    private static final String TABLE_NAME = "feedbackstbl";
    private static final String COL_FEEDBACK_ITERATION = "feedback_iteration";
    private static final String COL_GROUP_NAME = "group_name";
    private static final String COL_TITLE = "title";
    private static final String COL_TYPE = "type";
    private static final String COL_FEEDBACKS = "feedbacks";

    public DBHandler_AddFeedback(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL query to create the book table
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " ("
                + COL_FEEDBACK_ITERATION + " VARCHAR(5) PRIMARY KEY, "
                + COL_GROUP_NAME + " VARCHAR(30), "
                + COL_TITLE + " VARCHAR(30), "
                + COL_TYPE + " VARCHAR(30), "
                + COL_FEEDBACKS + " VARCHAR(50))";

        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop the existing table and recreate it on upgrade
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Method to add a new stock to the database
    public void addNewFeedback(String feedbackIteration, String groupName, String projectTitle, String docType, String feedBacks) {
        SQLiteDatabase db = null;
        try {
            db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            // Populate the values with the book details
            values.put(COL_FEEDBACK_ITERATION, feedbackIteration);
            values.put(COL_GROUP_NAME, groupName);
            values.put(COL_TITLE, projectTitle);
            values.put(COL_TYPE, docType);
            values.put(COL_FEEDBACKS, feedBacks);

            // Insert the new book into the table
            db.insert(TABLE_NAME, null, values);
        } finally {
            // Close the database connection
            if (db != null) {
                db.close();
            }
        }
    }

    // Method to get a book by its ID
    @SuppressLint("Range")
    public Feed getFeedsByCode(String feedbackIteration) {
        SQLiteDatabase db = null;
        Cursor cursor = null;

        try {
            db = this.getReadableDatabase();

            // Query to find the book by ID
            cursor = db.query(
                    TABLE_NAME, // The table to query
                    null, // Return all columns
                    COL_FEEDBACK_ITERATION + " = ?", // WHERE clause
                    new String[]{feedbackIteration}, // WHERE clause arguments
                    null, // GROUP BY
                    null, // HAVING
                    null // ORDER BY
            );

            // Check if the cursor contains a valid record
            if (cursor != null && cursor.moveToFirst()) {
                // Create a new book object and set its fields
                Feed feed = new Feed();
                feed.setFeedbackIteration(cursor.getString(cursor.getColumnIndex(COL_FEEDBACK_ITERATION)));
                feed.setGroupName(cursor.getString(cursor.getColumnIndex(COL_GROUP_NAME)));
                feed.setProjectTitle(cursor.getString(cursor.getColumnIndex(COL_TITLE)));
                feed.setDocType(cursor.getString(cursor.getColumnIndex(COL_TYPE)));
                feed.setFeedBacks(cursor.getString(cursor.getColumnIndex(COL_FEEDBACKS)));

                return feed;
            }

            return null;
        } finally {
            // Ensure resources are closed properly
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        }
    }

    public void deleteFeedback() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.close();
    }

    @SuppressLint("Range")
    public List<Feed> getAllFeedbacks() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Feed> feedList = new ArrayList<>();
        Cursor cursor = null;

        try {
            // Query to fetch all books
            cursor = db.query(
                    TABLE_NAME, // The table to query
                    null, // Return all columns
                    null, // No WHERE clause
                    null, // No WHERE arguments
                    null, // No GROUP BY
                    null, // No HAVING
                    null // No ORDER BY
            );

            // Loop through each row in the result set
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    Feed feed = new Feed();
                    feed.setFeedbackIteration(cursor.getString(cursor.getColumnIndex(COL_FEEDBACK_ITERATION)));
                    feed.setGroupName(cursor.getString(cursor.getColumnIndex(COL_GROUP_NAME)));
                    feed.setProjectTitle(cursor.getString(cursor.getColumnIndex(COL_TITLE)));
                    feed.setDocType(cursor.getString(cursor.getColumnIndex(COL_TYPE)));
                    feed.setFeedBacks(cursor.getString(cursor.getColumnIndex(COL_FEEDBACKS)));
                    feedList.add(feed);
                } while (cursor.moveToNext());
            }

            return feedList;
        } finally {
            // Close cursor and database
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
    }

}

