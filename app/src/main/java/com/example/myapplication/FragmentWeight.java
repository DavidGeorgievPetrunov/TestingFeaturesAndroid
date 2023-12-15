package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class FragmentWeight extends Fragment {

    private View view1;
    private View view2;
    private View view3;

    public FragmentWeight() {
        // Required empty public constructor
    }

    public static FragmentWeight newInstance() {
        return new FragmentWeight();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weight, container, false);

        view1 = view.findViewById(R.id.view);
        view2 = view.findViewById(R.id.view2);
        view3 = view.findViewById(R.id.view3);

        EditText editText1 = view.findViewById(R.id.editText1);
        EditText editText2 = view.findViewById(R.id.editText2);
        EditText editText3 = view.findViewById(R.id.editText3);

        setupTextWatcher(editText1, view1);
        setupTextWatcher(editText2, view2);
        setupTextWatcher(editText3, view3);

        return view;
    }

    private void setupTextWatcher(final EditText editText, final View targetView) {
        if (editText != null && targetView != null) {
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void afterTextChanged(Editable editable) {
                    handleTextChange(editable.toString(), targetView);
                }
            });
        }
    }

    private void handleTextChange(String newText, View targetView) {
        try {
            int weight = Integer.parseInt(newText);
            setWeight(targetView, weight);
        } catch (NumberFormatException e) {
            newText = "0";
        }
    }
    private void setWeight(View view, int weight) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view.getLayoutParams();
        params.weight = weight;
        view.setLayoutParams(params);
    }
}
