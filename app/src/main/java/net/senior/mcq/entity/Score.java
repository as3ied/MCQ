package net.senior.mcq.entity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import net.senior.mcq.R;

public class Score extends AppCompatActivity {
TextView score,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        score=findViewById(R.id.score);
        result=findViewById(R.id.result);
        score.append(""+MainActivity.counter);
        User u=AppDbManager.getInstance(this).selectQueById(MainActivity.username,MainActivity.password);
        u.setScore(MainActivity.counter);
        AppDbManager.getInstance(this).update(u);
        if(MainActivity.counter>=5){

            result.setText("Succeeded ..");
        }else
        {
            result.setText("Failed ..");

        }
    }

    public void tryAgain(View view) {
        MainActivity.counter=0;
        startActivity(new Intent(Score.this,StartActivity.class));
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
