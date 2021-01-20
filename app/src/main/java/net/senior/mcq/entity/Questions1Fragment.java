package net.senior.mcq.entity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.senior.mcq.R;

public class Questions1Fragment extends Fragment {


    TextView quesNo,question;
    Questions ques;
    CheckBox choice1;
    CheckBox choice2;
    CheckBox choice3;
    CheckBox choice4;
    public static boolean flag;
    int id;
    Button next;
    public Questions1Fragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
flag=false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (container == null) {
            return null;
        }

        CardView linearLayout = (CardView ) inflater.inflate(R.layout.fragment_questions, container, false);



        quesNo=linearLayout.findViewById(R.id.questoinNo);
        question=linearLayout.findViewById(R.id.questoin);
        choice1=linearLayout.findViewById(R.id.choice1);
        choice2=linearLayout.findViewById(R.id.choice2);
        choice3=linearLayout.findViewById(R.id.choice3);
        choice4=linearLayout.findViewById(R.id.choice4);
        next=linearLayout.findViewById(R.id.next);

if(StartActivity.id==0)
{StartActivity.id=1;}

        ques=AppDbManager.getInstance(getContext()).selectQueById(StartActivity.id);


        quesNo.setText("Q "+StartActivity.id);

        question.setText(ques.getText());
        choice1.setText(AppDbManager.getInstance(getContext()).selectById(1).getText());
        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!choice4.isChecked() && choice1.isChecked() && !choice2.isChecked() && choice3.isChecked())
                {
                    MainActivity.counter++;
flag=true;
                }
            }
        });
        choice2.setText(AppDbManager.getInstance(getContext()).selectById(2).getText());
        choice3.setText(AppDbManager.getInstance(getContext()).selectById(11).getText());
        choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!choice4.isChecked() && choice1.isChecked() && !choice2.isChecked() && choice3.isChecked())
                {
                    MainActivity.counter++;
flag=true;
                }

            }
        });
        choice4.setText(AppDbManager.getInstance(getContext()).selectById(4).getText());

        return linearLayout;
    }




}




