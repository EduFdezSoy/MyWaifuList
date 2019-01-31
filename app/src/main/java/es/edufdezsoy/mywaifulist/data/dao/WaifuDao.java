package es.edufdezsoy.mywaifulist.data.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.MyWaifuListApplication;
import es.edufdezsoy.mywaifulist.data.model.Anime;
import es.edufdezsoy.mywaifulist.data.model.Waifu;
import es.edufdezsoy.mywaifulist.data.model.WaifuView;

public class WaifuDao {
    public ArrayList<Waifu> getAll() {
        SQLiteDatabase sqLiteDatabase = MyWaifuListOpenHelper.getInstance().openDatabase();
        ArrayList<Waifu> list = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(MyWaifuListContract.WaifuEntry.TABLE_NAME,
                MyWaifuListContract.WaifuEntry.ALL_COLUMNS,
                null, null, null, null,
                MyWaifuListContract.WaifuEntry.DEFAULT_SORT);

        if (cursor.moveToFirst()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            do {
                try {
                    Waifu waifu = new Waifu(
                            cursor.getString(cursor.getColumnIndex(MyWaifuListContract.WaifuEntry.COLUMN_NAME)),
                            cursor.getString(cursor.getColumnIndex(MyWaifuListContract.WaifuEntry.COLUMN_SURNAME)),
                            cursor.getString(cursor.getColumnIndex(MyWaifuListContract.WaifuEntry.COLUMN_NICKNAME)),
                            dateFormat.parse(cursor.getString(cursor.getColumnIndex(MyWaifuListContract.WaifuEntry.COLUMN_BIRTHDAY)))
                    );
                    list.add(waifu);
                } catch (ParseException e) {
                    Log.e(MyWaifuListApplication.TAG, "Error parsing date in WaifuDao:getAll");
                    e.printStackTrace();
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        MyWaifuListOpenHelper.getInstance().closeDatabase();
        return list;
    }

    public Waifu get(int id) {
        Waifu waifu = null;
        SQLiteDatabase sqLiteDatabase = MyWaifuListOpenHelper.getInstance().openDatabase();

        SQLiteQueryBuilder sqLiteQueryBuilder = new SQLiteQueryBuilder();
        sqLiteQueryBuilder.setTables(MyWaifuListContract.WaifuInnerEntry.TABLE_NAME);
        sqLiteQueryBuilder.setProjectionMap(MyWaifuListContract.WaifuInnerEntry.sWaifuInnerProjectionMap);

        Cursor cursor = sqLiteQueryBuilder.query(
                sqLiteDatabase,
                MyWaifuListContract.WaifuInnerEntry.ALL_COLUMNS,
                (MyWaifuListContract.WaifuInnerEntry._ID + " = " + id), null, null, null,
                MyWaifuListContract.WaifuInnerEntry.DEFAULT_SORT);

        if (cursor.moveToFirst()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            do {
                try {
                    waifu = new Waifu(
                            cursor.getString(cursor.getColumnIndex(MyWaifuListContract.WaifuInnerEntry.COLUMN_NAME)),
                            cursor.getString(cursor.getColumnIndex(MyWaifuListContract.WaifuInnerEntry.COLUMN_SURNAME)),
                            cursor.getString(cursor.getColumnIndex(MyWaifuListContract.WaifuInnerEntry.COLUMN_NICKNAME)),
                            new Anime(
                                    cursor.getInt(cursor.getColumnIndex(MyWaifuListContract.WaifuInnerEntry.COLUMN_ANIME_ID)),
                                    cursor.getString(cursor.getColumnIndex(MyWaifuListContract.WaifuInnerEntry.COLUMN_ANIME_TITLE))
                            ),
                            dateFormat.parse(cursor.getString(cursor.getColumnIndex(MyWaifuListContract.WaifuInnerEntry.COLUMN_BIRTHDAY)))
                    );
                } catch (ParseException e) {
                    Log.e(MyWaifuListApplication.TAG, "Error parsing date in WaifuDao:get+ID=" + id);
                    e.printStackTrace();
                }
            } while (cursor.moveToNext());
        }

        cursor.close();
        MyWaifuListOpenHelper.getInstance().closeDatabase();
        return waifu;
    }

    public void add(Waifu waifu) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SQLiteDatabase sqLiteDatabase = MyWaifuListOpenHelper.getInstance().openDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyWaifuListContract.WaifuEntry.COLUMN_NAME, waifu.getName());
        contentValues.put(MyWaifuListContract.WaifuEntry.COLUMN_SURNAME, waifu.getSurname());
        contentValues.put(MyWaifuListContract.WaifuEntry.COLUMN_NICKNAME, waifu.getNickname());
        contentValues.put(MyWaifuListContract.WaifuEntry.COLUMN_BIRTHDAY, dateFormat.format(waifu.getBirthday()));

        sqLiteDatabase.insert(MyWaifuListContract.WaifuEntry.TABLE_NAME, null, contentValues);

        MyWaifuListOpenHelper.getInstance().closeDatabase();
    }

    public void remove(Waifu waifu) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SQLiteDatabase sqLiteDatabase = MyWaifuListOpenHelper.getInstance().openDatabase();

        // TODO: to finish
        // sqLiteDatabase.delete()

        MyWaifuListOpenHelper.getInstance().closeDatabase();
    }

    public void edit(Waifu oldWaifu, Waifu newWaifu) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SQLiteDatabase sqLiteDatabase = MyWaifuListOpenHelper.getInstance().openDatabase();

        // TODO: to finish

        MyWaifuListOpenHelper.getInstance().closeDatabase();
    }

    public WaifuView view(int i) {
        SQLiteDatabase sqLiteDatabase = MyWaifuListOpenHelper.getInstance().openDatabase();

        WaifuView waifu = null;
        SQLiteQueryBuilder sqLiteQueryBuilder = new SQLiteQueryBuilder();
        sqLiteQueryBuilder.setTables(MyWaifuListContract.WaifuInnerEntry.WAIFU_INNER_ANIME);
        sqLiteQueryBuilder.setProjectionMap(MyWaifuListContract.WaifuInnerEntry.sWaifuInnerProjectionMap);

        Cursor cursor = sqLiteQueryBuilder.query(sqLiteDatabase, MyWaifuListContract.WaifuInnerEntry.ALL_COLUMNS,
                null, null, null, null, MyWaifuListContract.WaifuInnerEntry.DEFAULT_SORT);
        if (cursor.moveToFirst()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            try {
                waifu = new WaifuView(
                        cursor.getString(cursor.getColumnIndex(MyWaifuListContract.WaifuEntry.COLUMN_NAME)),
                        cursor.getString(cursor.getColumnIndex(MyWaifuListContract.WaifuEntry.COLUMN_SURNAME)),
                        cursor.getString(cursor.getColumnIndex(MyWaifuListContract.WaifuEntry.COLUMN_NICKNAME)),
                        dateFormat.parse(cursor.getString(cursor.getColumnIndex(MyWaifuListContract.WaifuEntry.COLUMN_BIRTHDAY)))
                );
            } catch (ParseException e) {
                Log.e(MyWaifuListApplication.TAG, "Error parsing date in WaifuDao:getAll");
                e.printStackTrace();
            }
        }
        MyWaifuListOpenHelper.getInstance().closeDatabase();

        return waifu;
    }
}
