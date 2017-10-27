package com.study.xuan.lib;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.study.xuan.lib.model.IMixModel;
import com.study.xuan.lib.model.MixModel;

import java.util.LinkedList;
import java.util.List;

import static com.study.xuan.lib.Type.TYPE_EDIT;
import static com.study.xuan.lib.Type.TYPE_HEAD;
import static com.study.xuan.lib.Type.TYPE_IMG;

/**
 * Author : xuan.
 * Date : 2017/10/26.
 * Description :input the description of this file.
 */

public class TextPicMixView extends RecyclerView {
    private List<IMixModel> mDatas;
    private Context mContext;
    private MixAdapter mAdapter;

    public TextPicMixView(Context context) {
        this(context, null);
    }

    public TextPicMixView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextPicMixView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        initData();
        init();
    }

    private void init() {
        setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new MixAdapter(mContext, mDatas);
        setAdapter(mAdapter);
    }

    private void initData() {
        IMixModel head = new MixModel(TYPE_HEAD, "", true);
        IMixModel Edit = new MixModel(TYPE_EDIT, "", true);
        mDatas = new LinkedList<>();
        mDatas.add(head);
        mDatas.add(Edit);
    }

    public void setDatas(List<IMixModel> datas) {
        if (datas != null && mDatas != null) {
            mDatas.addAll(datas);
        }
    }

    public void addPic() {
        mDatas.add(new MixModel(TYPE_IMG, "",true));
        mAdapter.notifyDataSetChanged();
    }

    public void addText() {
        mDatas.add(new MixModel(TYPE_EDIT, "",true));
        mAdapter.notifyDataSetChanged();
    }
}
