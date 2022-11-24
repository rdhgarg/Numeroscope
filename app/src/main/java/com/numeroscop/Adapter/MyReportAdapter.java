package com.numeroscop.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.numeroscop.ApiCall.Model.MyReportResBean;
import com.numeroscop.R;
import java.util.ArrayList;

public class MyReportAdapter extends RecyclerView.Adapter<MyReportAdapter.MyViewHolder> {
    private Context context;
    ArrayList<MyReportResBean.DataItem> list;
    private ReportClickListner listner;

    public interface ReportClickListner{
        void onReportClicked(int position);
    }

    public MyReportAdapter(Context context, ArrayList<MyReportResBean.DataItem> list, ReportClickListner listner) {
        this.context = context;
        this.list = list;
        this.listner = listner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_my_report,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        MyReportResBean.DataItem model = list.get(position);

        holder.txtName.setText(model.getName());
        holder.txtGender.setText(model.getGender());
        holder.txtMobile.setText("Mobile: "+model.getMobile());
        holder.txtDateOfBirth.setText("DOD: "+model.getDobOrignal());

        holder.cardPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listner.onReportClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtName,txtGender,txtMobile,txtDateOfBirth;
        CardView cardPdf;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtGender = itemView.findViewById(R.id.txtGender);
            txtMobile = itemView.findViewById(R.id.txtMobile);
            txtDateOfBirth = itemView.findViewById(R.id.txtDateOfBirth);
            cardPdf = itemView.findViewById(R.id.cardPdf);
        }
    }
}


