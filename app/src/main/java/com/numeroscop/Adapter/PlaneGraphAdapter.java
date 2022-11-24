package com.numeroscop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.numeroscop.Model.NumberModel;
import com.numeroscop.R;

import java.util.ArrayList;

public class PlaneGraphAdapter extends RecyclerView.Adapter<PlaneGraphAdapter.MyViewHolder> {
    private Context context;
    ArrayList<NumberModel> list;


    public PlaneGraphAdapter(Context context, ArrayList<NumberModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plane_child_layout, parent, false);

        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        NumberModel model = list.get(position);

        holder.txtNumber.setText(model.getText());




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtNumber;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNumber = itemView.findViewById(R.id.txtNumber);

        }
    }


}
