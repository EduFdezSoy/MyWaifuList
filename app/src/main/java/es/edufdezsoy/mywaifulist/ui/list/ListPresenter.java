package es.edufdezsoy.mywaifulist.ui.list;

import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.data.model.Waifu;

public class ListPresenter implements ListContract.Presenter, ListInteractor.InteractorListener {
    ListContract.View view;
    ListInteractor interactor;

    public ListPresenter(ListContract.View view) {
        this.view = view;
        interactor = new ListInteractor();
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
