package com.example.cakeque;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderAdapterClass extends RecyclerView.Adapter<OrderAdapterClass.ViewHolder>{

    List<OrderModelClass> order;
    Context context;
    DatabaseHelper databaseHelper;

    public OrderAdapterClass(List<OrderModelClass> order, Context context) {
        this.order = order;
        this.context = context;
        databaseHelper = new DatabaseHelper(context);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.order_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final OrderModelClass orderModelClass = order.get(position);

        holder.textViewOrderId.setText(Integer.toString(orderModelClass.getOrderId()));
        holder.textViewName.setText(orderModelClass.getName());
        holder.textViewAddress.setText(orderModelClass.getAddress());
        holder.textViewRequirements.setText(orderModelClass.getRequirements());
        holder.textViewBudget.setText(orderModelClass.getBudget());
        holder.textViewDate.setText(orderModelClass.getdDate());
    }

    @Override
    public int getItemCount() {
        return order.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //Create objects
        TextView textViewOrderId;
        TextView textViewName;
        TextView textViewAddress;
        TextView textViewRequirements;
        TextView textViewBudget;
        TextView textViewDate;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            textViewOrderId = itemView.findViewById(R.id.text_displyorderid);
            textViewName = itemView.findViewById(R.id.text_displayName);
            textViewAddress = itemView.findViewById(R.id.text_displayAddress);
            textViewRequirements = itemView.findViewById(R.id.text_displayReq);
            textViewBudget = itemView.findViewById(R.id.text_displayBudget);
            textViewDate = itemView.findViewById(R.id.text_displayDate);
        }
    }
}
