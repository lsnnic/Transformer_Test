package com.example.lsnnic.transformertest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lsnnic.transformertest.fragment.TabFragment;
import com.example.lsnnic.transformertest.transformer.RotateScaleTransformer;
import com.example.lsnnic.transformertest.transformer.RotateTransformer;
import com.example.lsnnic.transformertest.transformer.ScaleTransformer;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    private int[] resIds = new int[]{
            R.drawable.page_1,
            R.drawable.page_2,
            R.drawable.page_3,
            R.drawable.page_4,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);

        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                TabFragment tabFragment = TabFragment.newInstance(resIds[i]);
                return tabFragment;
            }

            @Override
            public int getCount() {
                return resIds.length;
            }
        });

        viewPager.setPageMargin(70);
        viewPager.setPageTransformer(true,new RotateScaleTransformer());

    }
}
