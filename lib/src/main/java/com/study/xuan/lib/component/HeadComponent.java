package com.study.xuan.lib.component;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.study.xuan.lib.MixViewHolder;
import com.study.xuan.lib.R;
import com.study.xuan.lib.model.IMixModel;

import java.util.List;

/**
 * Author : xuan.
 * Date : 2017/10/27.
 * Description :input the description of this file.
 */

public class HeadComponent extends IComponent {
    public HeadComponent(Context mContext) {
        super(mContext);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_mix_head;
    }

    @Override
    public MixViewHolder getViewHolder(View root) {
        return new HeadHolder(root);
    }

    public class HeadHolder extends MixViewHolder {
        private EditText mTvHead;
        public HeadHolder(View itemView) {
            super(itemView);
            mTvHead = itemView.findViewById(R.id.tv_mix_head);
            mTvHead.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (i == EditorInfo.IME_ACTION_UNSPECIFIED) {

                    }
                    return true;
                }
            });
        }

        @Override
        public void bind() {
            mTvHead.setHint(datas.get(pos).getDefault());
            mTvHead.setText(datas.get(pos).getSource());
        }
    }
}
