package com.wisdomrider;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.appcompat.app.AlertDialog;
import android.text.Html;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.wisdomrider.Interfaces.BroadCast;
import com.wisdomrider.Interfaces.Interface;
import com.wisdomrider.Interfaces.Pass;
import com.wisdomrider.Interfaces.Receiver;
import com.wisdomrider.Utils.Preferences;
import com.wisdomrider.sqliteclosedhelper.SqliteClosedHelper;

import static com.wisdomrider.Utils.Constants.ACTION;

/*
CREated by avi(Wisdomrider)
on 8/19/2018
*/
public class WisdomRider implements Interface {
    public Context context;
    public Activity activity;
    public BroadcastReceiver mReceiver;
    Preferences preferences;
    public SqliteClosedHelper sqliteClosedHelper;
    Encryption encryption;

    public WisdomRider(Context c) {
        context = c;
    }

    public WisdomRider(Activity c) {
        context = c;
        activity = c;
    }


    @Override
    public WisdomRider toast(String s) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
        return this;
    }


    @Override
    public TextView textView(int id) {
        return activity.findViewById(id);
    }

    @Override
    public Button button(int id) {
        return activity.findViewById(id);
    }

    @Override
    public EditText editText(int id) {
        return activity.findViewById(id);
    }

    @Override
    public Spinner spinner(int id) {
        return activity.findViewById(id);
    }

    @Override
    public Object object(int id) {
        return activity.findViewById(id);
    }

    @Override
    public ImageView imageView(int id) {
        return activity.findViewById(id);
    }

    @Override
    public ProgressBar progressBar(int id) {
        return activity.findViewById(id);
    }

    @Override
    public RelativeLayout relativeLayout(int id) {
        return activity.findViewById(id);
    }

    @Override
    public LinearLayout linearLayout(int id) {
        return activity.findViewById(id);
    }

    public AlertDialog alertDialog(String text, final Pass positive, final Pass negative, boolean cancelable) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(Html.fromHtml(text));
        if (positive != null) {
            String positiveText = positive.value();
            builder.setPositiveButton(positiveText,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            positive.function(dialog);
                        }
                    });
        }
        if (negative != null) {
            String negativeText = negative.value();
            builder.setNegativeButton(negativeText,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            negative.function(dialog);
                        }
                    });
        }
        AlertDialog dialog = builder.create();
        dialog.setCancelable(cancelable);
        dialog.show();
        return dialog;
    }

    public static void sendBroadcast(Context c, String what) {
        Intent i = new Intent(ACTION).putExtra("DATA", what);
        c.sendBroadcast(i);
    }

    public static void sendBroadcast(Context c, Intent what) {
        what.setAction(ACTION);
        c.sendBroadcast(what);
    }

    public BroadcastReceiver sendBroadcast(String text) {
        Intent i = new Intent(ACTION).putExtra("DATA", text);
        context.sendBroadcast(i);
        return mReceiver;
    }

    public BroadcastReceiver sendBroadcast(Intent text) {
        text.setAction(ACTION);
        context.sendBroadcast(text);
        return mReceiver;
    }

    @Override
    public BroadcastReceiver receiveBroadcast(final BroadCast broadCast) {
        IntentFilter intentFilter = new IntentFilter(
                "android.intent.action.MAIN");
        mReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                String msg_for_me = intent.getStringExtra("DATA").trim();
                broadCast.thingtoBroadCast(msg_for_me);
            }

        };
        activity.registerReceiver(mReceiver, intentFilter);
        return mReceiver;

    }

    @Override
    public BroadcastReceiver receiveBroadcast(final Receiver broadCast) {
        IntentFilter intentFilter = new IntentFilter(
                "android.intent.action.MAIN");
        mReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                broadCast.pass(context, intent);
            }

        };
        activity.registerReceiver(mReceiver, intentFilter);
        return mReceiver;

    }

    @Override
    public SqliteClosedHelper initSqliteClosedHelper(String database_name) {
        sqliteClosedHelper = new SqliteClosedHelper(context, database_name);
        return sqliteClosedHelper;
    }

    @Override
    public WisdomRider initEncryption(String secretkey, String algorithmkey) {
        encryption = new Encryption(secretkey, algorithmkey);
        return this;
    }


    @Override
    public String encrypt(String textToEncrypt) {
        try {
            byte[] b = encryption.encrypt(textToEncrypt);
            return Encryption.bytesToHex(b);
        } catch (Exception e) {
            Log.e("ERR", e.getMessage());
        }
        return "";
    }


    @Override
    public String decrypt(String textToDecrypt) {
        try {
            return new String(encryption.decrypt(textToDecrypt));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public Preferences initSharedPreference(String dbname) {
        preferences = new Preferences(context, dbname, 0);
        return preferences;
    }


}
