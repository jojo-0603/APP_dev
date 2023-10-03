package com.example.signuploginfirebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdoptAdapter extends RecyclerView.Adapter<MyAdoptAdapter.MyViewHolder> {

    Context context;
    ArrayList<AdoptUser>list;

    public MyAdoptAdapter(Context context, ArrayList<AdoptUser> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(context).inflate(R.layout.adopt_item,parent,false);
       return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AdoptUser user=list.get(position);
        holder.FirstName.setText(user.getFirstName());
        holder.LastName.setText(user.getLastName());
        holder.age.setText(user.getAge());
        holder.hobby.setText(user.getHobby());
        holder.address.setText(user.getAddress());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView FirstName,LastName,age,hobby,address;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            FirstName=itemView.findViewById(R.id.FName);
            LastName=itemView.findViewById(R.id.LName);
            age=itemView.findViewById(R.id.A_age);
            hobby=itemView.findViewById(R.id.Hobby);
            address=itemView.findViewById(R.id.A_address);
        }
    }

}
