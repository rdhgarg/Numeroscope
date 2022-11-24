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
import java.util.List;

public class GridCompatibilityAdapter extends RecyclerView.Adapter<GridCompatibilityAdapter.MyViewHolder> {
    List<Integer> cal = new ArrayList<>();
    ArrayList<NumberModel> list;
    Context context;



    public GridCompatibilityAdapter(ArrayList<NumberModel> list,  List<Integer> cal, Context context) {
        this.list = list;
        this.context = context;
        this.cal = cal;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_child_layout_number,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        NumberModel model = list.get(position);

        String generatedText = " ";

        for(int i = 1; i<=cal.get(position); i++){
            if (i==0) {
                generatedText = model.getText();
            }
            else {
                generatedText =  model.getText()+","+generatedText;
            }
        }

        generatedText = generatedText.replaceAll(", $", "");

        holder.txtNumber.setText(generatedText);

     /*   if(tableData.getCalculation().get(position) == 0 ){
            holder.consRoot.setBackgroundColor(Color.parseColor("#FFEA00"));
        }else if(tableData.getCalculation().get(position) == 1){

            holder.consRoot.setBackgroundColor(Color.parseColor("#4AA41F"));
        }else{
            holder.consRoot.setBackgroundColor(Color.parseColor("#034411"));
        }*/

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
        ConstraintLayout consRoot;
        TextView txtNumber,txtFixNumber;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            consRoot = itemView.findViewById(R.id.consRoot);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            txtFixNumber = itemView.findViewById(R.id.txtFixNumber);
        }
    }
}

