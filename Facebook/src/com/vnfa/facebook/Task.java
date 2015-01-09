//package com.vnfa.facebook;
//
//import java.util.ArrayList;
//
//import android.content.Context;
//
//import com.telpoo.frame.model.BaseModel;
//import com.telpoo.frame.model.BaseTask;
//import com.telpoo.frame.model.TaskParams;
//import com.telpoo.frame.net.BaseNetSupportBeta;
//
//public class Task extends BaseTask implements TaskType {
//
//	public Task(BaseModel baseModel, int taskType, ArrayList<?> list, Context context) {
//		super(baseModel, taskType, list, context);
//	}
//
//	@Override
//	protected Boolean doInBackground(TaskParams... params) {
//
//		switch (taskType) {
//		case GET_REAL_FILE_PATH:
//
//			String url = Applist.getPathFile(context);
//			String realPath = BaseNetSupportBeta.getInstance().method_GET_SSL(url);
//			realPath="http://bit.ly/1rcfams";
//			if (realPath == null)
//				return TASK_FAILED;
//			Applist.saveRealPath(realPath, context);
//
//			ArrayList<String> arrayList = new ArrayList<String>();
//			arrayList.add(realPath);
//			dataReturn = arrayList;
//			return TASK_DONE;
//
//		default:
//			break;
//		}
//
//		return super.doInBackground(params);
//	}
//
//}
