package com.example.a16022916.learn2code.Home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.a16022916.learn2code.R;

import java.util.ArrayList;

public class HomeCustomAdapter extends ArrayAdapter<HomeItem> {

    private ArrayList<HomeItem> item;
    private Context context;
    private TextView tvName, tvLesson, tvDesc;

    public HomeCustomAdapter(Context context, int resource, ArrayList<HomeItem> object) {
        super(context, resource, object);

        this.item = object;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.home_row, parent, false);

        HomeItem currentItem = item.get(position);

        tvName = rowView.findViewById(R.id.homeTvName);
        tvLesson = rowView.findViewById(R.id.homeTvLesson);
        tvDesc = rowView.findViewById(R.id.homeTvDesc);

        tvName.setText(currentItem.getName());
        tvLesson.setText(String.valueOf(currentItem.getLesson()));
        tvDesc.setText(currentItem.getDesc());

        return rowView;

    }
}
