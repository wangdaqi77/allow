package com.wq.allowurl.io;

/**
 * Create by wq on 2018/1/11.
 */
public interface IO {
    INet netFramework();     // 从网络获取
    IDisk diskFramework();   // 从磁盘缓存获取
}