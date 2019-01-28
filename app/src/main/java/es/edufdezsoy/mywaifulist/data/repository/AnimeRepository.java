package es.edufdezsoy.mywaifulist.data.repository;

import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.data.dao.AnimeDao;
import es.edufdezsoy.mywaifulist.data.model.Anime;

/**
 * singleton to store the animes for our waifus
 */
public class AnimeRepository {
    private ArrayList<Anime> animes;
    private int page;
    private static AnimeRepository animeRepository;
    private AnimeDao dao;

    private AnimeRepository() {
        animes = new ArrayList<>();
        dao = new AnimeDao();
    }

    public static AnimeRepository getInstance() {
        if (animeRepository == null)
            animeRepository = new AnimeRepository();

        return animeRepository;
    }

    public void add(Anime anime) {
        dao.add(anime);
    }

    public void addAll(ArrayList<Anime> animes) {
        this.animes.addAll(animes);
    }

    public Anime get(int i) {
        return animes.get(i);
    }

    public ArrayList<Anime> getAll() {
        return dao.getAll();
    }
}
