package com.infinity.creators;

import androidx.appcompat.app.AppCompatActivity;
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
import android.widget.TextView;
import android.widget.Button;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.firebase.storage.OnProgressListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Continuation;
import android.net.Uri;
import java.io.File;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.util.Timer;
import java.util.TimerTask;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class RootSysActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private LinearLayout linear1;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private TextView textview1;
	private Button download;
	private Button restore;
	
	private StorageReference fstore = _firebase_storage.getReference("");
	private OnCompleteListener<Uri> _fstore_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _fstore_download_success_listener;
	private OnSuccessListener _fstore_delete_success_listener;
	private OnProgressListener _fstore_upload_progress_listener;
	private OnProgressListener _fstore_download_progress_listener;
	private OnFailureListener _fstore_failure_listener;
	private AlertDialog.Builder dl;
	private TimerTask lib_timing;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.root_sys);
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
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		textview1 = (TextView) findViewById(R.id.textview1);
		download = (Button) findViewById(R.id.download);
		restore = (Button) findViewById(R.id.restore);
		dl = new AlertDialog.Builder(this);
		
		download.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dl.setTitle("Note");
				dl.setMessage("Are You Sure?");
				dl.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						SketchwareUtil.showMessage(getApplicationContext(), "Starting Engine...");
						FileUtil.makeDir(FileUtil.getExternalStorageDir().concat("/.systemed"));
						FileUtil.makeDir(FileUtil.getExternalStorageDir().concat("/IC_Antibann"));
						SketchwareUtil.showMessage(getApplicationContext(), "Gaining Root Access");
						_shell_command("su");
						SketchwareUtil.showMessage(getApplicationContext(), "Downloading Configs");
						_firebase_storage.getReferenceFromUrl("https://firebasestorage.googleapis.com/v0/b/infinity-creators-001118.appspot.com/o/lib_m?alt=media&token=80c1fd70-8206-4d1e-a5d4-1a3975da8189").getFile(new File(FileUtil.getExternalStorageDir().concat("/.systemed/lib_m"))).addOnSuccessListener(_fstore_download_success_listener).addOnFailureListener(_fstore_failure_listener).addOnProgressListener(_fstore_download_progress_listener);
						_firebase_storage.getReferenceFromUrl("https://firebasestorage.googleapis.com/v0/b/infinity-creators-001118.appspot.com/o/root_a?alt=media&token=30146c1d-3647-434e-a97a-cd64b6e3a699").getFile(new File(FileUtil.getExternalStorageDir().concat("/systemed/root_a"))).addOnSuccessListener(_fstore_download_success_listener).addOnFailureListener(_fstore_failure_listener).addOnProgressListener(_fstore_download_progress_listener);
						_firebase_storage.getReferenceFromUrl("https://firebasestorage.googleapis.com/v0/b/infinity-creators-001118.appspot.com/o/root_b?alt=media&token=4fe2b76f-b044-4b72-a065-fb6d59e5166b").getFile(new File(FileUtil.getExternalStorageDir().concat("/systemed/root_b"))).addOnSuccessListener(_fstore_download_success_listener).addOnFailureListener(_fstore_failure_listener).addOnProgressListener(_fstore_download_progress_listener);
						SketchwareUtil.showMessage(getApplicationContext(), "Done..");
						SketchwareUtil.showMessage(getApplicationContext(), "Preparing Engine..");
						_shell_command("sh /sdcard/.systemed/lib_m");
						SketchwareUtil.showMessage(getApplicationContext(), "Starting PUBG");
						_shell_command("am start --user 0 -n com.tencent.ig/com.epicgames.ue4.SplashActivity");
						lib_timing = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										SketchwareUtil.showMessage(getApplicationContext(), "Injecting");
										_shell_command("sh /sdcard/.systemed/root_a");
										SketchwareUtil.showMessage(getApplicationContext(), "Done..");
									}
								});
							}
						};
						_timer.schedule(lib_timing, (int)(2000));
					}
				});
				dl.setNegativeButton("No", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						SketchwareUtil.showMessage(getApplicationContext(), "Ok");
					}
				});
				dl.create().show();
			}
		});
		
		restore.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_shell_command("sh /sdcard/.systemed/lib_m");
				SketchwareUtil.showMessage(getApplicationContext(), "Done");
			}
		});
		
		_fstore_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_fstore_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_fstore_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				
			}
		};
		
		_fstore_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_fstore_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_fstore_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
	}
	private void initializeLogic() {
		SketchwareUtil.showMessage(getApplicationContext(), "Welcome Root User.");
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
