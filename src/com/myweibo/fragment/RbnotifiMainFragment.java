package com.myweibo.fragment;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.myweibo.activity.R;
import com.myweibo.adapter.MyRbnotifiPagerAdapter;

@SuppressLint("ValidFragment")
public class RbnotifiMainFragment extends Fragment {
	
	private List<Fragment> fragments;
	private Context context;
	private FragmentManager fm;
	private ViewPager pager;
	private PagerAdapter adapter;
	private RadioGroup rg;
	private RadioButton rbme,rbcomment,rbprivate;
	
	public RbnotifiMainFragment(FragmentManager fm, Context context) {
		this.context = context;
		this.fm = fm;
	}
	
	private void initData(){
		fragments = new ArrayList<Fragment>();
		Fragment me = new RbnotifiMeFragment(context);
		Fragment comment = new RbnotifiCommentFragment();
		Fragment privatel = new RbnotifiPrivateFragment();
		fragments.add(me);
		fragments.add(comment);
		fragments.add(privatel);
		adapter = new MyRbnotifiPagerAdapter(fm, fragments);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.rb_notifi_main_viewpager, null);
		initData();
		pager = (ViewPager) view.findViewById(R.id.rb_notifi_viewpager1);
		pager.setAdapter(adapter);
		rg = (RadioGroup) view.findViewById(R.id.rb_notifi_rg);
		rbme = (RadioButton) view.findViewById(R.id.rb_notifi_me);
		rbcomment = (RadioButton) view.findViewById(R.id.rb_notifi_comment1);
		rbprivate = (RadioButton) view.findViewById(R.id.rb_notifi_private);
		
		pager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				
				switch (arg0) {
				case 0:
					rbme.setChecked(true);
					break;
				case 1:
					rbcomment.setChecked(true);
					break;
				case 2:
					rbprivate.setChecked(true);
					break;

				default:
					break;
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				if(arg1 == rbme.getId()){
					pager.setCurrentItem(0);
				} else if(arg1 == rbcomment.getId()){
					pager.setCurrentItem(1);
				} else if(arg1 == rbprivate.getId()){
					pager.setCurrentItem(2);
				}
			}
		});
		
		return view;
	}
}
