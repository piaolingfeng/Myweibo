package com.myweibo.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.myweibo.activity.LoginActivity;
import com.myweibo.activity.PersonSettingsActivity;
import com.myweibo.activity.R;

@SuppressLint("ValidFragment")
public class RbpersonMainFragment extends Fragment {
	
	private Context context;
	private FragmentManager fm;
	private ImageButton settings;
	
	public RbpersonMainFragment(FragmentManager fm, Context context) {
		this.context = context;
		this.fm = fm;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.rb_person_listview, null);
		
		settings = (ImageButton) view.findViewById(R.id.rb_person_head_settings);
		settings.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, PersonSettingsActivity.class);
				startActivity(intent);
			}
		});
		
		return view;
	}
	
}
