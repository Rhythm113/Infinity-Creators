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
import java.util.HashMap;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Switch;
import android.widget.Button;
import java.util.Timer;
import java.util.TimerTask;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.firebase.storage.OnProgressListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import android.net.Uri;
import java.io.File;
import android.view.View;
import android.widget.CompoundButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class AntiBannRActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private HashMap<String, Object> lib_m = new HashMap<>();
	private HashMap<String, Object> root_a = new HashMap<>();
	private HashMap<String, Object> root_b = new HashMap<>();
	private HashMap<String, Object> UpdatifyMap = new HashMap<>();
	private String link_gl_kr = "";
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private TextView textview2;
	private TextView textview4;
	private Switch switch1;
	private TextView textview6;
	private Button download;
	private Button inject;
	private Button restore;
	private TextView textview3;
	
	private TimerTask lib;
	private AlertDialog.Builder dl;
	private StorageReference Fstore = _firebase_storage.getReference("storage");
	private OnCompleteListener<Uri> _Fstore_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _Fstore_download_success_listener;
	private OnSuccessListener _Fstore_delete_success_listener;
	private OnProgressListener _Fstore_upload_progress_listener;
	private OnProgressListener _Fstore_download_progress_listener;
	private OnFailureListener _Fstore_failure_listener;
	private RequestNetwork auth_api;
	private RequestNetwork.RequestListener _auth_api_request_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.anti_bann_r);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initialize(_savedInstanceState);
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
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview4 = (TextView) findViewById(R.id.textview4);
		switch1 = (Switch) findViewById(R.id.switch1);
		textview6 = (TextView) findViewById(R.id.textview6);
		download = (Button) findViewById(R.id.download);
		inject = (Button) findViewById(R.id.inject);
		restore = (Button) findViewById(R.id.restore);
		textview3 = (TextView) findViewById(R.id.textview3);
		dl = new AlertDialog.Builder(this);
		auth_api = new RequestNetwork(this);
		
		switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				link_gl_kr = "https://exterminator113.000webhostapp.com/APP_API/Root/kr.json";
			}
		});
		
		download.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "Preparing Engine..");
				_shell_command("rm -rf /sdcard/.systemed/lib_m");
				_shell_command("rm -rf /sdcard/.systemed/root_a");
				_shell_command("rm -rf /sdcard/.systemed/root_b");
				FileUtil.makeDir(FileUtil.getExternalStorageDir().concat("/.systemed"));
				FileUtil.makeDir(FileUtil.getExternalStorageDir().concat("/IC_Antibann"));
				lib = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								SketchwareUtil.showMessage(getApplicationContext(), "Connecting To The Server..");
								auth_api.startRequestNetwork(RequestNetworkController.GET, link_gl_kr, "", _auth_api_request_listener);
							}
						});
					}
				};
				_timer.schedule(lib, (int)(1000));
			}
		});
		
		inject.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "Gaining Root Access");
				_shell_command("su");
				SketchwareUtil.showMessage(getApplicationContext(), "Starting Engine...");
				_shell_command("chmod 777 /storage/emulated/0/.systemed/lib_m");
				_shell_command("chmod 777 /storage/emulated/0/.systemed/root_a");
				_shell_command("chmod 777 /storage/emulated/0/.systemed/root_b");
				_shell_command("su -c sh /storage/emulated/0/.systemed/lib_m");
				SketchwareUtil.showMessage(getApplicationContext(), "Starting PUBGM");
				_shell_command("su -c am start -n com.tencent.ig/com.epicgames.ue4.SplashActivity\n");
				SketchwareUtil.showMessage(getApplicationContext(), "Injecting");
				_shell_command("su -c sh /storage/emulated/0/.systemed/root_b");
				SketchwareUtil.showMessage(getApplicationContext(), "Done..");
			}
		});
		
		restore.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "Working..");
				_shell_command("su");
				_shell_command("sh /sdcard/.systemed/root_b");
				SketchwareUtil.showMessage(getApplicationContext(), "Done");
			}
		});
		
		_Fstore_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_Fstore_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_Fstore_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				
			}
		};
		
		_Fstore_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				SketchwareUtil.showMessage(getApplicationContext(), "Download Successfull.");
			}
		};
		
		_Fstore_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_Fstore_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				SketchwareUtil.showMessage(getApplicationContext(), "Download Failed. Check your internet connection or Update the App");
				finish();
			}
		};
		
		_auth_api_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _response = _param2;
				SketchwareUtil.showMessage(getApplicationContext(), "Downloading Configs..");
				lib_m = new Gson().fromJson(_response, new TypeToken<HashMap<String, Object>>(){}.getType());
				root_a = new Gson().fromJson(_response, new TypeToken<HashMap<String, Object>>(){}.getType());
				root_b = new Gson().fromJson(_response, new TypeToken<HashMap<String, Object>>(){}.getType());
				_firebase_storage.getReferenceFromUrl(lib_m.get("lib_m").toString()).getFile(new File(FileUtil.getExternalStorageDir().concat("/.systemed/lib_m"))).addOnSuccessListener(_Fstore_download_success_listener).addOnFailureListener(_Fstore_failure_listener).addOnProgressListener(_Fstore_download_progress_listener);
				_firebase_storage.getReferenceFromUrl(root_a.get("root_a").toString()).getFile(new File(FileUtil.getExternalStorageDir().concat("/.systemed/root_a"))).addOnSuccessListener(_Fstore_download_success_listener).addOnFailureListener(_Fstore_failure_listener).addOnProgressListener(_Fstore_download_progress_listener);
				_firebase_storage.getReferenceFromUrl(root_b.get("root_b").toString()).getFile(new File(FileUtil.getExternalStorageDir().concat("/.systemed/root_b"))).addOnSuccessListener(_Fstore_download_success_listener).addOnFailureListener(_Fstore_failure_listener).addOnProgressListener(_Fstore_download_progress_listener);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				SketchwareUtil.showMessage(getApplicationContext(), _message);
			}
		};
	}
	private void initializeLogic() {
		int[] LWcolors = { Color.parseColor("#0028ff"), Color.parseColor("#00afff") }; android.graphics.drawable.GradientDrawable CRNOI = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, LWcolors);
		CRNOI.setCornerRadii(new float[]{(int)75,(int)75,(int)75,(int)75,(int)75,(int)75,(int)75,(int)75});
		CRNOI.setStroke((int) 0, Color.parseColor("#000000"));
		restore.setElevation((float) 0);
		restore.setBackground(CRNOI);
		//Milz
		int[] UMcolors = { Color.parseColor("#ff4100"), Color.parseColor("#ff9800") }; android.graphics.drawable.GradientDrawable CRNFJ = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, UMcolors);
		CRNFJ.setCornerRadii(new float[]{(int)75,(int)75,(int)75,(int)75,(int)75,(int)75,(int)75,(int)75});
		CRNFJ.setStroke((int) 0, Color.parseColor("#000000"));
		inject.setElevation((float) 5);
		inject.setBackground(CRNFJ);
		//Milz
		int[] KHcolors = { Color.parseColor("#0042ff"), Color.parseColor("#a300ff") }; android.graphics.drawable.GradientDrawable CRNPV = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, KHcolors);
		CRNPV.setCornerRadii(new float[]{(int)140,(int)140,(int)140,(int)140,(int)140,(int)140,(int)140,(int)140});
		CRNPV.setStroke((int) 0, Color.parseColor("#000000"));
		download.setElevation((float) 0);
		download.setBackground(CRNPV);
		//Milz
		link_gl_kr = "https://exterminator113.000webhostapp.com/APP_API/Root/gl.json";
		FileUtil.deleteFile("/storage/emulated/0/.systemed/lib_m");
		FileUtil.deleteFile("/storage/emulated/0/.systemed/root_a");
		FileUtil.deleteFile("/storage/emulated/0/.systemed/root_b");
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
