package es.edufdezsoy.mywaifulist.data.dao;

import android.provider.BaseColumns;

import java.util.HashMap;

/**
 * This class will only contain constants to define the database, tables, columns and the test data
 */
public final class MyWaifuListContract {

    public static final String DATABASE_NAME = "MyWaifuList.db";
    public static final int DATABASE_VERSION = 1;

    /**
     * Anime table data
     */
    public static final class AnimeEntry implements BaseColumns {
        // TABLE NAME
        public static final String TABLE_NAME = "anime";
        // COLUMNS
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_ROMANJI_TITLE = "romanji_title";
        public static final String COLUMN_YEAR = "year";
        public static final String COLUMN_SEASON = "season";
        public static final String COLUMN_IMAGE = "image";
        public static final String COLUMN_MYANIMELIST_URL = "myanimelist";
        public static final String COLUMN_TYPE = "type";

        // DEFAULT ORDER
        public static final String DEFAULT_SORT = COLUMN_TITLE;
        // COLUMNS ARRAY
        public static final String[] ALL_COLUMNS = new String[]{
                BaseColumns._ID, COLUMN_TITLE, COLUMN_ROMANJI_TITLE,
                COLUMN_YEAR, COLUMN_SEASON, COLUMN_IMAGE,
                COLUMN_MYANIMELIST_URL, COLUMN_TYPE};

        // CREATE TABLE
        public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME +
                " (" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT NOT NULL, " +
                COLUMN_ROMANJI_TITLE + " TEXT NOT NULL, " +
                COLUMN_YEAR + " INTEGER NOT NULL, " +
                COLUMN_SEASON + " TEXT NOT NULL, " +
                COLUMN_IMAGE + " TEXT NOT NULL, " +
                COLUMN_MYANIMELIST_URL + " TEXT NOT NULL, " +
                COLUMN_TYPE + " TEXT NOT NULL)";
        // DELETE TABLE
        public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME;
        // INSERT TEST DATA
        public static final String SQL_INSERT_ENTRIES = "INSERT INTO " + TABLE_NAME + " (" +
                COLUMN_TITLE + ", " +
                COLUMN_ROMANJI_TITLE + ", " +
                COLUMN_YEAR + ", " +
                COLUMN_SEASON + ", " +
                COLUMN_IMAGE + ", " +
                COLUMN_MYANIMELIST_URL + ", " +
                COLUMN_TYPE +
                ") VALUES (" +
                "'" + "Darling in the FranXX" + "', " +
                "'" + "" + "', " +
                "'" + 2018 + "', " +
                "'" + "Winter" + "', " +
                "'" + "darlinginthefranxx" + "', " +
                "'" + "https://myanimelist.net/anime/35849/Darling_in_the_FranXX" + "', " +
                "'" + "Anime" + "'" +
                ")" +
                ", (" +
                "'" + "Rascal Does Not Dream of Bunny Girl Senpai" + "', " +
                "'" + "Seishun Buta Yarou wa Bunny Girl Senpai no Yume wo Minai" + "', " +
                "'" + 2018 + "', " +
                "'" + "Fall" + "', " +
                "'" + "seishunbutayarou" + "', " +
                "'" + "https://myanimelist.net/anime/37450/Seishun_Buta_Yarou_wa_Bunny_Girl_Senpai_no_Yume_wo_Minai" + "', " +
                "'" + "Anime" + "'" +
                ")" +
                ", (" +
                "'" + "A Silent Voice" + "', " +
                "'" + "Koe no Katachi" + "', " +
                "'" + 2016 + "', " +
                "'" + "" + "', " +
                "'" + "koenokatachi" + "', " +
                "'" + "https://myanimelist.net/anime/28851/Koe_no_Katachi" + "', " +
                "'" + "Film" + "'" +
                ")" +
                ", (" +
                "'" + "Komi-san wa, Comyushou desu." + "', " +
                "'" + "" + "', " +
                "'" + 2016 + "', " +
                "'" + "" + "', " +
                "'" + "komisan" + "', " +
                "'" + "https://myanimelist.net/manga/99007/Komi-san_wa_Comyushou_desu" + "', " +
                "'" + "Manga" + "'" +
                ")";
    }

    /**
     * Waifu table data
     */
    public static final class WaifuEntry implements BaseColumns {
        // TABLE NAME
        public static final String TABLE_NAME = "waifu";
        // COLUMNS
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SURNAME = "surname";
        public static final String COLUMN_NICKNAME = "nickname";
        public static final String COLUMN_BIRTHDAY = "birthday";
        public static final String COLUMN_IMAGE = "image";
        // FK COLUMNS
        public static final String COLUMN_ANIME_ID = "anime_id";
        // DEFAULT ORDER
        public static final String DEFAULT_SORT = COLUMN_NAME;
        // COLUMNS ARRAY
        public static final String[] ALL_COLUMNS = new String[]{
                BaseColumns._ID, COLUMN_NAME, COLUMN_SURNAME,
                COLUMN_NICKNAME, COLUMN_BIRTHDAY, COLUMN_IMAGE,
                COLUMN_ANIME_ID};
        // FOREIGN KEYS REFERENCES
        public static final String REFERENCE_WAIFU_ANIME = "FOREIGN KEY(" + COLUMN_ANIME_ID + ") REFERENCES " + TABLE_NAME +
                " (" + BaseColumns._ID + ") ON UPDATE CASCADE ON DELETE RESTRICT";

        // CREATE TABLE
        public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME +
                " (" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT NOT NULL, " +
                COLUMN_SURNAME + " TEXT NOT NULL, " +
                COLUMN_NICKNAME + " TEXT NOT NULL, " +
                COLUMN_BIRTHDAY + " TEXT NOT NULL, " +
                COLUMN_IMAGE + " TEXT NOT NULL, " +
                COLUMN_ANIME_ID + " INTEGER NOT NULL, " +
                REFERENCE_WAIFU_ANIME + ")";

        // DELETE TABLE
        public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME;

        // TEST DATA INSERT
        public static final String SQL_INSERT_ENTRIES = "INSERT INTO " + TABLE_NAME + " (" +
                COLUMN_NAME + ", " +
                COLUMN_SURNAME + ", " +
                COLUMN_NICKNAME + ", " +
                COLUMN_BIRTHDAY + ", " +
                COLUMN_IMAGE + ", " +
                COLUMN_ANIME_ID +
                ") VALUES (" +
                "'" + "Iota" + "', " +
                "'" + "Nine" + "', " +
                "'" + "Zero Two" + "', " +
                "'" + "27-02-0000" + "', " +
                "'" + "zerotwo" + "', " +
                "" + 1 + "" +
                ")" +
                ", (" +
                "'" + "Mai" + "', " +
                "'" + "Sakurajima" + "', " +
                "'" + "Mai-san" + "', " +
                "'" + "02-12-0000" + "', " +
                "'" + "sakurajimamai" + "', " +
                "" + 2 + "" +
                ")" +
                ", (" +
                "'" + "Shouko" + "', " +
                "'" + "Nishimiya" + "', " +
                "'" + "" + "', " +
                "'" + "07-06-0000" + "', " +
                "'" + "nishimiyashouko" + "', " +
                "" + 3 + "" +
                ")";
    }

    /**
     * Class for inner join selects
     */
    public static final class WaifuInnerEntry implements BaseColumns {
        // TABLE NAME
        public static final String TABLE_NAME = WaifuEntry.TABLE_NAME;
        // COLUMNS
        public static final String COLUMN_NAME = WaifuEntry.COLUMN_NAME;
        public static final String COLUMN_SURNAME = WaifuEntry.COLUMN_SURNAME;
        public static final String COLUMN_NICKNAME = WaifuEntry.COLUMN_NICKNAME;
        public static final String COLUMN_BIRTHDAY = WaifuEntry.COLUMN_BIRTHDAY;
        public static final String COLUMN_IMAGE = WaifuEntry.COLUMN_IMAGE;
        // FK COLUMNS
        public static final String COLUMN_ANIME_ID = WaifuEntry.COLUMN_ANIME_ID;
        public static final String COLUMN_ANIME_TITLE = AnimeEntry.COLUMN_TITLE;
        // DEFAULT ORDER
        public static final String DEFAULT_SORT = COLUMN_NAME;
        // COLUMNS ARRAY
        public static final String[] ALL_COLUMNS = new String[]{
                BaseColumns._ID, COLUMN_NAME, COLUMN_SURNAME,
                COLUMN_NICKNAME, COLUMN_BIRTHDAY,
                COLUMN_ANIME_ID, COLUMN_ANIME_TITLE};

        public static final String WAIFU_INNER_ANIME = TABLE_NAME + " INNER JOIN " +
                AnimeEntry.TABLE_NAME + " ON " +
                COLUMN_ANIME_ID + "=" + AnimeEntry.TABLE_NAME + "." + AnimeEntry._ID;
//        public static final String WAIFU_INNER_ANIME = "SELECT "+ ALL_COLUMNS + " FROM " + TABLE_NAME + " INNER JOIN " +
//                AnimeEntry.TABLE_NAME + " ON " +
//                COLUMN_ANIME_ID + "=" + AnimeEntry._ID;

        // PROJECTION MAP from the columns of the db to a cursor
        public static HashMap<String, String> sWaifuInnerProjectionMap = new HashMap<>();
        static {
            sWaifuInnerProjectionMap.put(_ID, TABLE_NAME + "." + _ID);
            sWaifuInnerProjectionMap.put(COLUMN_NAME, TABLE_NAME + "." + COLUMN_NAME);
            sWaifuInnerProjectionMap.put(COLUMN_SURNAME, TABLE_NAME + "." + COLUMN_SURNAME);
            sWaifuInnerProjectionMap.put(COLUMN_NICKNAME, TABLE_NAME + "." + COLUMN_NICKNAME);
            sWaifuInnerProjectionMap.put(COLUMN_BIRTHDAY, TABLE_NAME + "." + COLUMN_BIRTHDAY);
            sWaifuInnerProjectionMap.put(COLUMN_ANIME_ID, AnimeEntry.TABLE_NAME + "." + AnimeEntry._ID);
            sWaifuInnerProjectionMap.put(COLUMN_ANIME_TITLE, AnimeEntry.TABLE_NAME + "." + COLUMN_ANIME_TITLE);
        }
    }
}