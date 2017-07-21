package com.nat.weex;

import android.Manifest;
import android.app.Activity;

import com.nat.recorder.RecorderModule;
import com.nat.recorder.Constant;
import com.nat.recorder.ModuleResultListener;
import com.nat.recorder.Util;
import com.nat.permission.PermissionChecker;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

import java.util.HashMap;

/**
 * Created by Acathur on 17/2/18. 
 * Copyright (c) 2017 Instapp. All rights reserved.
 */

public class Recorder extends WXModule {

    HashMap<String, String> mCallParams;
    JSCallback mCallCallback;

    @JSMethod
    public void start(HashMap<String, String> params, final JSCallback jsCallback){
        boolean permAllow = PermissionChecker.lacksPermissions(mWXSDKInstance.getContext(), Manifest.permission.RECORD_AUDIO, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permAllow) {
            HashMap<String, String> dialog = new HashMap<>();
            dialog.put("title", "权限申请");
            dialog.put("message", "请允许音频录制");
            
            mCallParams = params;
            mCallCallback = jsCallback;

            PermissionChecker.requestPermissions((Activity) mWXSDKInstance.getContext(), dialog, new com.nat.permission.ModuleResultListener() {
                @Override
                public void onResult(Object o) {
                    if ((boolean)o == true) jsCallback.invoke(Util.getError(Constant.RECORD_AUDIO_PERMISSION_DENIED, Constant.RECORD_AUDIO_PERMISSION_DENIED_CODE));
                }
            }, Constant.RECORD_AUDIO_PERMISSION_REQUEST_CODE,  Manifest.permission.RECORD_AUDIO, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        } else {
            realRecord(params, jsCallback);
        }
    }

    @JSMethod
    public void pause(final JSCallback jsCallback){
        RecorderModule.getInstance().pause(new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }

    @JSMethod
    public void stop(final JSCallback jsCallback){
        RecorderModule.getInstance().stop(new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == Constant.RECORD_AUDIO_PERMISSION_REQUEST_CODE) {
            if (PermissionChecker.hasAllPermissionsGranted(grantResults)) {
                realRecord(mCallParams, mCallCallback);
            } else {
                mCallCallback.invoke(Util.getError(Constant.RECORD_AUDIO_PERMISSION_DENIED, Constant.RECORD_AUDIO_PERMISSION_DENIED_CODE));
            }
        }
    }

    public void realRecord(HashMap<String, String> params, final JSCallback jsCallback){
        RecorderModule.getInstance().start(params, new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }
}
