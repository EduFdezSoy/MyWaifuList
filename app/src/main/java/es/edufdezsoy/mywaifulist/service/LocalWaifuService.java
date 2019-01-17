package es.edufdezsoy.mywaifulist.service;

import android.os.AsyncTask;

import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.data.model.Waifu;

/**
 * singleton
 * saves and loads the favs waifus to local storage
 */
public class LocalWaifuService {
    interface OnLoadListener {
        void onLoadSuccess(ArrayList<Waifu> waifus);
        void onLoadFailure();
    }

    /**
     * saves the favourites waifus to the internal memory
     *
     * @param waifus
     */
    static void saveFavsWaifus(ArrayList<Waifu> waifus) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                return null;
            }
        };
    }

    /**
     * loads the favourites waifus from the internal memory
     *
     * @param listener
     */
    static void loadFavsWaifus(final OnLoadListener listener) {
        new AsyncTask<Void, Void, ArrayList<Waifu>>() {
            @Override
            protected ArrayList<Waifu> doInBackground(Void... voids) {
                return null;
            }

            @Override
            protected void onPostExecute(ArrayList<Waifu> waifus) {
                if (waifus.isEmpty())
                    listener.onLoadFailure();
                else
                    listener.onLoadSuccess(waifus);
            }

            @Override
            protected void onCancelled() {
                listener.onLoadFailure();
            }
        };
    }
}
