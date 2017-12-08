package cn.colafans.hellotest.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import cn.colafans.hellotest.R;
import cn.colafans.hellotest.util.IntentFactory;

/**
 * Created by lance on 2017/10/26.
 */

public class CameraActivity extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private static final String TAG = CameraActivity.class.getSimpleName()+"lancelot";
    private Spinner mSpinner;
    private String cameraId;
    private Button btnStartPreview;
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        initViews();
        initListener();
        //int cameras = Camera.getNumberOfCameras();
        //Log.d(TAG,"cameras : " + cameras);
        //Camera camera = openCamera(1);
    }

    void initViews() {
        mSpinner = (Spinner) findViewById(R.id.camera_id_spinner);
        btnStartPreview = (Button) findViewById(R.id.btn_preview);
    }

    void initListener() {
        mSpinner.setOnItemSelectedListener(this);
        btnStartPreview.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.d(TAG,"[onItemSelected] position:" + position + " id:" + id);
        cameraId = id+"";
        Log.i(TAG, "cameraId:" + cameraId);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_preview:
                startPreview();
                break;
        }
    }

    private void startPreview() {
        startActivity(IntentFactory.getPreviewIntent(mContext));
    }

    public static Camera openCamera(int cameraId) {
        try{
            return Camera.open(cameraId);
        }catch(Exception e) {
            return null;
        }
    }
    public static void followScreenOrientation(Context context, Camera camera){
        final int orientation = context.getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            camera.setDisplayOrientation(180);
        }else if(orientation == Configuration.ORIENTATION_PORTRAIT) {
            camera.setDisplayOrientation(90);
        }
    }
}
