package dars17.corvo.example.com.muximduolar.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import dars17.corvo.example.com.muximduolar.db.ItemDB;
import dars17.corvo.example.com.muximduolar.fragments.AllSpells;
import dars17.corvo.example.com.muximduolar.fragments.LovedSpells;

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm){
        super(fm);
    }
    @Override    public Fragment getItem(int position) {
        switch (position){
            case 0: return new AllSpells();
            case 1: return new LovedSpells();
        }
        return null;
    }
    @Override
    public int getCount() {
        return 2;
    }
    @Override    public CharSequence getPageTitle(int position) {
        switch (position){
        case 0: return "Barcha duolar";
        case 1: return "Sevimlilar";
        default: return null;
    }
    }
}
