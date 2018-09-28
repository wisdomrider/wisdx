package com.wisdomrider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.ImageView;

import com.wisdomrider.Activities.BaseActivity;
import com.wisdomrider.Utils.Preferences;

public class MainActivity extends BaseActivity {
    Preferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences=new Preferences(this,"chk",0);
        preferences.putString("avishek1","seven");
        preferences.putInt("avishek2",7);
        preferences.putLong("avishek3",70);
        preferences.putBoolean("avishek4",true);
        preferences.apply();

    }

}
