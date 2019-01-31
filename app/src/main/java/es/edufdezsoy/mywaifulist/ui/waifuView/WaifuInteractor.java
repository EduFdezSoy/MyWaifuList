package es.edufdezsoy.mywaifulist.ui.waifuView;

import es.edufdezsoy.mywaifulist.data.model.Waifu;
import es.edufdezsoy.mywaifulist.data.repository.WaifuRepository;

public class WaifuInteractor {
    interface InteractorListener {
        void onSuccess(Waifu waifu);
    }

    public void getWaifu(int waifuId, InteractorListener listener) {
        listener.onSuccess(WaifuRepository.getInstance().get(waifuId));
    }

    public void getWaifuByName(String waifuName, InteractorListener listener) {
        Waifu waifu = WaifuRepository.getInstance().get(1);
        listener.onSuccess(waifu);
    }
}
