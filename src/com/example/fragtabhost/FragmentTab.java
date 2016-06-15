package com.example.fragtabhost;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class FragmentTab extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_layout, container, false);
		
		
		init(v, R.id.tuangou, 30.0f, "1");
		init(v, R.id.tuangouhd, 30.0f, "2");

		init1(v, R.id.m_first, 8.0f, "3");
		init1(v, R.id.m_two, 10f, "4");
		init1(v, R.id.m_three, 12.0f, "5");
		init1(v, R.id.m_four, 12.0f, "6");
		init1(v, R.id.m_five, 10.0f, "7");
		init1(v, R.id.m_six, 8.0f, "8");

		init(v, R.id.c_first, 10.0f, "9");
		init(v, R.id.c_two, 10.0f, "10");
		init(v, R.id.c_three, 10.0f, "11");
		return v;
	}
	
	
	@SuppressLint("NewApi")
	private void init1(View v, int id, float size, String name) {
		WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);

		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		int width = outMetrics.widthPixels;

		LinearLayout parent = (LinearLayout) v.findViewById(id);
		TextView t1 = (TextView) parent.findViewById(R.id.name);
		LayoutParams layout = (LayoutParams) t1.getLayoutParams();
		layout.width = width / 5-75;
		layout.height = width / 5-75;
		t1.setPadding(30, 30, 30, 30);
		t1.setGravity(Gravity.CENTER);
		t1.setBackground(getActivity().getResources().getDrawable(R.drawable.item_textback_c));
		t1.setTextSize(size);
		t1.setText(name);
		t1.setLayoutParams(layout);
	}

	@SuppressLint("NewApi")
	private void init(View v, int id, float size, String name) {
		LinearLayout parent = (LinearLayout) v.findViewById(id);
		TextView t1 = (TextView) parent.findViewById(R.id.name);
		t1.setBackground(getActivity().getResources().getDrawable(R.drawable.item_textback_s));
		t1.setTextSize(size);
		t1.setText(name);
	}
}
