package com.wq.allowurl;

import com.wq.allowurl.rule.AbsRuleHandler;
import com.wq.allowurl.callback.OnAllowValueCallBack;
import com.wq.allowurl.io.IO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by wq on 2018/1/11.
 */
@SuppressWarnings("all")
public class Allow<P, V extends Serializable> {
    private static Allow INSTANCE;
    private static Map<String, WorkBuffer> connectBuffer;
    private IO<P, V> io;

    private Allow() {
    }

    public static Allow create() {
        if (INSTANCE == null) {
            synchronized (Allow.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Allow();
                }
            }
        }
        return INSTANCE;
    }

    public static <T, V extends Serializable> void load(AbsRuleHandler ruleHandler, T target, OnAllowValueCallBack<T, V> callBack) {
        IO io = create().io;
        if (null == io) {
            throw new NullPointerException("please call AllowUrl.create().io() when application init");
        }

        String key = ruleHandler.getKey();
        if (null == key || "" == key) {
            callBack.success(target, null);
            return;
        }

        if (connectBuffer == null) {
            connectBuffer = new HashMap<>();
        }

        if (connectBuffer.get(key) == null) {
            WorkBuffer getQnDownUrlBuffer = new WorkBuffer<>(io.netFramework(), io.diskFramework(), ruleHandler);
            connectBuffer.put(key, getQnDownUrlBuffer);
        }

        WorkBuffer getQnDownUrlBuffer = connectBuffer.get(key);
        getQnDownUrlBuffer.start(target, callBack);
    }

    public void io(IO io) {
        this.io = io;
    }
}
