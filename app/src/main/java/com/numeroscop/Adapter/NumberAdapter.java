package com.numeroscop.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.numeroscop.ApiCall.Model.GetNumberResBean;
import com.numeroscop.Model.NumberModel;
import com.numeroscop.R;

import java.util.ArrayList;
import java.util.List;

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.MyViewHolder> {

    ArrayList<NumberModel>list;
    Context context;
    GetNumberResBean.Data tableData;
    String driverNo="";
    String conductorNo ="";
    String kuaNo ="";

    public NumberAdapter(ArrayList<NumberModel> list, GetNumberResBean.Data tableData,String driverNo,String  conductorNo,String kuaNo, Context context) {
        this.list = list;
        this.context = context;
        this.tableData = tableData;
        this.driverNo = driverNo;
        this.conductorNo = conductorNo;
        this.kuaNo = kuaNo;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_grid,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        NumberModel model = list.get(position);

        List<Integer> cal = new ArrayList<>();
        cal.addAll(tableData.getCalculation());

        String generatedText = " ";

        for(int i = 1; i<=tableData.getCalculation().get(position); i++){
            if (i==0) {
                generatedText = model.getText();
            }
            else {
                generatedText =  model.getText()+","+generatedText;
            }
        }

        generatedText = generatedText.replaceAll(", $", "");

        holder.txtNumber.setText(generatedText);



        Log.e("kuaNo", kuaNo);
        Log.e("conductorNo", conductorNo);
        Log.e("driverNo", driverNo);

        holder.layoutDriver.setVisibility(View.GONE);
        holder.layoutConductor.setVisibility(View.GONE);
        holder.layoutKuaNumber.setVisibility(View.GONE);

        if(list.get(position).getText().equalsIgnoreCase(kuaNo)){
            holder.txtNumberNameKua.setText(list.get(position).getText());
            holder.layoutKuaNumber.setVisibility(View.VISIBLE);
        }
        if(list.get(position).getText().equalsIgnoreCase(conductorNo)){
            holder.txtNumberNameCond.setText(list.get(position).getText());
            holder.layoutConductor.setVisibility(View.VISIBLE);
        }
        if(list.get(position).getText().equalsIgnoreCase(driverNo)){
            holder.txtNumberName.setText(list.get(position).getText());
            holder.layoutDriver.setVisibility(View.VISIBLE);
        }




        switch (position){
            case 0:
                holder.consRoot.setBackgroundColor(Color.parseColor("#8B20BB"));
                holder.txtFixNumber.setText("4");
                break;
            case 1:
                holder.consRoot.setBackgroundColor(Color.parseColor("#F24A49"));
                holder.txtFixNumber.setText("9");
                break;
            case 2:
                holder.consRoot.setBackgroundColor(Color.parseColor("#F977BD"));
                holder.txtFixNumber.setText("2");
                break;
            case 3:
                holder.consRoot.setBackgroundColor(Color.parseColor("#26D560"));
                holder.txtFixNumber.setText("3");
                break;
            case 4:
                holder.consRoot.setBackgroundColor(Color.parseColor("#FEA500"));
                holder.txtFixNumber.setText("5");
                break;
            case 5:
                holder.consRoot.setBackgroundColor(Color.parseColor("#010101"));
                holder.txtFixNumber.setText("7");
                break;
            case 6:
                holder.consRoot.setBackgroundColor(Color.parseColor("#007AC7"));
                holder.txtFixNumber.setText("8");
                break;
            case 7:
                holder.consRoot.setBackgroundColor(Color.parseColor("#404040"));
                holder.txtFixNumber.setText("1");
                break;
            case 8:
                holder.consRoot.setBackgroundColor(Color.parseColor("#808080"));
                holder.txtFixNumber.setText("6");
                break;

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout consRoot,layoutDriver,layoutConductor,layoutKuaNumber;
        ImageView imgCircleNameNumber;
        TextView txtNumber,txtFixNumber,txtNumberName,txtNumberNameKua,txtNumberNameCond;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            consRoot = itemView.findViewById(R.id.consRoot);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            txtFixNumber = itemView.findViewById(R.id.txtFixNumber);
            txtNumberName = itemView.findViewById(R.id.txtNumberName);
            layoutDriver = itemView.findViewById(R.id.layoutDriver);
            layoutConductor = itemView.findViewById(R.id.layoutConductor);
            layoutKuaNumber = itemView.findViewById(R.id.layoutKuaNumber);
            imgCircleNameNumber = itemView.findViewById(R.id.imgCircleNameNumber);
            txtNumberNameKua = itemView.findViewById(R.id.txtNumberNameKua);
            txtNumberNameCond = itemView.findViewById(R.id.txtNumberNameCond);
        }
    }
}
