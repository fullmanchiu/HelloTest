package cn.colafans.hellotest.view;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.text.format.DateUtils;
import android.util.Log;
import android.widget.TextView;

import java.util.Formatter;
import java.util.Locale;
import java.util.TimeZone;

import cn.colafans.hellotest.R;

public class DateUtilsDemoActivity extends Activity {

    private static final String TAG = "lancelot";
    private TextView textView, ringtone,notification,alarm,all;
    private String date;
    private Formatter formatter;
    private StringBuilder stringBuilder;
    private long mMilliTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_utils_demo);
        textView = findViewById(R.id.tv_date);
        stringBuilder = new StringBuilder(50);
        formatter = new Formatter(stringBuilder, Locale.UK);
        date = DateUtils.formatDateRange(this, formatter, System.currentTimeMillis(), System.currentTimeMillis(), DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_NO_YEAR
                | DateUtils.FORMAT_NO_MONTH_DAY, String.valueOf(TimeZone.getDefault())).toString();
        date = covertToNumber(date);
        textView.setText(date);
        ringtone = findViewById(R.id.tv_ringtone);
        notification = findViewById(R.id.tv_notification);
        alarm = findViewById(R.id.tv_alarm);
        all = findViewById(R.id.tv_all);
        ringtone.setText(updateRingtoneName(this,RingtoneManager.TYPE_RINGTONE));
        notification.setText(updateRingtoneName(this,RingtoneManager.TYPE_NOTIFICATION));
        alarm.setText(updateRingtoneName(this,RingtoneManager.TYPE_ALARM));
        all.setText(updateRingtoneName(this,RingtoneManager.TYPE_ALL));
    }

    private static CharSequence updateRingtoneName(Context context, int type) {
        if (context == null) {
            Log.e(TAG, "Unable to update ringtone name, no context provided");
            return null;
        }
        Uri ringtoneUri = RingtoneManager.getActualDefaultRingtoneUri(context, type);
        CharSequence summary = context.getString(R.string.ringtone_unknown);
        //checkDefaultUri(ringtoneUri,context,type);
        // Is it a silent ringtone?
        if (ringtoneUri == null) {
            summary = context.getString(R.string.ringtone_silent);
        }else {
            Cursor cursor = null;
            try {
                if (MediaStore.AUTHORITY.equals(ringtoneUri.getAuthority())) {
                    // Fetch the ringtone title from the media provider
                    cursor = context.getContentResolver().query(ringtoneUri,
                            new String[] { MediaStore.Audio.Media.TITLE }, null, null, null);
                } else if (ContentResolver.SCHEME_CONTENT.equals(ringtoneUri.getScheme())) {
                    cursor = context.getContentResolver().query(ringtoneUri,
                            new String[] { OpenableColumns.DISPLAY_NAME }, null, null, null);
                }
                if (cursor != null) {
                    if (cursor.moveToFirst()) {
                        summary = cursor.getString(0);
                    /*}else if(!ringtoneUri.toString().startsWith(MediaStore.Audio.Media.INTERNAL_CONTENT_URI.toString())){
						ringtoneUri = queryDefaultUri(context,type);
						if(null != ringtoneUri) RingtoneManager.setActualDefaultRingtoneUri(context,type,ringtoneUri);
						summary = updateRingtoneName(context,type);*/
                    }
                }
            } catch (SQLiteException sqle) {
                // Unknown title for the ringtone
            } catch (IllegalArgumentException iae) {
                // Some other error retrieving the column from the provider
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        Log.d("lancelot", "updateRingtoneName type:" + type + " summary:" + summary);
        return summary;
    }

    private String covertToNumber(String date) {
        String num = date.substring(0, date.length()-1);
        String unit = date.substring(date.length()-1);
        switch (num) {
            case "一":
                num = "1";
                break;
            case "二":
                num = "2";
                break;
            case "三":
                num = "3";
                break;
            case "四":
                num = "4";
                break;
            case "五":
                num = "5";
                break;
            case "六":
                num = "6";
                break;
            case "七":
                num = "7";
                break;
            case "八":
                num = "8";
                break;
            case "九":
                num = "9";
                break;
            case "十":
                num = "10";
                break;
            case "十一":
                num = "11";
                break;
            case "十二":
                num = "12";
                break;
        }
        return num + unit;
    }

    public void setTime(long time) {
        mMilliTime = time;
    }
}
