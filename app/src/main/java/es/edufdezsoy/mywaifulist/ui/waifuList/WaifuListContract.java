package es.edufdezsoy.mywaifulist.ui.waifuList;

import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.data.model.Waifu;

public interface WaifuListContract {
    interface View {
        void onLoaded(ArrayList<Waifu> waifus);
    }

    interface Presenter {
        void loadList();
    }
}
