package com.myweibo.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.myweibo.activity.R;
import com.myweibo.adapter.RbhomeListAdapter;
import com.myweibo.util.RefreshableView;
import com.myweibo.util.RefreshableView.PullToRefreshListener;

@SuppressLint("ValidFragment")
public class RbhomeFragment extends Fragment {

	private ListView content;

	private Context context;
	// 模拟数据
	private List<Map<String, String>> contents;

	private RefreshableView refreshableView;

	public RbhomeFragment(Context context) {
		this.context = context;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.rb_home_listview, null);
		content = (ListView) view.findViewById(R.id.login_rbhome_lv);
	
		contents = getDatas();
	
		RbhomeListAdapter adapter = new RbhomeListAdapter(contents, context);
		content.setAdapter(adapter);

		refreshableView = (RefreshableView) view
				.findViewById(R.id.rb_home_refreshable_view);
		refreshableView.setOnRefreshListener(new PullToRefreshListener() {
			@Override
			public void onRefresh() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				refreshableView.finishRefreshing();
			}
		}, 0);

		return view;
	}

	private List<Map<String, String>> getDatas() {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		for (int i = 1; i <= 20; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("title", "内容标题" + i);
			map.put("reflashtime", i + "分钟前");
			map.put("content", "山东省就够了撒就到了关键爱上了结果的了解了解再联系空间老公受打击了国家森林噶就了解到公司啦");
			list.add(map);
		}

		return list;
	}

}
