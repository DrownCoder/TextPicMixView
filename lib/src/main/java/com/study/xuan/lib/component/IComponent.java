package com.study.xuan.lib.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.study.xuan.lib.MixViewHolder;

/**
 * Author : xuan.
 * Date : 2017/10/27.
 * Description :input the description of this file.
 */

public abstract class IComponent {
    protected Context mContext;

    public IComponent(Context mContext) {
        this.mContext = mContext;
    }

    public View getView(ViewGroup parent) {
        return LayoutInflater.from(mContext)
                .inflate(getLayoutId(), parent, false);
    }

    public abstract int getLayoutId();

    public abstract MixViewHolder getViewHolder(ViewGroup parent);
}
