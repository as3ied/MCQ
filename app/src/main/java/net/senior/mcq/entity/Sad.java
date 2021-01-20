package net.senior.mcq.entity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

import net.senior.mcq.R;

public class Sad extends AppCompatActivity {
MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sad);
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.loser);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
player.stop();   finish();             }
            });
        }

        player.start();
    }
}
