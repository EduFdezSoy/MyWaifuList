package es.edufdezsoy.mywaifulist.data.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.data.model.Anime;

public class AnimeDao {
    public ArrayList<Anime> getAll() {
        SQLiteDatabase sqLiteDatabase = WaifuOpenHelper.getInstance().openDatabase();
        ArrayList<Anime> list = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(WaifuContract.AnimeEntry.TABLE_NAME,
                WaifuContract.AnimeEntry.ALL_COLUMNS,
                null, null, null, null,
                WaifuContract.AnimeEntry.DEFAULT_SORT);

        if (cursor.moveToFirst()) {
            do {
                Anime anime = new Anime(
                        cursor.getString(cursor.getColumnIndex(WaifuContract.AnimeEntry.COLUMN_TITLE)),
                        cursor.getString(cursor.getColumnIndex(WaifuContract.AnimeEntry.COLUMN_ROMANJI_TITLE)),
                        cursor.getInt(cursor.getColumnIndex(WaifuContract.AnimeEntry.COLUMN_YEAR)),
                        cursor.getString(cursor.getColumnIndex(WaifuContract.AnimeEntry.COLUMN_SEASON)),
                        cursor.getString(cursor.getColumnIndex(WaifuContract.AnimeEntry.COLUMN_IMAGE)),
                        cursor.getString(cursor.getColumnIndex(WaifuContract.AnimeEntry.COLUMN_MYANIMELIST_URL)),
                        cursor.getString(cursor.getColumnIndex(WaifuContract.AnimeEntry.COLUMN_TYPE))
                );
                list.add(anime);
            } while (cursor.moveToNext());
        }
        cursor.close();
        WaifuOpenHelper.getInstance().closeDatabase();
        return list;
    }

    public void add(Anime anime) {
        SQLiteDatabase sqLiteDatabase = WaifuOpenHelper.getInstance().openDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(WaifuContract.AnimeEntry.COLUMN_TITLE, anime.getTitle());
        contentValues.put(WaifuContract.AnimeEntry.COLUMN_ROMANJI_TITLE, anime.getRomanji());
        contentValues.put(WaifuContract.AnimeEntry.COLUMN_YEAR, anime.getYear());
        contentValues.put(WaifuContract.AnimeEntry.COLUMN_SEASON, anime.getSeason());
        contentValues.put(WaifuContract.AnimeEntry.COLUMN_IMAGE, anime.getImage());
        contentValues.put(WaifuContract.AnimeEntry.COLUMN_MYANIMELIST_URL, anime.getMyAnimeListURL());
        contentValues.put(WaifuContract.AnimeEntry.COLUMN_TYPE, anime.getType());

        sqLiteDatabase.insert(WaifuContract.AnimeEntry.TABLE_NAME, null, contentValues);

        WaifuOpenHelper.getInstance().closeDatabase();
    }
}
