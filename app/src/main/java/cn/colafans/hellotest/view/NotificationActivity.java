package cn.colafans.hellotest.view;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

import cn.colafans.hellotest.R;


public class NotificationActivity extends Activity implements View.OnClickListener{
    private Button btnSend;
    private NotificationManager manager;

    Locale locale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        initViews();
        initListener();
        locale = getResources().getConfiguration().locale;
    }

    void initViews() {
        btnSend = (Button) findViewById(R.id.btn_send);
    }

    void initListener() {
        btnSend.setOnClickListener(this);
    }

    private void sendNotification() {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("111")
                .setContentText("111")
                .setFullScreenIntent(pendingIntent,false)
                //.setPriority(Notification.PRIORITY_MAX)
                //.setDefaults(Notification.DEFAULT_ALL)
                .setAutoCancel(true);


        manager.notify(1,builder.build());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send:
                Log.d("lancelot","11111");
                sendNotification();
                break;
            default:
        }
    }

//    // 为发送通知的按钮的点击事件定义事件处理方法
//    public void send(View source) {
//        // 创建一个启动其他Activity的Intent
//        Intent intent = new Intent(NotificationTest.this, OtherActivity.class);
//        // 单击Notification 通知时将会启动Intent 对应的程序，实现页面的跳转
//        PendingIntent pi = PendingIntent.getActivity(NotificationTest.this, 0, intent, 0);
//
//        Notification notify = new Notification.Builder(this)
//                // 设置打开该通知，该通知自动消失
//                .setAutoCancel(true)
//                // 设置显示在状态栏的通知提示信息
//                .setTicker(有新消息)
//                // 设置通知的图标
//                .setSmallIcon(R.drawable.notify)
//                // 设置通知内容的标题
//                .setContentTitle(一条新通知)
//                // 设置通知内容
//                .setContentText(恭喜你，您加薪了，工资增加20%!)
//                // // 设置使用系统默认的声音、默认LED灯
//                // .setDefaults(Notification.DEFAULT_SOUND
//                // |Notification.DEFAULT_LIGHTS)
//                // 设置通知的自定义声音
//                .setSound(
//                        Uri.parse(android.resource://org.crazyit.ui/
//        + R.raw.msg))
//                .setWhen(System.currentTimeMillis())
//                // 设改通知将要启动程序的Intent
//                .setContentIntent(pi)
//                .getNotification();
//        // 发送通知
//        nm.notify(NOTIFICATION_ID, notify);
//    }

}
