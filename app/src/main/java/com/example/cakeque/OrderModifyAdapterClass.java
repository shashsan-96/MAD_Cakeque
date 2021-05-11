package com.example.cakeque;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderModifyAdapterClass extends RecyclerView.Adapter<OrderModifyAdapterClass.ViewHolder>{

    List<OrderModelClass> orders;
    Context context;
    DatabaseHelperClass databaseHelperClass;

    public OrderModifyAdapterClass(List<OrderModelClass> orders, Context context) {
        this.orders = orders;
        this.context = context;
        databaseHelperClass = new DatabaseHelperClass(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.modify_order_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final OrderModelClass orderModelClass = orders.get(position);

        holder.textViewOrderId.setText(Integer.toString(orderModelClass.getOrderId()));
        holder.editTextName.setText(orderModelClass.getName());
        holder.editTextAddress.setText(orderModelClass.getAddress());
        holder.editTextRequirements.setText(orderModelClass.getRequirements());
        holder.editTextBudget.setText(orderModelClass.getBudget());
        holder.editTextdDate.setText(orderModelClass.getdDate());

        holder.button_Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Call updateOrder method
                String stringName = holder.editTextName.getText().toString();
                String stringAddress = holder.editTextAddress.getText().toString();
                String stringRequirements = holder.editTextRequirements.getText().toString();
                String stringBudget = holder.editTextBudget.getText().toString();
                String stringdDate = holder.editTextdDate.getText().toString();

                databaseHelperClass.updateOrder(new OrderModelClass(orderModelClass.getOrderId(),
                        stringName,stringAddress,stringRequirements,stringBudget,stringdDate));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });

        holder.button_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Call deleteOrder method
                databaseHelperClass.deleteOrder(orderModelClass.getOrderId());
                orders.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        //Create objects TextView and EditText and Button
        TextView textViewOrderId;
        EditText editTextName;
        EditText editTextAddress;
        EditText editTextRequirements;
        EditText editTextBudget;
        EditText editTextdDate;
        Button button_Update;
        Button button_Delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewOrderId = itemView.findViewById(R.id.textView_OrderID);
            editTextName = itemView.findViewById(R.id.editText_name);
            editTextAddress = itemView.findViewById(R.id.editText_address);
            editTextRequirements = itemView.findViewById(R.id.editText_req);
            editTextBudget = itemView.findViewById(R.id.editText_budget);
            editTextdDate = itemView.findViewById(R.id.editText_ddate);
            button_Update = itemView.findViewById(R.id.btnUpdate);
            button_Delete = itemView.findViewById(R.id.btnDelete);
        }
    }
}
