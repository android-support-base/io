package com.amlzq.asb;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.amlzq.android.encode.Unicode;
import com.amlzq.android.file.PrefsUtil;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends Activity {
    String TAG = "MainActivity";

    Context mContext;
    TextView mTVInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        mTVInfo = findViewById(R.id.tv_info);

//        String message = "Man is distinguished, not only by his reason, but by this singular passion from other animals, which is a lust of the mind, that by a perseverance of delight in the continued and indefatigable generation of knowledge, exceeds the short vehemence of any carnal pleasure.";
//        String output = Base64Util.encode(message);

//        String message = "TWFuIGlzIGRpc3Rpbmd1aXNoZWQsIG5vdCBvbmx5IGJ5IGhpcyByZWFzb24sIGJ1dCBieSB0aGlzIHNpbmd1bGFyIHBhc3Npb24gZnJvbSBvdGhlciBhbmltYWxzLCB3aGljaCBpcyBhIGx1c3Qgb2YgdGhlIG1pbmQsIHRoYXQgYnkgYSBwZXJzZXZlcmFuY2Ugb2YgZGVsaWdodCBpbiB0aGUgY29udGludWVkIGFuZCBpbmRlZmF0aWdhYmxlIGdlbmVyYXRpb24gb2Yga25vd2xlZGdlLCBleGNlZWRzIHRoZSBzaG9ydCB2ZWhlbWVuY2Ugb2YgYW55IGNhcm5hbCBwbGVhc3VyZS4=";
//        String output = Base64Util.decode(message);

        String message = "";
        JSONObject params = new JSONObject();
        try {
            params.put("gameid", "427");
            params.put("extend", "CP_2208020181114");
            params.put("total_amount", "0.01");
            params.put("props_name", Unicode.utf8ToUnicode("商品"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        message = params.toString();
        Log.i(TAG, message);
//        String output = Unicode.encode(message);
//        Log.i(TAG, output);
        mTVInfo.append(message);

        applyPrefsUtil();
    }

    void applyPrefsUtil() {
        PrefsUtil.FILE_NAME = "IO" + "Prefs";
        PrefsUtil.save(mContext, "key_", "value_");
        String value = PrefsUtil.get(mContext, "key_");
        Log.d(TAG, value);
    }

}
