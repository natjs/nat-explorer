package com.instapp.natex;

import android.app.Application;

import com.instapp.natex.ApiKey;
import com.instapp.natex.commons.adapter.ImageAdapter;
import com.instapp.natex.commons.util.AppConfig;
import com.instapp.natex.extend.module.WXEventModule;
import com.instapp.natex.pluginmanager.PluginManager;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.taobao.weex.InitConfig;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVAnalytics;

public class WXApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
//    initDebugEnvironment(true, false, "DEBUG_SERVER_HOST");

		WXSDKEngine.addCustomOptions("appName", "NatExplorer");
		WXSDKEngine.addCustomOptions("appGroup", "Nat");
		WXSDKEngine.initialize(this,
				new InitConfig.Builder()
						.setImgAdapter(new ImageAdapter())
						.build()
		);

		AVOSCloud.useAVCloudUS();
		AVOSCloud.initialize(this, ApiKey.LC_APPID, ApiKey.LC_APPKEY);
		AVOSCloud.setDebugLogEnabled(true);
		AVAnalytics.enableCrashReport(this, true);

		try {
			WXSDKEngine.registerModule("event", WXEventModule.class);
		} catch (WXException e) {
			e.printStackTrace();
		}
		Fresco.initialize(this);
		AppConfig.init(this);
		PluginManager.init(this);
	}

	/**
	 * @param enable enable remote debugger. valid only if host not to be "DEBUG_SERVER_HOST".
	 *               true, you can launch a remote debugger and inspector both.
	 *               false, you can  just launch a inspector.
	 * @param host   the debug server host, must not be "DEBUG_SERVER_HOST", a ip address or domain will be OK.
	 *               for example "127.0.0.1".
	 */
	private void initDebugEnvironment(boolean connectable,boolean enable, String host) {
		if (!"DEBUG_SERVER_HOST".equals(host)) {
			WXEnvironment.sDebugServerConnectable = connectable;
			WXEnvironment.sRemoteDebugMode = enable;
			WXEnvironment.sRemoteDebugProxyUrl = "ws://" + host + ":8088/debugProxy/native";
		}
	}

}
