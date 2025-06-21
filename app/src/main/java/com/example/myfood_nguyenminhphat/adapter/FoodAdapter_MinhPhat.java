// ===============================
// FoodAdapter_MinhPhat.java (Đồng bộ layout + tên id item_food_minhphat.xml)
// ===============================
package com.example.myfood_nguyenminhphat.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        holder.txtType.setText("Size S");
        holder.txtPrice.setText("10000 VNĐ");
        holder.txtRestaurant.setText("Quán bánh mì cô Ba"); // hoặc lấy từ DAO nếu có
        holder.imgFood.setImageResource(R.drawable.ic_restaurant); // hoặc food.getImage() nếu có logic load ảnh

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
        TextView txtName, txtType, txtPrice, txtRestaurant;
        ImageView imgFood;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.imgFoodDetail_MinhPhat);
            txtName = itemView.findViewById(R.id.txtFoodNameDetail_MinhPhat);
            txtType = itemView.findViewById(R.id.txtFoodTypeDetail_MinhPhat);
            txtPrice = itemView.findViewById(R.id.txtFoodDescDetail_MinhPhat);
            txtRestaurant = itemView.findViewById(R.id.txtRestaurantDetail_MinhPhat);
        }
    }
}