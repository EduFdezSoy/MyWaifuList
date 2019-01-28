package es.edufdezsoy.mywaifulist.ui.animeList;

import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.data.model.Anime;
import es.edufdezsoy.mywaifulist.data.repository.AnimeRepository;

public class AnimeListInteractor {
    public interface InteractorListener {
        void onListLoaded(ArrayList<Anime> anime);
    }

    public void loadList(InteractorListener listener) {
        listener.onListLoaded(AnimeRepository.getInstance().getAll());
    }
}
