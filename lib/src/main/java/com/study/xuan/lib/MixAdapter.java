package com.study.xuan.lib;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ViewGroup;

import com.study.xuan.lib.component.ComponentFactory;
import com.study.xuan.lib.model.IMixModel;

import java.util.List;

/**
 * Author : xuan.
 * Date : 2017/10/26.
 * Description :input the description of this file.
 */

public class MixAdapter extends RecyclerView.Adapter<MixViewHolder> {
    private Context mContext;
    private List<IMixModel> mDatas;
    private ComponentFactory mFactory;
    private TextWatcher mTextWatcher;
    private MixViewHolder mViewHolder;

    public MixAdapter(Context mContext, List<IMixModel> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        mFactory = new ComponentFactory(mContext);
        mTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (mViewHolder != null) {
                    mViewHolder.onTextChange(editable.toString());
                }
            }
        };
    }

    @Override
    public MixViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mViewHolder = mFactory.createViewHolder(viewType, parent);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(MixViewHolder holder, int position) {
        mViewHolder = holder;
        holder.bind(this, mDatas, position);
    }

    @Override
    public int getItemViewType(int position) {
        return mDatas.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

}
