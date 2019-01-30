package es.edufdezsoy.mywaifulist.ui.waifuView;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import es.edufdezsoy.mywaifulist.MyWaifuListApplication;
import es.edufdezsoy.mywaifulist.R;
import es.edufdezsoy.mywaifulist.data.model.Waifu;
import es.edufdezsoy.mywaifulist.ui.waifuList.WaifuListActivity;

public class WaifuActivity extends AppCompatActivity implements WaifuContract.View {
    private ImageView image;
    private TextView name, surname, nickname, birthday, anime;
    private Waifu waifu;
    private WaifuContract.Presenter presenter;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waifu_form);

        presenter = new WaifuPresenter(this);

        image = findViewById(R.id.imageView);
        name = findViewById(R.id.textViewName);
        surname = findViewById(R.id.textViewSurname);
        nickname = findViewById(R.id.textViewNickname);
        birthday = findViewById(R.id.textViewBirthday);
        anime = findViewById(R.id.textViewAnime);

        if ((waifu = (Waifu) getIntent().getSerializableExtra(Waifu.TAG)) != null) {

            name.setText(waifu.getName());
            surname.setText(waifu.getSurname());
            nickname.setText(waifu.getNickname());
            birthday.setText(dateFormat.format(waifu.getBirthday()));
        }

        // TODO: add a menu with an edit option
    }
}
