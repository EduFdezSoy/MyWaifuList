package es.edufdezsoy.mywaifulist.ui.animeList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.R;
import es.edufdezsoy.mywaifulist.adapter.AnimeAdapter;
import es.edufdezsoy.mywaifulist.data.model.Anime;

public class AnimeListActivity extends AppCompatActivity implements AnimeListContract.View {
    private AnimeListContract.Presenter presenter;
    private RecyclerView recyclerView;
    private AnimeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_list);
        presenter = new AnimeListPresenter(this);
        adapter = new AnimeAdapter(this);
        recyclerView = findViewById(R.id.recycler_anime);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        presenter.loadList();
    }

    @Override
    public void onLoaded(ArrayList<Anime> animes) {
        adapter.clear();
        adapter.addAll(animes);
        adapter.notifyDataSetChanged();
    }
}
