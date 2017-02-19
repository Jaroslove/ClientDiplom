package ru.diplom.ru.clientdiplom.db;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import ru.diplom.ru.clientdiplom.entity.Event;

public class AddUserTask extends AsyncTask<String,String,String> {
    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection httpURLConnection = null;

        try {
            URL url = new URL(params[0]);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpURLConnection != null)
                httpURLConnection.disconnect();
        }
        return null;

    }
}
