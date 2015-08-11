package com.myweibo.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.myweibo.activity.R;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public class HorizontalListViewAdapter extends BaseAdapter {
	
	private Context context;
	private List<Map<String,Object>> list;
	private ViewHolder vh;

	public HorizontalListViewAdapter(Context context,List<Map<String,Object>> list){
		this.context = context;
		this.list = list;
	}
	
	private static class ViewHolder {
		private Button bt;
	}
	
	@Override
	public int getCount() {
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
		if(convertView == null){
			vh = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(R.layout.rb_search_layout_listview_item, null);
			vh.bt = (Button) convertView.findViewById(R.id.rb_search_listview_ib);
			convertView.setTag(vh);
		} else {
			vh = (ViewHolder) convertView.getTag();
		}
		Map<String,Object> map = new HashMap<String, Object>();
		map = list.get(arg0);
//		vh.bt.setBackground((Drawable) map.get("db"));
		vh.bt.setCompoundDrawablesWithIntrinsicBounds(null, (Drawable) map.get("db"), null, null);
		vh.bt.setText((CharSequence) map.get("text"));
		
		return convertView;
	}

}
