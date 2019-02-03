package com.slobodsky.nick.fragmentwithrecyclerview;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    final List<Fragment> listFragment = new ArrayList<>();

    final List<String> listTitles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {

        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        return listFragment.get(i);
    }

    @Override
    public int getCount() {

        return listTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        return listTitles.get(position);
    }

    public void addFragment(Fragment fragment, String title)
    {
        listFragment.add(fragment);

        listTitles.add(title);
    }
}
