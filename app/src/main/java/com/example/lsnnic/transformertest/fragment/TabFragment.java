package com.example.lsnnic.transformertest.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lsnnic.transformertest.R;

public class TabFragment extends Fragment {

    private ImageView imageView;

    private static final String BUNDLE_KEY_IMG = "bundle_key_img";

    private int resId;

    public static TabFragment newInstance(int resId){
        Bundle bundle = new Bundle();
        bundle.putInt(BUNDLE_KEY_IMG,resId);
        TabFragment fragment = new TabFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if(arguments!=null){
            resId = arguments.getInt(BUNDLE_KEY_IMG);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_view,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(resId);

        imageView.setTag(resId);
    }
}
