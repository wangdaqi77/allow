package com.wq.allowurl.base;

import com.wq.allowurl.inter.IRuleHandle;

/**
 * Create by wq on 2018/1/11.
 */

@SuppressWarnings("all")
public abstract class AbsRuleHandler<P> implements IRuleHandle {
    private P mParams;    // 需要去获取凭证的参数
    private String mAllowUrl;       // 带凭证可以使用的

    public AbsRuleHandler(P params) {
        this.mParams = params;
    }


    public void setParams(P params) {
        this.mParams = params;
    }

    public P getParams() {
        return mParams;
    }

    /**
     * 设置未过期的url
     */
    @Override
    public void setAllowUrl(String allowUrl) {
        this.mAllowUrl = allowUrl;
    }

    @Override
    public String getAllowUrl() {
        return mAllowUrl;
    }

}
