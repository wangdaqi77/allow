package com.wq.allowurl.entity;

import com.wq.allowurl.callback.OnAllowValueCallBack;

import java.io.Serializable;
import java.lang.ref.SoftReference;

/**
 *
 * Create by wq on 2018/1/11.
 */

public class BufferEntity<T,V extends Serializable> {
    private SoftReference<T> target = null;
    private SoftReference<OnAllowValueCallBack<T,V>> callback;

    public BufferEntity(T target, OnAllowValueCallBack<T,V> callback) {
        this.target = new SoftReference<>(target);
        this.callback = new SoftReference<>(callback);
    }

    public void success(V allowValue) {
        if (callback != null && callback.get() != null/* && target != null && target.get() != null*/) {
            callback.get().success(target == null ? null : target.get(), allowValue);
        }
    }
}
