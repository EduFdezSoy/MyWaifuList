package es.edufdezsoy.mywaifulist.ui.form;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import es.edufdezsoy.mywaifulist.R;
import es.edufdezsoy.mywaifulist.WaifuApplication;
import es.edufdezsoy.mywaifulist.data.model.Waifu;
import es.edufdezsoy.mywaifulist.ui.list.ListActivity;

public class FormActivity extends AppCompatActivity implements FormContract.View {
    private ImageView image;
    private TextInputEditText name, surname, nickname, birthday;
    private Button addButton;
    private Waifu originalWaifu;
    private FormContract.Presenter presenter;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        presenter = new FormPresenter(this);

        addButton = findViewById(R.id.buttonAdd);
        addButton.setOnClickListener(v -> onAddButtonClick());

        image = findViewById(R.id.imageView);
        name = findViewById(R.id.textInputEditTextName);
        surname = findViewById(R.id.textInputEditTextSurname);
        nickname = findViewById(R.id.textInputEditTextNickname);
        birthday = findViewById(R.id.textInputEditTextBirthday);

        if ((originalWaifu = (Waifu) getIntent().getSerializableExtra(Waifu.TAG)) != null) {

            name.setText(originalWaifu.getName());
            surname.setText(originalWaifu.getSurname());
            nickname.setText(originalWaifu.getNickname());
            birthday.setText(dateFormat.format(originalWaifu.getBirthday()));
        }
    }

    private void onAddButtonClick() {
        Waifu waifu = null;
        try {
            waifu = new Waifu(
                    name.getText().toString().trim(),
                    surname.getText().toString().trim(),
                    nickname.getText().toString().trim(),
                    dateFormat.parse(birthday.getText().toString())
            );
        } catch (ParseException e) {
            // TODO: refactor this A LOT
            Toast.makeText(this, "Data parse error", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        if (originalWaifu != null) {
            presenter.editWaifu(originalWaifu, waifu);
        } else {
            presenter.addWaifu(waifu);
        }
    }

    @Override
    public void onSucess() {
        Intent intent = new Intent(this, ListActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        buildNotification(getString(R.string.app_name), "Your Waifu was added!", pendingIntent);
    }

    @Override
    public void onFailure(int error) {
        Toast.makeText(this, ":(", Toast.LENGTH_SHORT).show();
    }

    /**
     * Create notification, for fun
     */
    public void buildNotification(String title, String text, PendingIntent intent) {
        // see for help: https://developer.android.com/training/notify-user/build-notification
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, WaifuApplication.NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_stat_waifu)
                .setContentTitle(title)
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(intent)
                .setAutoCancel(false);

        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, mBuilder.build());
    }
}
