package com.study.xuan.lib;

import android.util.SparseArray;

/**
 * Author : xuan.
 * Date : 2017/10/27.
 * Description :input the description of this file.
 */

public class Type {
    public static final int TYPE_IMG = 0;
    public static final int TYPE_EDIT = 1;
    public static final int TYPE_HEAD = 2;

    private static final SparseArray<Integer> type = new SparseArray<Integer>(){
        {
            append(TYPE_IMG, R.layout.item_mix_img);
            append(TYPE_EDIT,R.layout.item_mix_edit);
            append(TYPE_HEAD, R.layout.item_mix_head);
        }
    };

}
