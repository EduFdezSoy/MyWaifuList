package es.edufdezsoy.mywaifulist.ui.splash;

public class SplashInteractor {
    interface InteractorListener {
        void onSuccess();
        void onTimeOut();
        void onConnectionError();
    }

    void loadWaifuList(InteractorListener listener) {

    }
}
