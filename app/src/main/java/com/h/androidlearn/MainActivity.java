package com.h.androidlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  Button call_android_button;
  WebView webView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    call_android_button = findViewById(R.id.call_android_button);
    call_android_button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        webView.evaluateJavascript("javascript:callJs(" + "'hello'" + ")", new ValueCallback<String>() {
          @Override
          public void onReceiveValue(String s) {
            Toast.makeText(MainActivity.this, "receive from javascript" + s, Toast.LENGTH_LONG).show();
          }
        });
      }
    });
    webView = findViewById(R.id.webview);
    webView.loadUrl("file:///android_asset/web/index.html");
    WebSettings webSettings = webView.getSettings();
    webSettings.setJavaScriptEnabled(true);
    // enable localstorage
    webSettings.setDomStorageEnabled(true);
    webView.setWebViewClient(new WebViewClient() {
      @Override
      public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        Uri uri = request.getUrl();
        if (uri != null) {
          // httx://dota:100/path?id:10
          // httx
          String schema = uri.getScheme();
          // dota
          String host = uri.getHost();
          // 100
          int port = uri.getPort();
          // path
          String path = uri.getPath();
          // 10
          String param = uri.getQueryParameter("id");
          if (path.equals("path")) {
            Toast.makeText(MainActivity.this, "call by javascript...", Toast.LENGTH_LONG).show();
          }
        }
        return super.shouldOverrideUrlLoading(view, request);
      }
    });
  }
}