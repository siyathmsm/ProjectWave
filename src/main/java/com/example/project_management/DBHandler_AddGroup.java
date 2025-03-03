package com.example.project_management;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DBHandler_AddGroup extends SQLiteOpenHelper {
    // Database constants
    private static final String DB_NAME = "ProjectWave";
    private static final int DB_VERSION = 1;

    // Table and column constants
    private static final String TABLE_NAME = "groups";
    private static final String COL_GROUP_NAME = "group_name";
    private static final String COL_TITLE = "title";
    private static final String COL_MEMBER_NAME_1 = "member_name1";
    private static final String COL_INDEX_NO_1 = "index_no1";
    private static final String COL_REG_NO_1 = "reg_no1";
    private static final String COL_MEMBER_NAME_2 = "member_name2";
    private static final String COL_INDEX_NO_2 = "index_no2";
    private static final String COL_REG_NO_2 = "reg_no2";
    private static final String COL_MEMBER_NAME_3 = "member_name3";
    private static final String COL_INDEX_NO_3 = "index_no3";
    private static final String COL_REG_NO_3 = "reg_no3";
    private static final String COL_MEMBER_NAME_4 = "member_name4";
    private static final String COL_INDEX_NO_4 = "index_no4";
    private static final String COL_REG_NO_4 = "reg_no4";
    private static final String COL_MEMBER_NAME_5 = "member_name5";
    private static final String COL_INDEX_NO_5 = "index_no5";
    private static final String COL_REG_NO_5 = "reg_no5";

    public DBHandler_AddGroup(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL query to create the book table
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " ("
                + COL_GROUP_NAME + " VARCHAR(20) PRIMARY KEY, "
                + COL_TITLE + " VARCHAR(30), "
                + COL_MEMBER_NAME_1 + " VARCHAR(30), "
                + COL_INDEX_NO_1 + " VARCHAR(10), "
                + COL_REG_NO_1 + " VARCHAR(10), "
                + COL_MEMBER_NAME_2 + " VARCHAR(30), "
                + COL_INDEX_NO_2 + " VARCHAR(10), "
                + COL_REG_NO_2 + " VARCHAR(10), "
                + COL_MEMBER_NAME_3 + " VARCHAR(30), "
                + COL_INDEX_NO_3 + " VARCHAR(10), "
                + COL_REG_NO_3 + " VARCHAR(10), "
                + COL_MEMBER_NAME_4 + " VARCHAR(30), "
                + COL_INDEX_NO_4 + " VARCHAR(10), "
                + COL_REG_NO_4 + " VARCHAR(10), "
                + COL_MEMBER_NAME_5 + " VARCHAR(30), "
                + COL_INDEX_NO_5 + " VARCHAR(10), "
                + COL_REG_NO_5 + " VARCHAR(10))";

        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop the existing table and recreate it on upgrade
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Method to add a new stock to the database
    public void addNewGroup(String groupName, String title, String membName1, String indexNo1, String regNo1, String membName2, String indexNo2, String regNo2, String membName3, String indexNo3, String regNo3, String membName4, String indexNo4, String regNo4, String membName5, String indexNo5, String regNo5) {
        SQLiteDatabase db = null;
        try {
            db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            // Populate the values with the book details
            values.put(COL_GROUP_NAME, groupName);
            values.put(COL_TITLE, title);
            values.put(COL_MEMBER_NAME_1, membName1);
            values.put(COL_INDEX_NO_1, indexNo1);
            values.put(COL_REG_NO_1, regNo1);
            values.put(COL_MEMBER_NAME_2, membName2);
            values.put(COL_INDEX_NO_2, indexNo2);
            values.put(COL_REG_NO_2, regNo2);
            values.put(COL_MEMBER_NAME_3, membName3);
            values.put(COL_INDEX_NO_3, indexNo3);
            values.put(COL_REG_NO_3, regNo3);
            values.put(COL_MEMBER_NAME_4, membName4);
            values.put(COL_INDEX_NO_4, indexNo4);
            values.put(COL_REG_NO_4, regNo4);
            values.put(COL_MEMBER_NAME_5, membName5);
            values.put(COL_INDEX_NO_5, indexNo5);
            values.put(COL_REG_NO_5, regNo5);

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
    public Grp getGroupsByName(String groupName) {
        SQLiteDatabase db = null;
        Cursor cursor = null;

        try {
            db = this.getReadableDatabase();

            // Query to find the book by ID
            cursor = db.query(
                    TABLE_NAME, // The table to query
                    null, // Return all columns
                    COL_GROUP_NAME + " = ?", // WHERE clause
                    new String[]{groupName}, // WHERE clause arguments
                    null, // GROUP BY
                    null, // HAVING
                    null // ORDER BY
            );

            // Check if the cursor contains a valid record
            if (cursor != null && cursor.moveToFirst()) {
                // Create a new book object and set its fields
                Grp grp = new Grp();
                grp.setGroupName(cursor.getString(cursor.getColumnIndex(COL_GROUP_NAME)));
                grp.setProjectTitle(cursor.getString(cursor.getColumnIndex(COL_TITLE)));
                grp.setMemberName1(cursor.getString(cursor.getColumnIndex(COL_MEMBER_NAME_1)));
                grp.setIndexNo1(cursor.getString(cursor.getColumnIndex(COL_INDEX_NO_1)));
                grp.setRegNo1(cursor.getString(cursor.getColumnIndex(COL_REG_NO_1)));
                grp.setMemberName2(cursor.getString(cursor.getColumnIndex(COL_MEMBER_NAME_2)));
                grp.setIndexNo2(cursor.getString(cursor.getColumnIndex(COL_INDEX_NO_2)));
                grp.setRegNo2(cursor.getString(cursor.getColumnIndex(COL_REG_NO_2)));
                grp.setMemberName3(cursor.getString(cursor.getColumnIndex(COL_MEMBER_NAME_3)));
                grp.setIndexNo3(cursor.getString(cursor.getColumnIndex(COL_INDEX_NO_3)));
                grp.setRegNo3(cursor.getString(cursor.getColumnIndex(COL_REG_NO_3)));
                grp.setMemberName4(cursor.getString(cursor.getColumnIndex(COL_MEMBER_NAME_4)));
                grp.setIndexNo4(cursor.getString(cursor.getColumnIndex(COL_INDEX_NO_4)));
                grp.setRegNo4(cursor.getString(cursor.getColumnIndex(COL_REG_NO_4)));
                grp.setMemberName5(cursor.getString(cursor.getColumnIndex(COL_MEMBER_NAME_5)));
                grp.setIndexNo5(cursor.getString(cursor.getColumnIndex(COL_INDEX_NO_5)));
                grp.setRegNo5(cursor.getString(cursor.getColumnIndex(COL_REG_NO_5)));

                return grp;
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

    public void updateGroup(Grp grp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_GROUP_NAME, grp.getGroupName());
        values.put(COL_TITLE, grp.getProjectTitle());
        values.put(COL_MEMBER_NAME_1, grp.getMemberName1());
        values.put(COL_INDEX_NO_1, grp.getIndexNo1());
        values.put(COL_REG_NO_1, grp.getRegNo1());
        values.put(COL_MEMBER_NAME_2, grp.getMemberName2());
        values.put(COL_INDEX_NO_2, grp.getIndexNo2());
        values.put(COL_REG_NO_2, grp.getRegNo2());
        values.put(COL_MEMBER_NAME_3, grp.getMemberName3());
        values.put(COL_INDEX_NO_3, grp.getIndexNo3());
        values.put(COL_REG_NO_3, grp.getRegNo3());
        values.put(COL_MEMBER_NAME_4, grp.getMemberName4());
        values.put(COL_INDEX_NO_4, grp.getIndexNo4());
        values.put(COL_REG_NO_4, grp.getRegNo4());
        values.put(COL_MEMBER_NAME_5, grp.getMemberName5());
        values.put(COL_INDEX_NO_5, grp.getIndexNo5());
        values.put(COL_REG_NO_5, grp.getRegNo5());

        db.update(TABLE_NAME, values, COL_GROUP_NAME + " = ?", new String[]{grp.getGroupName()});
        db.close();
    }

    public void deleteGroup(String groupName) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COL_GROUP_NAME + " = ?", new String[]{groupName});
        db.close();
    }

    @SuppressLint("Range")
    public List<Grp> getAllGroups() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Grp> groupList = new ArrayList<>();
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
                    Grp grp = new Grp();
                    grp.setGroupName(cursor.getString(cursor.getColumnIndex(COL_GROUP_NAME)));
                    grp.setProjectTitle(cursor.getString(cursor.getColumnIndex(COL_TITLE)));
                    grp.setMemberName1(cursor.getString(cursor.getColumnIndex(COL_MEMBER_NAME_1)));
                    grp.setIndexNo1(cursor.getString(cursor.getColumnIndex(COL_INDEX_NO_1)));
                    grp.setRegNo1(cursor.getString(cursor.getColumnIndex(COL_REG_NO_1)));
                    grp.setMemberName2(cursor.getString(cursor.getColumnIndex(COL_MEMBER_NAME_2)));
                    grp.setIndexNo2(cursor.getString(cursor.getColumnIndex(COL_INDEX_NO_2)));
                    grp.setRegNo2(cursor.getString(cursor.getColumnIndex(COL_REG_NO_2)));
                    grp.setMemberName3(cursor.getString(cursor.getColumnIndex(COL_MEMBER_NAME_3)));
                    grp.setIndexNo3(cursor.getString(cursor.getColumnIndex(COL_INDEX_NO_3)));
                    grp.setRegNo3(cursor.getString(cursor.getColumnIndex(COL_REG_NO_3)));
                    grp.setMemberName4(cursor.getString(cursor.getColumnIndex(COL_MEMBER_NAME_4)));
                    grp.setIndexNo4(cursor.getString(cursor.getColumnIndex(COL_INDEX_NO_4)));
                    grp.setRegNo4(cursor.getString(cursor.getColumnIndex(COL_REG_NO_4)));
                    grp.setMemberName5(cursor.getString(cursor.getColumnIndex(COL_MEMBER_NAME_5)));
                    grp.setIndexNo5(cursor.getString(cursor.getColumnIndex(COL_INDEX_NO_5)));
                    grp.setRegNo5(cursor.getString(cursor.getColumnIndex(COL_REG_NO_5)));
                    groupList.add(grp);
                } while (cursor.moveToNext());
            }

            return groupList;
        } finally {
            // Close cursor and database
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
    }

}

