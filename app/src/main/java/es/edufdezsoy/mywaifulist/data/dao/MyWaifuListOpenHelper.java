package es.edufdezsoy.mywaifulist.data.dao;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.concurrent.atomic.AtomicInteger;

import es.edufdezsoy.mywaifulist.MyWaifuListApplication;

public class MyWaifuListOpenHelper extends SQLiteOpenHelper {
    private static MyWaifuListOpenHelper waifuOpenHelper;
    private SQLiteDatabase sqLiteDatabase;
    /**
     * openCounter will count how many clases are using the database.
     * We will not open it if the static object already exist and we will not close it if anyone is
     * using it.
     */
    private AtomicInteger openCounter = new AtomicInteger();

    private MyWaifuListOpenHelper() {
        super(MyWaifuListApplication.getContext(), MyWaifuListContract.DATABASE_NAME, null, MyWaifuListContract.DATABASE_VERSION);
    }

    public static MyWaifuListOpenHelper getInstance() {
        if (waifuOpenHelper == null)
            waifuOpenHelper = new MyWaifuListOpenHelper();

        return waifuOpenHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(MyWaifuListApplication.TAG, "Creating database (MyWaifuListOpenHelper:onCreate)");
        db.beginTransaction();
        try {
            db.execSQL(MyWaifuListContract.AnimeEntry.SQL_CREATE_ENTRIES);
            db.execSQL(MyWaifuListContract.AnimeEntry.SQL_INSERT_ENTRIES);
            db.execSQL(MyWaifuListContract.WaifuEntry.SQL_CREATE_ENTRIES);
            db.execSQL(MyWaifuListContract.WaifuEntry.SQL_INSERT_ENTRIES);
            db.setTransactionSuccessful();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(MyWaifuListApplication.TAG, "Upgrading database (MyWaifuListOpenHelper:onUpgrade)");
        db.beginTransaction();
        try {
            db.execSQL(MyWaifuListContract.WaifuEntry.SQL_DELETE_ENTRIES);
            db.execSQL(MyWaifuListContract.AnimeEntry.SQL_DELETE_ENTRIES);
            onCreate(db);
            db.setTransactionSuccessful();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public synchronized SQLiteDatabase openDatabase() {
        Log.v(MyWaifuListApplication.TAG, "Opening database (MyWaifuListOpenHelper:openDatabase)");
        if (openCounter.incrementAndGet() == 1)
            sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase;
    }

    public synchronized void closeDatabase() {
        Log.v(MyWaifuListApplication.TAG, "Closing database (MyWaifuListOpenHelper:closeDatabase)");
        if (openCounter.decrementAndGet() == 0)
            sqLiteDatabase.close();
    }

    /**
     * this method is a callback whenever the database is opened, if its for write we would like to
     * activate the foreign keys.
     *
     * @param db SQLiteDatabase
     */
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly())
            db.execSQL("PRAGMA foreign_keys=ON");
    }
}
