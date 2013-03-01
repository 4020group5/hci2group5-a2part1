package hci2.group5.a2part3.config;

import hci2.group5.a2part3.util.PixelDpConverter;
import android.content.Context;
import android.graphics.Color;

public class ColorPaletteConfig {
	
	public static int[] COLORS = {Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.MAGENTA, Color.YELLOW};
	
	private static final int UNIT_LENGTH_IN_DP = 100;
	// to be calculated in first activity is created
	public static int UNIT_LENGTH_IN_PX;

	public static void init(Context context) {
		if (UNIT_LENGTH_IN_PX == 0) {
			UNIT_LENGTH_IN_PX = (int) PixelDpConverter.dpToPx(UNIT_LENGTH_IN_DP, context);
		}
	}
}
