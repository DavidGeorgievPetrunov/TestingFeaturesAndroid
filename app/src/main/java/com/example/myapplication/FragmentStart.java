package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentStart#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentStart extends Fragment {

    private ListView listview;
    private ArrayList<String> names;
    private ArrayList<Fragment> fragments;

    public FragmentStart() {
    }

    public static FragmentStart newInstance() {
        return new FragmentStart();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);

        ListView listView = view.findViewById(R.id.listView);

        addNamesToList(listView);

        return view;
    }

    private void addNamesToList(ListView listview) {
        names = new ArrayList<String>();
        names.add("Radio Group");
        names.add("Weight Testing");
        names.add("Overlap");
        names.add("Scroll");
        names.add("Relative Layour and URL navigation");
        names.add("Dialog");

        fragments = new ArrayList<Fragment>();
        fragments.add(RadioGroupFragment.newInstance());
        fragments.add(FragmentWeight.newInstance());
        fragments.add(FragmentOverlap.newInstance());
        fragments.add(FragmentScroll.newInstance());
        fragments.add(FragmentRelativeAndUrlNavigation.newInstance());
        fragments.add(FragmentDialog.newInstance());

        MyAdapter myAdapter = new MyAdapter(getContext(), R.layout.list_item, names, fragments);
        listview.setAdapter(myAdapter);
    }

}