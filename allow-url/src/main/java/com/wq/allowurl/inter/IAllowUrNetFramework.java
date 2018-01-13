package com.wq.allowurl.inter;

import com.wq.allowurl.callback.NetFrameworkCallBack;
import com.wq.allowurl.base.AbsRuleHandler;

/**
 * Create by wq on 2018/1/11.
 * 服务器获取或者本地生成可用url的实现
 */
public interface IAllowUrNetFramework<P> {
    void load(AbsRuleHandler<P> ruleHandler, NetFrameworkCallBack callBack);
}
