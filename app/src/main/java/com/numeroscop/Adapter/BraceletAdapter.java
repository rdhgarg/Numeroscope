package com.numeroscop.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.numeroscop.ApiCall.Model.YantraBraceletResBean;
import com.numeroscop.R;
import com.numeroscop.Utils.ApiConstants;
import com.squareup.picasso.Picasso;
import java.util.List;

public class BraceletAdapter extends RecyclerView.Adapter<BraceletAdapter.MyViewHolder> {

    Context context;
    List<YantraBraceletResBean.Data.BraceletItem> yantraList;
    ItemClickListner listner;

    public BraceletAdapter(Context context, List<YantraBraceletResBean.Data.BraceletItem> yantraList, ItemClickListner listner) {
        this.context = context;
        this.yantraList = yantraList;
        this.listner = listner;
    }

    public interface ItemClickListner{
        void onBraceletClicked(int poisition);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_yantra,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Picasso.get().load(ApiConstants.IMAGE_BASE_URL+yantraList.get(position).getImage()).into(holder.imgProduct);
        holder.txtName.setText(yantraList.get(position).getTitle());
        if (yantraList.get(position).getIsSelected()){
            holder.imgCheckbox.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_checked));
        }else {
            holder.imgCheckbox.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_unchecked));
        }

        holder.consRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listner.onBraceletClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return yantraList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout consRoot;
        ImageView imgProduct, imgCheckbox;
        TextView txtName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            consRoot = itemView.findViewById(R.id.consRoot);
            txtName = itemView.findViewById(R.id.txtName);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            imgCheckbox = itemView.findViewById(R.id.imgCheckbox);
        }
    }
}


