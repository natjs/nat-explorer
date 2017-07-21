package com.nat.weex;

import com.nat.device_network.NetworkModule;
import com.nat.device_network.ModuleResultListener;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

/**
 * Created by Acathur on 17/2/17.
 * Copyright (c) 2017 Instapp. All rights reserved.
 */

public class Network extends WXModule{

    @JSMethod
    public void status(final JSCallback jsCallback){
        NetworkModule.getInstance(mWXSDKInstance.getContext()).status(new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }
}
