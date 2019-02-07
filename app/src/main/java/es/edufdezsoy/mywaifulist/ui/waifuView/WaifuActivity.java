package es.edufdezsoy.mywaifulist.ui.waifuView;

import android.os.Bundle;
import android.support.v4.os.ConfigurationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

import es.edufdezsoy.mywaifulist.R;
import es.edufdezsoy.mywaifulist.data.model.Waifu;

public class WaifuActivity extends AppCompatActivity implements WaifuContract.View {
    private ImageView image;
    private TextView name, surname, nickname, birthday, anime;
    private TextView nameTag, nicknameTag, birthdayTag, animeTag;
    private WaifuContract.Presenter presenter;
    SimpleDateFormat dateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waifu_view);

        presenter = new WaifuPresenter(this);
        dateFormat = new SimpleDateFormat("d MMMM", ConfigurationCompat.getLocales(getResources().getConfiguration()).get(0));

        image = findViewById(R.id.imageView);
        name = findViewById(R.id.textViewName);
        surname = findViewById(R.id.textViewSurname);
        nickname = findViewById(R.id.textViewNickname);
        birthday = findViewById(R.id.textViewBirthday);
        anime = findViewById(R.id.textViewAnime);

        nameTag = findViewById(R.id.textViewNameNSurnameTag);
        nicknameTag = findViewById(R.id.textViewAKATag);
        birthdayTag = findViewById(R.id.textViewBirthdayTag);
        animeTag = findViewById(R.id.textViewAnimeTag);
        Waifu wa;
        if ((wa = (Waifu) getIntent().getSerializableExtra(Waifu.TAG)) != null)
            presenter.loadWaifuByName(wa.getName(), wa.getSurname());
        // TODO: add a menu with an edit option
    }

    @Override
    public void onWaifuLoaded(Waifu waifu) {
        name.setText(waifu.getName());
        surname.setText(waifu.getSurname());
        nickname.setText(waifu.getNickname());
        birthday.setText(dateFormat.format(waifu.getBirthday()));
        anime.setText(waifu.getAnime().getTitle());

        if (nickname.getText().toString().isEmpty())
        {
            nicknameTag.setVisibility(View.GONE);
            nickname.setVisibility(View.GONE);
        }
    }
}
