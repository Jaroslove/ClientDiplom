package ru.diplom.ru.clientdiplom.db;

import android.os.AsyncTask;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import ru.diplom.ru.clientdiplom.MainActivity;
import ru.diplom.ru.clientdiplom.R;
import ru.diplom.ru.clientdiplom.entity.Event;


public class JsonTask extends AsyncTask<String, Object, List<Event>> {
    List<Event> list;
    MainActivity mainActivity;
    public void link(MainActivity activity){
        mainActivity = activity;
    }
    void unlink(){
        mainActivity=null;
    }
    @Override
    protected List<Event> doInBackground(String... params) {
        HttpURLConnection httpURLConnection = null;

        BufferedReader bufferedReader = null;

        try {
            URL url = new URL(params[0]);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder bilder = new StringBuilder();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                bilder.append(line);
            }

            list = new Gson().fromJson(bilder.toString(), new TypeToken<List<Event>>() {
            }.getType());
            return list;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (httpURLConnection != null)
                httpURLConnection.disconnect();
        }
        return null;
    }
    
    protected void onPostExecute(List<Event> s) {
        super.onPostExecute(s);
        TextView textView = (TextView) mainActivity.findViewById(R.id.txtHelper);
        textView.setText(s.toString());
    }
}
