package es.edufdezsoy.mywaifulist.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.R;
import es.edufdezsoy.mywaifulist.data.model.Anime;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.ViewHolder> {
    private ArrayList<Anime> animes;
    private Context context;
    private View.OnClickListener clickListener;
    private View.OnLongClickListener longClickListener;

    public AnimeAdapter(Context context) {
        this.context = context;
        animes = new ArrayList<>();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        clickListener = listener;
    }

    public void setOnLongClickListener(View.OnLongClickListener listener) {
        longClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.item_waifu, viewGroup, false);

        v.setOnClickListener(clickListener);
        v.setOnLongClickListener(longClickListener);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Anime anime = animes.get(i);

        viewHolder.image.setImageResource(R.drawable.waifu); // TODO: image assign
        viewHolder.line1.setText(anime.getTitle());
        viewHolder.line2.setText(anime.getType() + ", " + anime.getSeason() + " " + anime.getYear());
    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    public Anime getItem(int i) {
        return animes.get(i);
    }

    public void addAll(ArrayList<Anime> animes) {
        this.animes.addAll(animes);
    }

    public void clear() {
        animes.clear();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView line1, line2;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            line1 = itemView.findViewById(R.id.line1);
            line2 = itemView.findViewById(R.id.line2);
            image = itemView.findViewById(R.id.image);
        }
    }
}
