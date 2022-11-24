package com.numeroscop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.numeroscop.ApiCall.Model.GetReportResBean;
import com.numeroscop.R;

import java.util.ArrayList;

public class RemediesAdapter extends RecyclerView.Adapter<RemediesAdapter.MyViewHolder> {
    private Context context;
    ArrayList<GetReportResBean.RemediesDTO> list;
    boolean isHindi;


    public RemediesAdapter(Context context, ArrayList<GetReportResBean.RemediesDTO> list, boolean isHindi) {
        this.context = context;
        this.list = list;
        this.isHindi = isHindi;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_remedies,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        GetReportResBean.RemediesDTO model = list.get(position);

        if (isHindi){
            if (model.getHindiRemedie()!=null){
                holder.txtRemedy.setText(model.getHindiRemedie());
            }else {
                holder.txtRemedy.setText(model.getEnglishRemedie());
            }
        }else {
            if (model.getEnglishRemedie()!=null){
                holder.txtRemedy.setText(model.getEnglishRemedie());
            }else {
                holder.txtRemedy.setText(model.getHindiRemedie());
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtRemedy;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtRemedy = itemView.findViewById(R.id.txtRemedy);
        }
    }
}


