package com.example.tomriddle.intfair;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.tomriddle.intfair.fragment.RecyclerViewFragment;
import com.example.tomriddle.intfair.fragment.ScrollFragment;
import com.example.tomriddle.intfair.fragment.ScrollFragmentThree;
import com.example.tomriddle.intfair.fragment.ScrollTwoFragment;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;


public class MainActivity extends DrawerActivity {

    private MaterialViewPager mViewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("");

        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);

        toolbar = mViewPager.getToolbar();

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position % 4) {
                    case 0:
                        return ScrollFragment.newInstance();
                    case 1:
                        return ScrollTwoFragment.newInstance();
                    case 2:
                        return ScrollFragmentThree.newInstance();
                    default:
                        return RecyclerViewFragment.newInstance();
                }
            }

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 4) {
                    case 0:
                        return "The Fair";
                    case 1:
                        return "Registration";
                    case 2:
                        return "The Team";
                    case 3:
                        return "Companies";
                }
                return "";
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndDrawable(
                            R.color.spclcolor,
                            getResources().getDrawable(R.drawable.back));
                    case 1:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.spclcolor,
                                getResources().getDrawable(R.drawable.back));
                    case 2:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.spclcolor,
                                getResources().getDrawable(R.drawable.back));
                    case 3:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.spclcolor,
                                getResources().getDrawable(R.drawable.back));
                }

                //execute others actions if needed (ex : modify your header logo)



                return null;
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        View logo = findViewById(R.id.logo_white);
        if (logo != null) {
            logo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.notifyHeaderChanged();
                    Toast.makeText(getApplicationContext(), "Yes, the title is clickable", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
