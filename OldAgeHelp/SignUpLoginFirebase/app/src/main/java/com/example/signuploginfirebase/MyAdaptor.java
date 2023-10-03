package com.example.signuploginfirebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdaptor extends RecyclerView.Adapter<MyAdaptor.MyViewHolder> {
    Context context;
    ArrayList<User> list;


    public MyAdaptor(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user=list.get(position);
        holder.d_name.setText(user.getD_name());
        holder.d_email.setText(user.getD_email());
        holder.d_number.setText(user.getD_number());
        holder.d_add.setText(user.getD_add());
        holder.type.setText(user.getType());
        holder.quantity.setText(user.getQuantity());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView d_name,d_email,d_number,d_add,type,quantity;
        Button accept;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            d_name=itemView.findViewById(R.id.tvName);
            d_email=itemView.findViewById(R.id.tvEmail);
            d_number=itemView.findViewById(R.id.tvPhone);
            d_add=itemView.findViewById(R.id.tvAdd);
            type=itemView.findViewById(R.id.tvFoodType);
            quantity=itemView.findViewById(R.id.tvquantity);


        }
    }
}
