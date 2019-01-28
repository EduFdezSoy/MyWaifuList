package es.edufdezsoy.mywaifulist.ui.animeList;

import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.data.model.Anime;

public class AnimeListPresenter implements AnimeListContract.Presenter, AnimeListInteractor.InteractorListener {
    private AnimeListContract.View view;
    private AnimeListInteractor interactor;

    public AnimeListPresenter(AnimeListContract.View view) {
        this.view = view;
        interactor = new AnimeListInteractor();
    }

    @Override
    public void loadList() {
        interactor.loadList(this);
    }

    @Override
    public void onListLoaded(ArrayList<Anime> anime) {
        view.onLoaded(anime);
    }
}
