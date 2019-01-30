package es.edufdezsoy.mywaifulist.ui.waifuView;

public class WaifuPresenter implements WaifuContract.Presenter, WaifuInteractor.InteractorListener {
    WaifuContract.View view;
    WaifuInteractor interactor;

    public WaifuPresenter(WaifuContract.View view) {
        this.view = view;
        interactor = new WaifuInteractor();
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFailure() {

    }
}
