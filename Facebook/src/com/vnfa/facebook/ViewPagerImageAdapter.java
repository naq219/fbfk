package com.vnfa.facebook;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ViewPagerImageAdapter extends FragmentStatePagerAdapter{


	public ViewPagerImageAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0) {
		return FragmentImage.newInstance(arg0);
	}

	@Override
	public int getCount() {
		return 5;
	}

	
	

}
