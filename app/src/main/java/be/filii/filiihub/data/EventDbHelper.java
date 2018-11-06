package be.filii.filiihub.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EventDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Events.db";
    public EventDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }



    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + EventContract.EventEntry.TABLE_NAME + " (" +
                    EventContract.EventEntry._ID + " INTEGER PRIMARY KEY," +
                    EventContract.EventEntry.COLUMN_NAME_TITLE + " TEXT," +
                    EventContract.EventEntry.COLUMN_NAME_DESCRIPTION + " TEXT," +
                    EventContract.EventEntry.COLUMN_INTERN + " INTEGER," +
                   EventContract.EventEntry.COLUMN_NAME_DATE + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + EventContract.EventEntry.TABLE_NAME;



}
