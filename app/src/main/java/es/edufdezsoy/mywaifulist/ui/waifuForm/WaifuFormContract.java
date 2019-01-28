package es.edufdezsoy.mywaifulist.ui.waifuForm;

import es.edufdezsoy.mywaifulist.data.model.Waifu;

public interface WaifuFormContract {
    interface View {
        void onSucess();
        void onFailure(int error);
    }

    interface Presenter {
        void editWaifu(Waifu originalWaifu, Waifu editedWaifu);
        void addWaifu(Waifu waifu);
    }
}
