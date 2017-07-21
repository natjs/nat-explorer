package com.nat.weex;

import android.Manifest;
import android.app.Activity;

import com.nat.communication.CommunicationModule;
import com.nat.communication.Constant;
import com.nat.communication.ModuleResultListener;
import com.nat.communication.Util;
import com.nat.permission.PermissionChecker;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

import java.util.HashMap;

/**
 * Created by Acathur on 17/2/16.
 * Copyright (c) 2017 Instapp. All rights reserved.
 */

public class Communication extends WXModule {

    String mCallNumber;
    JSCallback mCallCallback;

    @JSMethod
    public void call(String number, final JSCallback jsCallback){
        boolean permAllow = PermissionChecker.lacksPermission(mWXSDKInstance.getContext(), Manifest.permission.CALL_PHONE);

        if (permAllow) {
            HashMap<String, String> dialog = new HashMap<>();
            dialog.put("title", "权限申请");
            dialog.put("message", "请允许拨打电话");
            
            mCallNumber = number;
            mCallCallback = jsCallback;

            PermissionChecker.requestPermissions((Activity) mWXSDKInstance.getContext(), dialog, new com.nat.permission.ModuleResultListener() {
                @Override
                public void onResult(Object o) {
                    if ((boolean)o == true) jsCallback.invoke(Util.getError(Constant.CALL_PHONE_PERMISSION_DENIED, Constant.CALL_PHONE_PERMISSION_DENIED_CODE));
                }
            }, Constant.CALL_PHONE_PERMISSION_REQUEST_CODE, Manifest.permission.CALL_PHONE);
        } else {
            realCall(number, jsCallback);
        }
    }

    @JSMethod
    public void mail(String[] tos, HashMap<String, String> params, final JSCallback jsCallback){
        CommunicationModule.getInstance(mWXSDKInstance.getContext()).mail(tos, params, new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }

    @JSMethod
    public void sms(String[] tos, String text, final JSCallback jsCallback){
        CommunicationModule.getInstance(mWXSDKInstance.getContext()).sms(tos, text, new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == Constant.CALL_PHONE_PERMISSION_REQUEST_CODE) {
            if (PermissionChecker.hasAllPermissionsGranted(grantResults)) {
                realCall(mCallNumber, mCallCallback);
            } else {
                mCallCallback.invoke(Util.getError(Constant.CALL_PHONE_PERMISSION_DENIED, Constant.CALL_PHONE_PERMISSION_DENIED_CODE));
            }
        }
    }

    public void realCall(String number, final JSCallback jsCallback){
        CommunicationModule.getInstance(mWXSDKInstance.getContext()).call(number, new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }
}
