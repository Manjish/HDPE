package com.fourthassignment.hdpecalculator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class TabbedActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        tabLayout = findViewById(R.id.tabId);
        viewPager = findViewById(R.id.view_pager);

        ViewPager_adapter adapter = new ViewPager_adapter(getSupportFragmentManager());

        adapter.addFragment(new Calculator(),"Calculator");
        adapter.addFragment(new ReverseConverter(),"Converter");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
