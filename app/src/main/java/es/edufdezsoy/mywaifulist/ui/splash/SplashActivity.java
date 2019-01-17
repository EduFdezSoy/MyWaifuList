package es.edufdezsoy.mywaifulist.ui.splash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import es.edufdezsoy.mywaifulist.R;

public class SplashActivity extends AppCompatActivity implements SplashContract.View {
    SplashContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        presenter = new SplashPresenter(this);
    }

    @Override
    public void showErrorBox(String msg) {

    }

    @Override
    public void showMessageBox(String msg) {

    }

    @Override
    public void onWaifuListLoaded() {

    }
}
