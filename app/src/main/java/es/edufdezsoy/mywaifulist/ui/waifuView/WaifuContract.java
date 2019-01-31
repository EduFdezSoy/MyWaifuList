package es.edufdezsoy.mywaifulist.ui.waifuView;

import es.edufdezsoy.mywaifulist.data.model.Waifu;

public interface WaifuContract {
    interface View {
        void onWaifuLoaded(Waifu waifu);
    }

    interface Presenter {
        void loadWaifu(int id);
        void loadWaifuByName(String name, String surname);
    }
}
