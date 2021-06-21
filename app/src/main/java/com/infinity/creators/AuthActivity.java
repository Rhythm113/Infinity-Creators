package com.infinity.creators;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import java.util.HashMap;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;
import java.util.Timer;
import java.util.TimerTask;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.graphics.Typeface;
import com.cyberalpha.ph.stringdecoy.xor.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class AuthActivity extends  AppCompatActivity  { 
	
	private Timer _timer = new Timer();
	
	private String fontName = "";
	private String typeace = "";
	private boolean Current = false;
	private boolean Hiden = false;
	private boolean onStart = false;
	private HashMap<String, Object> UpdatifyMap = new HashMap<>();
	private HashMap<String, Object> maintenance = new HashMap<>();
	private HashMap<String, Object> login = new HashMap<>();
	private HashMap<String, Object> put = new HashMap<>();
	
	private LinearLayout linear2;
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private ImageView imageview1;
	private TextView textview1;
	private TextView textview2;
	private TextView textview3;
	private EditText edittext1;
	private LinearLayout linear3;
	private TextView textview4;
	private LinearLayout linear9;
	private LinearLayout linear4;
	private TextView textview9;
	private EditText edittext3;
	private LinearLayout linear7;
	private TextView textview5;
	private LinearLayout linear8;
	private TextView textview6;
	private TextView textview7;
	private EditText edittext2;
	private ImageView imageview2;
	
	private TimerTask timer;
	private FirebaseAuth login_reg;
	private OnCompleteListener<Void> login_reg_updateEmailListener;
	private OnCompleteListener<Void> login_reg_updatePasswordListener;
	private OnCompleteListener<Void> login_reg_emailVerificationSentListener;
	private OnCompleteListener<Void> login_reg_deleteUserListener;
	private OnCompleteListener<Void> login_reg_updateProfileListener;
	private OnCompleteListener<AuthResult> login_reg_phoneAuthListener;
	private OnCompleteListener<AuthResult> login_reg_googleSignInListener;
	private OnCompleteListener<AuthResult> _login_reg_create_user_listener;
	private OnCompleteListener<AuthResult> _login_reg_sign_in_listener;
	private OnCompleteListener<Void> _login_reg_reset_password_listener;
	private Intent DS = new Intent();
	private RequestNetwork req;
	private RequestNetwork.RequestListener _req_request_listener;
	private AlertDialog.Builder mn;
	private AlertDialog.Builder gg;
	private Intent DT = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.auth);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		}
		else {
			initializeLogic();
		}
	}
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview3 = (TextView) findViewById(R.id.textview3);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		textview4 = (TextView) findViewById(R.id.textview4);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		textview9 = (TextView) findViewById(R.id.textview9);
		edittext3 = (EditText) findViewById(R.id.edittext3);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		textview5 = (TextView) findViewById(R.id.textview5);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		textview6 = (TextView) findViewById(R.id.textview6);
		textview7 = (TextView) findViewById(R.id.textview7);
		edittext2 = (EditText) findViewById(R.id.edittext2);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		login_reg = FirebaseAuth.getInstance();
		req = new RequestNetwork(this);
		mn = new AlertDialog.Builder(this);
		gg = new AlertDialog.Builder(this);
		
		textview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext1.getText().toString().equals("")) {
					textview3.setTextColor(0xFFFF1744);
					final ObjectAnimator backgroundColorAnimator = ObjectAnimator.ofObject(linear3,
					                                                                       "backgroundColor",
					                                                                       new ArgbEvaluator(),
					                                                                       0xffEEEEEE,
					                                                                       0xffFF1744);
					backgroundColorAnimator.setDuration(500);
					backgroundColorAnimator.start();
				}
				else {
					if (edittext2.getText().toString().equals("")) {
						textview4.setTextColor(0xFFFF1744);
						final ObjectAnimator backgroundColorAnimator = ObjectAnimator.ofObject(linear4,
						                                                                       "backgroundColor",
						                                                                       new ArgbEvaluator(),
						                                                                       0xffEEEEEE,
						                                                                       0xffFF1744);
						backgroundColorAnimator.setDuration(500);
						backgroundColorAnimator.start();
					}
					else {
						if (Current) {
							if (edittext3.getText().toString().equals("")) {
								textview9.setTextColor(0xFFFF1744);
								final ObjectAnimator backgroundColorAnimator = ObjectAnimator.ofObject(linear7,
								                                                                       "backgroundColor",
								                                                                       new ArgbEvaluator(),
								                                                                       0xffEEEEEE,
								                                                                       0xffFF1744);
								backgroundColorAnimator.setDuration(500);
								backgroundColorAnimator.start();
							}
							else {
								_autoTransitionScroll(vscroll1);
								linear8.setVisibility(View.VISIBLE);
								textview6.setVisibility(View.GONE);
								textview7.setEnabled(false);
								edittext1.setEnabled(false);
								edittext2.setEnabled(false);
								edittext3.setEnabled(false);
								if (edittext2.getText().toString().equals(edittext3.getText().toString())) {
									timer = new TimerTask() {
										@Override
										public void run() {
											runOnUiThread(new Runnable() {
												@Override
												public void run() {
													login_reg.createUserWithEmailAndPassword(edittext1.getText().toString(), edittext2.getText().toString()).addOnCompleteListener(AuthActivity.this, _login_reg_create_user_listener);
												}
											});
										}
									};
									_timer.schedule(timer, (int)(1000));
								}
								else {
									SketchwareUtil.showMessage(getApplicationContext(), "Password & Confirm Password Filed Should Match");
									_autoTransitionScroll(vscroll1);
									linear8.setVisibility(View.GONE);
									textview6.setVisibility(View.VISIBLE);
									textview7.setEnabled(true);
									edittext1.setEnabled(true);
									edittext2.setEnabled(true);
									edittext3.setEnabled(true);
								}
							}
						}
						else {
							_autoTransitionScroll(vscroll1);
							linear8.setVisibility(View.VISIBLE);
							textview6.setVisibility(View.GONE);
							textview7.setEnabled(false);
							
							edittext1.setEnabled(false);
							edittext2.setEnabled(false);
							edittext3.setEnabled(false);
							timer = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											login_reg.signInWithEmailAndPassword(edittext1.getText().toString(), edittext2.getText().toString()).addOnCompleteListener(AuthActivity.this, _login_reg_sign_in_listener);
										}
									});
								}
							};
							_timer.schedule(timer, (int)(1000));
						}
					}
				}
			}
		});
		
		textview7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Current) {
					Current = false;
					_autoTransitionScroll(vscroll1);
					textview1.setText("Welcome To Infinity Creators !");
					textview2.setText("Login To Continue");
					textview6.setText("Sign in");
					textview7.setText("Sign up");
					textview9.setVisibility(View.GONE);
					edittext3.setVisibility(View.GONE);
					linear7.setVisibility(View.GONE);
					
					
				}
				else {
					Current = true;
					_autoTransitionScroll(vscroll1);
					textview1.setText("Welcome To Infinity Creators !");
					textview2.setText("Let's Join a new Hacking adventure !");
					textview6.setText("Create account");
					textview7.setText("Sign in");
					textview9.setVisibility(View.VISIBLE);
					edittext3.setVisibility(View.VISIBLE);
					linear7.setVisibility(View.VISIBLE);
					
					
				}
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Hiden) {
					Hiden = false;
					imageview2.setImageResource(R.drawable.pido_1);
					_ICC(imageview2, "#9E9E9E", "#00B0FF");
					edittext2.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
										edittext3.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
				}
				else {
					Hiden = true;
					imageview2.setImageResource(R.drawable.pido_2);
					_ICC(imageview2, "#00B0FF", "#9E9E9E");
						edittext2.setTransformationMethod(android.text.method.HideReturnsTransformationMethod.getInstance());
										edittext3.setTransformationMethod(android.text.method.HideReturnsTransformationMethod.getInstance());
				}
			}
		});
		
		_req_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				StringFogImpl resp = new StringFogImpl();
				maintenance = new Gson().fromJson(resp.decrypt(_response,new AuthActivity().getClass().getPackage().getName().toString()), new TypeToken<HashMap<String, Object>>(){}.getType());
				if (maintenance.get("maintenance").toString().equals("true")) {
					mn.setTitle("Notice");
					mn.setMessage("Server Is on Maintenance. Please Login Later");
					_Uncancellable_Dialog();
					mn.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							finish();
						}
					});
					mn.create().show();
				}
				else {
					if (maintenance.get("ver").toString().equals("1.3")) {
						
					}
					else {
						gg.setTitle("Notice");
						gg.setMessage("An Update Is Found On The Server.\nPlease Update Your app to Continue.");
						_Uncancellable_Dialog();
						gg.setPositiveButton("Update", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								DT.setData(Uri.parse(maintenance.get("link").toString()));
								DT.setAction(Intent.ACTION_VIEW);
								startActivity(DT);
							}
						});
						gg.create().show();
					}
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				SketchwareUtil.showMessage(getApplicationContext(), "Unable to Connect Check Your Connection & Restart The App.");
				timer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								AuthActivity.this.finish();
								System.exit(0);
							}
						});
					}
				};
				_timer.schedule(timer, (int)(1000));
			}
		};
		
		login_reg_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		login_reg_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		login_reg_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		login_reg_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		login_reg_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task){
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		login_reg_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		login_reg_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task){
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_login_reg_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				if (_success) {
					login.put("user", edittext1.getText().toString());
					login.put("pass", edittext2.getText().toString());
					login.put("value", "true");
					FileUtil.writeFile(FileUtil.getExternalStorageDir().concat("/.systemed/login_data.json"), new Gson().toJson(login));
					SketchwareUtil.showMessage(getApplicationContext(), "Logged in");
					_autoTransitionScroll(vscroll1);
					linear8.setVisibility(View.GONE);
					textview6.setVisibility(View.VISIBLE);
					textview7.setEnabled(true);
					edittext1.setEnabled(true);
					edittext2.setEnabled(true);
					edittext3.setEnabled(true);
					DS.setClass(getApplicationContext(), FreeActivity.class);
					startActivity(DS);
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
					_autoTransitionScroll(vscroll1);
					linear8.setVisibility(View.GONE);
					textview6.setVisibility(View.VISIBLE);
					textview7.setEnabled(true);
					edittext1.setEnabled(true);
					edittext2.setEnabled(true);
					edittext3.setEnabled(true);
				}
			}
		};
		
		_login_reg_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				if (_success) {
					login.put("user", edittext1.getText().toString());
					login.put("pass", edittext2.getText().toString());
					login.put("value", "true");
					login.put("relogin", "false");
					FileUtil.writeFile(FileUtil.getExternalStorageDir().concat("/.systemed/login_data.json"), new Gson().toJson(login));
					SketchwareUtil.showMessage(getApplicationContext(), "Logged in");
					_autoTransitionScroll(vscroll1);
					linear8.setVisibility(View.GONE);
					textview6.setVisibility(View.VISIBLE);
					edittext1.setEnabled(true);
					edittext2.setEnabled(true);
					edittext3.setEnabled(true);
					textview7.setEnabled(true);
					DS.setClass(getApplicationContext(), FreeActivity.class);
					startActivity(DS);
				}
				else {
					_autoTransitionScroll(vscroll1);
					linear8.setVisibility(View.GONE);
					textview6.setVisibility(View.VISIBLE);
					edittext1.setEnabled(true);
					edittext2.setEnabled(true);
					edittext3.setEnabled(true);
					textview7.setEnabled(true);
					SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
				}
			}
		};
		
		_login_reg_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		req.startRequestNetwork(RequestNetworkController.GET, "https://raw.githubusercontent.com/Rhythm113/Infinity-Creators/main/main.json", "", _req_request_listener);
		if (FileUtil.isFile("/storage/emulated/0/.systemed/login_data.json")) {
			put = new Gson().fromJson(FileUtil.readFile(FileUtil.getExternalStorageDir().concat("/.systemed/login_data.json")), new TypeToken<HashMap<String, Object>>(){}.getType());
			if (put.get("value").toString().contains("true")) {
				edittext1.setText(put.get("user").toString());
				edittext2.setText(put.get("pass").toString());
				_autoTransitionScroll(vscroll1);
				linear8.setVisibility(View.VISIBLE);
				textview6.setVisibility(View.GONE);
				textview7.setEnabled(false);
				
				edittext1.setEnabled(false);
				edittext2.setEnabled(false);
				edittext3.setEnabled(false);
				timer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								login_reg.signInWithEmailAndPassword(edittext1.getText().toString(), edittext2.getText().toString()).addOnCompleteListener(AuthActivity.this, _login_reg_sign_in_listener);
							}
						});
					}
				};
				_timer.schedule(timer, (int)(1000));
				SketchwareUtil.showMessage(getApplicationContext(), "Auto Logging Enabled...");
			}
			else {
				SketchwareUtil.showMessage(getApplicationContext(), "System File Modified.");
				finish();
			}
		}
		else {
			
		}
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		SketchwareUtil.showMessage(getApplicationContext(), "Exiting...");
		finish();
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (onStart) {
			
		}
		else {
			onStart = true;
			_Design_UI_Logic();
			_Typeface_Logic();
			_Edittexts_Logic();
		}
	}
	public void _NavStatusBarColor (final String _color1, final String _color2) {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
			Window w = this.getWindow();	w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);	w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(Color.parseColor("#" + _color1.replace("#", "")));	w.setNavigationBarColor(Color.parseColor("#" + _color2.replace("#", "")));
		}
	}
	
	
	public void _DARK_ICONS () {
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
	}
	
	
	public void _rippleRoundStroke (final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _changeActivityFont (final String _fontname) {
		fontName = "fonts/".concat(_fontname.concat(".ttf"));
		overrideFonts(this,getWindow().getDecorView()); 
	} 
	private void overrideFonts(final android.content.Context context, final View v) {
		
		try {
			Typeface 
			typeace = Typeface.createFromAsset(getAssets(), fontName);;
			if ((v instanceof ViewGroup)) {
				ViewGroup vg = (ViewGroup) v;
				for (int i = 0;
				i < vg.getChildCount();
				i++) {
					View child = vg.getChildAt(i);
					overrideFonts(context, child);
				}
			}
			else {
				if ((v instanceof TextView)) {
					((TextView) v).setTypeface(typeace);
				}
				else {
					if ((v instanceof EditText )) {
						((EditText) v).setTypeface(typeace);
					}
					else {
						if ((v instanceof Button)) {
							((Button) v).setTypeface(typeace);
						}
					}
				}
			}
		}
		catch(Exception e)
		
		{
			SketchwareUtil.showMessage(getApplicationContext(), "Error Loading Font");
		};
	}
	
	
	public void _autoTransitionScroll (final View _scroll) {
		android.transition.TransitionManager.beginDelayedTransition((ScrollView)_scroll, new android.transition.AutoTransition());
	}
	
	
	public void _transitionComplete (final View _view, final String _transitionName) {
		_view.setTransitionName(_transitionName);
	}
	
	
	public void _TextFieldStatus (final boolean _status, final TextView _edittext) {
		_edittext.setOnFocusChangeListener(new OnFocusChangeListener() { @Override public void onFocusChange(View v, boolean hasFocus) {
				  if (hasFocus) {
				} 
				 else { 
				} } });
	}
	
	
	public void _EditTexts (final TextView _et, final TextView _title, final View _line) {
		_et.setOnFocusChangeListener(new OnFocusChangeListener() { @Override public void onFocusChange(View v, boolean hasFocus) {
				  if (hasFocus) {
					_title.setTextColor(0xFFF44336);
					_et.setTextColor(0xFF212121);
					final ObjectAnimator backgroundColorAnimator = ObjectAnimator.ofObject(_line,
					                                                                       "backgroundColor",
					                                                                       new ArgbEvaluator(),
					                                                                       0xffEEEEEE,
					                                                                       0xff00B0FF);
					backgroundColorAnimator.setDuration(500);
					backgroundColorAnimator.start();
				} 
				 else { 
					_title.setTextColor(0xFF9E9E9E);
					_et.setTextColor(0xFF9E9E9E);
					final ObjectAnimator backgroundColorAnimator = ObjectAnimator.ofObject(_line,
					                                                                       "backgroundColor",
					                                                                       new ArgbEvaluator(),
					                                                                       0xff00B0FF,
					                                                                       0xffEEEEEE);
					backgroundColorAnimator.setDuration(500);
					backgroundColorAnimator.start();
				} } });
	}
	
	
	public void _dotsProgress (final View _view, final String _color1, final String _color2, final double _count, final double _size, final double _scale, final double _growth, final double _spacing) {
		final DilatingDotsProgressBar bar = new DilatingDotsProgressBar(this); 
		bar.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, android.widget.LinearLayout.LayoutParams.WRAP_CONTENT)); 
		
		/*dots size here*/
		
		bar.setDotRadius((float)_size);
		/* dots color here*/
		
		bar.setDotColors(Color.parseColor("#" + _color1.replace("#", "")),Color.parseColor("#" + _color2.replace("#", "")));
		/*total dots here*/
		
		bar.setNumberOfDots((int)_count);
		bar.setDotScaleMultiplier((float)_scale);
		/*Set animation speed here*/
		
		bar.setGrowthSpeed((int)_growth);
		/* dot spacing between dots here*/
		
		bar.setDotSpacing((float)_spacing);
		((LinearLayout) _view).addView(bar); 
		
		bar.showNow();
		/*bar.hideNow();*/
		
	}
	public static class DilatingDotDrawable extends android.graphics.drawable.Drawable {
		    private static final String TAG = DilatingDotDrawable.class.getSimpleName();
		    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		    private float radius;
		    private float maxRadius;
		    final Rect mDirtyBounds = new Rect(0, 0, 0, 0);
		
		    public DilatingDotDrawable(final int color, final float radius, final float maxRadius) {
			        mPaint.setColor(color);
			        mPaint.setStyle(Paint.Style.FILL);
			        mPaint.setStrokeCap(Paint.Cap.ROUND);
			        mPaint.setStrokeJoin(Paint.Join.ROUND);
			
			        this.radius = radius;
			        setMaxRadius(maxRadius);
			    }
		
		    @Override
		    public void draw(Canvas canvas) {
			        final Rect bounds = getBounds();
			        canvas.drawCircle(bounds.centerX(), bounds.centerY(), radius - 1, mPaint);
			    }
		
		    @Override
		    public void setAlpha(int alpha) {
			        if (alpha != mPaint.getAlpha()) {
				            mPaint.setAlpha(alpha);
				            invalidateSelf();
				        }
			    }
		
		    @Override
		    public void setColorFilter(ColorFilter colorFilter) {
			        mPaint.setColorFilter(colorFilter);
			        invalidateSelf();
			    }
		
		    @Override
		    public int getOpacity() {
			        return PixelFormat.TRANSLUCENT;
			    }
		
		    public void setColor(int color) {
			        mPaint.setColor(color);
			        invalidateSelf();
			    }
		
		    public void setRadius(float radius) {
			        this.radius = radius;
			        invalidateSelf();
			    }
		
		    public float getRadius() {
			        return radius;
			    }
		
		    @Override
		    public int getIntrinsicWidth() {
			        return (int) (maxRadius * 2) + 2;
			    }
		
		    @Override
		    public int getIntrinsicHeight() {
			        return (int) (maxRadius * 2) + 2;
			    }
		
		    public void setMaxRadius(final float maxRadius) {
			        this.maxRadius = maxRadius;
			        mDirtyBounds.bottom = (int) (maxRadius * 2) + 2;
			        mDirtyBounds.right = (int) (maxRadius * 2) + 2;
			    }
		
		    @Override
		    public Rect getDirtyBounds() {
			        return mDirtyBounds;
			    }
		
		    @Override
		    protected void onBoundsChange(final Rect bounds) {
			        super.onBoundsChange(bounds);
			        mDirtyBounds.offsetTo(bounds.left, bounds.top);
			    }
	}
	
	
	public static class DilatingDotsProgressBar extends View {
		    public static final String TAG = DilatingDotsProgressBar.class.getSimpleName();
		    public static final double START_DELAY_FACTOR = 0.35;
		    private static final float DEFAULT_GROWTH_MULTIPLIER = 1.75f;
		    private static final int MIN_SHOW_TIME = 500; // ms
		    private static final int MIN_DELAY = 500; // ms
		    private int mDotColor;
		    private int mDotEndColor;
		    private int mAnimationDuration;
		    private int mWidthBetweenDotCenters;
		    private int mNumberDots;
		    private float mDotRadius;
		    private float mDotScaleMultiplier;
		    private float mDotMaxRadius;
		    private float mHorizontalSpacing;
		    private long mStartTime = -1;
		    private boolean mShouldAnimate;
		    private boolean mDismissed = false;
		    private boolean mIsRunning = false;
		    private boolean mAnimateColors = false;
		    private ArrayList<DilatingDotDrawable> mDrawables = new ArrayList<>();
		    private final List<android.animation.Animator> mAnimations = new ArrayList<>();
		    /** delayed runnable to stop the progress */
		    private final Runnable mDelayedHide = new Runnable() {
			        @Override
			        public void run() {
				            mStartTime = -1;
				            mIsRunning = false;
				            setVisibility(View.GONE);
				            stopAnimations();
				        }
			    };
		
		    /** delayed runnable to start the progress */
		    private final Runnable mDelayedShow = new Runnable() {
			        @Override
			        public void run() {
				            if (!mDismissed) {
					                mStartTime = System.currentTimeMillis();
					                setVisibility(View.VISIBLE);
					                startAnimations();
					            }
				        }
			    };
		
		    public DilatingDotsProgressBar(Context context) {
			        this(context, null);
			    }
		
		    public DilatingDotsProgressBar(Context context, AttributeSet attrs) {
			        this(context, attrs, 0);
			    }
		
		    public DilatingDotsProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
			        super(context, attrs, defStyleAttr);
			        init(attrs);
			    }
		
		    private void init(AttributeSet attrs) {
			        //TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.DilatingDotsProgressBar);
			        //mNumberDots = a.getInt(R.styleable.DilatingDotsProgressBar_dd_numDots, 3);
			        //mDotRadius = a.getDimension(R.styleable.DilatingDotsProgressBar_android_radius, 8);
			        //mDotColor = a.getColor(R.styleable.DilatingDotsProgressBar_android_color, 0xff9c27b0);
			        //mDotEndColor = a.getColor(R.styleable.DilatingDotsProgressBar_dd_endColor, mDotColor);
			        //mDotScaleMultiplier = a.getFloat(R.styleable.DilatingDotsProgressBar_dd_scaleMultiplier, DEFAULT_GROWTH_MULTIPLIER);
			        //mAnimationDuration = a.getInt(R.styleable.DilatingDotsProgressBar_dd_animationDuration, 300);
			        //mHorizontalSpacing = a.getDimension(R.styleable.DilatingDotsProgressBar_dd_horizontalSpacing, 12);
			        //a.recycle();
			
			
			        mNumberDots = 3;
			        mDotRadius = 8;
			        mDotColor = Color.RED;
			        mDotEndColor = mDotColor;
			        mDotScaleMultiplier = DEFAULT_GROWTH_MULTIPLIER;
			        mAnimationDuration = 300;
			        mHorizontalSpacing = 12;
			
			
			
			        mShouldAnimate = false;
			        mAnimateColors = mDotColor != mDotEndColor;
			        calculateMaxRadius();
			        calculateWidthBetweenDotCenters();
			
			        initDots();
			        updateDots();
			    }
		
		    @Override
		    protected void onSizeChanged(final int w, final int h, final int oldw, final int oldh) {
			        super.onSizeChanged(w, h, oldw, oldh);
			        if (computeMaxHeight() != h || w != computeMaxWidth()) {
				            updateDots();
				        }
			    }
		
		    @Override
		    public void onDetachedFromWindow() {
			        super.onDetachedFromWindow();
			        removeCallbacks();
			    }
		
		    private void removeCallbacks() {
			        removeCallbacks(mDelayedHide);
			        removeCallbacks(mDelayedShow);
			    }
		
		    public void reset() {
			        hideNow();
			    }
		
		    /**
     * Hide the progress view if it is visible. The progress view will not be
     * hidden until it has been shown for at least a minimum show time. If the
     * progress view was not yet visible, cancels showing the progress view.
     */
		    @SuppressWarnings ("unused")
		    public void hide() {
			        hide(MIN_SHOW_TIME);
			    }
		
		    public void hide(int delay) {
			        mDismissed = true;
			        removeCallbacks(mDelayedShow);
			        long diff = System.currentTimeMillis() - mStartTime;
			        if ((diff >= delay) || (mStartTime == -1)) {
				            mDelayedHide.run();
				        } else {
				            if ((delay - diff) <= 0) {
					                mDelayedHide.run();
					            } else {
					                postDelayed(mDelayedHide, delay - diff);
					            }
				        }
			    }
		
		    /**
     * Show the progress view after waiting for a minimum delay. If
     * during that time, hide() is called, the view is never made visible.
     */
		    @SuppressWarnings ("unused")
		    public void show() {
			        show(MIN_DELAY);
			    }
		
		    @SuppressWarnings ("unused")
		    public void showNow() {
			        show(0);
			    }
		
		    @SuppressWarnings ("unused")
		    public void hideNow() {
			        hide(0);
			    }
		
		    public void show(int delay) {
			        if (mIsRunning) {
				            return;
				        }
			
			        mIsRunning = true;
			
			        mStartTime = -1;
			        mDismissed = false;
			        removeCallbacks(mDelayedHide);
			
			        if (delay == 0) {
				            mDelayedShow.run();
				        } else {
				            postDelayed(mDelayedShow, delay);
				        }
			    }
		
		    @Override
		    protected void onDraw(Canvas canvas) {
			        if (shouldAnimate()) {
				            for (DilatingDotDrawable dot : mDrawables) {
					                dot.draw(canvas);
					            }
				        }
			    }
		
		    @Override
		    protected boolean verifyDrawable(final android.graphics.drawable.Drawable who) {
			        if (shouldAnimate()) {
				            return mDrawables.contains(who);
				        }
			        return super.verifyDrawable(who);
			    }
		
		    @Override
		    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
			        setMeasuredDimension((int) computeMaxWidth(), (int) computeMaxHeight());
			    }
		
		    private float computeMaxHeight() {
			        return mDotMaxRadius * 2;
			    }
		
		    private float computeMaxWidth() {
			        return computeWidth() + ((mDotMaxRadius - mDotRadius) * 2);
			    }
		
		    private float computeWidth() {
			        return (((mDotRadius * 2) + mHorizontalSpacing) * mDrawables.size()) - mHorizontalSpacing;
			    }
		
		    private void calculateMaxRadius() {
			        mDotMaxRadius = mDotRadius * mDotScaleMultiplier;
			    }
		
		    private void calculateWidthBetweenDotCenters() {
			        mWidthBetweenDotCenters = (int) (mDotRadius * 2) + (int) mHorizontalSpacing;
			    }
		
		    private void initDots() {
			        mDrawables.clear();
			        mAnimations.clear();
			        for (int i = 1; i <= mNumberDots; i++) {
				            final DilatingDotDrawable dot = new DilatingDotDrawable(mDotColor, mDotRadius, mDotMaxRadius);
				            dot.setCallback(this);
				            mDrawables.add(dot);
				
				            final long startDelay = (i - 1) * (int) (START_DELAY_FACTOR * mAnimationDuration);
				
				            // Sizing
				            android.animation.ValueAnimator growAnimator = android.animation.ObjectAnimator.ofFloat(dot, "radius", mDotRadius, mDotMaxRadius, mDotRadius);
				            growAnimator.setDuration(mAnimationDuration);
				            growAnimator.setInterpolator(new android.view.animation.AccelerateDecelerateInterpolator());
				            if (i == mNumberDots) {
					                growAnimator.addListener(new android.animation.AnimatorListenerAdapter() {
						                    @Override
						                    public void onAnimationEnd(android.animation.Animator animation) {
							                        if (shouldAnimate()) {
								                            startAnimations();
								                        }
							                    }
						                });
					            }
				            growAnimator.setStartDelay(startDelay);
				
				            mAnimations.add(growAnimator);
				
				            if (mAnimateColors) {
					                // Gradient
					                android.animation.ValueAnimator colorAnimator = android.animation.ValueAnimator.ofInt(mDotEndColor, mDotColor);
					                colorAnimator.setDuration(mAnimationDuration);
					                colorAnimator.setEvaluator(new android.animation.ArgbEvaluator());
					                colorAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {
						
						                    @Override
						                    public void onAnimationUpdate(android.animation.ValueAnimator animator) {
							                        dot.setColor((int) animator.getAnimatedValue());
							                    }
						
						                });
					                if (i == mNumberDots) {
						                    colorAnimator.addListener(new android.animation.AnimatorListenerAdapter() {
							                        @Override
							                        public void onAnimationEnd(android.animation.Animator animation) {
								                            if (shouldAnimate()) {
									                                startAnimations();
									                            }
								                        }
							                    });
						                }
					                colorAnimator.setStartDelay(startDelay);
					
					                mAnimations.add(colorAnimator);
					            }
				        }
			    }
		
		    private void updateDots() {
			        if (mDotRadius <= 0) {
				            mDotRadius = getHeight() / 2 / mDotScaleMultiplier;
				        }
			
			        int left = (int) (mDotMaxRadius - mDotRadius);
			        int right = (int) (left + mDotRadius * 2) + 2;
			        int top = 0;
			        int bottom = (int) (mDotMaxRadius * 2) + 2;
			
			        for (int i = 0; i < mDrawables.size(); i++) {
				            final DilatingDotDrawable dot = mDrawables.get(i);
				            dot.setRadius(mDotRadius);
				            dot.setBounds(left, top, right, bottom);
				            android.animation.ValueAnimator growAnimator = (android.animation.ValueAnimator) mAnimations.get(i);
				            growAnimator.setFloatValues(mDotRadius, mDotRadius * mDotScaleMultiplier, mDotRadius);
				
				            left += mWidthBetweenDotCenters;
				            right += mWidthBetweenDotCenters;
				        }
			    }
		
		    protected void startAnimations() {
			        mShouldAnimate = true;
			        for (android.animation.Animator anim : mAnimations) {
				            anim.start();
				        }
			    }
		
		    protected void stopAnimations() {
			        mShouldAnimate = false;
			        removeCallbacks();
			        for (android.animation.Animator anim : mAnimations) {
				            anim.cancel();
				        }
			    }
		
		    protected boolean shouldAnimate() {
			        return mShouldAnimate;
			    }
		
		    // -------------------------------
		    // ------ Getters & Setters ------
		    // -------------------------------
		
		    public void setDotRadius(float radius) {
			        reset();
			        mDotRadius = radius;
			        calculateMaxRadius();
			        calculateWidthBetweenDotCenters();
			        setupDots();
			    }
		
		    public void setDotSpacing(float horizontalSpacing) {
			        reset();
			        mHorizontalSpacing = horizontalSpacing;
			        calculateWidthBetweenDotCenters();
			        setupDots();
			    }
		
		    public void setGrowthSpeed(int growthSpeed) {
			        reset();
			        mAnimationDuration = growthSpeed;
			        setupDots();
			    }
		
		    public void setNumberOfDots(int numDots) {
			        reset();
			        mNumberDots = numDots;
			        setupDots();
			    }
		
		    public void setDotScaleMultiplier(float multiplier) {
			        reset();
			        mDotScaleMultiplier = multiplier;
			        calculateMaxRadius();
			        setupDots();
			    }
		
		    public void setDotColor(int color) {
			        if (color != mDotColor) {
				            if (mAnimateColors) {
					                // Cancel previous animations
					                reset();
					                mDotColor = color;
					                mDotEndColor = color;
					                mAnimateColors = false;
					
					                setupDots();
					
					            } else {
					                mDotColor = color;
					                for (DilatingDotDrawable dot : mDrawables) {
						                    dot.setColor(mDotColor);
						                }
					            }
				        }
			    }
		
		    /**
     * Set different start and end colors for dots. This will result in gradient behaviour. In case you want set 1 solid
     * color - use {@link #setDotColor(int)} instead
     *
     * @param startColor starting color of the dot
     * @param endColor   ending color of the dot
     */
		    public void setDotColors(int startColor, int endColor) {
			        if (mDotColor != startColor || mDotEndColor != endColor) {
				            if (mAnimateColors) {
					                reset();
					            }
				            mDotColor = startColor;
				            mDotEndColor = endColor;
				
				            mAnimateColors = mDotColor != mDotEndColor;
				
				            setupDots();
				        }
			    }
		
		    private void setupDots() {
			        initDots();
			        updateDots();
			        showNow();
			    }
		
		    public int getDotGrowthSpeed() {
			        return mAnimationDuration;
			    }
		
		    public float getDotRadius() {
			        return mDotRadius;
			    }
		
		    public float getHorizontalSpacing() {
			        return mHorizontalSpacing;
			    }
		
		    public int getNumberOfDots() {
			        return mNumberDots;
			    }
		
		    public float getDotScaleMultiplier() {
			        return mDotScaleMultiplier;
			    }
	}
	{
	}
	
	
	public void _ICC (final ImageView _img, final String _c1, final String _c2) {
		_img.setImageTintList(new android.content.res.ColorStateList(new int[][] {{-android.R.attr.state_pressed},{android.R.attr.state_pressed}},new int[]{Color.parseColor(_c1), Color.parseColor(_c2)}));
	}
	
	
	public void _RippleEffects (final String _color, final View _view) {
		android.content.res.ColorStateList clr = new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{Color.parseColor(_color)});
		android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(clr, null, null);
		_view.setBackground(ripdr);
	}
	
	
	public void _removeScollBar (final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
	}
	
	
	public void _Design_UI_Logic () {
		_dotsProgress(linear8, "#00B0FF", "#FFFFFF", 3, 8, 1, 600, 11);
		_rippleRoundStroke(textview6, "#00B0FF", "#33FFFFFF", 10, 2, "#00B0FF");
		_rippleRoundStroke(linear8, "#00B0FF", "#33FFFFFF", 10, 2, "#00B0FF");
		_rippleRoundStroke(textview7, "#0000B0FF", "#16000000", 10, 2, "#E0E0E0");
		_ICC(imageview2, "#9E9E9E", "#00B0FF");
		_NavStatusBarColor("#FFFFFF", "#FFFFFF");
		_RippleEffects("#F5F5F5", imageview2);
		textview9.setVisibility(View.GONE);
		edittext3.setVisibility(View.GONE);
		
		linear7.setVisibility(View.GONE);
		linear8.setVisibility(View.GONE);
		_removeScollBar(vscroll1);
		_DARK_ICONS();
	}
	
	
	public void _Typeface_Logic () {
		_changeActivityFont("en_light");
		textview6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_med.ttf"), 0);
		textview7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_med.ttf"), 0);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_med.ttf"), 0);
	}
	
	
	public void _Edittexts_Logic () {
		_EditTexts(edittext1, textview3, linear3);
		_EditTexts(edittext2, textview4, linear4);
		_EditTexts(edittext3, textview9, linear7);
		edittext2.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
							edittext3.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
					
	}
	
	
	public void _Uncancellable_Dialog () {
		mn.setCancelable(false);
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