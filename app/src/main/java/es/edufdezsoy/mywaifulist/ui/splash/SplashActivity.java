package es.edufdezsoy.mywaifulist.ui.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import es.edufdezsoy.mywaifulist.R;
import es.edufdezsoy.mywaifulist.ui.list.ListActivity;

public class SplashActivity extends AppCompatActivity implements SplashContract.View {
    SplashContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        presenter = new SplashPresenter(this);

        // JUST FOR TEST PROPOSES
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onWaifuListLoaded();
    }

    @Override
    public void showErrorBox(String msg) {

    }

    @Override
    public void showMessageBox(String msg) {

    }

    @Override
    public void onWaifuListLoaded() {
        startActivity(new Intent(this, ListActivity.class));
    }
}
