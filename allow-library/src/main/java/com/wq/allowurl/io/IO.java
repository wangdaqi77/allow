package com.wq.allowurl.io;

import java.io.Serializable;

/**
 * Create by wq on 2018/1/11.
 */
public interface IO<P, V extends Serializable> {
    INet<P, V> netFramework();     // 从网络获取

    IDisk<V> diskFramework();   // 从磁盘缓存获取
}