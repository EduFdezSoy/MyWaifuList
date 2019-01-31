package es.edufdezsoy.mywaifulist.data.repository;

import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.data.dao.WaifuDao;
import es.edufdezsoy.mywaifulist.data.model.Waifu;

/**
 * singleton to store our waifus
 */
public class WaifuRepository {
    private ArrayList<Waifu> waifus;
    private int page;
    private static WaifuRepository waifuRepository;
    private WaifuDao dao;

    private WaifuRepository() {
        waifus = new ArrayList<>();
        dao = new WaifuDao();
    }

    public static WaifuRepository getInstance() {
        if (waifuRepository == null)
            waifuRepository = new WaifuRepository();

        return waifuRepository;
    }

    public void add(Waifu waifu) {
        dao.add(waifu);
    }

    public void remove(Waifu waifu) {
        waifus.remove(waifu);
    }

    public void addAll(ArrayList<Waifu> waifus) {
        this.waifus.addAll(waifus);
    }

    public Waifu get(int i) {
        return dao.get(i);
    }

    public Waifu get(String name, String surname) {
        return dao.get(1);
        // return dao.get(name, surname);
    }

    public ArrayList<Waifu> getAll() {
        return dao.getAll();
    }
}