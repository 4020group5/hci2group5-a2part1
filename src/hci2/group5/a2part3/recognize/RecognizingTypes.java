package hci2.group5.a2part3.recognize;

public enum RecognizingTypes {

	RECTANGLE {
		@Override
		public Recognizing getAlgrithm() {
			return new RecognizingRectangle();
		}
		
	},
	CIRCLE {
		@Override
		public Recognizing getAlgrithm() {
			return new RecognizingCircle();
		}
	},
	LINE {
		@Override
		public Recognizing getAlgrithm() {
			return new RecognizingLine();
		}
	},
	TRIANGLE {
		@Override
		public Recognizing getAlgrithm() {
			return new RecognizingTriangle();
		}
	};
	
	public abstract Recognizing getAlgrithm();
}
