package com.study.xuan.lib.component;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.study.xuan.lib.MixViewHolder;
import com.study.xuan.lib.R;
import com.study.xuan.lib.model.IMixModel;

import java.util.List;

/**
 * Author : xuan.
 * Date : 2017/10/27.
 * Description :input the description of this file.
 */

class ImageComponent extends IComponent {

    public ImageComponent(Context mContext) {
        super(mContext);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_mix_img;
    }

    @Override
    public MixViewHolder getViewHolder(ViewGroup parent) {
        return new ImageHolder(getView(parent));
    }

    public class ImageHolder extends MixViewHolder {
        ImageView mIv;
        ImageHolder(View itemView) {
            super(itemView);
            mIv = itemView.findViewById(R.id.iv_mix_pic);
        }

        @Override
        public void bind(RecyclerView.Adapter adapter, List<IMixModel> datas, int pos) {
            mIv.setImageResource(R.drawable.ic_launcher);
            mIv.setFocusable(true);
            mIv.setFocusableInTouchMode(true);
            mIv.requestFocus();
        }
    }

}
