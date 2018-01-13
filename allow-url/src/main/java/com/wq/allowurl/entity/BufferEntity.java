package com.wq.allowurl.entity;

import com.wq.allowurl.callback.OnAllowUrlSuccessListener;

import java.lang.ref.SoftReference;

/**
 *
 * Create by wq on 2018/1/11.
 */

public class BufferEntity<T> {
    private SoftReference<T> target = null;
    private SoftReference<OnAllowUrlSuccessListener<T>> callback;

    public BufferEntity(T target, OnAllowUrlSuccessListener<T> callback) {
        this.target = new SoftReference<>(target);
        this.callback = new SoftReference<>(callback);
    }

    public void success(String allowUrl) {
        if (callback != null && callback.get() != null/* && target != null && target.get() != null*/) {
            callback.get().success(target == null ? null : target.get(), allowUrl);
        }
    }
}
