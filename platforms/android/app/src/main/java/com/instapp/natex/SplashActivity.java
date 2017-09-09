package com.instapp.natex;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;

import com.instapp.natex.commons.util.AppConfig;

public class SplashActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);

    String url = AppConfig.getLaunchUrl();
    if (!TextUtils.isEmpty(url)) {
      Intent intent = new Intent(Intent.ACTION_VIEW);
      String scheme = Uri.parse(url).getScheme();
      StringBuilder builder = new StringBuilder();
      if (TextUtils.equals("file", scheme)) {
        intent.putExtra("isLocal", true);
      } else if (!TextUtils.equals("http", scheme) && !TextUtils.equals("https", scheme)) {
        builder.append("http:");
      }
      builder.append(url);

      Uri uri = Uri.parse(builder.toString());
      intent.setData(uri);
      intent.addCategory("com.instapp.natex.android.intent.category.WEEX");
      intent.setPackage(getPackageName());
      startActivity(intent);
      finish();
    }

  }
}
