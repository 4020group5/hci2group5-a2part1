package hci2.group5.a2part3.main;

import hci2.group5.a2part3.R;
import hci2.group5.a2part3.config.PaintFactory;
import hci2.group5.a2part3.config.PointConfig;
import hci2.group5.a2part3.recognize.RecognizingTypes;

import java.util.Hashtable;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	private Hashtable<String, ToggleButton> _toggleButtons;
	private CompoundButton _checkedButton;
	
	private CanvasView _canvasView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// this layout contain buttons and canvas view
		setContentView(R.layout.activity_main);

		setUpToggleButtons();

		// get canvas view
		_canvasView = (CanvasView) findViewById(R.id.canvasView);
		
		// set up fill color button
		Button fillColorButton = (Button) findViewById(R.id.fillColor);
		fillColorButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				PaintFactory.fillAllRecognizedShapesWithColor(Color.GREEN);
				_canvasView.invalidate();
			}
		});
		
		// set default to recognize rectangle
		_toggleButtons.get(RecognizingTypes.RECTANGLE.whatType()).setChecked(true);
		_canvasView.setRecognizing(RecognizingTypes.RECTANGLE);
		
		PointConfig.init(getApplicationContext());
	}

	private void setUpToggleButtons() {
		_toggleButtons = new Hashtable<String, ToggleButton>(4);
		
		// hash table with key that is tightly related to RecognizingTypes so that we can easily 
		// find the RecognizingTypes when user click a toggle button is checked
		_toggleButtons.put(RecognizingTypes.LINE.whatType(), (ToggleButton) findViewById(R.id.line));
		_toggleButtons.put(RecognizingTypes.CIRCLE.whatType(), (ToggleButton) findViewById(R.id.circle));
		_toggleButtons.put(RecognizingTypes.TRIANGLE.whatType(), (ToggleButton) findViewById(R.id.triangle));
		_toggleButtons.put(RecognizingTypes.RECTANGLE.whatType(), (ToggleButton) findViewById(R.id.rectangle));
		
		setToggleButtonsOnCheckListeners(_toggleButtons);
	}

	private void setToggleButtonsOnCheckListeners(final Hashtable<String, ToggleButton> toggleButtons) {
		for (ToggleButton toggleButton : toggleButtons.values()) {
			
			toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if (isChecked) {
						if (buttonView == _checkedButton) {
							// avoid listener call when user wants to uncheck the current one and
							// we call setChecked(true) that will call this method again...
							return;
						}
						
						_checkedButton = buttonView;
						
						// uncheck the checked one
						for (ToggleButton toggleButton : toggleButtons.values()) {
							if (toggleButton != buttonView && toggleButton.isChecked()) {
								toggleButton.toggle();
							}
						}
						
						recognizingShapedChangedByUser(buttonView);
					}
					else {
						// we don't want to uncheck the currently checked button
						if (buttonView == _checkedButton) {
							buttonView.setChecked(true);
						}
					}
				}

			});
		}
	}
	
	private void recognizingShapedChangedByUser(CompoundButton buttonView) {
		for (RecognizingTypes recognizingType : RecognizingTypes.values()) {
			if (buttonView == _toggleButtons.get(recognizingType.whatType())) {
				_canvasView.setRecognizing(recognizingType);
				return;
			}
		}
	}
}
