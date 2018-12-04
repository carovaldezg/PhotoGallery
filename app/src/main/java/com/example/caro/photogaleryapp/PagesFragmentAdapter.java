package com.example.caro.photogaleryapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.caro.photogaleryapp.Home.HomeTabFragment;
import com.example.caro.photogaleryapp.Profile.ProfileFragment;
import com.example.caro.photogaleryapp.about.AboutFragment;

public class PagesFragmentAdapter  extends FragmentPagerAdapter {

    private Fragment[] mTabFragments;
    private String[] mTabTitles;

    public PagesFragmentAdapter(FragmentManager fm, Context context ) {
        super(fm);
        mTabFragments = getFragments();
        mTabTitles = context.getResources().getStringArray(tabTitlesArrayRes());
    }

    @Override
    public Fragment getItem(int position) {
        if (position >= 0 && position < mTabFragments.length)
            return mTabFragments[position];

        return null;
    }

    @Override
    public int getCount() {
        return mTabFragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return mTabTitles[position];
    }

    protected int tabTitlesArrayRes() {
        return R.array.home_tabs_title;
    }

    @NonNull
    protected Fragment[] getFragments() {
        return new Fragment[]{new HomeTabFragment(), new ProfileFragment(), new AboutFragment()};
    }

}