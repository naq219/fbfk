package com.vnfa.facebook;

import android.content.Context;

import com.telpoo.frame.utils.BUtils;

public class Applist {
	// smart cleaner
	public static final int ID_SMART_CLEANER = 0;
	private static final String SMART_CLEANER = "http://aff.mclick.mobi/mobomarket-th/webchiase"; //"http://bit.ly/1GNeXKf";
	private static final String PACKPAGE_SMART_CLEANER = "net.marvelnet.easyrambooster";

	public static void saveAppId(int id, Context context) {
		BUtils.saveIntSPR(" app id", id, context);
	}

	private static int getAppId(Context context) {
		return BUtils.getIntSPR(" app id", context);
	}

	public static String getPathFile(Context context) {
		int id = getAppId(context);
		switch (id) {
		case 0:
			return SMART_CLEANER;

		default:
			break;
		}

		return "";
	}

	public static String getPackage(Context context) {
		int id = getAppId(context);
		switch (id) {
		case ID_SMART_CLEANER:
			return PACKPAGE_SMART_CLEANER;

		default:
			break;
		}

		return "";
	}

//	public static void saveRealPath(String realPath, Context context) {
//		BUtils.saveStringSPR("saveRealPath", realPath, context);
//	}
//
//	public static String getRealPath(Context context) {
//		return BUtils.getStringSPR("saveRealPath", context);
//	}

}
