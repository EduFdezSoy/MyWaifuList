package es.edufdezsoy.mywaifulist.data.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.WaifuApplication;
import es.edufdezsoy.mywaifulist.data.model.Waifu;

public class WaifuDao {
    public ArrayList<Waifu> getAll() {
        SQLiteDatabase sqLiteDatabase = WaifuOpenHelper.getInstance().openDatabase();
        ArrayList<Waifu> list = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(WaifuContract.WaifuEntry.TABLE_NAME,
                WaifuContract.WaifuEntry.ALL_COLUMNS,
                null, null, null, null,
                WaifuContract.WaifuEntry.DEFAULT_SORT);

        if (cursor.moveToFirst()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            do {
                try {
                    Waifu waifu = new Waifu(
                            cursor.getString(cursor.getColumnIndex(WaifuContract.WaifuEntry.COLUMN_NAME)),
                            cursor.getString(cursor.getColumnIndex(WaifuContract.WaifuEntry.COLUMN_SURNAME)),
                            cursor.getString(cursor.getColumnIndex(WaifuContract.WaifuEntry.COLUMN_NICKNAME)),
                            dateFormat.parse(cursor.getString(cursor.getColumnIndex(WaifuContract.WaifuEntry.COLUMN_BIRTHDAY)))
                    );
                    list.add(waifu);
                } catch (ParseException e) {
                    Log.e(WaifuApplication.TAG, "Error parsing date in WaifuDao:getAll");
                    e.printStackTrace();
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        WaifuOpenHelper.getInstance().closeDatabase();
        return list;
    }

    public void add(Waifu waifu) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SQLiteDatabase sqLiteDatabase = WaifuOpenHelper.getInstance().openDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(WaifuContract.WaifuEntry.COLUMN_NAME, waifu.getName());
        contentValues.put(WaifuContract.WaifuEntry.COLUMN_SURNAME, waifu.getSurname());
        contentValues.put(WaifuContract.WaifuEntry.COLUMN_NICKNAME, waifu.getNickname());
        contentValues.put(WaifuContract.WaifuEntry.COLUMN_BIRTHDAY, dateFormat.format(waifu.getBirthday()));

        sqLiteDatabase.insert(WaifuContract.WaifuEntry.TABLE_NAME, null, contentValues);

        WaifuOpenHelper.getInstance().closeDatabase();
    }

    public void remove(Waifu waifu) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SQLiteDatabase sqLiteDatabase = WaifuOpenHelper.getInstance().openDatabase();

        // TODO: to finish
        // sqLiteDatabase.delete()

        WaifuOpenHelper.getInstance().closeDatabase();
    }

    public void edit(Waifu oldWaifu, Waifu newWaifu) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SQLiteDatabase sqLiteDatabase = WaifuOpenHelper.getInstance().openDatabase();

        // TODO: to finish

        WaifuOpenHelper.getInstance().closeDatabase();
    }
}
