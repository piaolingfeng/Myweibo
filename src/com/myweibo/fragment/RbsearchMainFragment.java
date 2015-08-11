package com.myweibo.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.myweibo.activity.R;
import com.myweibo.adapter.HorizontalListViewAdapter;
import com.myweibo.adapter.RbsearchGridviewAdapter;
import com.myweibo.listview.HorizontalListView;

@SuppressLint("ValidFragment")
public class RbsearchMainFragment extends Fragment {
	
	private Context context;
	private FragmentManager fm;
	
	private HorizontalListView hlv;
	private HorizontalListViewAdapter adapter;
	
	private GridView gv;
	private RbsearchGridviewAdapter gvAdapter;
	
	public RbsearchMainFragment(FragmentManager fm, Context context) {
		this.context = context;
		this.fm = fm;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.rb_search_layout, null);
		hlv = (HorizontalListView) view.findViewById(R.id.horizontallistview1);
		adapter = new HorizontalListViewAdapter(context, getDatas());
		adapter.notifyDataSetChanged();
		hlv.setAdapter(adapter);
		
		gv = (GridView) view.findViewById(R.id.rb_search_gridview);
		gvAdapter = new RbsearchGridviewAdapter(context, getGvData());
		gvAdapter.notifyDataSetChanged();
		gv.setAdapter(gvAdapter);
		
		return view;
	}
	
	private List<Map<String,Object>> getGvData(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("bitmap", BitmapFactory.decodeResource(getResources(), R.drawable.snow21));
		map.put("text", "RMB");
		list.add(map);
		
		Map<String,Object> map2 = new HashMap<String, Object>();
		map2.put("bitmap", BitmapFactory.decodeResource(getResources(), R.drawable.snow22));
		map2.put("text", "USD");
		list.add(map2);
		
		Map<String,Object> map3 = new HashMap<String, Object>();
		map3.put("bitmap", BitmapFactory.decodeResource(getResources(), R.drawable.snow23));
		map3.put("text", "IDN");
		list.add(map3);
		
		Map<String,Object> map4 = new HashMap<String, Object>();
		map4.put("bitmap", BitmapFactory.decodeResource(getResources(), R.drawable.snow24));
		map4.put("text", "IDN");
		list.add(map4);
		
		Map<String,Object> map5 = new HashMap<String, Object>();
		map5.put("bitmap", BitmapFactory.decodeResource(getResources(), R.drawable.channel_add_button));
		map5.put("text", "更多");
		list.add(map5);
		
		return list;
	}
	
	private List<Map<String,Object>> getDatas(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("text", "黄家驹");
		map.put("db", getResources().getDrawable(R.drawable.cam_paster_1));
		list.add(map);
		Map<String,Object> map1 = new HashMap<String, Object>();
		map1.put("text", "张星彩");
		map1.put("db", getResources().getDrawable(R.drawable.cam_paster_2));
		list.add(map1);
		Map<String,Object> map2 = new HashMap<String, Object>();
		map2.put("text", "陈琳");
		map2.put("db", getResources().getDrawable(R.drawable.cam_paster_3));
		list.add(map2);
		Map<String,Object> map3 = new HashMap<String, Object>();
		map3.put("text", "veggieg");
		map3.put("db", getResources().getDrawable(R.drawable.cam_paster_4));
		list.add(map3);
		list.add(map3);
		list.add(map3);
		list.add(map3);
		list.add(map3);
		list.add(map3);
		list.add(map3);
		list.add(map3);
		list.add(map3);
		list.add(map3);
		list.add(map3);
		list.add(map3);
		list.add(map3);
		list.add(map3);
		list.add(map3);
		return list;
	}
	
}
