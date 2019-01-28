package es.edufdezsoy.mywaifulist.data.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.data.model.Anime;

public class AnimeDao {
    public ArrayList<Anime> getAll() {
        SQLiteDatabase sqLiteDatabase = MyWaifuListOpenHelper.getInstance().openDatabase();
        ArrayList<Anime> list = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(MyWaifuListContract.AnimeEntry.TABLE_NAME,
                MyWaifuListContract.AnimeEntry.ALL_COLUMNS,
                null, null, null, null,
                MyWaifuListContract.AnimeEntry.DEFAULT_SORT);

        if (cursor.moveToFirst()) {
            do {
                Anime anime = new Anime(
                        cursor.getString(cursor.getColumnIndex(MyWaifuListContract.AnimeEntry.COLUMN_TITLE)),
                        cursor.getString(cursor.getColumnIndex(MyWaifuListContract.AnimeEntry.COLUMN_ROMANJI_TITLE)),
                        cursor.getInt(cursor.getColumnIndex(MyWaifuListContract.AnimeEntry.COLUMN_YEAR)),
                        cursor.getString(cursor.getColumnIndex(MyWaifuListContract.AnimeEntry.COLUMN_SEASON)),
                        cursor.getString(cursor.getColumnIndex(MyWaifuListContract.AnimeEntry.COLUMN_IMAGE)),
                        cursor.getString(cursor.getColumnIndex(MyWaifuListContract.AnimeEntry.COLUMN_MYANIMELIST_URL)),
                        cursor.getString(cursor.getColumnIndex(MyWaifuListContract.AnimeEntry.COLUMN_TYPE))
                );
                list.add(anime);
            } while (cursor.moveToNext());
        }
        cursor.close();
        MyWaifuListOpenHelper.getInstance().closeDatabase();
        return list;
    }

    public void add(Anime anime) {
        SQLiteDatabase sqLiteDatabase = MyWaifuListOpenHelper.getInstance().openDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(MyWaifuListContract.AnimeEntry.COLUMN_TITLE, anime.getTitle());
        contentValues.put(MyWaifuListContract.AnimeEntry.COLUMN_ROMANJI_TITLE, anime.getRomanji());
        contentValues.put(MyWaifuListContract.AnimeEntry.COLUMN_YEAR, anime.getYear());
        contentValues.put(MyWaifuListContract.AnimeEntry.COLUMN_SEASON, anime.getSeason());
        contentValues.put(MyWaifuListContract.AnimeEntry.COLUMN_IMAGE, anime.getImage());
        contentValues.put(MyWaifuListContract.AnimeEntry.COLUMN_MYANIMELIST_URL, anime.getMyAnimeListURL());
        contentValues.put(MyWaifuListContract.AnimeEntry.COLUMN_TYPE, anime.getType());

        sqLiteDatabase.insert(MyWaifuListContract.AnimeEntry.TABLE_NAME, null, contentValues);

        MyWaifuListOpenHelper.getInstance().closeDatabase();
    }
}
