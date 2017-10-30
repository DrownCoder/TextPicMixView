package com.study.xuan.lib.component;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.study.xuan.lib.MixViewHolder;

import static com.study.xuan.lib.Type.TYPE_EDIT;
import static com.study.xuan.lib.Type.TYPE_HEAD;
import static com.study.xuan.lib.Type.TYPE_IMG;

/**
 * Author : xuan.
 * Date : 2017/10/27.
 * Description :input the description of this file.
 */

public class ComponentFactory {
    private IComponent mConponent;
    private Context mContext;

    public ComponentFactory(Context mContext) {
        this.mContext = mContext;
    }

    public MixViewHolder createViewHolder(int type, ViewGroup parent) {
        switch (type) {
            case TYPE_IMG:
                mConponent = new ImageComponent(mContext);
                break;
            case TYPE_EDIT:
                mConponent = new EditComponent(mContext);
                break;
            case TYPE_HEAD:
                mConponent = new HeadComponent(mContext);
                break;
        }
        return mConponent.createViewHolder(parent);
    }
}
