package com.example.a16022916.learn2code.Custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.a16022916.learn2code.R;

import java.util.ArrayList;

public class CustomCustomAdapter extends ArrayAdapter<CustomItem> {

    private ArrayList<CustomItem> item;
    private Context context;
    private TextView tvName, tvNickName;

    public CustomCustomAdapter(Context context, int resource, ArrayList<CustomItem> object) {
        super(context, resource, object);

        this.item = object;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.custom_row, parent, false);

        CustomItem customItem = item.get(position);

        tvName = rowView.findViewById(R.id.customTvName);
        tvNickName = rowView.findViewById(R.id.customTvNickName);

        tvName.setText(customItem.getName());
        tvNickName.setText(customItem.getNickname());

        return rowView;

    }


}
