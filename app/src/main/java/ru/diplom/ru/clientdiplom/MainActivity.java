package ru.diplom.ru.clientdiplom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import ru.diplom.ru.clientdiplom.db.JsonTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnAdd = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = (Button)findViewById(R.id.btnAddEvent);
        btnAdd.setOnClickListener(this);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        JsonTask jsonTask = new JsonTask();
        jsonTask.link(this);
        jsonTask.execute("http://192.168.0.14:8080/api?method=getAllEvents");
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(),"sd",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,AddFormActivity.class);
        startActivity(intent);
    }
}
