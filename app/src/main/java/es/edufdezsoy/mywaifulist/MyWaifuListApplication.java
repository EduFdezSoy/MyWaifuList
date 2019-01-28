package es.edufdezsoy.mywaifulist;

import android.app.Application;
import android.content.Context;

public class MyWaifuListApplication extends Application {
    public static final String TAG = "EDUFDEZSOY"; // for debug proposes
    public static final String NOTIFICATION_CHANNEL_ID = "MWL_NT_CH_ID";
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}