package com.youku.example.moi.fragment.high;

import android.animation.Animator;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.youku.example.moi.R;


public class MyFragmentOne extends Fragment {

	private static int sCount = 0;
	private int mId = 0;
	private final int[] mColors = new int[] { Color.RED, Color.GREEN,
			Color.BLUE, Color.BLACK };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		++sCount;
		mId = sCount;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.myfragment_layout, container,
				false);

		TextView textView = (TextView) view.findViewById(R.id.fragment_name);
		textView.setText("This is Fragment No." + mId);
		textView.setBackgroundColor(mColors[mId % mColors.length]);

		return view;
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
		return super.onCreateAnimator(transit, enter, nextAnim);
	}
}
