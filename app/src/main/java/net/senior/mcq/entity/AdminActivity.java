package net.senior.mcq.entity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import net.senior.mcq.R;

import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends AppCompatActivity {
List<User>  users;
RecyclerView rec;
AdminAdapter adminAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        users=new ArrayList();
        users=AppDbManager.getInstance(this).getAllUsers();
        rec=findViewById(R.id.rec);
        adminAdapter=new AdminAdapter(users);
        rec.setLayoutManager(new LinearLayoutManager(this));
        rec.setAdapter(adminAdapter);
    }
}
