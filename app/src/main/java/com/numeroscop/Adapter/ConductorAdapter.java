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


public class ConductorAdapter extends RecyclerView.Adapter<ConductorAdapter.MyViewHolder> {
    private Context context;
    ArrayList<NumberModel> list;
    String strConductor;
    String conductor = "";


    public ConductorAdapter(Context context, ArrayList<NumberModel> list,String strConductor ) {
        this.context = context;
        this.list = list;
        this.strConductor = strConductor;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plane_child_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (list.get(position).getText().toString().equalsIgnoreCase(strConductor) ) {
            conductor = list.get(position).getText().toString();
            holder.txtNumber.setText(conductor);
            holder.consRoot.setBackgroundColor(Color.parseColor("#A62A2A"));
        } else {
            conductor = "";
            holder.txtNumber.setText(conductor);
            holder.consRoot.setBackgroundColor(Color.parseColor("#4AA41F"));
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtNumber;
        ConstraintLayout consRoot;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            consRoot = itemView.findViewById(R.id.consRoot);

        }
    }

}
