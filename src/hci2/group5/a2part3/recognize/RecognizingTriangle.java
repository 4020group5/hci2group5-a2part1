package hci2.group5.a2part3.recognize;

import hci2.group5.a2part3.shape.Triangle;
import hci2.group5.a2part3.util.PointMaster;

public class RecognizingTriangle extends RecognizingByBoundingBoxAndCorners {

	private PointMaster _p1,_p2,_p3;
	private PointMaster pre_p, prepre_p,cur_p;
	
	private float ROUGH_RANGE = 1f;
	
	private boolean initialDraw = true;
	
	@Override
	public void touchDown(float x, float y) {
		// TODO Auto-generated method stub
		if(initialDraw){
			_p1 = new PointMaster(x,y);
			cur_p = _p1;
		}
	}

	@Override
	public void touchMove(float x, float y) {
		pre_p = cur_p;
		cur_p = new PointMaster(x, y);
		isStraightOrNot(x, y);
		prepre_p = pre_p;
	}

	@Override
	public void touchUp(float x, float y) {
		if(_p2 != null && _p3 != null){
			doneRecognizing(new Triangle(_p1, _p2, _p3));
		}	
	}
	
	private void isStraightOrNot(float x, float y) {
		float scope_1,scope_2;
		float result;
		if(prepre_p != null){
			scope_1 = getScop(prepre_p, pre_p);
			scope_2 = getScop(pre_p, cur_p);
			
			result = scope_2 - scope_1;
			
			if(result > ROUGH_RANGE){
				if(_p2 == null){
					_p2 = pre_p;
					prepre_p = pre_p;
					
				}else if(_p3 == null){
					_p3 = new PointMaster(x, y);
					return;
				}
			}
		}
	}
	
	private float getScop(PointMaster p1, PointMaster p2){
		return (p1.y-p2.y)/(p1.x-p2.x);	
	}
}
