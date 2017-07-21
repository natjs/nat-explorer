package com.nat.weex;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.widget.Toast;

import com.nat.device_screen.Constant;
import com.nat.device_screen.ModuleResultListener;
import com.nat.device_screen.ScreenModule;
import com.nat.device_screen.Util;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

/**
 * Created by Acathur on 17/2/17.
 * Copyright (c) 2017 Instapp. All rights reserved.
 */

public class DeviceScreen extends WXModule{

    JSCallback mSetBritnessCallback;
    float mBritness;
    @JSMethod
    public void info(final JSCallback jsCallback){
        ScreenModule.getInstance(mWXSDKInstance.getContext()).info(new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }

    @JSMethod
    public void getBrightness(final JSCallback jsCallback){
        ScreenModule.getInstance(mWXSDKInstance.getContext()).getBrightness(new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }

    @JSMethod
    public void getOrientation(final JSCallback jsCallback){
        ScreenModule.getInstance(mWXSDKInstance.getContext()).getOrientation(new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }

    @JSMethod
    public void lockOrientation(String orientation, final JSCallback jsCallback){
        ScreenModule.getInstance(mWXSDKInstance.getContext()).lockOrientation((Activity) mWXSDKInstance.getContext(), orientation, new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }

    @JSMethod
    public void unlockOrientation(final JSCallback jsCallback){
        ScreenModule.getInstance(mWXSDKInstance.getContext()).unlockOrientation((Activity) mWXSDKInstance.getContext(), new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }

    @JSMethod
    public void setBrightness(float brightness, JSCallback jsCallback){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mSetBritnessCallback = jsCallback;
            mBritness = brightness;
            Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
            intent.setData(Uri.parse("package:" + mWXSDKInstance.getContext().getPackageName()));
            ((Activity)mWXSDKInstance.getContext()).startActivityForResult(intent, Constant.WRITE_SETTINGS_REQUEST_CODE);
        } else {
            setBrightness(brightness);
            getBrightness(jsCallback);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.WRITE_SETTINGS_REQUEST_CODE) {

            if (Settings.System.canWrite(mWXSDKInstance.getContext())) {
                setBrightness(mBritness);
                getBrightness(mSetBritnessCallback);
            } else {
                mSetBritnessCallback.invoke(Util.getError(Constant.CAMERA_PERMISSION_DENIED, Constant.CAMERA_PERMISSION_DENIED_CODE));
            }
        }
    }

    private void setScreenMode(int value) {
        Settings.System.putInt(mWXSDKInstance.getContext().getContentResolver(), Settings.System.SCREEN_BRIGHTNESS_MODE, value);
    }

    public void setBrightness(float value) {
        int screenMode = 0;
        try {
            screenMode = Settings.System.getInt(mWXSDKInstance.getContext().getContentResolver(), Settings.System.SCREEN_BRIGHTNESS_MODE);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }

        if(screenMode == Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC){
            setScreenMode(Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
        }

        Settings.System.putInt(mWXSDKInstance.getContext().getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, (int) (value * 255));
    }
}
