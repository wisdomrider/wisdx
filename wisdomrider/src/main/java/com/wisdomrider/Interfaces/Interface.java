package com.wisdomrider.Interfaces;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.wisdomrider.Utils.Preferences;
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

    Spinner spinner(int id);

    Object object(int id);

    ImageView imageView(int id);

    ProgressBar progressBar(int id);

    RelativeLayout relativeLayout(int id);

    LinearLayout linearLayout(int id);

    AlertDialog alertDialog(String text, final Pass positive, final Pass negative, boolean cancelable);

    BroadcastReceiver sendBroadcast(String text);

    BroadcastReceiver sendBroadcast(Intent text);

    BroadcastReceiver receiveBroadcast(BroadCast broadCast);

    BroadcastReceiver receiveBroadcast(Receiver broadCast);

    SqliteClosedHelper initSqliteClosedHelper(String database_name);

    WisdomRider initEncryption(String secretkey, String algorithmkey);


    String encrypt(String textToEncrypt);

    String decrypt(String textToDecrypt);

    Preferences initSharedPreference(String dbname);



}
