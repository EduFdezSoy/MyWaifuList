package es.edufdezsoy.mywaifulist.data.dao;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import es.edufdezsoy.mywaifulist.WaifuApplication;

public class WaifuOpenHelper extends SQLiteOpenHelper {
    private static WaifuOpenHelper waifuOpenHelper;
    private static SQLiteDatabase sqLiteDatabase;

    private WaifuOpenHelper() {
        super(WaifuApplication.getContext(), WaifuContract.DATABASE_NAME, null, WaifuContract.DATABASE_VERSION);
    }

    public static WaifuOpenHelper getInstance() {
        if (waifuOpenHelper == null)
            waifuOpenHelper = new WaifuOpenHelper();

        return waifuOpenHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.beginTransaction();
        try {
            db.execSQL(WaifuContract.WaifuEntry.SQL_CREATE_ENTRIES);
            db.setTransactionSuccessful();
        } catch (SQLException e) {

        } finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.beginTransaction();
        try {
            db.execSQL(WaifuContract.WaifuEntry.SQL_DELETE_ENTRIES);
            onCreate(db);
            db.setTransactionSuccessful();
        } catch (SQLException e) {

        } finally {
            db.endTransaction();
        }
    }

    public SQLiteDatabase openDatabase() {
        if (sqLiteDatabase == null)
            sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase;
    }

    public void closeDatabase() {
        sqLiteDatabase.close();
    }
}
