package cn.colafans.hellotest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;

public class MediaButtonReceiver extends BroadcastReceiver {
    private static final int DELAY_TIME = 250;
    private static String TAG = "lancelot";
    private static int clickCount = 0;
    private static final Runnable CLICK = new Runnable() {
        @Override
        public void run() {
            Log.d("lancelot", " do click");
            clickCount = 0;
        }
    };
    private static final Runnable DOUBLECLICK = new Runnable() {
        @Override
        public void run() {
            Log.d("lancelot", " do double click");
            clickCount = 0;
        }
    };
    private static Handler handler = new Handler();

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);

        if (Intent.ACTION_MEDIA_BUTTON.equals(intentAction)) {
            int keyCode = keyEvent.getKeyCode();
            int keyAction = keyEvent.getAction();
            switch (keyCode) {
                case KeyEvent.KEYCODE_HEADSETHOOK:
                    if (keyAction == KeyEvent.ACTION_UP) {
                        clickCount++;
                        if (clickCount % 2 == 1) {
                            handler.postDelayed(CLICK, DELAY_TIME);
                        } else if (clickCount % 2 == 0) {
                            handler.removeCallbacks(CLICK);
                            handler.postDelayed(DOUBLECLICK, DELAY_TIME);
                        }
                    }
                    break;
            }
        }
    }
}