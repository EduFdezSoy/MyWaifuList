package es.edufdezsoy.mywaifulist.ui.list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.R;
import es.edufdezsoy.mywaifulist.adapter.WaifuAdapter;
import es.edufdezsoy.mywaifulist.data.model.Waifu;
import es.edufdezsoy.mywaifulist.ui.AnimeList.AnimeListActivity;

public class ListActivity extends AppCompatActivity implements ListContract.View {
    private ListContract.Presenter presenter;
    private RecyclerView recyclerView;
    private WaifuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        presenter = new ListPresenter(this);
        adapter = new WaifuAdapter(this);
        recyclerView = findViewById(R.id.recycler_waifu);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        presenter.loadList();

        adapter.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ListActivity.this.goToAnimeList();
                return true;
            }
        });
    }

    private void goToAnimeList(){
        startActivity(new Intent(this, AnimeListActivity.class));
    }

    @Override
    public void onLoaded(ArrayList<Waifu> waifus) {
        adapter.clear();
        adapter.addAll(waifus);
        adapter.notifyDataSetChanged();
    }
}
