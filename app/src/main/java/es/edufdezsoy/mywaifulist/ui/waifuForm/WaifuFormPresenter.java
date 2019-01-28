package es.edufdezsoy.mywaifulist.ui.waifuForm;

import es.edufdezsoy.mywaifulist.data.model.Waifu;

public class WaifuFormPresenter implements WaifuFormContract.Presenter, WaifuFormInteractor.InteractorListener {
    WaifuFormContract.View view;
    WaifuFormInteractor interactor;

    public WaifuFormPresenter(WaifuFormContract.View view) {
        this.view = view;
        interactor = new WaifuFormInteractor();
    }

    @Override
    public void editWaifu(Waifu originalWaifu, Waifu editedWaifu) {
        interactor.removeWaifu(originalWaifu, this);
        interactor.addWaifu(editedWaifu, this);
    }

    @Override
    public void addWaifu(Waifu waifu) {
        interactor.addWaifu(waifu, this);
    }


    // Interactor implemented methods

    @Override
    public void onSuccess() {
        view.onSucess();
    }

    @Override
    public void onFailure() {
        view.onFailure(1);
    }
}
