package com.tt.taste.util;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 重写的ListView，以便可以嵌套在ScrollView�?
 * 
 * @author
 * 
 */
public class GridViewForScrollView extends GridView {
	public GridViewForScrollView(Context context) {
		super(context);
	}

	public GridViewForScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public GridViewForScrollView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
	}

	// @Override
	// public boolean dispatchTouchEvent(MotionEvent ev) {
		// if (ev.getAction() == MotionEvent.ACTION_MOVE)
		// return super.dispatchTouchEvent(ev) || true;
		// else
//			return super.dispatchTouchEvent(ev);
//	}

	@Override
	/**
	 * 重写该方法，达到使ListView适应ScrollView的效�?
	 */
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}
}