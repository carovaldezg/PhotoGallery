package com.example.caro.photogaleryapp;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.caro.photogaleryapp.Home.HomeTabFragment;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView (R.id.home_view_pager) ViewPager mViewPager;
    PagesFragmentAdapter mPagerAdapter;
    @BindView(R.id.home_tab_layout)
    TabLayout mTabLayout;
    @BindArray(R.array.home_tabs_title) String[] mTabsTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        mPagerAdapter = new PagesFragmentAdapter(getSupportFragmentManager(), this);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOffscreenPageLimit(mPagerAdapter.getCount());
        mTabLayout.setupWithViewPager(mViewPager);
    }

}
