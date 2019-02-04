package es.edufdezsoy.mywaifulist.ui.waifuView;

import es.edufdezsoy.mywaifulist.data.model.Waifu;

public class WaifuPresenter implements WaifuContract.Presenter, WaifuInteractor.InteractorListener {
    WaifuContract.View view;
    WaifuInteractor interactor;

    public WaifuPresenter(WaifuContract.View view) {
        this.view = view;
        interactor = new WaifuInteractor();
    }

    @Override
    public void loadWaifu(int id) {
        interactor.getWaifu(id, this);
    }

    @Override
    public void loadWaifuByName(String name, String surname) {
        interactor.getWaifu(1, this);
    }

    @Override
    public void onSuccess(Waifu waifu) {
        view.onWaifuLoaded(waifu);
    }
}
