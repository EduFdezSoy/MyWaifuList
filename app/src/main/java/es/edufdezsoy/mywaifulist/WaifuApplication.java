package es.edufdezsoy.mywaifulist;

import android.app.Application;
import android.content.Context;

import es.edufdezsoy.mywaifulist.data.dao.WaifuOpenHelper;

public class WaifuApplication extends Application {
    public static final String TAG = "EDUFDEZSOY"; // for debug propouses
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