package es.edufdezsoy.mywaifulist.ui.waifuList;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.R;
import es.edufdezsoy.mywaifulist.adapter.WaifuAdapter;
import es.edufdezsoy.mywaifulist.data.model.Waifu;
import es.edufdezsoy.mywaifulist.ui.animeList.AnimeListActivity;
import es.edufdezsoy.mywaifulist.ui.waifuForm.WaifuFormActivity;
import es.edufdezsoy.mywaifulist.ui.waifuView.WaifuActivity;

public class WaifuListActivity extends AppCompatActivity implements WaifuListContract.View {
    private WaifuListContract.Presenter presenter;
    private RecyclerView recyclerView;
    private FloatingActionButton addButton;
    private WaifuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waifu_list);
        presenter = new WaifuListPresenter(this);
        adapter = new WaifuAdapter(this);
        addButton = findViewById(R.id.floatingActionButton);
        addButton.setOnClickListener(v -> onAddButtonClick());
        recyclerView = findViewById(R.id.recycler_waifu);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setOnClickListener(v -> seeWaifuClick(v));
        recyclerView.setAdapter(adapter);
        presenter.loadList();

        adapter.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                WaifuListActivity.this.goToAnimeList();
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

    private void onAddButtonClick() {
        Intent intent = new Intent(this, WaifuFormActivity.class);
        startActivity(intent);
    }
    private void onEditClick(View v) {
        Intent intent = new Intent(this, WaifuFormActivity.class);
        Waifu waifu = adapter.getItem(recyclerView.getChildAdapterPosition(v));
        intent.putExtra(Waifu.TAG, waifu);
        startActivity(intent);
    }

    private void seeWaifuClick(View v) {
        Intent intent = new Intent(this, WaifuActivity.class);
        Waifu waifu = adapter.getItem(recyclerView.getChildAdapterPosition(v));
        intent.putExtra(Waifu.TAG, waifu);
        startActivity(intent);
    }
}
