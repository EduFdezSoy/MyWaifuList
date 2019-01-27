package es.edufdezsoy.mywaifulist.ui.AnimeList;

import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.data.model.Anime;
import es.edufdezsoy.mywaifulist.data.model.Waifu;

public interface AnimeListContract {
    interface View {
        void onLoaded(ArrayList<Anime> animes);
    }

    interface Presenter {
        void loadList();
    }
}
