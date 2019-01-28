package es.edufdezsoy.mywaifulist.data.model;

import java.util.Date;

public class WaifuView extends Waifu {
    public WaifuView(String name, String surname, String nickname, Date birthday) {
        super(name, surname, nickname, birthday);
    }

    public WaifuView(String name, String surname, String nickname, Anime anime, Date birthday) {
        super(name, surname, nickname, anime, birthday);
    }

    public WaifuView(String name, String surname, Anime anime, Date birthday) {
        super(name, surname, anime, birthday);
    }
}
