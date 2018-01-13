package com.wq.allowurl.inter;

/**
 * Create by wq on 2018/1/11.
 */

public interface IRuleHandle {

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
    String getAllowUrl();

    /**
     * 设置可以使用的url
     */
    void setAllowUrl(String allowUrl);

}
