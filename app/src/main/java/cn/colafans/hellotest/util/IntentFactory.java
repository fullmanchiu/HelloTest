package cn.colafans.hellotest.util;

import android.content.Context;
import android.content.Intent;

import cn.colafans.hellotest.view.BroadcastActivity;
import cn.colafans.hellotest.view.CameraActivity;
import cn.colafans.hellotest.view.DateUtilsDemoActivity;
import cn.colafans.hellotest.view.IntentActivity;
import cn.colafans.hellotest.view.NotificationActivity;
import cn.colafans.hellotest.view.PreviewActivity;
import cn.colafans.hellotest.view.RvSampleActivity;
import cn.colafans.hellotest.view.TimeActivity;

/**
 * Created by lance on 2017/10/23.
 */

public class IntentFactory {
    private static Intent intent;
    public static Intent getNotificationIntent(Context mContext) {
        intent = new Intent(mContext, NotificationActivity.class);
        return intent;
    }

    public static Intent getCameraIntent(Context mContext) {
        intent = new Intent(mContext, CameraActivity.class);
        return intent;
    }

    public static Intent getPreviewIntent(Context context) {
        intent = new Intent(context, PreviewActivity.class);
        return intent;
    }

    public static Intent getTimeIntent(Context mContext) {
        intent = new Intent(mContext, TimeActivity.class);
        return intent;
    }

    public static Intent getBroadCastIntent(Context mContext) {
        intent = new Intent(mContext, BroadcastActivity.class);
        return intent;
    }

    public static Intent getIntentIntent(Context mContext) {
        intent = new Intent(mContext, IntentActivity.class);
        return intent;
    }

    public static Intent getDateUtilsIntent(Context mContext) {
        intent = new Intent(mContext, DateUtilsDemoActivity.class);
        return intent;
    }

    public static Intent getRvIntent(Context mContext) {
        intent = new Intent(mContext, RvSampleActivity.class);
        return intent;
    }
}
