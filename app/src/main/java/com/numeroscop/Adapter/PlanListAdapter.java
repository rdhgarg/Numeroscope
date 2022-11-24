package com.numeroscop.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.numeroscop.ApiCall.Model.PlanListResBean;
import com.numeroscop.R;

import java.util.ArrayList;


public class PlanListAdapter extends RecyclerView.Adapter<PlanListAdapter.MyViewHolder> {
    private Context context;
    ArrayList<PlanListResBean.DataDTO> list;
    private  ItemClickListner listner;



    public interface ItemClickListner{
        void onItemClicked(int poisition);
    }

    public PlanListAdapter(Context context, ArrayList<PlanListResBean.DataDTO> list,ItemClickListner listner) {
        this.context = context;
        this.list = list;
        this.listner = listner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_plan_layout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        PlanListResBean.DataDTO model = list.get(position);

        holder.txtTitle.setText("Title:"+model.getTitle());
        holder.txtAmount.setText("RS."+model.getAmount());
        holder.txtDays.setText("Days:"+model.getDays());
        holder.txtNumOfReport.setText("No. of report:"+model.getNoOfReports());
        holder.txtTitle.setText(""+model.getTitle());

        if(model.getIsSubscribe().toString().equalsIgnoreCase("1")){
            holder.layRoot.setBackground(context.getResources().getDrawable(R.drawable.boundary_selected_plan));
            holder.textBuy.setText(context.getResources().getString(R.string.purchased));
            holder.txtExpiry.setVisibility(View.VISIBLE);
            holder.txtPurchaseDate.setVisibility(View.VISIBLE);
            holder.txtExpiry.setText("Expired on: "+model.getExpirationDate().toString());
            holder.txtPurchaseDate.setText("Purchased on : "+model.getStartDate().toString());
        }else {
            holder.layRoot.setBackground(null);
            holder.textBuy.setText(context.getResources().getString(R.string.upgrade));
            holder.txtExpiry.setVisibility(View.GONE);
            holder.txtPurchaseDate.setVisibility(View.GONE);
        }

        holder.cvBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(model.getIsSubscribe().toString().equalsIgnoreCase("1")){
                    Toast.makeText(context, "You are already purchased plan", Toast.LENGTH_SHORT).show();
                }else{
                    listner.onItemClicked(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle,txtAmount,txtDays,txtNumOfReport,textBuy,txtExpiry,txtPurchaseDate;
        ConstraintLayout layRoot;
        CardView cvBuy;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtAmount = itemView.findViewById(R.id.txtAmount);
            txtDays = itemView.findViewById(R.id.txtDays);
            txtNumOfReport = itemView.findViewById(R.id.txtNumOfReport);
            layRoot = itemView.findViewById(R.id.layRoot);
            textBuy = itemView.findViewById(R.id.textBuy);
            cvBuy = itemView.findViewById(R.id.cvBuy);
            txtExpiry = itemView.findViewById(R.id.txtExpiry);
            txtPurchaseDate = itemView.findViewById(R.id.txtPurchaseDate);
        }
    }
}

