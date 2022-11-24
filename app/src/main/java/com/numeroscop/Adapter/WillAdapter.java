package com.numeroscop.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.numeroscop.Model.NumberModel;
import com.numeroscop.R;

import java.util.ArrayList;

public class WillAdapter extends RecyclerView.Adapter<WillAdapter.MyViewHolder> {
    private Context context;
    ArrayList<NumberModel> list;
    ArrayList<String> numberModelArrayList;


    public WillAdapter(Context context, ArrayList<NumberModel> list,ArrayList<String> numberModelArrayList ) {
        this.context = context;
        this.list = list;
        this.numberModelArrayList = numberModelArrayList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plane_child_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        if(position == 1|| position == 4 || position == 7 ){
            holder.consRoot.setBackgroundColor(Color.parseColor("#A62A2A"));
        }else{
            holder.consRoot.setBackgroundColor(Color.parseColor("#4AA41F"));
        }

        if (position == 1 || position == 4 || position == 7) {
            if (position == 1) {
                if (Integer.parseInt(numberModelArrayList.get(0)) != 0) {
                    String value = "";
                    for (int i = 0; i < Integer.parseInt(numberModelArrayList.get(0)); i++) {
                        if (i == 0) {
                            value = list.get(position).getText();
                        } else {
                            value = value + "," + list.get(position).getText();
                        }
                    }holder.txtNumber.setText(value);
                    holder.consRoot.setBackgroundColor(context.getResources().getColor(R.color.colorA62A2A));
                } else {
                    holder.txtNumber.setText("");
                }
            }else if (position == 4) {
                if (Integer.parseInt(numberModelArrayList.get(1)) != 0) {
                    String value = "";
                    for (int i = 0; i < Integer.parseInt(numberModelArrayList.get(1)); i++) {
                        if (i == 0) {
                            value = list.get(position).getText();
                        } else {
                            value = value + "," + list.get(position).getText();
                        }
                    }
                    holder.txtNumber.setText(value);
                    holder.consRoot.setBackgroundColor(context.getResources().getColor(R.color.colorA62A2A));
                }else {
                    holder.txtNumber.setText("");
                }
            } else if (position == 7) {
                if (Integer.parseInt(numberModelArrayList.get(2)) != 0) {
                    String value = "";
                    for (int i = 0; i < Integer.parseInt(numberModelArrayList.get(2)); i++) {
                        if (i == 0) {
                            value = list.get(position).getText();
                        } else {
                            value = value + "," + list.get(position).getText();
                        }
                    }holder.txtNumber.setText(value);
                    holder.consRoot.setBackgroundColor(context.getResources().getColor(R.color.colorA62A2A));
                }else {
                    holder.txtNumber.setText("");
                }
            } else {
                holder.txtNumber.setText("");
            }
        }else{
            holder.txtNumber.setText("");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtNumber;
        ConstraintLayout  consRoot;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            consRoot = itemView.findViewById(R.id.consRoot);

        }
    }

}
