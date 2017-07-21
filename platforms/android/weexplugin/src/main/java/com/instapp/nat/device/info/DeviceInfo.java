package com.nat.weex;

import com.nat.device_info.DeviceInfoModule;
import com.nat.device_info.ModuleResultListener;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

/**
 * Created by Acathur on 17/2/17.
 * Copyright (c) 2017 Instapp. All rights reserved.
 */

public class DeviceInfo extends WXModule{

    @JSMethod
    public void info(final JSCallback jsCallback){
        DeviceInfoModule.getInstance(mWXSDKInstance.getContext()).info(new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }
}
