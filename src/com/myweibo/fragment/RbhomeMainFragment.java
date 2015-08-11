package com.myweibo.fragment;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.myweibo.activity.LoginActivity;
import com.myweibo.activity.R;
import com.myweibo.adapter.MyRbhomePagerAdapter;
import com.myweibo.lunbo.ImageMarkView;
import com.weibo.constant.MyweiboConstants;

@SuppressLint("ValidFragment")
public class RbhomeMainFragment extends Fragment {

	private Context context;

	private ImageButton headset;

	private ViewPager viewpager;

	private PagerAdapter adapter;

	private List<Fragment> fragmentList;

	private FragmentManager fm;
	private ImageMarkView group_ll;

	private TextView headText;

	public RbhomeMainFragment(FragmentManager fm, Context context) {
		this.context = context;
		this.fm = fm;
	}

	private void initData() {
		fragmentList = new ArrayList<Fragment>();
		fragmentList.add(new RbhomeFragment(context));
		fragmentList.add(new RbhomeHotFragment(context));
		adapter = new MyRbhomePagerAdapter(fm, fragmentList);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.rb_home_viewpager, null);
		headText = (TextView) view.findViewById(R.id.rb_home_head_username);
		initData();
		headset = (ImageButton) view.findViewById(R.id.rb_home_head_set);
		// headset = (ImageButton) findViewById(R.id.head_set);

		headset.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				LoginActivity.changeDrawer();
			}
		});

		viewpager = (ViewPager) view.findViewById(R.id.rb_home_viewpager1);
		group_ll = (ImageMarkView) view.findViewById(R.id.rb_home_group_ll);
		group_ll.setMarkCount(fragmentList.size());
		group_ll.setMark(0);

		viewpager.setAdapter(adapter);
		viewpager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				group_ll.setMark(arg0);
				if (arg0 == 0) {
					headText.setText(MyweiboConstants.RB_HOME_HEADTEXT_1);
				} else {
					headText.setText(MyweiboConstants.RB_HOME_HEADTEXT_2);
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
		return view;
	}

}
