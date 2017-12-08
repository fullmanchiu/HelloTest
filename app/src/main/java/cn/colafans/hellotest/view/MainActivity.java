package cn.colafans.hellotest.view;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.colafans.hellotest.MediaButtonReceiver;
import cn.colafans.hellotest.R;
import cn.colafans.hellotest.util.IntentFactory;

public class MainActivity extends Activity implements View.OnClickListener {
    AudioManager mAudioManager;
    ComponentName mbCN;
    private Context mContext = this;
    private Button mNotification, mCamera, mTime, mBroadCast, mIntent, mDateUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListener();
        //获得AudioManager对象
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        //构造一个ComponentName，指向MediaoButtonReceiver类
        //下面为了叙述方便，我直接使用ComponentName类来替代MediaoButtonReceiver类
        mbCN = new ComponentName(getPackageName(), MediaButtonReceiver.class.getName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        //注册一个MedioButtonReceiver广播监听
        mAudioManager.registerMediaButtonEventReceiver(mbCN);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //取消注册的方法
        mAudioManager.unregisterMediaButtonEventReceiver(mbCN);
    }

    void initViews() {
        mNotification = findViewById(R.id.btn_notification);
        mCamera = findViewById(R.id.btn_camera);
        mTime = findViewById(R.id.btn_time);
        mBroadCast = findViewById(R.id.btn_broadcast);
        mIntent = findViewById(R.id.btn_intent);
        mDateUtils = findViewById(R.id.btn_date_utils);
    }

    void initListener() {
        mNotification.setOnClickListener(this);
        mCamera.setOnClickListener(this);
        mTime.setOnClickListener(this);
        mBroadCast.setOnClickListener(this);
        mIntent.setOnClickListener(this);
        mDateUtils.setOnClickListener(this);
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode, Configuration newConfig) {
        super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig);
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        super.onMultiWindowModeChanged(isInMultiWindowMode);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_notification:
                startActivity(IntentFactory.getNotificationIntent(mContext));
                break;
            case R.id.btn_camera:
                startActivity(IntentFactory.getCameraIntent(mContext));
                break;
            case R.id.btn_time:
                startActivity(IntentFactory.getTimeIntent(mContext));
                break;
            case R.id.btn_broadcast:
                startActivity(IntentFactory.getBroadCastIntent(mContext));
                break;
            case R.id.btn_intent:
                startActivity(IntentFactory.getIntentIntent(mContext));
                break;
            case R.id.btn_date_utils:
                startActivity(IntentFactory.getDateUtilsIntent(mContext));
            default:
        }
    }
}
