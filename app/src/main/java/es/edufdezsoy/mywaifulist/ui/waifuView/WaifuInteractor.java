package es.edufdezsoy.mywaifulist.ui.waifuView;

import es.edufdezsoy.mywaifulist.data.model.Waifu;
import es.edufdezsoy.mywaifulist.data.repository.WaifuRepository;

public class WaifuInteractor {
    interface InteractorListener {
        void onSuccess();
        void onFailure();
    }

    public void addWaifu(Waifu waifu, InteractorListener listener) {
        // WaifuRepository.getInstance().add(waifu);
        listener.onSuccess();
    }

    public void editWaifu(Waifu oldWaifu, Waifu newWaifu, InteractorListener listener) {
        WaifuRepository.getInstance();
        listener.onSuccess();
    }

    public void removeWaifu(Waifu waifu, InteractorListener listener) {
        WaifuRepository.getInstance().remove(waifu);
        listener.onSuccess();
    }
}
