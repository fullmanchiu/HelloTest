package cn.colafans.hellotest.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextClock;

import cn.colafans.hellotest.R;

public class TimeActivity extends Activity {
    TextClock textClock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        textClock = (TextClock) findViewById(R.id.tc);
    }
}
