package es.edufdezsoy.mywaifulist;

import android.app.Application;
import android.content.Context;

import es.edufdezsoy.mywaifulist.data.dao.WaifuOpenHelper;

public class WaifuApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        WaifuOpenHelper.getInstance().openDatabase();
    }

    public static Context getContext() {
        return context;
    }
}