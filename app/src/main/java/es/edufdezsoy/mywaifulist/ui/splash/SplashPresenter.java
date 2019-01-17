package es.edufdezsoy.mywaifulist.ui.splash;

public class SplashPresenter implements SplashContract.Presenter, SplashInteractor.InteractorListener {
    SplashContract.View view;
    SplashInteractor interactor;

    public SplashPresenter(SplashContract.View view) {
        this.view = view;
        interactor = new SplashInteractor();
    }

    @Override
    public void loadWaifuList() {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onTimeOut() {

    }

    @Override
    public void onConnectionError() {

    }
}
