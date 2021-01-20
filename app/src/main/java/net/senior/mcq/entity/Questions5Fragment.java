package net.senior.mcq.entity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import net.senior.mcq.R;

public class Questions5Fragment extends Fragment {


    TextView quesNo,question;
    Questions ques;
    CheckBox choice1;
    CheckBox choice2;
    CheckBox choice3;
    CheckBox choice4;
    int id;
    Button next;
    public Questions5Fragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        choice2.setText(AppDbManager.getInstance(getContext()).selectById(9).getText());
        choice3.setText(AppDbManager.getInstance(getActivity()).selectById(5).getText());
        choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(choice4.isChecked() && !choice1.isChecked() && !choice2.isChecked() && choice3.isChecked())
                {
                    MainActivity.counter++;
                    Questions1Fragment.flag=true;

                }
            }
        });
        choice4.setText(AppDbManager.getInstance(getActivity()).selectById(13).getText());
        choice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(choice4.isChecked() && !choice1.isChecked() && !choice2.isChecked() && choice3.isChecked())
                {
                    MainActivity.counter++;
                    Questions1Fragment.flag=true;

                }
            }
        });

        return linearLayout;
    }




    }




