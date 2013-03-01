package hci2.group5.a2part3.util;

import android.content.Context;

public class PixelDpConverter {

	public static float pxToDp(float px, Context context) {
		return px / context.getResources().getDisplayMetrics().density;
	}

	public static float dpToPx(float dp, Context context) {
		return dp * context.getResources().getDisplayMetrics().density;
	}
}
