package com.h.androidlearn;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.QRCodeDecoder;

public class MainActivity extends AppCompatActivity implements QRCodeView.Delegate {

  private static final int REQUEST_CODE_CHOOSE_QRCODE_FROM_GALLERY = 666;
  private static final int scan_result_code = 1;

  cn.bingoogolapple.qrcode.zxing.ZXingView zXingView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    zXingView = findViewById(R.id.zxingview);
    initView();
  }

  private void initView() {
    // 设置二维码代理
    zXingView.setDelegate(this);
  }

  @Override
  protected void onStart() {
    super.onStart();
    // 打开后置摄像头预览，但没有开始扫描
    zXingView.startCamera();
    // 开启扫描框
    zXingView.showScanRect();
    zXingView.startSpot();
  }

  @Override
  protected void onStop() {
    zXingView.startCamera();
    super.onStop();
  }

  @Override
  protected void onDestroy() {
    zXingView.onDestroy();
    super.onDestroy();
  }

  //扫描成功解析二维码成功后调用,可做对应的操作
  @Override
  public void onScanQRCodeSuccess(String result) {
    // 扫描成功后调用震动器
    vibrate();
    // 显示扫描结果
    Toast.makeText(this, result, Toast.LENGTH_LONG).show();
  }

  @Override
  public void onScanQRCodeOpenCameraError() {
    Toast.makeText(this, "相机打开失败", Toast.LENGTH_SHORT).show();
  }

  private void vibrate() {
    Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
    vibrator.vibrate(200);
  }

}