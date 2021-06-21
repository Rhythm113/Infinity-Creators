package com.infinity.creators;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

public class Menu_1Activity extends AppCompatActivity {
	
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private ImageView imageview1;
	private TextView textview3;
	private TextView textview4;
	private Button root_sys;
	private Button n_root_sys;
	private TextView textview5;
	
	private Intent Display = new Intent();
	private Intent root_sys2 = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.menu_1);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview4 = (TextView) findViewById(R.id.textview4);
		root_sys = (Button) findViewById(R.id.root_sys);
		n_root_sys = (Button) findViewById(R.id.n_root_sys);
		textview5 = (TextView) findViewById(R.id.textview5);
		
		root_sys.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_shell_command("su");
				root_sys2.setClass(getApplicationContext(), AntiBannRActivity.class);
				startActivity(root_sys2);
			}
		});
		
		n_root_sys.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "Coming Soon..!!");
			}
		});
	}
	private void initializeLogic() {
		int[] WGcolors = { Color.parseColor("#00ffc4"), Color.parseColor("#007aff") }; android.graphics.drawable.GradientDrawable CRNGD = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, WGcolors);
		CRNGD.setCornerRadii(new float[]{(int)151,(int)151,(int)151,(int)151,(int)151,(int)151,(int)151,(int)151});
		CRNGD.setStroke((int) 0, Color.parseColor("#000000"));
		root_sys.setElevation((float) 0);
		root_sys.setBackground(CRNGD);
		//Milz
		int[] YCcolors = { Color.parseColor("#ff00bc"), Color.parseColor("#ff0006") }; android.graphics.drawable.GradientDrawable CRNUU = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, YCcolors);
		CRNUU.setCornerRadii(new float[]{(int)151,(int)151,(int)151,(int)151,(int)151,(int)151,(int)151,(int)151});
		CRNUU.setStroke((int) 0, Color.parseColor("#000000"));
		n_root_sys.setElevation((float) 0);
		n_root_sys.setBackground(CRNUU);
		//Milz
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	private void _shell_command (final String _cmd) {
		try {
			Runtime.getRuntime().exec(_cmd);
		} catch (Exception e) {
		}
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
