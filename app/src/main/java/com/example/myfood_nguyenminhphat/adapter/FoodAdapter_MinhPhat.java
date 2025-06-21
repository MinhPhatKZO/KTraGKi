package com.example.myfood_nguyenminhphat.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfood_nguyenminhphat.FoodDetailActivity_MinhPhat;
import com.example.myfood_nguyenminhphat.R;
import com.example.myfood_nguyenminhphat.model.Food_MinhPhat;

import java.util.List;

public class FoodAdapter_MinhPhat extends RecyclerView.Adapter<FoodAdapter_MinhPhat.FoodViewHolder> {

    private Context context;
    private List<Food_MinhPhat> list;

    public FoodAdapter_MinhPhat(Context context, List<Food_MinhPhat> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_food_minhphat, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food_MinhPhat food = list.get(position);
        holder.txtName.setText(food.getName());
        holder.txtDesc.setText(food.getDescription());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, FoodDetailActivity_MinhPhat.class);
            intent.putExtra("food_id", food.getFoodID());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtDesc;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtFoodName_MinhPhat);
            txtDesc = itemView.findViewById(R.id.txtFoodDesc_MinhPhat);
        }
    }
}
