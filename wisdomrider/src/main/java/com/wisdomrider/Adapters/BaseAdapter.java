package com.wisdomrider.Adapters;

/*
CREated by avi(Wisdomrider)
on 9/11/2018
*/

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.wisdomrider.R;

public  class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.WisdomHolder> {
    @Override
    public  WisdomHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom, parent, false);
        return new WisdomHolder(itemView);

    }


    @Override
    public void onBindViewHolder(final WisdomHolder holder, final int position) {

    }



    @Override
    public int getItemCount() {

        return 0;
    }

    public class WisdomHolder extends RecyclerView.ViewHolder {

        public WisdomHolder(View itemView) {
            super(itemView);
        }
    }

}
