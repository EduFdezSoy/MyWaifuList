package es.edufdezsoy.mywaifulist.ui.list;

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
import es.edufdezsoy.mywaifulist.ui.form.FormActivity;

public class ListActivity extends AppCompatActivity implements ListContract.View {
    private ListContract.Presenter presenter;
    private RecyclerView recyclerView;
    private FloatingActionButton addButton;
    private WaifuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        presenter = new ListPresenter(this);
        adapter = new WaifuAdapter(this);
        addButton = findViewById(R.id.floatingActionButton);
        addButton.setOnClickListener(v -> onAddButtonClick());
        recyclerView = findViewById(R.id.recycler_waifu);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setOnClickListener(v -> onEditClick(v));
        recyclerView.setAdapter(adapter);
        presenter.loadList();
    }

    @Override
    public void onLoaded(ArrayList<Waifu> waifus) {
        adapter.clear();
        adapter.addAll(waifus);
        adapter.notifyDataSetChanged();
    }

    private void onAddButtonClick() {
        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);
    }
    private void onEditClick(View v) {
        Intent intent = new Intent(this, FormActivity.class);
        Waifu waifu = adapter.getItem(recyclerView.getChildAdapterPosition(v));
        intent.putExtra(Waifu.TAG, waifu);
        startActivity(intent);
    }
}
