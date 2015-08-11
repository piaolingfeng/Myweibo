package com.myweibo.adapter;

import java.util.List;
import java.util.Map;

import com.myweibo.activity.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RbsearchGridviewAdapter extends BaseAdapter {
	
	private List<Map<String,Object>> list;
	private Context context;
	private ViewHolder vh;
	
	public RbsearchGridviewAdapter(Context context,List<Map<String,Object>> list){
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
	public View getView(int arg0, View converView, ViewGroup arg2) {
		if(converView == null){
			vh = new ViewHolder();
			converView = LayoutInflater.from(context).inflate(R.layout.rb_search_gridview_item, null);
			vh.iv = (ImageView) converView.findViewById(R.id.rb_search_gridview_iv);
			vh.tv = (TextView) converView.findViewById(R.id.rb_search_gridview_tv);
			
			converView.setTag(vh);
		} else {
			vh = (ViewHolder) converView.getTag();
		}
		
		Map<String,Object> map = list.get(arg0);
		vh.iv.setImageBitmap((Bitmap) map.get("bitmap"));
		vh.tv.setText((CharSequence) map.get("text"));
		
		return converView;
	}
	
	
	private class ViewHolder{
		ImageView iv;
		TextView tv;
	}

}
