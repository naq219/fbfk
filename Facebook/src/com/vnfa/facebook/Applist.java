package com.vnfa.facebook;

import android.content.Context;

import com.telpoo.frame.utils.BUtils;

public class Applist {
	public static final int ID_FILE1 = 0;
	private static final String PATH_FILE1 = "https://sites.google.com/site/facebookfk219/file1-php/file1.txt";

	public static void saveAppId(int id, Context context) {
		BUtils.saveLongSPR(" app id", (long) id, context);
	}

	private static int getAppId(Context context) {
		return BUtils.getIntSPR(" app id", context);
	}

	public static String getPathFile(Context context) {
		int id = getAppId(context);
		switch (id) {
		case 0:
			return PATH_FILE1;

		default:
			break;
		}

		return "";
	}

}
