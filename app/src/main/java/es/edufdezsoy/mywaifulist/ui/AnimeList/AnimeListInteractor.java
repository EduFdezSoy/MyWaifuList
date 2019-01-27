package es.edufdezsoy.mywaifulist.ui.AnimeList;

import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.data.model.Anime;
import es.edufdezsoy.mywaifulist.data.model.Waifu;
import es.edufdezsoy.mywaifulist.data.repository.AnimeRepository;
import es.edufdezsoy.mywaifulist.data.repository.WaifuRepository;

public class AnimeListInteractor {
    public interface InteractorListener {
        void onListLoaded(ArrayList<Anime> anime);
    }

    public void loadList(InteractorListener listener) {
        listener.onListLoaded(AnimeRepository.getInstance().getAll());
    }
}
