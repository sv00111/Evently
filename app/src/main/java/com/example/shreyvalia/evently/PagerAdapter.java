package com.example.shreyvalia.evently;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {

        Fragment frag=null;
        switch (position){
            case 0:
                frag=new HotFragment();
                break;
            case 1:
                frag=new RecentFragment();
                break;
            case 2:
                frag=new selfFragment();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        String title=" ";
        switch (position){
            case 0:
                title="Hot";
                break;
            case 1:
                title="New";
                break;
            case 2:
                title="Own";
                break;
        }

        return title;
    }

}
