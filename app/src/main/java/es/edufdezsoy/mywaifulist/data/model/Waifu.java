package es.edufdezsoy.mywaifulist.data.model;

import java.util.Date;

public class Waifu {
    String name;
    String surname;
    String nickname;
    Date birthday;

    public Waifu(String name, String surname, String nickname, Date birthday) {
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
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
}
