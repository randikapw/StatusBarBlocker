package statusbarblocker;

public class UnsupportedApiException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6485518248400110047L;
	private static String message = "The opertaon is not supported for current API Versoin. current API version: "+ android.os.Build.VERSION.SDK_INT;
	public UnsupportedApiException(String detailMessage) {
		super(detailMessage);
	}
	
	public UnsupportedApiException() {
		super(message);
	}
	
}
