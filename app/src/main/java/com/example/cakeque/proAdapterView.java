
package com.example.cakeque;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class  proAdapterView extends RecyclerView.Adapter<proAdapterView.ViewHolder> {

    List<CakeModel> proposal;
    Context context;
    DatabaseHelper databaseHelperClass;

    public proAdapterView(List<CakeModel> proposal, Context context) {
        this.proposal = proposal;
        this.context = context;
        databaseHelperClass = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.proposal_item_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final CakeModel cakeModel = proposal.get(position);

        holder.edit_user.setText(cakeModel.getUserid());
        holder.edit_order.setText(cakeModel.getOrderid());
        holder.edit_proposition.setText(cakeModel.getProposition());
        holder.edit_cakecost.setText(cakeModel.getCakecost());
        holder.edit_delivercost.setText(cakeModel.getDelivercost());
        holder.edit_contacts.setText(cakeModel.getContacts()); }

    @Override
    public int getItemCount() {
        return proposal.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView edit_user;
        TextView edit_order;
        TextView edit_proposition;
        TextView edit_cakecost;
        TextView edit_delivercost;
        TextView edit_contacts;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            edit_user = itemView.findViewById(R.id.edittext_User);
            edit_order = itemView.findViewById(R.id.edittext_Order);
            edit_proposition = itemView.findViewById(R.id.edittext_Proposition);
            edit_cakecost = itemView.findViewById(R.id.edittext_Cakecost);
            edit_delivercost = itemView.findViewById(R.id.edittext_Delivercost);
            edit_contacts = itemView.findViewById(R.id.edittext_Contacts);


        }
    }
}


package com.example.cakeque;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class  proAdapterView extends RecyclerView.Adapter<proAdapterView.ViewHolder> {

    List<CakeModel> proposal;
    Context context;
    DatabaseHelper databaseHelperClass;

    public proAdapterView(List<CakeModel> proposal, Context context) {
        this.proposal = proposal;
        this.context = context;
        databaseHelperClass = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.proposal_item_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final CakeModel cakeModel = proposal.get(position);

        holder.edit_user.setText(cakeModel.getUserid());
        holder.edit_order.setText(cakeModel.getOrderid());
        holder.edit_proposition.setText(cakeModel.getProposition());
        holder.edit_cakecost.setText(cakeModel.getCakecost());
        holder.edit_delivercost.setText(cakeModel.getDelivercost());
        holder.edit_contacts.setText(cakeModel.getContacts()); }

    @Override
    public int getItemCount() {
        return proposal.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView edit_user;
        TextView edit_order;
        TextView edit_proposition;
        TextView edit_cakecost;
        TextView edit_delivercost;
        TextView edit_contacts;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            edit_user = itemView.findViewById(R.id.edittext_User);
            edit_order = itemView.findViewById(R.id.edittext_Order);
            edit_proposition = itemView.findViewById(R.id.edittext_Proposition);
            edit_cakecost = itemView.findViewById(R.id.edittext_Cakecost);
            edit_delivercost = itemView.findViewById(R.id.edittext_Delivercost);
            edit_contacts = itemView.findViewById(R.id.edittext_Contacts);


        }
    }
}




