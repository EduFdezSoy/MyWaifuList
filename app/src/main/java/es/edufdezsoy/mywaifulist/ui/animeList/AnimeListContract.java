package es.edufdezsoy.mywaifulist.ui.animeList;

import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.data.model.Anime;

public interface AnimeListContract {
    interface View {
        void onLoaded(ArrayList<Anime> animes);
    }

    interface Presenter {
        void loadList();
    }
}
