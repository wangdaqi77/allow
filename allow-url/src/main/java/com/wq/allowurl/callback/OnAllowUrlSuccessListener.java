package com.wq.allowurl.callback;

/**
 *
 * Create by wq on 2018/1/11.
 */

public interface OnAllowUrlSuccessListener<T> {
    void success(T target, String allowUrl);
}
