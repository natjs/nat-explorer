package com.instapp.natex;

import android.app.Application;
import android.os.Build;
import android.os.StrictMode;

import com.instapp.natex.extend.ImageAdapter;
import com.instapp.natex.extend.WXEventModule;
import com.alibaba.weex.plugin.loader.WeexPluginContainer;
import com.instapp.natex.util.AppConfig;
import com.taobao.weex.InitConfig;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVAnalytics;

public class WXApplication extends Application {

  @Override
  public void onCreate() {
    if (Build.VERSION.SDK_INT>=18) {
      StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
      StrictMode.setVmPolicy(builder.build());
      builder.detectFileUriExposure();
    }

    super.onCreate();

    WXSDKEngine.addCustomOptions("appName", "NatExplorer");
    WXSDKEngine.addCustomOptions("appGroup", "Instapp");
    WXSDKEngine.initialize(this,
        new InitConfig.Builder().setImgAdapter(new ImageAdapter()).build()
    );

    AVOSCloud.useAVCloudUS();
    AVOSCloud.initialize(this, ApiKey.LC_APPID, ApiKey.LC_APPKEY);
    AVAnalytics.enableCrashReport(this, true);

    try {
      WXSDKEngine.registerModule("event", WXEventModule.class);
    } catch (WXException e) {
      e.printStackTrace();
    }
    AppConfig.init(this);
    WeexPluginContainer.loadAll(this);
  }
}
