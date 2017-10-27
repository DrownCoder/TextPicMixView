package com.study.xuan.lib.model;


/**
 * Author : xuan.
 * Date : 2017/10/26.
 * Description :input the description of this file.
 */

public class MixModel implements IMixModel {
    int type;
    String source;
    boolean hasFocus;

    public MixModel(int typeText, String s,boolean hasFocus) {
        type = typeText;
        source = s;
        this.hasFocus = hasFocus;
    }

    @Override
    public void append(String s) {
        source += s;
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public void setSource(String s) {
        this.source = s;
    }

    @Override
    public boolean hasFocus() {
        return hasFocus;
    }

    public void setFocus(boolean hasFocus) {
        this.hasFocus = hasFocus;
    }
}
