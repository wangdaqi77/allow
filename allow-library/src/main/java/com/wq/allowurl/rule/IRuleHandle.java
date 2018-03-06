package com.wq.allowurl.rule;

import java.io.Serializable;

/**
 * Create by wq on 2018/1/11.
 */

public interface IRuleHandle<V extends Serializable> {

    /**
     * 内存缓存和磁盘缓存的key
     */
    String getKey();

    /**
     * 是否失效
     */
    boolean isDisallow();

    /**
     * 获取可以使用的url
     */
    V getAllowValue();

    /**
     * 设置可以使用的url
     */
    void setAllowValue(V allowValue);

}
