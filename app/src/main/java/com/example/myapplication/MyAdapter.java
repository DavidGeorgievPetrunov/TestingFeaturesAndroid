package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<String> names;
    private ArrayList<Fragment> fragments;

    public MyAdapter(Context context, int layout, ArrayList<String> names, ArrayList<Fragment> fragments) {
        this.context = context;
        this.layout = layout;
        this.names = names;
        this.fragments = fragments;
    }

    @Override
    public int getCount() {
        return this.names.size();
    }

    @Override
    public Object getItem(int position) {
        return this.names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position; // Fixed the parameter name here
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        View v = layoutInflater.inflate(R.layout.list_item, null);

        if (position >= 0 && position < fragments.size()) {
            final String currentName = names.get(position);
            final Fragment currentFragment = fragments.get(position);

            if (currentFragment != null) {
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (context instanceof MainActivity) {
                            ((MainActivity) context).loadFragment(currentFragment);
                        }
                        Toast.makeText(context, "Clicked: " + currentName, Toast.LENGTH_SHORT).show();
                    }
                });

                TextView textView = v.findViewById(R.id.textView5);
                textView.setText(currentName);
            }
        }
        return v;
    }

}
