package com.wq.allowurl;

import com.wq.allowurl.base.AbsRuleHandler;
import com.wq.allowurl.callback.NetCallBack;
import com.wq.allowurl.callback.OnAllowValueCallBack;
import com.wq.allowurl.entity.BufferEntity;
import com.wq.allowurl.io.IDisk;
import com.wq.allowurl.io.INet;

import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Create by wq on 2018/1/11.
 * 一个key对应一个缓冲区
 */
class WorkBuffer<P, T, V extends Serializable> implements NetCallBack {
    private AbsRuleHandler<P, V> mRuleHandler;
    private IDisk mDisk;
    private INet<P, V> mNet;
    private List<SoftReference<BufferEntity<T, V>>> mBuffer = new ArrayList<>();
    private V mAllowValue;
    private boolean mRequesting;

    WorkBuffer(INet<P, V> net, IDisk disk, AbsRuleHandler<P, V> ruleHandler) {
        this.mNet = net;
        this.mDisk = disk;
        this.mRuleHandler = ruleHandler;
    }

    private void append(T target, OnAllowValueCallBack<T, V> callBack) {
        mBuffer.add(new SoftReference<>(new BufferEntity<>(target, callBack)));
    }

    void start(T target, OnAllowValueCallBack<T, V> callBack) {
        // 从本地获取下载地址
        if (null != mDisk && null == mAllowValue) {
            mAllowValue = (V) mDisk.getAllowValue(mRuleHandler);
            mRuleHandler.setAllowValue(mAllowValue);
        }

        if (!mRuleHandler.isDisallow()) {
            if (callBack != null) {
                callBack.success(target, mAllowValue);
            }
            return;
        }

        append(target, callBack);

        if (mRequesting) {
            return;
        }

        if (mNet != null) {
            mRequesting = true;
            mNet.load(mRuleHandler, this);
        }
    }

    @Override
    public void success(Serializable allowValue) {
        try {
            mAllowValue = (V) allowValue;
            mRuleHandler.setAllowValue(mAllowValue);
            if (null != mAllowValue) {
                mRequesting = false;
                for (SoftReference<BufferEntity<T, V>> next : mBuffer) {
                    if (next.get() != null) {
                        next.get().success(mAllowValue);
                    }
                }
            }
            mBuffer.clear();
            if (mDisk != null) {
                mDisk.save(mRuleHandler, mAllowValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
            error();
        }
    }

    @Override
    public void error() {
        mRequesting = false;
    }
}
