package net.senior.mcq.entity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import net.senior.mcq.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView name,pass;
    List<Questions> questions;
    List<Answer> answers;
public static int counter;
public static String username ,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        pass = findViewById(R.id.password);
        questions = new ArrayList();
        answers = new ArrayList();

        questions=AppDbManager.getInstance(this).getAllQues();
        answers=AppDbManager.getInstance(this).getAll();
        if(questions.size()==0 ) {
            for (int i = 1; i <=10; i++) {
                Questions q = new Questions(i, "question " + i);
                questions.add(q);
                AppDbManager.getInstance(this).insert(q);

            }
        }

        if(answers.size()==0 ) {

            for (int j = 1; j <=15; j++) {
                Answer a = new Answer(j, "Ans " + j);
                answers.add(a);
                AppDbManager.getInstance(this).insert(a);

            }
        }



    }


    public void start(View view) {
        if(!name.getText().toString().isEmpty())
        {username=name.getText().toString();
        password=pass.getText().toString();


        }


        else
        {
            Toast.makeText(this, "You must enter username and password", Toast.LENGTH_SHORT).show();
            return;
        }
        if(MainActivity.username.equalsIgnoreCase("admin")&&MainActivity.password.equalsIgnoreCase("admin")){
            startActivity(new Intent(this,AdminActivity.class));
        }else {
User user=new User(MainActivity.username,MainActivity.password);
        AppDbManager.getInstance(this).insert(user);

        Intent m = new Intent(this, StartActivity.class);
        startActivity(m);
    }}


}
