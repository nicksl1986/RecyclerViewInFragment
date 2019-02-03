package com.slobodsky.nick.fragmentwithrecyclerview;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;

    ViewPager viewPager;

    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout_id);

        viewPager = findViewById(R.id.view_pager_id);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new CallFragment(), "");

        adapter.addFragment(new ContactFragment(), "");

        adapter.addFragment(new FavFragment(), "");

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_call);

        tabLayout.getTabAt(1).setIcon(R.drawable.ic_group);

        tabLayout.getTabAt(2).setIcon(R.drawable.ic_star);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setElevation(0);
    }
}
