package com.h.androidlearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.h.androidlearn.adapter.FruitHorizontalAdapter;
import com.h.androidlearn.bean.Fruit;

import java.util.ArrayList;

public class HorizontalActivity extends AppCompatActivity {

  private ArrayList<Fruit> mFruitList = new ArrayList<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_layout);
    initFruits();
    RecyclerView recyclerView = findViewById(R.id.recycler_view);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    // set horizontal layout
    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
    recyclerView.setLayoutManager(linearLayoutManager);
    FruitHorizontalAdapter fruitHorizontalAdapter = new FruitHorizontalAdapter(mFruitList);
    recyclerView.setAdapter(fruitHorizontalAdapter);
  }

  private void initFruits() {
    Fruit apple = new Fruit("apple", R.mipmap.ic_launcher_round);
    Fruit banana = new Fruit("banana", R.mipmap.ic_launcher_round);
    Fruit orange = new Fruit("orange", R.mipmap.ic_launcher_round);
    Fruit watermelon = new Fruit("watermelon", R.mipmap.ic_launcher_round);
    for (int i = 0; i < 6; i++) {
      mFruitList.add(apple);
      mFruitList.add(banana);
      mFruitList.add(orange);
      mFruitList.add(watermelon);
    }
  }
}