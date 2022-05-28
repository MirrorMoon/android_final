package com.leafmaple.androidtraining.ui.video.detail;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leafmaple.androidtraining.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class VideoIntroFragment extends Fragment {


    private final String intro;

    public VideoIntroFragment(String intro) {
        this.intro = intro;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_video_intro, container, false);
        TextView textView = root.findViewById(R.id.textView);
        textView.setText(intro);
        return root;
    }
}