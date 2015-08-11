package com.myweibo.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.myweibo.activity.R;

public class RbnotifiListAdapter extends BaseAdapter {
	
	private List<Map<String,String>> contents;
	private Context context;
	

	public RbnotifiListAdapter(List<Map<String,String>> contents,Context context) {
		this.contents = contents;
		this.context = context;
	}
	
	
	@Override
	public int getCount() {
		return contents.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return contents.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View convertView, ViewGroup arg2) {
		ViewHold hold = null;
		
		if(arg0==0){
				convertView = LayoutInflater.from(context).inflate(R.layout.rb_notifi_head, null);
		} else {
		
				hold = new ViewHold();
				convertView = LayoutInflater.from(context).inflate(R.layout.listview, null);
				hold.listview_title = (TextView) convertView.findViewById(R.id.listview_title);
				hold.listview_reflashtime = (TextView) convertView.findViewById(R.id.listview_reflashtime);
				hold.listview_content = (TextView) convertView.findViewById(R.id.listview_content);
				convertView.setTag(hold);
			
			
			
			Map<String,String> contentMap = contents.get(arg0);
			hold.listview_title.setText(contentMap.get("title"));
			hold.listview_reflashtime.setText(contentMap.get("reflashtime"));
			hold.listview_content.setText(contentMap.get("content"));
			
		}
		
		return convertView;
	}
	
	static class ViewHold {
		ImageButton listview_head;
		TextView listview_title;
		TextView listview_reflashtime;
		TextView listview_content;
	}
	
}
