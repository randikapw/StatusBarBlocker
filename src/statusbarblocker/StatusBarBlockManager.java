package statusbarblocker;

import android.content.ContextWrapper;


public class StatusBarBlockManager {
	public static StatusBarHider createStatusBarHider(ContextWrapper contextWrapper) throws UnsupportedApiException{
		return new StatusBarHider(contextWrapper);
	}
}
