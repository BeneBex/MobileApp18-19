package be.filii.filiihub.data;

import android.provider.BaseColumns;

import java.util.Date;

public final class EventContract {
    private EventContract() {}

    /*Inner class that defines table contents*/
    public static class EventEntry implements BaseColumns {
        public static final String TABLE_NAME = "events";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_INTERN = "intern";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_DATE = "date";
    }

    /**
     * Possible values for the intern
     */
    public static final int INTERN_EVENT = 0;
    public static final int EXTERN_EVENT = 1;

}
