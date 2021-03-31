package com.h.androidlearn;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.h.androidlearn.adapter.FruitHorizontalAdapter;
import com.h.androidlearn.bean.Fruit;

import java.util.ArrayList;
import java.util.Random;

public class StaggeredActivity extends AppCompatActivity {

    private ArrayList<Fruit> mFruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        initFruits();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        // staggered layout
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        // grid layout
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        FruitHorizontalAdapter fruitHorizontalAdapter = new FruitHorizontalAdapter(mFruitList);
        recyclerView.setAdapter(fruitHorizontalAdapter);
    }

    private void initFruits() {
        Fruit apple = new Fruit(getRandomLengthName("apple"), R.mipmap.ic_launcher_round);
        Fruit banana = new Fruit(getRandomLengthName("banana"), R.mipmap.ic_launcher_round);
        Fruit orange = new Fruit(getRandomLengthName("orange"), R.mipmap.ic_launcher_round);
        Fruit watermelon = new Fruit(getRandomLengthName("watermelon"), R.mipmap.ic_launcher_round);
        for (int i = 0; i < 6; i++) {
            mFruitList.add(apple);
            mFruitList.add(banana);
            mFruitList.add(orange);
            mFruitList.add(watermelon);
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }
}