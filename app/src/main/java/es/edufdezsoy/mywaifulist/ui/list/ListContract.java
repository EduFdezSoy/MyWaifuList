package es.edufdezsoy.mywaifulist.ui.list;

import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.data.model.Waifu;

public class ListContract {
    interface View {
        void onLoaded(ArrayList<Waifu> waifus);
    }

    interface Presenter {
        void loadList();
    }
}
