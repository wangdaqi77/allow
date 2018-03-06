package com.wq.allowurl.io;

import com.wq.allowurl.base.AbsRuleHandler;

import java.io.Serializable;

/**
 * Create by wq on 2018/1/11.
 * 磁盘缓存的实现
 */
public interface IDisk<V extends Serializable> {
    void save(AbsRuleHandler ruleHandler, V allowValue);

    /**
     * 缓存不存在请return null
     */
    V getAllowValue(AbsRuleHandler ruleHandler);
}
