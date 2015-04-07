package statusbarblocker;

import java.lang.reflect.Method;

import android.content.ContextWrapper;
import android.util.Log;

public class StatusBarHider {

	Method collapse;
	Object service;
	protected StatusBarHider(ContextWrapper contextWrapper) throws UnsupportedApiException{
		try {
			service = contextWrapper.getSystemService("statusbar");
			Class<?> statusbarManager = Class.forName("android.app.StatusBarManager");
			int currentApiVersion = android.os.Build.VERSION.SDK_INT;
			Log.i("@@@@ SDK version :", ""+currentApiVersion);
			if (currentApiVersion <= 16) {
				collapse = statusbarManager.getMethod("collapse");
				collapse.invoke(service);
			} else {
				collapse = statusbarManager.getMethod("collapsePanels");
				collapse.invoke(service);
			}
//			Log.i("@@@@ Throw new exception :", "Throw new exception maually");
//			throw new Exception();
		} catch (Exception ex) {
			throw new UnsupportedApiException();
		}
	}
	
	public void collapseStatusBar() throws UnsupportedApiException{
		try {
			collapse.invoke(service);
		} catch (Exception ex) {
			throw new UnsupportedApiException();
		}
	}

}
