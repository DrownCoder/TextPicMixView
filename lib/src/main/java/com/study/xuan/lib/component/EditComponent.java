package com.study.xuan.lib.component;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.study.xuan.lib.MixViewHolder;
import com.study.xuan.lib.R;
import com.study.xuan.lib.model.IMixModel;

import java.util.List;

/**
 * Author : xuan.
 * Date : 2017/10/27.
 * Description :input the description of this file.
 */

public class EditComponent extends IComponent {

    public EditComponent(Context mContext) {
        super(mContext);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_mix_edit;
    }

    @Override
    public MixViewHolder getViewHolder(ViewGroup parent) {
        return new EditHolder(getView(parent));
    }

    class EditHolder extends MixViewHolder {
        EditText mEdit;

        public EditHolder(View itemView) {
            super(itemView);
            mEdit = itemView.findViewById(R.id.et_mix_content);
        }

        @Override
        public void bind(final RecyclerView.Adapter adapter, final List<IMixModel> datas, final
        int pos) {
            if (datas.get(pos).hasFocus()) {
                mEdit.setFocusable(true);
                mEdit.setFocusableInTouchMode(true);
                mEdit.requestFocus();
            } else {
                mEdit.clearFocus();
            }
            mEdit.removeTextChangedListener((TextWatcher) mEdit.getTag());
            mEdit.setText(datas.get(pos).getSource());
            mWatcher = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    datas.get(pos).setSource(editable.toString());
                }
            };
            mEdit.addTextChangedListener(mWatcher);
            mEdit.setTag(mWatcher);
            mEdit.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == KeyEvent.KEYCODE_DEL) {
                        if (((EditText) view).getSelectionStart() == 0) {
                            if (pos > 1) {
                                datas.get(pos - 1).setFocus(true);
                                datas.get(pos - 1).append(datas.get(pos).getSource());
                                datas.remove(pos);
                                adapter.notifyDataSetChanged();
                            }
                        }
                    }
                    return false;
                }
            });
        }
    }
}
