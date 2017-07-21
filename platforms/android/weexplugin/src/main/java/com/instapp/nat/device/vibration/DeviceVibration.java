package com.nat.weex;

import com.nat.device_vibration.VibrationModule;
import com.nat.device_vibration.ModuleResultListener;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

/**
 * Created by Acathur on 17/2/17.
 * Copyright (c) 2017 Instapp. All rights reserved.
 */

public class DeviceVibration extends WXModule{

    @JSMethod
    public void vibrate(int time, final JSCallback jsCallback){
        VibrationModule.getInstance(mWXSDKInstance.getContext()).vibrate(time, new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }
}
