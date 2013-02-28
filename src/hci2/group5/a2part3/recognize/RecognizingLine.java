package hci2.group5.a2part3.recognize;

import hci2.group5.a2part3.shape.Line;
import hci2.group5.a2part3.util.PointMaster;

public class RecognizingLine extends Recognizing {

	private PointMaster firstPoint;
	
	private boolean initialDraw = true;

	@Override
	public void touchDown(float x, float y) {
		if(initialDraw){
			firstPoint = new PointMaster(x,y);
			return;
		}
	}

	@Override
	public void touchMove(float x, float y) {
		
	}

	@Override
	public void touchUp(float x, float y) {
		// TODO Auto-generated method stub
		PointMaster lastPoint = new PointMaster(x,y);
		if(initialDraw){
			initialDraw = false;
		}
		if(!firstPoint.isRoughlyTheSame(lastPoint)){
			doneRecognizing(new Line(firstPoint,lastPoint));
		}
	}
	
}
