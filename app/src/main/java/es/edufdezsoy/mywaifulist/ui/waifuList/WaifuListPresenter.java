package es.edufdezsoy.mywaifulist.ui.waifuList;

import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.data.model.Waifu;

public class WaifuListPresenter implements WaifuListContract.Presenter, WaifuListInteractor.InteractorListener {
    WaifuListContract.View view;
    WaifuListInteractor interactor;

    public WaifuListPresenter(WaifuListContract.View view) {
        this.view = view;
        interactor = new WaifuListInteractor();
    }

    @Override
    public void loadList() {
        interactor.loadList(this);
    }

    @Override
    public void onListLoaded(ArrayList<Waifu> waifus) {
        view.onLoaded(waifus);
    }
}
