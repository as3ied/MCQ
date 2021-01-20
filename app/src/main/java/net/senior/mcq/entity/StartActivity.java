package net.senior.mcq.entity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.senior.mcq.R;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends AppCompatActivity {
    public static int id;
    Button next, finish;
    TextView counter;
    ImageView scoreImg;
    Questions1Fragment questions1Fragment;
    MediaPlayer player;
    Random rand;
    int[] images = {R.drawable.h, R.drawable.a, R.drawable.p, R.drawable.y, R.drawable.happy};
    int[] imagesSad = {R.drawable.s, R.drawable.aa, R.drawable.d, R.drawable.dd, R.drawable.sad};
    View v;
    private boolean isCounterRunning;
    CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        counter = findViewById(R.id.counter);

        countDownTimer = new CountDownTimer(6000, 1000) {

            public void onTick(long millisUntilFinished) {
                counter.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                if (id < 10) {
                    next(v);
                } else {
                    finish(v);
                }

            }
        }.start();
        scoreImg = findViewById(R.id.score_img);
        rand = new Random();
        if (id == 0) {
            id = 1;
        }

        questions1Fragment = new Questions1Fragment();
        getSupportFragmentManager().beginTransaction().add(R.id.question_frame, questions1Fragment).commit();

        next = findViewById(R.id.next);
        finish = findViewById(R.id.finish);
        if (id == 10) {
            next.setVisibility(View.INVISIBLE);
            finish.setVisibility(View.VISIBLE);
        }
    }

    public void next(View view) {

        id = id + 1;
        if (Integer.parseInt(counter.getText().toString()) > 0) {
            countDownTimer.cancel();
        }

        if (Questions1Fragment.flag == true) {
            scoreImg.setImageResource(images[rand.nextInt(images.length)]);
            scoreImg.setVisibility(View.VISIBLE);
            player = MediaPlayer.create(this, R.raw.cheering);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    player.stop();
                }
            });
            player.start();
            next.setEnabled(false);
            Questions1Fragment.flag = false;

        } else {
            scoreImg.setImageResource(imagesSad[rand.nextInt(images.length)]);
            scoreImg.setVisibility(View.VISIBLE);
            player = MediaPlayer.create(this, R.raw.loser);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    player.stop();
                }
            });
            player.start();
            next.setEnabled(false);


        }


        Timer t = new Timer();

        t.schedule(new TimerTask() {


            @Override
            public void run() {
                scoreImg.setVisibility(View.INVISIBLE);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        next.setEnabled(true);

                        countDownTimer.start();
                    }
                });
                switch (id) {
                    case 1:

                        questions1Fragment = new Questions1Fragment();
                        getSupportFragmentManager().beginTransaction().add(R.id.question_frame, questions1Fragment).commit();
                        break;
                    case 2:
                        Questions2Fragment questions2Fragment = new Questions2Fragment();
                        getSupportFragmentManager().beginTransaction().add(R.id.question_frame, questions2Fragment).commit();
                        Questions1Fragment.flag = false;


                        break;
                    case 3:
                        Questions3Fragment questions3Fragment = new Questions3Fragment();
                        getSupportFragmentManager().beginTransaction().add(R.id.question_frame, questions3Fragment).commit();

                        break;
                    case 4:
                        Questions4Fragment questions4Fragment = new Questions4Fragment();
                        getSupportFragmentManager().beginTransaction().add(R.id.question_frame, questions4Fragment).commit();

                        break;
                    case 5:
                        Questions5Fragment questions5Fragment = new Questions5Fragment();
                        getSupportFragmentManager().beginTransaction().add(R.id.question_frame, questions5Fragment).commit();

                        break;
                    case 6:
                        Questions6Fragment questions6Fragment = new Questions6Fragment();
                        getSupportFragmentManager().beginTransaction().add(R.id.question_frame, questions6Fragment).commit();

                        break;
                    case 7:
                        Questions7Fragment questions7Fragment = new Questions7Fragment();
                        getSupportFragmentManager().beginTransaction().add(R.id.question_frame, questions7Fragment).commit();

                        break;
                    case 8:
                        Questions8Fragment questions8Fragment = new Questions8Fragment();
                        getSupportFragmentManager().beginTransaction().add(R.id.question_frame, questions8Fragment).commit();

                        break;
                    case 9:
                        Questions9Fragment questions9Fragment = new Questions9Fragment();
                        getSupportFragmentManager().beginTransaction().add(R.id.question_frame, questions9Fragment).commit();

                        break;
                    case 10:
                        Questions10Fragment questions10Fragment = new Questions10Fragment();
                        getSupportFragmentManager().beginTransaction().add(R.id.question_frame, questions10Fragment).commit();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                next.setVisibility(View.INVISIBLE);
                                finish.setVisibility(View.VISIBLE);

                            }


                        });

                        break;
                }

            }
        }, 2500);
    }


    public void finish(View view) {

        countDownTimer.cancel();

        if (Questions1Fragment.flag == true) {
            scoreImg.setImageResource(R.drawable.happy);
            scoreImg.setVisibility(View.VISIBLE);
            player = MediaPlayer.create(this, R.raw.cheering);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    player.stop();
                    countDownTimer.cancel();

                }
            });
            player.start();
//            next.setEnabled(false);
            Questions1Fragment.flag = false;
            countDownTimer.cancel();


        } else {
            scoreImg.setImageResource(R.drawable.sad);
            scoreImg.setVisibility(View.VISIBLE);
            player = MediaPlayer.create(this, R.raw.loser);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    player.stop();
                    countDownTimer.cancel();


                }
            });
            player.start();
//            next.setEnabled(false);


        }


        Timer t = new Timer();

        t.schedule(new TimerTask() {


            @Override
            public void run() {
                scoreImg.setVisibility(View.INVISIBLE);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        countDownTimer.cancel();
                        startActivity(new Intent(getApplicationContext(), Score.class));
                        id = 1;
                    }
                });


            }
        }, 2500);
    }


}


