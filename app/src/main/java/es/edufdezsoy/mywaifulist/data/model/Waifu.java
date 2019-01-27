package es.edufdezsoy.mywaifulist.data.model;

import java.util.Date;

public class Waifu {
    String name;
    String surname;
    String nickname;
    Date birthday;
    Anime anime;

    /**
     * legacy constructor
     *
     * @param name
     * @param surname
     * @param nickname
     * @param birthday
     */
    public Waifu(String name, String surname, String nickname, Date birthday) {
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.birthday = birthday;
        this.anime = new Anime("-Legacy Constructor used-", 1, "", "", "", "");
    }

    /**
     * @param name
     * @param surname
     * @param nickname
     * @param anime
     * @param birthday
     */
    public Waifu(String name, String surname, String nickname, Anime anime, Date birthday) {
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.anime = anime;
        this.birthday = birthday;
    }

    /**
     * @param name
     * @param surname
     * @param anime
     * @param birthday
     */
    public Waifu(String name, String surname, Anime anime, Date birthday) {
        this.name = name;
        this.surname = surname;
        this.nickname = "";
        this.anime = anime;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

}
