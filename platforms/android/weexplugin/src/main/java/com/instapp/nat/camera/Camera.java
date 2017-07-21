package com.nat.weex;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;

import com.nat.camera.CameraModule;
import com.nat.camera.Constant;
import com.nat.camera.ModuleResultListener;
import com.nat.camera.Util;
import com.nat.permission.PermissionChecker;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

import java.util.HashMap;

/**
 * Created by Acathur on 17/2/18.
 */

public class Camera extends WXModule {

    JSCallback mImageCallBack;
    JSCallback mVideoCallBack;
    
    @JSMethod
    public void captureImage(HashMap<String, Object> param, final JSCallback jsCallback){
        boolean b = PermissionChecker.lacksPermissions(mWXSDKInstance.getContext(), Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (b) {
            HashMap<String, String> dialog = new HashMap<>();
            dialog.put("title", "权限申请");
            dialog.put("message", "请允许拍照");
            PermissionChecker.requestPermissions((Activity) mWXSDKInstance.getContext(), dialog, new com.nat.permission.ModuleResultListener() {
                @Override
                public void onResult(Object o) {
                    if ((boolean)o == true) jsCallback.invoke(Util.getError(Constant.CAMERA_PERMISSION_DENIED, Constant.CAMERA_PERMISSION_DENIED_CODE));
                }
            }, Constant.CAMERA_PERMISSION_REQUEST_CODE,  Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        } else {
            realCaptureImage(param, jsCallback);
        }
    }

    public void realCaptureImage(HashMap<String, Object> param, final JSCallback jsCallback){
        mImageCallBack = jsCallback;
        CameraModule.getInstance(mWXSDKInstance.getContext()).captureImage((Activity) mWXSDKInstance.getContext(), new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }

    @JSMethod
    public void captureVideo(HashMap<String, Object> param, final JSCallback jsCallback){
        boolean b = PermissionChecker.lacksPermissions(mWXSDKInstance.getContext(), Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (b) {
            HashMap<String, String> dialog = new HashMap<>();
            dialog.put("title", "权限申请");
            dialog.put("message", "请允许录像");
            PermissionChecker.requestPermissions((Activity) mWXSDKInstance.getContext(), dialog, new com.nat.permission.ModuleResultListener() {
                @Override
                public void onResult(Object o) {
                    if ((boolean)o == true) jsCallback.invoke(Util.getError(Constant.CAMERA_PERMISSION_DENIED, Constant.CAMERA_PERMISSION_DENIED_CODE));
                }
            }, Constant.CAMERA_PERMISSION_REQUEST_CODE,  Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        } else {
            realCaptureVideo(param, jsCallback);
        }
    }

    public void realCaptureVideo(HashMap<String, Object> param, final JSCallback jsCallback){
        mVideoCallBack = jsCallback;
        CameraModule.getInstance(mWXSDKInstance.getContext()).captureVideo((Activity) mWXSDKInstance.getContext(), new ModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Object o = CameraModule.getInstance(mWXSDKInstance.getContext()).onCaptureImgActivityResult(requestCode, resultCode, data);
        Object o1 = CameraModule.getInstance(mWXSDKInstance.getContext()).onCaptureVideoActivityResult(requestCode, resultCode, data);

        if (mImageCallBack != null) {
            mImageCallBack.invoke(o);
            mImageCallBack = null;
        }

        if (mVideoCallBack != null) {
            mVideoCallBack.invoke(o1);
            mVideoCallBack = null;
        }
    }
}
