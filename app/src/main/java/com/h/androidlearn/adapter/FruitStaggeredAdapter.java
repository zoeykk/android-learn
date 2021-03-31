package com.h.androidlearn.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h.androidlearn.R;
import com.h.androidlearn.bean.Fruit;

import java.util.List;

public class FruitStaggeredAdapter extends RecyclerView.Adapter<FruitStaggeredAdapter.ViewHolder> {
  private List<Fruit> mFruitList;

  static class ViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView textView;

    public ViewHolder(View view) {
      super(view);
      imageView = (ImageView) view.findViewById(R.id.fruit_image);
      textView = (TextView) view.findViewById(R.id.fruit_name);
    }
  }

  public FruitStaggeredAdapter(List<Fruit> mFruitList) {
    this.mFruitList = mFruitList;
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Fruit fruit = mFruitList.get(position);
    holder.imageView.setImageResource(fruit.getImageId());
    holder.textView.setText(fruit.getName());
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_staggered_item, parent, false);
    ViewHolder holder = new ViewHolder(view);
    return holder;
  }

  @Override
  public int getItemCount() {
    return mFruitList.size();
  }
}
