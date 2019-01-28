package es.edufdezsoy.mywaifulist.ui.waifuList;

import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.data.model.Waifu;
import es.edufdezsoy.mywaifulist.data.repository.WaifuRepository;

public class WaifuListInteractor {
    public interface InteractorListener {
        void onListLoaded(ArrayList<Waifu> waifus);
    }

    public void loadList(InteractorListener listener) {
        listener.onListLoaded(WaifuRepository.getInstance().getAll());
    }
}
