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
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Switch;
import android.widget.CheckBox;
import android.content.Intent;
import android.net.Uri;
import java.util.Timer;
import java.util.TimerTask;
import android.widget.CompoundButton;
import android.view.View;
import com.cyberalpha.ph.stringdecoy.xor.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class FreeActivity extends  AppCompatActivity  { 
	
	private Timer _timer = new Timer();
	
	private String game_package = "";
	private String Zero = "";
	private String view = "";
	private String fps_90 = "";
	private String grass_n = "";
	private String jump_f = "";
	private String fog_n = "";
	private String black_sky = "";
	private String less_recoilenc = "";
	private String magic_bullet_usereng = "";
	private String magic_usergame = "";
	private String less_recv2 = "";
	private String damage_usereng = "";
	
	private LinearLayout linear9;
	private LinearLayout linear1;
	private LinearLayout linear5;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear6;
	private LinearLayout linear10;
	private ProgressBar progressbar1;
	private Button start;
	private LinearLayout linear8;
	private Button end;
	private TextView textview4;
	private TextView textview5;
	private TextView textview1;
	private TextView textview2;
	private Switch gl;
	private Switch kr;
	private Switch lite;
	private Button reset;
	private TextView textview3;
	private CheckBox fps;
	private CheckBox grass;
	private CheckBox sky;
	private CheckBox ipad;
	private CheckBox fog;
	private CheckBox magic_bullet;
	private CheckBox zero;
	private CheckBox jump;
	private CheckBox less_recoil;
	private CheckBox damage;
	private CheckBox manual;
	
	private Intent launchIntent = new Intent();
	private TimerTask tm;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.free);
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
		
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
		start = (Button) findViewById(R.id.start);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		end = (Button) findViewById(R.id.end);
		textview4 = (TextView) findViewById(R.id.textview4);
		textview5 = (TextView) findViewById(R.id.textview5);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		gl = (Switch) findViewById(R.id.gl);
		kr = (Switch) findViewById(R.id.kr);
		lite = (Switch) findViewById(R.id.lite);
		reset = (Button) findViewById(R.id.reset);
		textview3 = (TextView) findViewById(R.id.textview3);
		fps = (CheckBox) findViewById(R.id.fps);
		grass = (CheckBox) findViewById(R.id.grass);
		sky = (CheckBox) findViewById(R.id.sky);
		ipad = (CheckBox) findViewById(R.id.ipad);
		fog = (CheckBox) findViewById(R.id.fog);
		magic_bullet = (CheckBox) findViewById(R.id.magic_bullet);
		zero = (CheckBox) findViewById(R.id.zero);
		jump = (CheckBox) findViewById(R.id.jump);
		less_recoil = (CheckBox) findViewById(R.id.less_recoil);
		damage = (CheckBox) findViewById(R.id.damage);
		manual = (CheckBox) findViewById(R.id.manual);
		
		start.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				progressbar1.setVisibility(View.VISIBLE);
				SketchwareUtil.showMessage(getApplicationContext(), "Please Wait..");
				tm = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								StringFogImpl maingfs = new StringFogImpl();
								StringFogImpl maingfd = new StringFogImpl();
								StringFogImpl tempfs = new StringFogImpl();
								FileUtil.deleteFile(FileUtil.getExternalStorageDir().concat("/Android/data/".concat(game_package.concat(maingfs.decrypt("TAkEQgwdSTwrXTMYQwZdNgkVCx0ENx0MTQILFCwWHQYYATAaBAUbGCYBAgwGSxsrHh0cCFs6QQ0UDAZbOgEWESoDSQAAA0cHBx0= ",new FreeActivity().getClass().getPackage().getName().toString())))));
								FileUtil.writeFile(FileUtil.getExternalStorageDir().concat(tempfs.decrypt("TEEOQgYNDUY7GhELaw0VDA8RQRsdCg==",new FreeActivity().getClass().getPackage().getName().toString())), Zero.concat(jump_f.concat(fps_90.concat(grass_n.concat(view.concat(black_sky.concat(fog_n.concat(less_recoilenc.concat(magic_bullet_usereng.concat(damage_usereng))))))))));
								FileUtil.writeFile(FileUtil.getExternalStorageDir().concat(tempfs.decrypt("TEEOQgYNDUY7GhELaQIfAE8dARs=",new FreeActivity().getClass().getPackage().getName().toString())), magic_usergame.concat(less_recv2));
								FileUtil.moveFile(FileUtil.getExternalStorageDir().concat(tempfs.decrypt("TEEOQgYNDUY7GhELaw0VDA8RQRsdCg==",new FreeActivity().getClass().getPackage().getName().toString())), FileUtil.getExternalStorageDir().concat("/Android/data/".concat(game_package.concat(maingfs.decrypt("TAkEQgwdSTwrXTMYQwZdNgkVCx0ENx0MTQILFCwWHQYYATAaBAUbGCYBAgwGSxsrHh0cCFs6QQ0UDAZbOgEWESoDSQAAA0cHBx0= ",new FreeActivity().getClass().getPackage().getName().toString())))));
								FileUtil.moveFile(FileUtil.getExternalStorageDir().concat(tempfs.decrypt("TEEOQgYNDUY7GhELaQIfAE8dARs=",new FreeActivity().getClass().getPackage().getName().toString())), FileUtil.getExternalStorageDir().concat("/Android/data/".concat(game_package.concat(maingfd.decrypt("TAkEQgwdSTwrXTMYQwZdNgkVCx0ENx0MTQILFCwWHQYYATAaBAUbGCYBAgwGSxsrHh0cCFs6QQ0UDAZbOgEWESgMQwxADwcH",new FreeActivity().getClass().getPackage().getName().toString())))));
								_LaunchApp(game_package);
								progressbar1.setVisibility(View.GONE);
								SketchwareUtil.showMessage(getApplicationContext(), "Patching..");
								tm = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												FileUtil.deleteFile(FileUtil.getExternalStorageDir().concat("/Android/data/".concat(game_package.concat(maingfs.decrypt("TAkEQgwdSTwrXTMYQwZdNgkVCx0ENx0MTQILFCwWHQYYATAaBAUbGCYBAgwGSxsrHh0cCFs6QQ0UDAZbOgEWESoDSQAAA0cHBx0= ",new FreeActivity().getClass().getPackage().getName().toString())))));
												FileUtil.deleteFile(FileUtil.getExternalStorageDir().concat("/Android/data/".concat(game_package.concat(maingfd.decrypt("TAkEQgwdSTwrXTMYQwZdNgkVCx0ENx0MTQILFCwWHQYYATAaBAUbGCYBAgwGSxsrHh0cCFs6QQ0UDAZbOgEWESgMQwxADwcH",new FreeActivity().getClass().getPackage().getName().toString())))));
												StringFogImpl toastr = new StringFogImpl();
												SketchwareUtil.showMessage(getApplicationContext(), toastr.decrypt("ocZNZwcIDwcHHQ1ZbREXBBUbHQE=",new FreeActivity().getClass().getPackage().getName().toString()));
											}
										});
									}
								};
								_timer.schedule(tm, (int)(25000));
							}
						});
					}
				};
				_timer.schedule(tm, (int)(1500));
			}
		});
		
		end.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.deleteFile(FileUtil.getExternalStorageDir().concat("/Android/data/".concat(game_package.concat("/files/ProgramBinaryCache/"))));
				FileUtil.deleteFile(FileUtil.getExternalStorageDir().concat("/Android/data/".concat(game_package.concat("/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Config/UserEngine.ini"))));
				FileUtil.deleteFile(FileUtil.getExternalStorageDir().concat("/Android/data/".concat(game_package.concat("/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Config/UserGame.ini"))));
				SketchwareUtil.showMessage(getApplicationContext(), "Done..");
			}
		});
		
		textview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				launchIntent.setData(Uri.parse("https://t.me/Rhythm113"));
				launchIntent.setAction(Intent.ACTION_VIEW);
				startActivity(launchIntent);
			}
		});
		
		textview5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				StringFogImpl linkk = new StringFogImpl();
				launchIntent.setAction(Intent.ACTION_VIEW);
				launchIntent.setData(Uri.parse(linkk.decrypt("CxsZXhpUSUYaRxkcASocAwgaBgYKIB0ITx0BFBpf",new FreeActivity().getClass().getPackage().getName().toString())));
				startActivity(launchIntent);
			}
		});
		
		gl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				game_package = "com.tencent.ig";
				lite.setEnabled(false);
				gl.setEnabled(false);
				kr.setEnabled(false);
				fps.setEnabled(true);
				grass.setEnabled(true);
				sky.setEnabled(true);
				ipad.setEnabled(true);
				jump.setEnabled(true);
				zero.setEnabled(true);
				fog.setEnabled(true);
				start.setEnabled(true);
				end.setEnabled(true);
				magic_bullet.setEnabled(true);
				less_recoil.setEnabled(true);
				damage.setEnabled(true);
				manual.setEnabled(false);
				SketchwareUtil.showMessage(getApplicationContext(), "You Can't Use User & Manual Mode Together..");
			}
		});
		
		kr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				game_package = "com.pubg.krmobile";
				lite.setEnabled(false);
				gl.setEnabled(false);
				kr.setEnabled(false);
				fps.setEnabled(true);
				grass.setEnabled(true);
				sky.setEnabled(true);
				ipad.setEnabled(true);
				jump.setEnabled(true);
				zero.setEnabled(true);
				fog.setEnabled(true);
				start.setEnabled(true);
				end.setEnabled(true);
				magic_bullet.setEnabled(true);
				less_recoil.setEnabled(true);
				damage.setEnabled(true);
				manual.setEnabled(false);
				SketchwareUtil.showMessage(getApplicationContext(), "You Can't Use User & Manual Mode Together..");
			}
		});
		
		lite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				game_package = "com.tencent.iglite";
				lite.setEnabled(false);
				gl.setEnabled(false);
				kr.setEnabled(false);
				fps.setEnabled(true);
				grass.setEnabled(true);
				sky.setEnabled(true);
				ipad.setEnabled(true);
				jump.setEnabled(true);
				zero.setEnabled(true);
				fog.setEnabled(true);
				start.setEnabled(true);
				end.setEnabled(true);
				magic_bullet.setEnabled(true);
				less_recoil.setEnabled(true);
				damage.setEnabled(true);
				manual.setEnabled(false);
				SketchwareUtil.showMessage(getApplicationContext(), "You Can't Use User & Manual Mode Together..");
			}
		});
		
		reset.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				game_package = "  ";
				Zero = " ";
				view = "";
				fps_90 = "";
				grass_n = "";
				jump_f = "";
				fog_n = "";
				black_sky = "";
				damage_usereng = "";
				progressbar1.setVisibility(View.INVISIBLE);
				fps.setEnabled(false);
				grass.setEnabled(false);
				sky.setEnabled(false);
				ipad.setEnabled(false);
				jump.setEnabled(false);
				zero.setEnabled(false);
				fog.setEnabled(false);
				start.setEnabled(false);
				end.setEnabled(false);
				magic_bullet.setEnabled(false);
				less_recoil.setEnabled(false);
				gl.setChecked(false);
				kr.setChecked(false);
				lite.setChecked(false);
				fps.setChecked(false);
				grass.setChecked(false);
				sky.setChecked(false);
				ipad.setChecked(false);
				jump.setChecked(false);
				zero.setChecked(false);
				fog.setChecked(false);
				damage.setChecked(false);
				magic_bullet.setChecked(false);
				less_recoil.setChecked(false);
				gl.setEnabled(true);
				kr.setEnabled(true);
				lite.setEnabled(true);
				start.setEnabled(false);
				end.setEnabled(false);
				damage.setEnabled(false);
				manual.setChecked(false);
				manual.setEnabled(true);
				SketchwareUtil.showMessage(getApplicationContext(), "Done..");
			}
		});
		
		fps.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				StringFogImpl enfps = new StringFogImpl();
				fps_90 = enfps.decrypt("ODwUXR0LCzoLHQAQQAQBOGsGQSImISggTxE9ExkeBgYNfxYTCQgAFj4WFQoBE1pkFEc+PDY+agYEDAIRKSIgLwAaE1BebBtAOSE7aScXEwgXCjQjMCIESlRXVmMcRyQsbCQ2ABcdDBc1MzwlRw4GW1BeYwZXfjYwIiURGRsQBik9fSEqNFRXWX4LADMnJyYwCgQaAAorfjo7Ch0cCDw9fF5LVWs=",new FreeActivity().getClass().getPackage().getName().toString());
				fps.setEnabled(false);
			}
		});
		
		grass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				StringFogImpl engrass = new StringFogImpl();
				grass_n = engrass.decrypt("OEA+TRsHFh1BLBoeRw0XSzMRARYWEQofYR8LFBsHDREqSxcGDA8THC95BB0MXRpADgwHDhwNfQATCQRJX3h5",new FreeActivity().getClass().getPackage().getName().toString());
				grass.setEnabled(false);
			}
		});
		
		sky.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		sky.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				StringFogImpl enfogngrass = new StringFogImpl();
				black_sky = enfogngrass.decrypt("ODwUXR0LCzoLHQAQQAQBOGsGQTEKDwYDSgwcKwgWLQYYWSsXDAYcG09KWldUJBtAIAYJVERz",new FreeActivity().getClass().getPackage().getName().toString());
				sky.setEnabled(false);
				fog.setEnabled(false);
				fog_n = "";
			}
		});
		
		ipad.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				StringFogImpl enipad = new StringFogImpl();
				view = enipad.decrypt("OEA+TRsHFh1BLBoeRw0XSy0bDBMfMwMMVwwcO2MvGgQcTRcgBBUdADMLChwuQQcdEhsPABoNE1N4",new FreeActivity().getClass().getPackage().getName().toString());
				ipad.setEnabled(false);
			}
		});
		
		fog.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				StringFogImpl fogg = new StringFogImpl();
				fog_n = fogg.decrypt("ODwUXR0LCzoLHQAQQAQBOGsGQTQcBFJdJGNk",new FreeActivity().getClass().getPackage().getName().toString());
				fog.setEnabled(false);
			}
		});
		
		magic_bullet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				StringFogImpl mv11 = new StringFogImpl();
				StringFogImpl mv12 = new StringFogImpl();
				magic_bullet_usereng = mv11.decrypt("OC4EQy8CCR4zYycRQRc6DBU3AAcdF1JJeAgCEwxkOhwWWisXBAU8BgYwDBoDWlQjBxFkOhwWWjMXFxIbAToaFywCWwcaWyQvMX4qRgwGNQQGHB0dKAYBQioBEwcaVDk4dml4Pi0bDBMfMAcCQR0mDx0qCAAYc2kwEA0YCgY3DBgDEyQvPmM9ARsWWiocEQQGGRMfXgkBQQgabCgHBDIWWF5BbwMBAx4WFysMQwgJAzsLDQEaSzETEQgbUj8SG2UsWx0BJwADOgQcSwdPVmt+NCEbDAAZeQwPFgYAKwEVQgYGJwAHCi95Jw4ATw4LMhAeDEkfQgwTEWs6ADUBAhkEWhA8BwcJDElJJGkpNgkbAAYkBg4dQQcrCB0HHQ0kJCEHFxIAPBocDBsvWwUCAx0dJwEUEy4zPWs2Gh4fBhsrRxsLNRkLDBBEYyIqbywVFzAGDwMIWicbCyAAJhocbQ8bFVw5Lip5Lg4VbBwCCgwaJwEUZw0wBBMGCh5OBQ4BXQxkMAYCBREAfQsdChU2Gh4fBhseYBwDWyQPEX4KRgwdETUNHxdOBQMCTx1kMQwPGRsXZgoGNQAGGzEcBQlQYwgWbC0PBBUeSzETEQRJVngwEQAeXSEPDxs6EAQcE1Z4MgQVHx0dIgYAaCY4W1o=",new FreeActivity().getClass().getPackage().getName().toString());
				magic_usergame = mv12.decrypt("OEA+TRsHFh1BOhwYSgwFMRMVDBkWESoVWhsPSDo6LAwNXAIwBBIRLBoSEQ4OWgwcO2MCGlo8QAIQCQQwDh8SBApQehsbA2MpDAAtTxEVABUkAxMKBh1QYyg2bCoCABEXWisbESMbFyISERsnWw0JCwwAHUlAAFZ4Jg0dChwHKwYZfggcEiMbDRMUSw0GWCw1N3gwDwYIQB0vDwQvGgcQXRc4EAUTAhcdF1JUF2MtCgALBwA4Rw4iBBMAUjo2IitnbQUHAwcaKwEVQgYGLQgAPxMBFyUYSg4DAwcaVDw8byd4Jg0dChwHKwoMShoGCR0+DAYaSw0GBAYRUktKaSwBRwwAEiELCBAKRgwGLxQQCBceBgEZE1BXbGM1OhcLRxMGNgkVCx0ENx0MTQILFCwWHQYYADAmIBkAHRMxAhwIbQEPFAgNHRELc2kxCQgRAQY7ChsdTxsaLBwKDhkcQBdPKAAMZTEfCgoDWiEHEjkPGwAzWwcVCAQaG09KWmUuQgALCB0vABk4XRAbFhU+GhYUDgoDWlRXX2MtBR0cQBczDAwkDgAHXicoby1kJQUHDBoNbBYeCQQAJxsHMw4fWiMbAg4DDBoNEys3JCV+LB4aBgEZZgwPAhoGBgApSxERAA8ADhUWXlZUJCoCDwwAHTwcTwcBDQ4AJQcXBAoASwcaW1BXYzcVRwYcESMBAx4WFysMQwgJAyMbDRMcQwYcEVxNVngwDwYIQB0oNjokHBAeSw4XCxVJIjMqaSwBRwwAEiEHHQQYXBc4EAUTAhcdF1IgTxFkMxoLOhwWQRckABMdCQs2G1IuQgALCB0mAAApTxEGLxQQCB8WDRs=",new FreeActivity().getClass().getPackage().getName().toString());
				magic_bullet.setEnabled(false);
			}
		});
		
		zero.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				StringFogImpl zerog = new StringFogImpl();
				Zero = zerog.decrypt("OEA+TRsHFh1BLBoeRw0XSzEcFgEaABw+Sx0aDwcJGilzagYUBBQYGzUBAhkEWhA0W1peD35z",new FreeActivity().getClass().getPackage().getName().toString());
				jump.setEnabled(false);
				zero.setEnabled(false);
				SketchwareUtil.showMessage(getApplicationContext(), "You Can't Enable Zero Gravity & Jump Float Together.");
			}
		});
		
		jump.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				StringFogImpl jff = new StringFogImpl();
				jump_f = jff.decrypt("OEA+TRsHFh1BLBoeRw0XSzEcFgEaABw+Sx0aDwcJGilzagYUBBQYGyYWEQIEQAgCMAwCBhcQWhpPSFASZXg=",new FreeActivity().getClass().getPackage().getName().toString());
				jump.setEnabled(false);
				zero.setEnabled(false);
				SketchwareUtil.showMessage(getApplicationContext(), "You Can't Enable Zero Gravity & Jump Float Together.");
			}
		});
		
		less_recoil.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				StringFogImpl lrenc = new StringFogImpl();
				StringFogImpl lrencv = new StringFogImpl();
				less_recoilenc = lrenc.decrypt("OC4ZWggNDS8CBgMkI2kwEA0YCgY3AgIMSQxTV1leZH47Ww8eABUnHxcWB1IgTxFjbCsbBRgcWiAdFhVJIjMrbmU6SwgeCQcvABk/YTVPUlRaXxR+aT0ITQYHClReR0IfI2kASzMRDB0aD1JdAF8Ia2M8DBcWRw8/ChcRN09eV1pDHg9jbDsLChsQQi4dEwQtUkZGTV8LI2MvEx0BKB0UfRMXAAVJIhMLbmUlRx0+BxsaVDk4dg==",new FreeActivity().getClass().getPackage().getName().toString());
				less_recv2 = lrencv.decrypt("OC4ZWggNDS8CBgMkJCEHCQ0RGzYSDg4KS1RfVllkKwEVQgYGNhERChZOLg4VJCsbCgULHTcWXRdPKCAsZSUWAh8CQCgHCy8hP0lKJDEXBg4dA09DaR1DfAwNCQACVERzfAYRCggYIh0FBjdQA1xebDsLChsQQi4dEwQtUkdDaS4YWgYvDwQ9GREcSl4/JDl+JxsHMw4fWlQjJzFkYy8pQgILABM3Dh8WEQ4gTwcPAQwcNjckJDYxBAwRHRMgCw4GS1Re",new FreeActivity().getClass().getPackage().getName().toString());
				less_recoil.setEnabled(false);
			}
		});
		
		damage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				StringFogImpl dmggg = new StringFogImpl();
				damage_usereng = dmggg.decrypt("ODwFQQYaMAwcABIAbQwcAwgTMngwDwYIQB0jExMUBRExSwoVDRU5DgpOLi41JGM1NT0+Bh0XWicTCAATCjcFBgEZADkBDwcaLRUUTwQXIBcRAQZdJw4ATw4LIx8LBwAkJCIEBBUVHTYSDg4KSzkBFQAaABsXEwUTCRIRZTYSDg4KSyADFhwCGhFEaCwkb2svKBMeBjwIWh0HCA4zYzUQQyIBFggHG08+IjdnfQAAAQULOhwWWjQXBBEbASEbDAAZYwYKA1QjCAxzbwAGChM1ARseAhsEQQc9EQAaChxESAIeFgR+LAAcEBwlTwAcW1lkJREfWisTCwUyBgAWXiIsdmMiNDoGBhsNfQ0bFQQGPAUaFwwFEyQvPmNkMjUNWgIRDicYAAUuaS0YQgULEi0PBBUeS15DVVF+LQcfDwoZfRkLAw1TJBUBJCEHCQ0RGzEcEBtQYyg2bD4LCAQWQCIbCCc7OU9AaS4YWgYvDwQ9GREcSl4/JDl+JxsHMw4fWlQjJzFkYy84Rw40CQ4DMnggCwAZZgAaJQYbBwBECjUTCRQRZSEbDBslSwgKLgAaKhsMQBdPKAAMZSEbDBs9SxsdCQcmAAA6QRYcEVw5Lip5MAcCWjkLFBoBBz8QQg8xChQaG08+IjdnJDIiCQoPBScRQQwGLQgAKxMHAjJnbBwCCgwaLRsOQF4/JDl+PBocDBskQB0LFB8PBUkfQgwTEWs1Bh81DBlQHWMMEwUCDAA9Tw4TAgQmChYGAAo/Tx0HCVQjCAxzbxYGCiAdAiEDBgoJE1pkbDI9ARsWWjQXBBEbATAGDwMIWisPFQwzYzAYQwIVADUNHxdOBQMCTx1kKAYpGxUPRxcLNwAaCBdOUw==",new FreeActivity().getClass().getPackage().getName().toString());
				damage.setEnabled(false);
			}
		});
		
		manual.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		manual.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					gl.setEnabled(false);
					kr.setEnabled(false);
					lite.setEnabled(false);
					start.setEnabled(false);
					end.setEnabled(false);
					launchIntent.setClass(getApplicationContext(), ManualModeActivity.class);
					startActivity(launchIntent);
				}
				else {
					
				}
			}
		});
	}
	
	private void initializeLogic() {
		int[] GRcolors = { Color.parseColor("#4c00ff"), Color.parseColor("#00dcff") }; android.graphics.drawable.GradientDrawable CRNXJ = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, GRcolors);
		CRNXJ.setCornerRadii(new float[]{(int)55,(int)55,(int)55,(int)55,(int)55,(int)55,(int)55,(int)55});
		CRNXJ.setStroke((int) 0, Color.parseColor("#000000"));
		start.setElevation((float) 60);
		start.setBackground(CRNXJ);
		
		int[] HUcolors = { Color.parseColor("#ff0400"), Color.parseColor("#ff00c6") }; android.graphics.drawable.GradientDrawable CRNOU = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, HUcolors);
		CRNOU.setCornerRadii(new float[]{(int)55,(int)55,(int)55,(int)55,(int)55,(int)55,(int)55,(int)55});
		CRNOU.setStroke((int) 0, Color.parseColor("#000000"));
		end.setElevation((float) 60);
		end.setBackground(CRNOU);
		
		int[] TOcolors = { Color.parseColor("#ff0007"), Color.parseColor("#ff008e") }; android.graphics.drawable.GradientDrawable CRNCT = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, TOcolors);
		CRNCT.setCornerRadii(new float[]{(int)55,(int)55,(int)55,(int)55,(int)55,(int)55,(int)55,(int)55});
		CRNCT.setStroke((int) 0, Color.parseColor("#000000"));
		reset.setElevation((float) 5);
		reset.setBackground(CRNCT);
		
		progressbar1.setVisibility(View.INVISIBLE);
		fps.setEnabled(false);
		grass.setEnabled(false);
		sky.setEnabled(false);
		ipad.setEnabled(false);
		jump.setEnabled(false);
		zero.setEnabled(false);
		fog.setEnabled(false);
		start.setEnabled(false);
		end.setEnabled(false);
		magic_bullet.setEnabled(false);
		less_recoil.setEnabled(false);
		damage.setEnabled(false);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _LaunchApp (final String _Pack) {
		Intent launchi = getPackageManager().getLaunchIntentForPackage(_Pack);
		
		if (launchi != null)
		
		{
			
			startActivity(launchi);
			
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