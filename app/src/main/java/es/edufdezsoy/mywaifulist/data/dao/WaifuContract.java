package es.edufdezsoy.mywaifulist.data.dao;

import android.provider.BaseColumns;

/**
 * This class will only contain constants to define the database, tables, columns and the test data
 */
public final class WaifuContract {

    public static final String DATABASE_NAME = "MyWaifuList.db";
    public static final int DATABASE_VERSION = 1;

    public static final class WaifuEntry implements BaseColumns {
        public static final String TABLE_NAME = "waifu";

        public static final String SQL_DELETE_ENTRIES = "CREATE TABLE " + TABLE_NAME +
                " (" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT)";
        public static final String SQL_CREATE_ENTRIES = "";
    }
}
