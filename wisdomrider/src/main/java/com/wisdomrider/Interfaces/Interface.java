package com.wisdomrider.Interfaces;

import android.content.BroadcastReceiver;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wisdomrider.WisdomRider;
import com.wisdomrider.sqliteclosedhelper.SqliteClosedHelper;

/*
CREated by avi(Wisdomrider)
on 8/19/2018
*/
public interface Interface {
    WisdomRider toast(String s);

    TextView textView(int id);

    Button button(int id);

    EditText editText(int id);

    ImageView imageView(int id);

    ProgressBar progressBar(int id);

    RelativeLayout relativeLayout(int id);

    LinearLayout linearLayout(int id);

    AlertDialog alertDialog(String text, final Pass positive, final Pass negative, boolean cancelable);

    void sendBroadcast(String text);

    BroadcastReceiver receiveBroadcast(BroadCast broadCast);

    SqliteClosedHelper initSqliteClosedHelper(String database_name);

    WisdomRider initEncryption(String secretkey, String algorithmkey);

    long getLongSharedPreference(String title);

    String encrypt(String textToEncrypt);

    String decrypt(String textToDecrypt);

    SharedPreferences initSharedPreference(String dbname);

    WisdomRider saveSharedPreference(String title, Object data);

    WisdomRider removeSharedPreference(String title);

    String getStringSharedPreference(String title);

    int getIntSharedPreference(String title);

    boolean getBooleanSharedPreference(String title);


}
