package hci2.group5.a2part3.main;

import hci2.group5.a2part3.config.ColorPaletteConfig;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

public class ColorPaletteDialog extends Dialog {

	public static int ID = 6382;
	
	public ColorPaletteDialog(Activity activity, final ColorPaletteGridView.Listener l) {
		super(activity);

		ColorPaletteGridView colorPalette = new ColorPaletteGridView(activity.getApplicationContext(), new ColorPaletteGridView.Listener() {
			
			@Override
			public void colorChanged(int color) {
				dismiss();
				l.colorChanged(color);
			}
		});
		
		super.setTitle("Fill color");
		super.setContentView(colorPalette);
	}
}

class ColorPaletteGridView extends GridView {

	public ColorPaletteGridView(Context context, ColorPaletteGridView.Listener l) {
		super(context);

	    setAdapter(new ColorPaletteAdaptor(l));
	    setColumnWidth(ColorPaletteConfig.UNIT_LENGTH_IN_PX);
	    setNumColumns(GridView.AUTO_FIT);
	    setStretchMode(NO_STRETCH);
	    setGravity(Gravity.FILL);
	}
	
	public interface Listener {
		void colorChanged(int color);
	}
}

class ColorPaletteAdaptor extends BaseAdapter {
	
	private ColorPaletteGridView.Listener _colorPalettelistener;
	
	public ColorPaletteAdaptor(ColorPaletteGridView.Listener l) {
		_colorPalettelistener = l;
	}

	@Override
	public int getCount() {
		return ColorPaletteConfig.COLORS.length;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		int color = ColorPaletteConfig.COLORS[position];
		
		if (convertView instanceof ColorPaletteUnit) {
			((ColorPaletteUnit)convertView).setColor(color);
			return convertView;
		}
		else {
			return new ColorPaletteUnit(parent, color, _colorPalettelistener);
		}
	}
	
	@Override
	public Object getItem(int position) {
		// not used
		return null;
	}

	@Override
	public long getItemId(int position) {
		// not used
		return 0;
	}
}

class ColorPaletteUnit extends View {

	private int _color;

	public ColorPaletteUnit(View parent, int color, final ColorPaletteGridView.Listener l) {
		super(parent.getContext());
		
		setColor(color);
		setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				l.colorChanged(_color);
			}
		});
	}

	public void setColor(int color) {
		_color = color;
		setBackgroundColor(_color);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(ColorPaletteConfig.UNIT_LENGTH_IN_PX, ColorPaletteConfig.UNIT_LENGTH_IN_PX);
	}
}