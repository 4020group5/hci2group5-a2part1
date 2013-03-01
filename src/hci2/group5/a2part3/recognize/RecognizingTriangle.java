package hci2.group5.a2part3.recognize;

import android.R.integer;
import hci2.group5.a2part3.shape.Triangle;
import hci2.group5.a2part3.util.PointMaster;

public class RecognizingTriangle extends RecognizingByBoundingBoxAndCorners {

	private PointMaster _p1,_p2,_p3,previous_p,secondPoint;
	
	private float scope;
	private float ROUGH_RANGE = 5;
	
	private boolean initialDraw = true;
	private boolean getSecondPoint = false;
	
	@Override
	public void touchDown(float x, float y) {
		// TODO Auto-generated method stub
		if(initialDraw){
			_p1 = new PointMaster(x,y);
			previous_p = new PointMaster(x,y);	
		}
		areCornersAllClosed();
	}

	@Override
	public void touchMove(float x, float y) {
		if(!getSecondPoint){
			secondPoint = new PointMaster(x, y);
			scope = getScop(_p1,secondPoint);
			getSecondPoint = true;
		}
		
		isStraightOrNot(x, y);
		previous_p = new PointMaster(x, y);
			
	}

	@Override
	public void touchUp(float x, float y) {
		if(_p2 != null && _p3 != null){
			doneRecognizing(new Triangle(_p1, _p2, _p3));
		}
		
	}
	
	private void isStraightOrNot(float x, float y) {

		float result = getScop(previous_p, secondPoint); 

		if(result > ROUGH_RANGE - scope)
		{
			if(_p2 == null)
			{
				_p2 = new PointMaster(x,y);
				scope = result;
				getSecondPoint = false;
			}else if(_p3 == null){
				_p3 = new PointMaster(x, y);
				scope = result;
				getSecondPoint = false;
			}
		}
		
	}
	
	private float getScop(PointMaster p1, PointMaster p2){
		return (p1.y-p2.y)/(p1.x-p2.x);	
	}
}
