package es.edufdezsoy.mywaifulist.data.model;

public class Anime {
    private String title;
    private String romanji;
    private int year;
    private String season;
    private String image;
    private String myAnimeListURL;
    private String type;

    /**
     * Use this constructor if the title and the romanji are not the same
     *
     * @param title          title of that anime
     * @param romanji        title as-readed from japanese
     * @param year           aired at
     * @param season         premier season
     * @param image          url to a image
     * @param myAnimeListURL url to myanimelist.net
     * @param type           anime/manga/film
     */
    public Anime(String title, String romanji, int year, String season, String image, String myAnimeListURL, String type) {
        this.title = title;
        this.romanji = romanji;
        this.year = year;
        this.season = season;
        this.image = image;
        this.myAnimeListURL = myAnimeListURL;
        this.type = type;
    }

    /**
     * Use this constructor if the title and the romanji title are the same
     *
     * @param title          same as romanji
     * @param year           aired at
     * @param season         premier season
     * @param image          url to a image
     * @param myAnimeListURL url to myanimelist.net
     * @param type           anime/manga/film
     */
    public Anime(String title, int year, String season, String image, String myAnimeListURL, String type) {
        this.title = title;
        this.romanji = title;
        this.year = year;
        this.season = season;
        this.image = image;
        this.myAnimeListURL = myAnimeListURL;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRomanji() {
        return romanji;
    }

    public void setRomanji(String romanji) {
        this.romanji = romanji;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMyAnimeListURL() {
        return myAnimeListURL;
    }

    public void setMyAnimeListURL(String myAnimeListURL) {
        this.myAnimeListURL = myAnimeListURL;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
