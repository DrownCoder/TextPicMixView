package com.study.xuan.lib.component;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.study.xuan.lib.MixViewHolder;
import com.study.xuan.lib.R;
import com.study.xuan.lib.model.IMixModel;
import com.study.xuan.shapebuilder.shape.ShapeBuilder;

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
    public MixViewHolder getViewHolder(View root) {
        return new ImageHolder(root);
    }

    public class ImageHolder extends MixViewHolder {
        ImageView mIv;
        ImageView mIvDelete;
        ImageHolder(View itemView) {
            super(itemView);
            mIv = itemView.findViewById(R.id.iv_mix_pic);
            mIvDelete = itemView.findViewById(R.id.iv_mix_delete);
        }

        @Override
        public void bind() {
            IMixModel item = datas.get(pos);

            if (item.hasFocus()) {
                ShapeBuilder.create().Stroke(3, Color.parseColor("#ff8161")).build(mIv);
                mIvDelete.setVisibility(View.VISIBLE);
                mIv.setVisibility(View.VISIBLE);
                mIv.setImageResource(R.drawable.ic_launcher);
                mIv.setFocusable(true);
                mIv.setFocusableInTouchMode(true);
                mIv.requestFocus();
            }else {
                mIvDelete.setVisibility(View.GONE);
                mIv.setVisibility(View.VISIBLE);
                mIv.setBackgroundResource(0);
                mIv.setImageResource(R.drawable.ic_launcher);
                mIv.clearFocus();
            }

        }
    }

}
