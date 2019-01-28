package es.edufdezsoy.mywaifulist.ui.splash;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import es.edufdezsoy.mywaifulist.R;
import es.edufdezsoy.mywaifulist.MyWaifuListApplication;
import es.edufdezsoy.mywaifulist.ui.waifuList.WaifuListActivity;

public class SplashActivity extends AppCompatActivity implements SplashContract.View {
    SplashContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        presenter = new SplashPresenter(this);
        createNotificationManager();
        // JUST FOR TEST PROPOSES
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onWaifuListLoaded();
    }

    private void createNotificationManager() {
        // see for help: https://developer.android.com/training/notify-user/build-notification

        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(MyWaifuListApplication.NOTIFICATION_CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    @Override
    public void showErrorBox(String msg) {

    }

    @Override
    public void showMessageBox(String msg) {

    }

    @Override
    public void onWaifuListLoaded() {
        startActivity(new Intent(this, WaifuListActivity.class));
    }
}
