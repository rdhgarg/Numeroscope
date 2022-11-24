package com.numeroscop.Adapter;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.numeroscop.ApiCall.Model.GetReportResBean;
import com.numeroscop.R;

import java.util.ArrayList;

public class SingleRepeatAdapter extends RecyclerView.Adapter<SingleRepeatAdapter.MyViewHolder> {
    private Context context;
    ArrayList<GetReportResBean.SingleNoReportDTO> list;
    private String lng;



    public SingleRepeatAdapter(Context context,ArrayList<GetReportResBean.SingleNoReportDTO> list,String lng) {
        this.context = context;
        this.list = list;
        this.lng = lng;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_single_number,parent,false);

        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        GetReportResBean.SingleNoReportDTO model = list.get(position);

        holder.textNumber.setText("Single No. "+model.getNumber());


        if(lng.equalsIgnoreCase("English")){
            if(model.getDetail()!= null){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    holder.textDetails.setText(Html.fromHtml(model.getDetail(), Html.FROM_HTML_MODE_LEGACY));
                } else {
                    holder.textDetails.setText(Html.fromHtml(model.getDetail()));
                }
            }
        }else{
            if(model.getDetail()!= null){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    holder.textDetails.setText(Html.fromHtml(model.getDetailHindi(), Html.FROM_HTML_MODE_LEGACY));
                } else {
                    holder.textDetails.setText(Html.fromHtml(model.getDetailHindi()));
                }
            }
        }




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textNumber,textDetails;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textNumber = itemView.findViewById(R.id.textNumber);
            textDetails = itemView.findViewById(R.id.textDetails);
        }
    }
}
