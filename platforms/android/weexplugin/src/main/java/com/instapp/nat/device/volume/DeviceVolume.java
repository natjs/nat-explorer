package com.nat.weex;

import com.nat.device_volume.VolumeModule;
import com.nat.device_volume.ModuleResultListener;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

/**
 * Created by Acathur on 17/2/17.
 * Copyright (c) 2017 Instapp. All rights reserved.
 */

public class DeviceVolume extends WXModule {

    @JSMethod
    public void get(final JSCallback jsCallback){
        VolumeModule.getInstance(mWXSDKInstance.getContext()).get(new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }

    @JSMethod
    public void set(float volume, final JSCallback jsCallback){
        VolumeModule.getInstance(mWXSDKInstance.getContext()).set(volume, new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }
}
