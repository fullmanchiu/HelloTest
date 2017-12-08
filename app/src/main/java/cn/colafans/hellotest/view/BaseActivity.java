package cn.colafans.hellotest.view;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

/**
 * Created by lance on 2017/10/23.
 */

public abstract class BaseActivity extends Activity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        initViews();
        initListener();
    }

    abstract void initViews();

    abstract void initListener();
}
