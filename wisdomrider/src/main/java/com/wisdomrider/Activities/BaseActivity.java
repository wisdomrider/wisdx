package com.wisdomrider.Activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.wisdomrider.WisdomRider;

/*
CREated by avi(Wisdomrider)
on 8/19/2018
*/
public class BaseActivity extends AppCompatActivity {
    public WisdomRider wisdom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wisdom = new WisdomRider(this);

     }

}
