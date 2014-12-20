package com.vnfa.facebook;

import java.io.File;
import java.util.ArrayList;

import android.app.DownloadManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.Button;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

import com.telpoo.frame.net.BaseNetSupportBeta;
import com.telpoo.frame.net.NetConfig;
import com.telpoo.frame.ui.BaseFragmentActivity;

public class MainActivity extends BaseFragmentActivity implements TaskType {
	AutoScrollViewPager pager;
	ViewPagerImageAdapter adapter;
	private Button _btn1, _btn2, _btn3, _btn4, _btn5;
	MainActivity me;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		me = MainActivity.this;
		initApp();
		initButton();
		new Task(model, GET_REAL_FILE_PATH, null, me).exe();
		
	}

	private void initApp() {
		Applist.saveAppId(Applist.ID_FILE1, MainActivity.this);
		BaseNetSupportBeta.getInstance().init(new NetConfig.Builder().numberRetry(3).build());
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
	
	@Override
	public void onSuccess(int taskType, ArrayList<?> list, String msg) {
		super.onSuccess(taskType, list, msg);
		String realUrl=(String) list.get(0);

		File direct = new File(Environment.getExternalStorageDirectory()
				+ "/temp");

		if (!direct.exists()) {
			direct.mkdirs();
		}
		
		DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
		DownloadManager.Request request = new DownloadManager.Request(
				Uri.parse(realUrl));
		
		request.setDestinationInExternalPublicDir("/temp", "test219.tmp");
		dm.enqueue(request);
		
	}
	
	@Override
	public void onFail(int taskType, String msg) {
		switch (taskType) {
		case GET_REAL_FILE_PATH:
			showToast("Have an error, please try again later!");
			finish();
			break;

		default:
			break;
		}
		super.onFail(taskType, msg);
	}

}
