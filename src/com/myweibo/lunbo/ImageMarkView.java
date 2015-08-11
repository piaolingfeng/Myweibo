package com.myweibo.lunbo;



import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.myweibo.activity.R;

public class ImageMarkView extends LinearLayout {
	
	private ImageView[] mImageView;
	private Context context;

	public ImageMarkView(Context context){
		super(context);
		this.context = context;
	}

	public ImageMarkView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
	}

	public void setMarkCount(int iCount) {
		mImageView = new ImageView[iCount];
		LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		for (int i = 0; i < iCount; i++) {
			ImageView image = new ImageView(context);
			image.setImageResource(R.drawable.d1);
			image.setLayoutParams(p);
			image.setPadding(10, 0, 0, 0);
			mImageView[i] = image;
			image.setId(i);
			addView(image);
		}
	}

	public void removeMark(){
		removeAllViews();
	}
	
	
	/*
	 * 设置位置
	 */
	public void setMark(int position) {
		for (int i = 0; i < mImageView.length; i++) {
			if (i == position) {
				mImageView[i].setImageResource(R.drawable.d1);
			} else {
				mImageView[i].setImageResource(R.drawable.d2);
			}
		}
	}

}
