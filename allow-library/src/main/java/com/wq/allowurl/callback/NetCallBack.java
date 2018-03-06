package com.wq.allowurl.callback;

import com.wq.allowurl.rule.AbsRuleHandler;
import com.wq.allowurl.io.INet;

import java.io.Serializable;

/**
 * @see INet#load(AbsRuleHandler, NetCallBack)
 * Create by wq on 2018/1/11.
 */
public interface NetCallBack<V extends Serializable> {
    void success(V allowValue);
    void error();
}
