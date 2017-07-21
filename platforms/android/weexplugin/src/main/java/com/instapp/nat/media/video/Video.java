package com.nat.weex;

import com.nat.media_video.ModuleResultListener;
import com.nat.media_video.VideoModule;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

/**
 * Created by Acathur on 17/2/17.
 * Copyright (c) 2017 Instapp. All rights reserved.
 */

public class Video extends WXModule {

    @JSMethod
    public void play(String path, final JSCallback jsCallback) {
        VideoModule.getInstance(mWXSDKInstance.getContext()).play(path, new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }

    @JSMethod
    public void pause(final JSCallback jsCallback) {
        VideoModule.getInstance(mWXSDKInstance.getContext()).pause(new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }

    @JSMethod
    public void stop(final JSCallback jsCallback) {
        VideoModule.getInstance(mWXSDKInstance.getContext()).stop(new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }
}
