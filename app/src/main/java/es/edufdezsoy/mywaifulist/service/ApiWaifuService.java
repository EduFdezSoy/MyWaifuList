package es.edufdezsoy.mywaifulist.service;

import android.os.AsyncTask;

import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.data.model.Waifu;

/**
 * Singleton
 * calls the api and update the repository
 */
public class ApiWaifuService {
    interface OnApiInteractLisneter {
        void onGetWaifusSuccess(ArrayList<Waifu> waifus);
        void onGetWaifusFailure();
    }

    static void getWaifus(final OnApiInteractLisneter lisneter) {
        new AsyncTask<Void, Void, ArrayList<Waifu>>() {
            @Override
            protected ArrayList<Waifu> doInBackground(Void... voids) {
                return null;
            }

            @Override
            protected void onPostExecute(ArrayList<Waifu> waifus) {
                if (waifus.isEmpty())
                    lisneter.onGetWaifusFailure();
                else
                    lisneter.onGetWaifusSuccess(waifus);
            }

            @Override
            protected void onCancelled() {
                lisneter.onGetWaifusFailure();
            }
        };
    }

    static void putWaifu(Waifu waifu) {
        new AsyncTask<Waifu, Void, Void>() {
            @Override
            protected Void doInBackground(Waifu... waifus) {
                return null;
            }
        };
    }
}
