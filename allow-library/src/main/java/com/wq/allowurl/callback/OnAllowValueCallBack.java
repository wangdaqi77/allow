package com.wq.allowurl.callback;

import com.wq.allowurl.rule.IRuleHandle;

import java.io.Serializable;

/**
 * Create by wq on 2018/1/11.
 */

public interface OnAllowValueCallBack<T, V extends Serializable> {
    /**
     * @param allowValue key为null时值为null
     * @see IRuleHandle#getKey()  key
     */
    void success(T target, V allowValue);
}
