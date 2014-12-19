package com.vnfa.facebook;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragmentImage extends Fragment{
	//private ArrayList<Drawable> mDrawables;
	private int[] mImageIds = {R.drawable.screen1, R.drawable.screen2, R.drawable.screen3, R.drawable.screen4, R.drawable.screen5};
	private ImageView mImageView;
	private static final String LINK_IMAGE = "LINK_IMAGE";
	public static FragmentImage newInstance(int position){
		FragmentImage fragmentImage = new FragmentImage();
		Bundle bundle = new Bundle();
		bundle.putInt(LINK_IMAGE, position);
		fragmentImage.setArguments(bundle);
		return fragmentImage;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		int position = getArguments().getInt(LINK_IMAGE);
		View rootView = inflater.inflate(R.layout.fragment_image_details, container, false);		
		mImageView = (ImageView) rootView.findViewById(R.id.fragment_image_details_image);
		mImageView.setImageResource(mImageIds[position]);
		return rootView;
	}
}
