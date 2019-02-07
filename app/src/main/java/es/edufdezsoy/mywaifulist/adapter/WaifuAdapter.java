package es.edufdezsoy.mywaifulist.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.os.ConfigurationCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import es.edufdezsoy.mywaifulist.R;
import es.edufdezsoy.mywaifulist.data.model.Waifu;

public class WaifuAdapter extends RecyclerView.Adapter<WaifuAdapter.ViewHolder> {
    private ArrayList<Waifu> waifus;
    private Context context;
    private View.OnClickListener listener;
    private View.OnLongClickListener longListener;
    private SimpleDateFormat dateFormat;

    public WaifuAdapter(Context context) {
        this.context = context;
        waifus = new ArrayList<>();
        dateFormat = new SimpleDateFormat("dd MMMM", ConfigurationCompat.getLocales(context.getResources().getConfiguration()).get(0));
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public void setOnLongClickListener(View.OnLongClickListener listener) {
        this.longListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.item_waifu, viewGroup, false);

        v.setOnClickListener(listener);
        v.setOnLongClickListener(longListener);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Waifu waifu = waifus.get(i);

        viewHolder.image.setImageResource(R.drawable.waifu); // TODO: image assign

        if (waifu.getNickname().isEmpty()) {
            viewHolder.line1.setText(waifu.getName() + " " + waifu.getSurname());
            viewHolder.line2.setText(dateFormat.format(waifu.getBirthday()));
        } else {
            viewHolder.line1.setText(waifu.getNickname());
            viewHolder.line2.setText(waifu.getName() + " " + waifu.getSurname() + ", " + dateFormat.format(waifu.getBirthday()));
        }
    }

    @Override
    public int getItemCount() {
        return waifus.size();
    }

    public Waifu getItem(int i) {
        return waifus.get(i);
    }

    public void addAll(ArrayList<Waifu> waifus) {
        this.waifus.addAll(waifus);
    }

    public void clear() {
        waifus.clear();
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
