package com.wisdomrider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;

import com.wisdomrider.Activities.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wisdom.initEncryption("avi", "shek");
        wisdom.textView(R.id.hi).setText(wisdom.encrypt("hey ! "));
        wisdom.textView(R.id.hello).setText(wisdom.decrypt("36daeb95cb627069c2aa3ad6c019a18f"));


        }

}
