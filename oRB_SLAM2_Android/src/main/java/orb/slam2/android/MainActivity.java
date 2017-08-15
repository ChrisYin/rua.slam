package orb.slam2.android;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	Button datasetMode, testMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
          WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        setContentView(R.layout.activity_main);
        datasetMode=(Button)findViewById(R.id.dataset_mode);
//        cameraMode=(Button)findViewById(R.id.camera_mode);
		testMode=(Button)findViewById(R.id.test_mode);
        datasetMode.setOnClickListener(this);
//        cameraMode.setOnClickListener(this);
		testMode.setOnClickListener(this);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			ActivityCompat.requestPermissions(this,
					new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA,
							Manifest.permission.INTERNET, Manifest.permission.ACCESS_WIFI_STATE, Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS,
							Manifest.permission.READ_EXTERNAL_STORAGE,
							Manifest.permission.READ_PHONE_STATE,
					}
					, 1);
		}
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.dataset_mode:
			startActivity(new Intent(MainActivity.this,DataSetModeActivity.class));
			break;
//		case R.id.camera_mode:
//			//Toast.makeText(MainActivity.this, "on the way...", Toast.LENGTH_LONG).show();
//			startActivity(new Intent(MainActivity.this,CameraModeActivity.class));
//			break;
		case R.id.test_mode:
			//Toast.makeText(MainActivity.this, "on the way...", Toast.LENGTH_LONG).show();
			startActivity(new Intent(MainActivity.this,TestModeActivity.class));
			break;
		}
	}
}
