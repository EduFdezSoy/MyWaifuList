package es.edufdezsoy.mywaifulist.ui.form;

import es.edufdezsoy.mywaifulist.data.model.Waifu;

public class FormPresenter implements FormContract.Presenter, FormInteractor.InteractorListener {
    FormContract.View view;
    FormInteractor interactor;

    public FormPresenter(FormContract.View view) {
        this.view = view;
        interactor = new FormInteractor();
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
