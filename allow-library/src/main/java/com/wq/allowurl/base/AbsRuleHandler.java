package com.wq.allowurl.base;

import com.wq.allowurl.rule.IRuleHandle;

/**
 * Create by wq on 2018/1/11.
 */

@SuppressWarnings("all")
public abstract class AbsRuleHandler<P> implements IRuleHandle {
    private P mParams;    // 需要去获取凭证的参数

    public AbsRuleHandler(P params) {
        this.mParams = params;
    }

    public void setParams(P params) {
        this.mParams = params;
    }

    public P getParams() {
        return mParams;
    }
}
