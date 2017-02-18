package ru.diplom.ru.clientdiplom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ru.diplom.ru.clientdiplom.db.JsonTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JsonTask jsonTask = new JsonTask();
        jsonTask.link(this);
        jsonTask.execute("http://192.168.56.1:8080/api?method=getAllEvents");
    }
}
