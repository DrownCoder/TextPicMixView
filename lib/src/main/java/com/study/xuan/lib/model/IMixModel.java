package com.study.xuan.lib.model;

/**
 * Author : xuan.
 * Date : 2017/10/26.
 * Description :input the description of this file.
 */

public interface IMixModel {
    int getType();

    String getSource();

    void setSource(String s);

    void append(String s);

    boolean hasFocus();

    void setFocus(boolean hasFocus);

    String getDefault();

    void setDefault(String df);
}
