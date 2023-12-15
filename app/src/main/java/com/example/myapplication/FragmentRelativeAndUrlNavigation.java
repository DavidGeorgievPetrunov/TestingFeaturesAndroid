package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class FragmentRelativeAndUrlNavigation extends Fragment {

    private EditText urlEditText;
    private Button okButton;

    public FragmentRelativeAndUrlNavigation() {
        // Required empty public constructor
    }

    public static FragmentRelativeAndUrlNavigation newInstance() {
        return new FragmentRelativeAndUrlNavigation();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_relative, container, false);

        urlEditText = view.findViewById(R.id.entry);
        okButton = view.findViewById(R.id.ok);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl();
            }
        });

        return view;
    }

    private void openUrl() {
        String url = urlEditText.getText().toString().trim();
        if (!url.isEmpty()) {
            // Check if the URL starts with a scheme (e.g., http:// or https://)
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                // If not, assume http://
                url = "http://" + url;
            }

            // Create an Intent to open the URL in a browser
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        }
    }
}
