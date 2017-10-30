package com.study.xuan.lib;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.study.xuan.lib.model.IMixModel;

import java.util.List;

import static com.study.xuan.lib.Type.TYPE_IMG;

/**
 * Author : xuan.
 * Date : 2017/10/27.
 * Description :input the description of this file.
 */

public abstract class MixViewHolder extends RecyclerView.ViewHolder{
    public TextWatcher mWatcher;
    public int pos;
    public List<IMixModel> datas;
    public RecyclerView.Adapter adapter;
    public MixViewHolder(View itemView) {
        super(itemView);
    }

    public void setWatcher(TextWatcher watcher) {
        this.mWatcher = watcher;
    }

    protected void onBind(RecyclerView.Adapter adapter, List<IMixModel> datas, int pos) {
        this.datas = datas;
        this.pos = pos;
        this.adapter = adapter;
        if (datas.get(pos).getType() != TYPE_IMG) {
            mWatcher = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    onTextChange(editable.toString());
                }
            };
        }

        bind();
    }

    protected void bind() {
    }

    protected void onTextChange(String s) {

    }
}
