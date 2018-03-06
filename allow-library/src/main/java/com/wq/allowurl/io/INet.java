package com.wq.allowurl.io;

import com.wq.allowurl.callback.NetCallBack;
import com.wq.allowurl.base.AbsRuleHandler;

/**
 * Create by wq on 2018/1/11.
 * 服务器获取或者本地生成可用url的实现
 */
public interface INet<P> {
    void load(AbsRuleHandler<P> ruleHandler, NetCallBack callBack);
}
