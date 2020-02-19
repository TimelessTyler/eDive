package com.example.edives.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class VpAuditAdapter extends FragmentStatePagerAdapter {
    private final FragmentManager fm;
    private final ArrayList<Fragment> fs;

    public VpAuditAdapter(FragmentManager fm, ArrayList<Fragment> fs) {
        super(fm);
        this.fm = fm;
        this.fs = fs;
    }

    @Override
    public Fragment getItem(int i) {
        return fs.get(i);
    }

    @Override
    public int getCount() {
        return fs.size();
    }
}
