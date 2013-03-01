package hci2.group5.a2part3.config;

import hci2.group5.a2part3.util.PixelDpConverter;
import android.content.Context;

public class PointConfig {

	private static final Float TWO_POINTS_ROUGHLY_THE_SAME_VALUE_IN_DP = Float.valueOf(50f);
	// to be calculated in first activity is created
	public static Float TWO_POINTS_ROUGHLY_THE_SAME_VALUE_IN_PX;
	
	public static void init(Context context) {
		if (TWO_POINTS_ROUGHLY_THE_SAME_VALUE_IN_PX == null) {
			TWO_POINTS_ROUGHLY_THE_SAME_VALUE_IN_PX = PixelDpConverter.dpToPx(TWO_POINTS_ROUGHLY_THE_SAME_VALUE_IN_DP, context);
		}
	}
}
