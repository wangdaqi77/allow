package com.wq.allowurl;

import android.text.TextUtils;

import com.wq.allowurl.base.AbsRuleHandler;
import com.wq.allowurl.callback.OnAllowUrlSuccessListener;
import com.wq.allowurl.inter.IO;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by wq on 2018/1/11.
 */
@SuppressWarnings("all")
public class AllowUrl {
    private static AllowUrl INSTANCE;
    private static Map<String, GetAllowUrlBuffer> connectBuffer;
    private IO io;

    private AllowUrl() {
    }

    public static AllowUrl create() {
        if (INSTANCE == null) {
            synchronized (AllowUrl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AllowUrl();
                }
            }
        }
        return INSTANCE;
    }

    public static <T> void load(AbsRuleHandler ruleHandler, T target, OnAllowUrlSuccessListener<T> callBack) {
        IO io = create().io;
        if (null == io) {
            throw new NullPointerException("please call AllowUrl.create().io() when application init");
        }

        String key = ruleHandler.getKey();
        if (TextUtils.isEmpty(key)) {
            callBack.success(target, "");
            return;
        }

        if (connectBuffer == null) {
            connectBuffer = new HashMap<>();
        }

        if (connectBuffer.get(key) == null) {
            GetAllowUrlBuffer getQnDownUrlBuffer = new GetAllowUrlBuffer<>(io.netFramework(), io.diskFramework(), ruleHandler);
            connectBuffer.put(key, getQnDownUrlBuffer);
        }

        GetAllowUrlBuffer getQnDownUrlBuffer = connectBuffer.get(key);
        getQnDownUrlBuffer.start(target, callBack);
    }

    public void io(IO io) {
        this.io = io;
    }
}
