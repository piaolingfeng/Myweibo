package com.myweibo.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myweibo.activity.R;
import com.myweibo.adapter.RbhomeListAdapter.ViewHold;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

public class RbhomeDrawerlayoutAdapter extends BaseAdapter {
	
	private List<Map<String,String>> list;
	
	private Context context;

	
	public RbhomeDrawerlayoutAdapter(List<Map<String,String>> list,Context context){
		this.context = context;
		this.list = list;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View convertView, ViewGroup arg2) {
		
		ViewHold hold = null;
		if(convertView!=null){
			hold = (ViewHold) convertView.getTag();
		} else {
			hold = new ViewHold();
			convertView = LayoutInflater.from(context).inflate(R.layout.rb_home_drawerlayout_listview, null);
			hold.listview_content = (TextView) convertView.findViewById(R.id.rb_home_drawerlayout_listview_tv);
			convertView.setTag(hold);
		}
		
		Map<String,String> contentMap = list.get(arg0);
		hold.listview_content.setText(contentMap.get("content"));
		
		return convertView;
	}
	
	static class ViewHold {
		TextView listview_content;
	}

}
