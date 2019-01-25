package es.edufdezsoy.mywaifulist.ui.form;

import es.edufdezsoy.mywaifulist.data.model.Waifu;

public interface FormContract {
    interface View {
        void onSucess();
        void onFailure(int error);
    }

    interface Presenter {
        void editWaifu(Waifu originalWaifu, Waifu editedWaifu);
        void addWaifu(Waifu waifu);
    }
}
