package com.nat.weex;

import android.Manifest;
import android.app.Activity;

import com.nat.geolocation.Constant;
import com.nat.geolocation.GeoModule;
import com.nat.geolocation.ModuleResultListener;
import com.nat.geolocation.Util;
import com.nat.permission.PermissionChecker;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

import java.util.HashMap;

/**
 * Created by Acathur on 17/2/17.
 * Copyright (c) 2017 Instapp. All rights reserved.
 */

public class Geolocation extends WXModule {

    JSCallback mGetCallback;
    JSCallback mWatchCallback;
    HashMap<String, Object> mWatchParam;
    public static final int GET_REQUEST_CODE = 103;
    public static final int WATCH_REQUEST_CODE = 104;

    @JSMethod
    public void get(final JSCallback jsCallback){
        boolean b = PermissionChecker.lacksPermissions(mWXSDKInstance.getContext(), Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION);
        if (b) {
            mGetCallback = jsCallback;
            HashMap<String, String> dialog = new HashMap<>();
            dialog.put("title", "权限申请");
            dialog.put("message", "请允许定位权限");
            PermissionChecker.requestPermissions((Activity) mWXSDKInstance.getContext(), dialog, new com.nat.permission.ModuleResultListener() {
                @Override
                public void onResult(Object o) {
                    if (o != null && o.toString().equals("true")) {
                        jsCallback.invoke(Util.getError(Constant.LOCATION_PERMISSION_DENIED, Constant.LOCATION_PERMISSION_DENIED_CODE));
                    }
                }
            }, GET_REQUEST_CODE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION);
        } else {
            GeoModule.getInstance(mWXSDKInstance.getContext()).get(new ModuleResultListener() {
                @Override
                public void onResult(Object o) {
                    jsCallback.invoke(o);
                }
            });
        }
    }

    @JSMethod
    public void watch(HashMap<String, Object> param, final JSCallback jsCallback){
        boolean b = PermissionChecker.lacksPermissions(mWXSDKInstance.getContext(), Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION);
        if (b) {
            mWatchCallback = jsCallback;
            mWatchParam = param;
            HashMap<String, String> dialog = new HashMap<>();
            dialog.put("title", "权限申请");
            dialog.put("message", "请允许定位权限");
            PermissionChecker.requestPermissions((Activity) mWXSDKInstance.getContext(), dialog, new com.nat.permission.ModuleResultListener() {
                @Override
                public void onResult(Object o) {
                    if (o != null && o.toString().equals("true")) {
                        jsCallback.invoke(Util.getError(Constant.LOCATION_PERMISSION_DENIED, Constant.LOCATION_PERMISSION_DENIED_CODE));
                    }
                }
            }, WATCH_REQUEST_CODE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION);
        } else {
            GeoModule.getInstance(mWXSDKInstance.getContext()).watch(param, new ModuleResultListener() {
                @Override
                public void onResult(Object o) {
                    jsCallback.invokeAndKeepAlive(o);
                }
            });
        }
    }

    @JSMethod
    public void clearWatch(final JSCallback jsCallback){
        GeoModule.getInstance(mWXSDKInstance.getContext()).clearWatch(new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == GET_REQUEST_CODE) {
            if (PermissionChecker.hasAllPermissionsGranted(grantResults)) {
                GeoModule.getInstance(mWXSDKInstance.getContext()).get(new ModuleResultListener() {
                    @Override
                    public void onResult(Object o) {
                        mGetCallback.invoke(o);
                    }
                });
            } else {
                if (mGetCallback != null) mGetCallback.invoke(Util.getError(Constant.LOCATION_PERMISSION_DENIED, Constant.LOCATION_PERMISSION_DENIED_CODE));
            }
        }

        if (requestCode == WATCH_REQUEST_CODE) {
            if (PermissionChecker.hasAllPermissionsGranted(grantResults)) {
                GeoModule.getInstance(mWXSDKInstance.getContext()).watch(mWatchParam, new ModuleResultListener() {
                    @Override
                    public void onResult(Object o) {
                        mWatchCallback.invokeAndKeepAlive(o);
                    }
                });
            } else {
                if (mWatchCallback != null) mWatchCallback.invoke(Util.getError(Constant.LOCATION_PERMISSION_DENIED, Constant.LOCATION_PERMISSION_DENIED_CODE));
            }
        }
    }
}
