package com.study.xuan.lib.component;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import com.study.xuan.lib.MixViewHolder;
import com.study.xuan.lib.R;
import com.study.xuan.lib.model.MixModel;

import static com.study.xuan.lib.Type.TYPE_EDIT;

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
    public MixViewHolder getViewHolder(View root) {
        return new EditHolder(root);
    }

    class EditHolder extends MixViewHolder {
        EditText mEdit;

        public EditHolder(View itemView) {
            super(itemView);
            mEdit = itemView.findViewById(R.id.et_mix_content);
        }

        @Override
        public void bind() {
            if (datas.get(pos).hasFocus()) {
                mEdit.setFocusable(true);
                mEdit.setFocusableInTouchMode(true);
                mEdit.requestFocus();
            } else {
                mEdit.setFocusable(false);
            }
            mEdit.removeTextChangedListener(mWatcher);
            mEdit.setText(datas.get(pos).getSource());
            mEdit.setSelection(datas.get(pos).getSource().length());
            mEdit.setHint(datas.get(pos).getDefault());
            mEdit.addTextChangedListener(mWatcher);
            mEdit.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (keyEvent != null && keyEvent.getAction() == keyEvent.ACTION_DOWN) {
                        switch (i) {
                            case KeyEvent.KEYCODE_DEL:
                                //删除
                                doDel(view);
                                break;
                            case KeyEvent.KEYCODE_ENTER:
                                //回车
                                doEnter();
                                break;
                        }
                    }
                    return false;
                }
            });
        }

        private void doEnter() {
            datas.add(new MixModel(TYPE_EDIT, "", true, ""));
            adapter.notifyDataSetChanged();
        }

        private void doDel(View view) {
            if (((EditText) view).getSelectionStart() == 0) {
                if (pos > 1) {
                    datas.get(pos - 1).append(datas.get(pos).getSource());
                    datas.remove(pos);
                    adapter.notifyDataSetChanged();
                }
            }
        }

        @Override
        public void onTextChange(String s) {
            datas.get(pos).setSource(s);
        }
    }
}
