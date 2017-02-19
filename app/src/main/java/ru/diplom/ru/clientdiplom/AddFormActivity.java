package ru.diplom.ru.clientdiplom;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ru.diplom.ru.clientdiplom.db.AddUserTask;

public class AddFormActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        AddUserTask addUserTask = new AddUserTask();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://192.168.0.14:8080/api?method=insertNewEvent&name=");
        stringBuilder.append(editText.getText().toString());
        stringBuilder.append("&idUser=4");
        addUserTask.execute(stringBuilder.toString());
        Toast.makeText(getApplicationContext(),stringBuilder.toString(),Toast.LENGTH_SHORT).show();
    }

    TextView textView = null;
    EditText editText = null;
    Button button = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_form);
        editText = (EditText)findViewById(R.id.etxName);
        textView = (TextView)findViewById(R.id.addLabel);
        button = (Button)findViewById(R.id.addBtEventForm);
        button.setOnClickListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
