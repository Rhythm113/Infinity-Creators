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
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ProgressBar;
import android.widget.Button;
import android.content.Intent;
import android.content.ClipData;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.util.Timer;
import java.util.TimerTask;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.OnProgressListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Continuation;
import android.net.Uri;
import java.io.File;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.cyberalpha.ph.stringdecoy.xor.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class ManualModeActivity extends  AppCompatActivity  { 
	
	public final int REQ_CD_FPS = 101;
	private Timer _timer = new Timer();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private String dir = "";
	private String old_dir = "";
	private String to_dec = "";
	private String dec_data = "";
	private HashMap<String, Object> data = new HashMap<>();
	
	private ArrayList<String> get_dir = new ArrayList<>();
	
	private LinearLayout linear1;
	private TextView textview1;
	private TextView textview2;
	private TextView info;
	private TextView rrsk;
	private TextView pkg;
	private ProgressBar progressbar1;
	private Button button1;
	private Button aply;
	
	private Intent fps = new Intent(Intent.ACTION_GET_CONTENT);
	private AlertDialog.Builder dllls;
	private TimerTask timerr;
	private StorageReference fstore = _firebase_storage.getReference("/");
	private OnCompleteListener<Uri> _fstore_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _fstore_download_success_listener;
	private OnSuccessListener _fstore_delete_success_listener;
	private OnProgressListener _fstore_upload_progress_listener;
	private OnProgressListener _fstore_download_progress_listener;
	private OnFailureListener _fstore_failure_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.manual_mode);
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
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		info = (TextView) findViewById(R.id.info);
		rrsk = (TextView) findViewById(R.id.rrsk);
		pkg = (TextView) findViewById(R.id.pkg);
		progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
		button1 = (Button) findViewById(R.id.button1);
		aply = (Button) findViewById(R.id.aply);
		fps.setType("*/*");
		fps.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		dllls = new AlertDialog.Builder(this);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "Select Your File.");
				startActivityForResult(fps, REQ_CD_FPS);
			}
		});
		
		aply.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "Checking Data...");
				if (FileUtil.isExistFile(FileUtil.getPackageDataDir(getApplicationContext()).concat(data.get("sav_name").toString()))) {
					SketchwareUtil.showMessage(getApplicationContext(), "Using Cached One..");
				}
				else {
					if (data.containsKey("sav_link")) {
						timerr = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										SketchwareUtil.showMessage(getApplicationContext(), "Downloading Activ.sav..");
										_firebase_storage.getReferenceFromUrl(data.get("sav_link").toString()).getFile(new File(FileUtil.getPackageDataDir(getApplicationContext()).concat(data.get("sav_name").toString()))).addOnSuccessListener(_fstore_download_success_listener).addOnFailureListener(_fstore_failure_listener).addOnProgressListener(_fstore_download_progress_listener);
									}
								});
							}
						};
						_timer.schedule(timerr, (int)(500));
						_UnZip(FileUtil.getPackageDataDir(getApplicationContext()).concat(data.get("sav_name").toString()), "/sdcard/");
					}
				}
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
				progressbar1.setProgress((int)_progressValue);
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
				SketchwareUtil.showMessage(getApplicationContext(), _message);
			}
		};
	}
	
	private void initializeLogic() {
		info.setVisibility(View.INVISIBLE);
		rrsk.setVisibility(View.INVISIBLE);
		pkg.setVisibility(View.INVISIBLE);
		aply.setVisibility(View.GONE);
		if (FileUtil.isExistFile(FileUtil.getPackageDataDir(getApplicationContext()).concat("/config.path"))) {
			old_dir = FileUtil.readFile(FileUtil.getPackageDataDir(getApplicationContext()).concat("/config.path"));
			if (FileUtil.isExistFile(old_dir)) {
				dir = old_dir;
				dllls.setTitle("Note :");
				dllls.setMessage("Previously Selected Config File Found at : ".concat(old_dir.concat(". Wanna Use that ?")));
				dllls.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						if (dir.contains(".icconf")) {
							to_dec = FileUtil.readFile(dir);
							info.setTextColor(0xFF673AB7);
							info.setVisibility(View.VISIBLE);
							info.setText("Checking Data..");
							button1.setVisibility(View.GONE);
							StringFogImpl fgh = new StringFogImpl();
							dec_data = fgh.decrypt(to_dec,new ManualModeActivity().getClass().getPackage().getName().toString());
							data = new Gson().fromJson(dec_data, new TypeToken<HashMap<String, Object>>(){}.getType());
							info.setText("Features : ".concat(data.get("features").toString()));
							aply.setVisibility(View.VISIBLE);
							FileUtil.writeFile(FileUtil.getPackageDataDir(getApplicationContext()).concat("/config.path"), dir);
							SketchwareUtil.showMessage(getApplicationContext(), "Using Old Data..");
						}
						else {
							info.setTextColor(0xFFF44336);
							info.setVisibility(View.VISIBLE);
							info.setText("Unsupported File...");
						}
					}
				});
				dllls.setNegativeButton("No", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						SketchwareUtil.showMessage(getApplicationContext(), "Okay...");
						aply.setVisibility(View.GONE);
					}
				});
				dllls.create().show();
			}
			else {
				SketchwareUtil.showMessage(getApplicationContext(), "Old Config Was Moved Or Deleted..");
			}
		}
		else {
			SketchwareUtil.showMessage(getApplicationContext(), "Welcome To Manual Mode..");
		}
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_FPS:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				dir = _filePath.get((int)(0));
				SketchwareUtil.showMessage(getApplicationContext(), "Loading...");
				if (dir.contains(".icconf")) {
					to_dec = FileUtil.readFile(dir);
					info.setTextColor(0xFF673AB7);
					info.setVisibility(View.VISIBLE);
					info.setText("Checking Data..");
					button1.setVisibility(View.GONE);
					StringFogImpl fgh = new StringFogImpl();
					dec_data = fgh.decrypt(to_dec,new ManualModeActivity().getClass().getPackage().getName().toString());
					data = new Gson().fromJson(dec_data, new TypeToken<HashMap<String, Object>>(){}.getType());
					info.setText("Features : ".concat(data.get("features").toString()));
					aply.setVisibility(View.VISIBLE);
					rrsk.setVisibility(View.VISIBLE);
					rrsk.setText("Risk Level : ".concat(data.get("risk").toString()));
					pkg.setVisibility(View.VISIBLE);
					rrsk.setText("Game Package : ".concat(data.get("package").toString()));
					FileUtil.writeFile(FileUtil.getPackageDataDir(getApplicationContext()).concat("/config.path"), dir);
				}
				else {
					info.setTextColor(0xFFF44336);
					info.setVisibility(View.VISIBLE);
					info.setText("Unsupported File...");
				}
			}
			else {
				SketchwareUtil.showMessage(getApplicationContext(), "Operation Cancelled..");
			}
			break;
			default:
			break;
		}
	}
	
	public void _UnZip (final String _fileZip, final String _destDir) {
		try
		{
			java.io.File outdir = new java.io.File(_destDir);
			java.util.zip.ZipInputStream zin = new java.util.zip.ZipInputStream(new java.io.FileInputStream(_fileZip));
			java.util.zip.ZipEntry entry;
			String name, dir;
			while ((entry = zin.getNextEntry()) != null)
			{
				name = entry.getName();
				if(entry.isDirectory())
				{
					mkdirs(outdir, name);
					continue;
				}
				
				/* this part is necessary because file entry can come before
* directory entry where is file located
* i.e.:
* /foo/foo.txt
* /foo/
*/
				
				dir = dirpart(name);
				if(dir != null)
				mkdirs(outdir, dir);
				
				extractFile(zin, outdir, name);
			}
			zin.close();
		}
		catch (java.io.IOException e)
		{
			e.printStackTrace();
		}
	}
	private static void extractFile(java.util.zip.ZipInputStream in, java.io.File outdir, String name) throws java.io.IOException
	{
		byte[] buffer = new byte[4096];
		java.io.BufferedOutputStream out = new java.io.BufferedOutputStream(new java.io.FileOutputStream(new java.io.File(outdir, name)));
		int count = -1;
		while ((count = in.read(buffer)) != -1)
		out.write(buffer, 0, count);
		out.close();
	}
	
	private static void mkdirs(java.io.File outdir, String path)
	{
		java.io.File d = new java.io.File(outdir, path);
		if(!d.exists())
		d.mkdirs();
	}
	
	private static String dirpart(String name)
	{
		int s = name.lastIndexOf(java.io.File.separatorChar);
		return s == -1 ? null : name.substring(0, s);
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