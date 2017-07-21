package com.nat.weex;

import android.app.Activity;

import com.nat.modal.ModalModule;
import com.nat.modal.ModuleResultListener;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

import java.util.HashMap;

/**
 * Created by Acathur on 17/2/17.
 * Copyright (c) 2017 Instapp. All rights reserved.
 */

public class Modal extends WXModule {

    @JSMethod
    public void alert(HashMap<String, String> hashMap, final JSCallback jsCallback){
        ModalModule.getInstance().alert((Activity) mWXSDKInstance.getContext(), hashMap, new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }

    @JSMethod
    public void confirm(HashMap<String, String> hashMap, final JSCallback jsCallback){
        ModalModule.getInstance().confirm((Activity) mWXSDKInstance.getContext(), hashMap, new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }

    @JSMethod
    public void prompt(HashMap<String, String> hashMap, final JSCallback jsCallback){
        ModalModule.getInstance().prompt((Activity) mWXSDKInstance.getContext(), hashMap, new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }

    @JSMethod
    public void toast(HashMap<String, String> hashMap, final JSCallback jsCallback){
        ModalModule.getInstance().toast((Activity) mWXSDKInstance.getContext(), hashMap, new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }
}
