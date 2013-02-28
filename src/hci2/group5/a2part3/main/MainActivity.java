package hci2.group5.a2part3.main;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		CanvasView canvasView = new CanvasView(getApplicationContext());
		setContentView(canvasView);
	}

}
