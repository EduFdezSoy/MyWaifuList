package es.edufdezsoy.mywaifulist.ui.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.R;
import es.edufdezsoy.mywaifulist.adapter.WaifuAdapter;
import es.edufdezsoy.mywaifulist.data.model.Waifu;

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
    }

    @Override
    public void onLoaded(ArrayList<Waifu> waifus) {
        adapter.clear();
        adapter.addAll(waifus);
        adapter.notifyDataSetChanged();
    }
}
