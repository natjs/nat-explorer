package com.nat.weex;

import com.nat.stream.ModuleResultListener;
import com.nat.stream.StreamModule;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

/**
 * Created by Acathur on 17/2/17.
 * Copyright (c) 2017 Instapp. All rights reserved.
 */

public class Stream extends WXModule {

    @JSMethod
    public void fetch(String str, final JSCallback jsCallback){
        StreamModule.getInstance(mWXSDKInstance.getContext()).fetch(str, new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }
}
