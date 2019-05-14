package com.wisdomrider;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WisdomEditText extends LinearLayout {
    Context context;
    AttributeSet attributeSet;
    public EditText editText;
    public LinearLayout linearLayout;
    public TextView name;
    public View v;
    public View line;

    public WisdomEditText(Context context) {
        super(context);
        init(context, null);
    }

    private void init(final Context context, AttributeSet attributeSet) {
        this.context = context;
        this.attributeSet = attributeSet;
        this.setOrientation(VERTICAL);
        v = LayoutInflater.from(context).inflate(R.layout.custom, null);
        line = v.findViewById(R.id.view);
        editText = v.findViewById(R.id.edit);
        name = v.findViewById(R.id.name);
        linearLayout = v.findViewById(R.id.name_layout);
        TypedArray attributes = context.obtainStyledAttributes(attributeSet, R.styleable.WisdomEditText);
        editText.setHint(attributes.getString(R.styleable.WisdomEditText_hint));
        addView(v);
        editText.setTextColor(attributes.getInt(R.styleable.WisdomEditText_edittextcolor, R.color.purple_primary));
        linearLayout.setBackgroundResource(attributes.getInt(R.styleable.WisdomEditText_textbackground, R.color.purple_primary));
        line.setBackgroundColor(attributes.getInt(R.styleable.WisdomEditText_linecolor, R.color.purple_primary));
        name.setTextColor(attributes.getInt(R.styleable.WisdomEditText_textcolor, R.color.purple_primary));
        editText.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {

                } else {
                    editText.setVisibility(GONE);
                    name.setText(editText.getText().toString());
                    linearLayout.setVisibility(VISIBLE);
                }
            }
        });
        name.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setVisibility(VISIBLE);
                linearLayout.setVisibility(GONE);
                editText.requestFocus();
            }
        });

    }

    public String getText() {
        return editText.getText().toString();
    }

    public WisdomEditText setText(String s) {
        editText.setText(s);
        return this;
    }


    public WisdomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);

    }

    public WisdomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public WisdomEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);

    }
}
