package com.study.xuan.lib;

import android.support.v7.widget.RecyclerView;
import android.text.TextWatcher;
import android.view.View;

import com.study.xuan.lib.model.IMixModel;

import java.util.List;

/**
 * Author : xuan.
 * Date : 2017/10/27.
 * Description :input the description of this file.
 */

public abstract class MixViewHolder extends RecyclerView.ViewHolder{
    public TextWatcher mWatcher;
    public int pos;
    public MixViewHolder(View itemView) {
        super(itemView);
    }

    public void setWatcher(TextWatcher watcher) {
        this.mWatcher = watcher;
    }


    public void setPos(int pos) {
        this.pos = pos;
    }

    public void bind(RecyclerView.Adapter adapter, List<IMixModel> mixModel, int pos){

    }

    public void onTextChange(String s){

    };
}
