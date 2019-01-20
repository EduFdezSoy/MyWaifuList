package es.edufdezsoy.mywaifulist.data.repository;

import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.data.model.Waifu;

/**
 * singleton to store our waifus
 */
public class WaifuRepository {
    private ArrayList<Waifu> waifus;
    private static WaifuRepository waifuRepository;

    private WaifuRepository() {
        waifus = new ArrayList<>();
    }

    public static WaifuRepository getInstance() {
        if (waifuRepository == null)
            waifuRepository = new WaifuRepository();

        return waifuRepository;
    }

    public void add(Waifu waifu) {
        waifus.add(waifu);
    }

    public void remove(Waifu waifu) {
        waifus.remove(waifu);
    }

    public void addAll(ArrayList<Waifu> waifus) {
        this.waifus.addAll(waifus);
    }

    public Waifu get(int i) {
        return waifus.get(i);
    }

    public ArrayList<Waifu> getAll() {
        return waifus;
    }
}