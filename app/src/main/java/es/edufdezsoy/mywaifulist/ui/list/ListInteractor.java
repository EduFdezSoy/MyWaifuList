package es.edufdezsoy.mywaifulist.ui.list;

import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.data.model.Waifu;
import es.edufdezsoy.mywaifulist.data.repository.WaifuRepository;

public class ListInteractor {
    public interface InteractorListener {
        void onListLoaded(ArrayList<Waifu> waifus);
    }

    public void loadList(InteractorListener listener) {
        listener.onListLoaded(WaifuRepository.getInstance().getAll());
    }
}
