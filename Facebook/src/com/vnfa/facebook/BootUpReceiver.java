package com.vnfa.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootUpReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		
//		Log.i("o", ""+intent);
		String realPath= Applist.getPackage(context);
//		Defi.isDone=true;
		String mpackage= intent.getDataString().substring(8);
		if(realPath.contains(mpackage)){
			
			Intent LaunchIntent = context.getPackageManager().getLaunchIntentForPackage(mpackage);
			context.startActivity( LaunchIntent );
		}
		
	}

}
