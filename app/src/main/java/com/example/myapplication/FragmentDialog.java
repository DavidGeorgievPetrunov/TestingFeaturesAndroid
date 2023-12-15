package com.example.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;

public class FragmentDialog extends Fragment {

    private ArrayList<String> selectedItems;
    public FragmentDialog() {
    }

    public static FragmentDialog newInstance() {
        return new FragmentDialog();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void showDialogButton(){
        selectedItems = new ArrayList<>();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.pick_toppings)
                .setMultiChoiceItems(R.array.toppings, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                String[] toppingsArray = getResources().getStringArray(R.array.toppings);

                                if (isChecked) {
                                    selectedItems.add(toppingsArray[which]);
                                } else if (selectedItems.contains(toppingsArray[which])) {
                                    selectedItems.remove(toppingsArray[which]);
                                }
                            }
                        })
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        TextView textView = requireView().findViewById(R.id.textViewAnswer);
                        if (!selectedItems.isEmpty()) {
                            StringBuilder stringBuilder = new StringBuilder();

                            for (int i = 0; i < selectedItems.size(); i++) {
                                String selected = selectedItems.get(i);
                                stringBuilder.append(selected);

                                // If there are more items, add a separator (e.g., a comma)
                                if (i < selectedItems.size() - 1) {
                                    stringBuilder.append(", ");
                                }
                            }

                            // Set the concatenated string to the textView
                            textView.setText(stringBuilder.toString());
                        } else {
                            // Handle the case where selectedItems is empty
                            textView.setText("No items selected");
                        }
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // Handle the cancel button click if needed
                    }
                });
        builder.create();
        builder.show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog, container, false);

        Button showDialogButton = view.findViewById(R.id.showdialog);
        showDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogButton();
            }
        });

        return view;
    }
}