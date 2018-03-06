package com.wq.allowurl.io;

import com.wq.allowurl.rule.AbsRuleHandler;
import com.wq.allowurl.callback.NetCallBack;

import java.io.Serializable;

/**
 * Create by wq on 2018/1/11.
 * 服务器获取或者本地生成可用url的实现
 */
public interface INet<P, V extends Serializable> {
    void load(AbsRuleHandler<P, V> ruleHandler, NetCallBack<V> callBack);
}
