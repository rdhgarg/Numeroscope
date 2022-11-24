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

public class LuckyProfessionAdapter extends RecyclerView.Adapter<LuckyProfessionAdapter.MyViewHolder> {
    private Context context;
    ArrayList<GetReportResBean.LuckyProffessionDTO> list;



    public LuckyProfessionAdapter(Context context, ArrayList<GetReportResBean.LuckyProffessionDTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_missing_number,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        GetReportResBean.LuckyProffessionDTO model = list.get(position);

        holder.textNumber.setText("Lucky Profession Number is : "+model.getNumber());
        holder.textNumber.setVisibility(View.GONE);


        if(model.getEnglishDetail()!=null){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                holder.textDetails.setText(Html.fromHtml(model.getEnglishDetail(), Html.FROM_HTML_MODE_LEGACY));
            } else {
                holder.textDetails.setText(Html.fromHtml(model.getEnglishDetail()));
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
