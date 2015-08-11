package com.myweibo.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PersonSettingsActivity extends FragmentActivity {
	
	private Button back;
	
	private TextView quit;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		
		setContentView(R.layout.rb_person_settings);
		back = (Button) findViewById(R.id.rb_person_settings_back);
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
		
		quit = (TextView) findViewById(R.id.rb_person_settings_quit);
		quit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				onBackPressed();
			}
		});
		
	}
	
	
	public void onBackPressed() { 
        new AlertDialog.Builder(this).setTitle("确认退出吗？") 
            .setIcon(android.R.drawable.ic_dialog_info) 
            .setPositiveButton("确定", new DialogInterface.OnClickListener() { 
         
                @Override 
                public void onClick(DialogInterface dialog, int which) { 
                // 点击“确认”后的操作 
                	finish();
                } 
            }) 
            .setNegativeButton("返回", new DialogInterface.OnClickListener() { 
         
                @Override 
                public void onClick(DialogInterface dialog, int which) { 
                // 点击“返回”后的操作,这里不设置没有任何操作 
                } 
            }).show(); 
           }
}
