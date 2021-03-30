package com.h.androidlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Button btn_horizontal = findViewById(R.id.btn_horizontal);
    btn_horizontal.setOnClickListener(this);
    Button btn_vertical = findViewById(R.id.btn_vertical);
    btn_vertical.setOnClickListener(this);
    Button btn_waterfall = findViewById(R.id.btn_waterfall);
    btn_waterfall.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.btn_horizontal:
        startActivity(new Intent(MainActivity.this, HorizontalActivity.class));
        break;
      case R.id.btn_vertical:
        break;
      case R.id.btn_waterfall:
        break;
    }
  }
}