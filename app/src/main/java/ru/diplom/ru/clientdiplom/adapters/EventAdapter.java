package ru.diplom.ru.clientdiplom.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ru.diplom.ru.clientdiplom.R;
import ru.diplom.ru.clientdiplom.entity.Event;

/**
 * Created by 1 on 18.02.2017.
 */

public class EventAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Event> objects;

    public EventAdapter(Context context, ArrayList<Event> events) {
        ctx = context;
        objects = events;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view==null){
            view = lInflater.inflate(R.layout.item,parent,false);
        }
        Event tempEvent = getEvent(position);
        ((TextView)view.findViewById(R.id.event)).setText(tempEvent.getName());
        return view;
    }

    Event getEvent(int position){
        return (Event) getItem(position);
    }
}
