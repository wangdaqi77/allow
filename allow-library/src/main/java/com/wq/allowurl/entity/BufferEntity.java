package com.wq.allowurl.entity;

import com.wq.allowurl.callback.OnAllowValueCallBack;

import java.io.Serializable;
import java.lang.ref.WeakReference;

/**
 * Create by wq on 2018/1/11.
 */

public class BufferEntity<T, V extends Serializable> {
    private WeakReference<T> target = null;
    private WeakReference<OnAllowValueCallBack<T, V>> callback;

    public BufferEntity(T target, OnAllowValueCallBack<T, V> callback) {
        this.target = new WeakReference<>(target);
        this.callback = new WeakReference<>(callback);
    }

    public void success(V allowValue) {
        if (callback != null && callback.get() != null/* && target != null && target.get() != null*/) {
            callback.get().success(target == null ? null : target.get(), allowValue);
        }
    }
}
