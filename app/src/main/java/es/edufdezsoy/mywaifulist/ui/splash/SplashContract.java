package es.edufdezsoy.mywaifulist.ui.splash;

public interface SplashContract {
    interface View {
        void showErrorBox(String msg);
        void showMessageBox(String msg);
        void onWaifuListLoaded();
    }

    interface Presenter {
        void loadWaifuList();
    }
}
