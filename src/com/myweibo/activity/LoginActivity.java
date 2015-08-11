package com.myweibo.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.myweibo.adapter.RbhomeDrawerlayoutAdapter;
import com.myweibo.fragment.RbhomeMainFragment;
import com.myweibo.fragment.RbnotifiMainFragment;
import com.myweibo.fragment.RbnotifiMeFragment;
import com.myweibo.fragment.RbpersonMainFragment;
import com.myweibo.fragment.RbsearchMainFragment;

public class LoginActivity extends FragmentActivity {

	private ListView content;
	
	
	private ImageButton rb_home_drawerlayout_ib;
	private ListView rb_home_drawerlayout_lv;
	
	private static DrawerLayout mDrawerLayout;
	
	private RadioGroup radioGroup;
	
	private Fragment rbhomeMainFragment;
	private Fragment rbnotifiFragment;
	private Fragment rbsearchFragment;
	private Fragment rbpersonFragment;
	FragmentManager fm;
	FragmentTransaction ft;
	//模拟数据
	private List<Map<String,String>> contents;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		rbhomeMainFragment = new RbhomeMainFragment(getSupportFragmentManager(),this);
		rbnotifiFragment = new RbnotifiMainFragment(getSupportFragmentManager(),this);
		rbsearchFragment = new RbsearchMainFragment(getSupportFragmentManager(),this);
		rbpersonFragment = new RbpersonMainFragment(getSupportFragmentManager(),this);
		
		mDrawerLayout = (DrawerLayout) findViewById(R.id.rb_home_drawerlayout);
		
		
		radioGroup = (RadioGroup) findViewById(R.id.rb);
		rb_home_drawerlayout_ib = (ImageButton) findViewById(R.id.rb_home_drawerlayout_ib);
		rb_home_drawerlayout_lv = (ListView) findViewById(R.id.rb_home_drawerlayout_lv);
		RbhomeDrawerlayoutAdapter darwerlayoutAdapter = new RbhomeDrawerlayoutAdapter(getDatas(),this);
		rb_home_drawerlayout_lv.setAdapter(darwerlayoutAdapter);
		
		Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.headimage);
		rb_home_drawerlayout_ib.setImageBitmap(toRoundBitmap(bm));
		fm=getSupportFragmentManager();
		ft=fm.beginTransaction();
//		ft.replace(R.id.rb_home_fragment, rbhomeMainFragment).commit();
		ft.add(R.id.rb_home_fragment, rbhomeMainFragment);
		ft.add(R.id.rb_home_fragment, rbnotifiFragment);
		ft.add(R.id.rb_home_fragment, rbsearchFragment);
		ft.add(R.id.rb_home_fragment, rbpersonFragment);
		ft.show(rbhomeMainFragment);
		ft.hide(rbnotifiFragment);
		ft.hide(rbsearchFragment);
		ft.hide(rbpersonFragment);
		ft.commit();
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				switch (arg1) {
				case R.id.rb_home:
					ft=fm.beginTransaction();
					ft.hide(rbnotifiFragment);
					ft.hide(rbsearchFragment);
					ft.hide(rbpersonFragment);
					ft.show(rbhomeMainFragment);
					ft.commit();
//					ft.replace(R.id.rb_home_fragment, rbhomeMainFragment).commit();
//					contents = getDatas();
//					
//					MyListAdapter adapter = new MyListAdapter(contents,LoginActivity.this);
//					content.setAdapter(adapter);
					break;
				case R.id.rb_notifi:
//					ft.replace(R.id.rb_home_fragment, rbnotifiFragment).commit();
					ft=fm.beginTransaction();
					ft.hide(rbhomeMainFragment);
					ft.hide(rbpersonFragment);
					ft.hide(rbsearchFragment);
					ft.show(rbnotifiFragment);
					ft.commit();
					break;
				case R.id.rb_search:
					ft=fm.beginTransaction();
					ft.hide(rbhomeMainFragment);
					ft.hide(rbnotifiFragment);
					ft.hide(rbpersonFragment);
					ft.show(rbsearchFragment);
					ft.commit();
					
					break;
					
				case R.id.rb_person:
					
					ft=fm.beginTransaction();
					ft.hide(rbhomeMainFragment);
					ft.hide(rbnotifiFragment);
					ft.hide(rbsearchFragment);
					ft.show(rbpersonFragment);
					ft.commit();
					
					break;

				default:
					break;
				}
			}
		});
		
		
		
		
		rb_home_drawerlayout_lv.setOnItemClickListener(new OnItemClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int arg2,
					long arg3) {
				
//				Drawable drawable = getResources().getDrawable(R.drawable.ic_launcher);
//				
//				view.setBackground(drawable);
			}
		});
		
	}
	
//	private List<Map<String,String>> getDatas(){
//		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
//		
//		for(int i=1;i<=20;i++){
//			Map<String,String> map = new HashMap<String, String>();
//			map.put("title", "内容标题"+i);
//			map.put("reflashtime", i+"分钟前");
//			map.put("content", "山东省就够了撒就到了关键爱上了结果的了解了解再联系空间老公受打击了国家森林噶就了解到公司啦");
//			list.add(map);
//		}
//		
//		return list;
//	}
	
	
	public static void changeDrawer(){
		if (mDrawerLayout.isDrawerVisible(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
	}
	
	private List<Map<String,String>> getDatas(){
		List<Map<String,String>> mDatas = new ArrayList<Map<String,String>>();
		for(int i=0;i<11;i++){
			Map<String,String> map = new HashMap<String, String>();
			
			map.put("content", "test" + (i+1));
			
			mDatas.add(map);
		}
		
		return mDatas;
	}
	
	
	
	/**
	* 转换图片成圆形
	* @param bitmap 传入Bitmap对象
	* @return
	*/
	public Bitmap toRoundBitmap(Bitmap bitmap) {
	    int width = bitmap.getWidth();
	    int height = bitmap.getHeight();
	    float roundPx;
	    float left, top, right, bottom, dst_left, dst_top, dst_right, dst_bottom;
	    if (width <= height) {
	        roundPx = width / 2;
	        top = 0;
	        bottom = width;
	        left = 0;
	        right = width;
	        height = width;
	        dst_left = 0;
	        dst_top = 0;
	        dst_right = width;
	        dst_bottom = width;
	    } else {
	        roundPx = height / 2;
	        float clip = (width - height) / 2;
	        left = clip;
	        right = width - clip;
	        top = 0;
	        bottom = height;
	        width = height;
	        dst_left = 0;
	        dst_top = 0;
	        dst_right = height;
	        dst_bottom = height;
	    }
	    Bitmap output = Bitmap.createBitmap(width,
	                                        height, Config.ARGB_8888);
	    Canvas canvas = new Canvas(output);
	    final int color = 0xff424242;
	    final Paint paint = new Paint();
	    final Rect src = new Rect((int)left, (int)top, (int)right, (int)bottom);
	    final Rect dst = new Rect((int)dst_left, (int)dst_top, (int)dst_right, (int)dst_bottom);
	    final RectF rectF = new RectF(dst);
	    paint.setAntiAlias(true);
	    canvas.drawARGB(0, 0, 0, 0);
	    paint.setColor(color);
	    canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
	    paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
	    canvas.drawBitmap(bitmap, src, dst, paint);
	    return output;
	}
	
	
}
