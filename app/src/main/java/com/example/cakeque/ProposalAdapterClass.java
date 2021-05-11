
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

public class ProposalAdapterClass extends RecyclerView.Adapter<ProposalAdapterClass.ViewHolder> {

    List<CakeModel> proposal;
    Context context;
    DatabaseHelper databaseHelperClass;


    public ProposalAdapterClass(List<CakeModel> proposal, Context context) {
        this.proposal = proposal;
        this.context = context;
        databaseHelperClass = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.proposal_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final CakeModel cakeModel = proposal.get(position);

        holder.textViewID.setText(Integer.toString(cakeModel.getId()));
        holder.edit_user.setText(cakeModel.getUserid());
        holder.edit_order.setText(cakeModel.getOrderid());
        holder.edit_proposition.setText(cakeModel.getProposition());
        holder.edit_cakecost.setText(cakeModel.getCakecost());
        holder.edit_delivercost.setText(cakeModel.getDelivercost());
        holder.edit_contacts.setText(cakeModel.getContacts());

        holder.button_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stringUser = holder.edit_user.getText().toString();
                String stringOrder =holder.edit_order.getText().toString();
                String stringProposition = holder.edit_proposition.getText().toString();
                String stringCakecost =holder.edit_cakecost.getText().toString();
                String stringDelivercost = holder.edit_delivercost.getText().toString();
                String stringContacts = holder.edit_contacts.getText().toString();

                databaseHelperClass.updateProposal(new CakeModel(cakeModel.getId(),stringUser,stringOrder,stringProposition,
                        stringCakecost,stringDelivercost,stringContacts));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });

        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperClass.deleteProposal(cakeModel.getId());
                proposal.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return proposal.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewID;
        EditText edit_user;
        EditText edit_order;
        EditText edit_proposition;
        EditText edit_cakecost;
        EditText edit_delivercost;
        EditText edit_contacts;
        Button button_Edit;
        Button button_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewID = itemView.findViewById(R.id.text_id);
            edit_user = itemView.findViewById(R.id.edittext_User);
            edit_order = itemView.findViewById(R.id.edittext_Order);
            edit_proposition = itemView.findViewById(R.id.edittext_Proposition);
            edit_cakecost = itemView.findViewById(R.id.edittext_Cakecost);
            edit_delivercost = itemView.findViewById(R.id.edittext_Delivercost);
            edit_contacts = itemView.findViewById(R.id.edittext_Contacts);
            button_delete = itemView.findViewById(R.id.button_delete);
            button_Edit = itemView.findViewById(R.id.button_edit);

        }
    }
}



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

public class ProposalAdapterClass extends RecyclerView.Adapter<ProposalAdapterClass.ViewHolder> {

    List<CakeModel> proposal;
    Context context;
    DatabaseHelper databaseHelperClass;


    public ProposalAdapterClass(List<CakeModel> proposal, Context context) {
        this.proposal = proposal;
        this.context = context;
        databaseHelperClass = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.proposal_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final CakeModel cakeModel = proposal.get(position);

        holder.textViewID.setText(Integer.toString(cakeModel.getId()));
        holder.edit_user.setText(cakeModel.getUserid());
        holder.edit_order.setText(cakeModel.getOrderid());
        holder.edit_proposition.setText(cakeModel.getProposition());
        holder.edit_cakecost.setText(cakeModel.getCakecost());
        holder.edit_delivercost.setText(cakeModel.getDelivercost());
        holder.edit_contacts.setText(cakeModel.getContacts());

        holder.button_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stringUser = holder.edit_user.getText().toString();
                String stringOrder =holder.edit_order.getText().toString();
                String stringProposition = holder.edit_proposition.getText().toString();
                String stringCakecost =holder.edit_cakecost.getText().toString();
                String stringDelivercost = holder.edit_delivercost.getText().toString();
                String stringContacts = holder.edit_contacts.getText().toString();

                databaseHelperClass.updateProposal(new CakeModel(cakeModel.getId(),stringUser,stringOrder,stringProposition,
                        stringCakecost,stringDelivercost,stringContacts));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });

        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperClass.deleteProposal(cakeModel.getId());
                proposal.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return proposal.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewID;
        EditText edit_user;
        EditText edit_order;
        EditText edit_proposition;
        EditText edit_cakecost;
        EditText edit_delivercost;
        EditText edit_contacts;
        Button button_Edit;
        Button button_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewID = itemView.findViewById(R.id.text_id);
            edit_user = itemView.findViewById(R.id.edittext_User);
            edit_order = itemView.findViewById(R.id.edittext_Order);
            edit_proposition = itemView.findViewById(R.id.edittext_Proposition);
            edit_cakecost = itemView.findViewById(R.id.edittext_Cakecost);
            edit_delivercost = itemView.findViewById(R.id.edittext_Delivercost);
            edit_contacts = itemView.findViewById(R.id.edittext_Contacts);
            button_delete = itemView.findViewById(R.id.button_delete);
            button_Edit = itemView.findViewById(R.id.button_edit);

        }
    }
}


