package cn.colafans.hellotest.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import cn.colafans.hellotest.R;

public class BroadcastActivity extends Activity implements View.OnClickListener {

    private Button btnSendBc1, btnSendBc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        btnSendBc1 = findViewById(R.id.btn_send_bc1);
        btnSendBc2 = findViewById(R.id.btn_send_bc2);
        btnSendBc1.setOnClickListener(this);
        btnSendBc2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send_bc1:
                send(1);
                break;
            case R.id.btn_send_bc2:
                send(2);
                break;
        }
    }

    private void send(int i) {
        Intent intent = new Intent();
        //intent.setAction("...");

        if (i == 1) {
            intent.setAction("cn.colafans.enable");
        } else if (i == 2) {
            intent.setAction("cn.colafans.disable");
        }
        Log.d("lancelot","intent:" + intent);
        sendBroadcast(intent);
    }
}
