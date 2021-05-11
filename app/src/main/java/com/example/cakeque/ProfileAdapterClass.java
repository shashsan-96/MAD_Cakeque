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

public class ProfileAdapterClass extends RecyclerView.Adapter<ProfileAdapterClass.ViewHolder> {

    List<ProfileModelClass> profile;
    Context context;
    DatabaseHelper databaseHelper;

    public ProfileAdapterClass(List<ProfileModelClass> profile, Context context) {
        this.profile = profile;
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.profile_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final ProfileModelClass profileModelClass = profile.get(position);

        holder.textViewID.setText(Integer.toString(profileModelClass.getId()));
        holder.editText_fName.setText(profileModelClass.getFname());
        holder.editText_lName.setText(profileModelClass.getLname());
        holder.editText_userid.setText(profileModelClass.getUserid());
        holder.editText_qualifications.setText(profileModelClass.getQualifications());
        holder.editText_contact.setText(profileModelClass.getContact());
        holder.editText_location.setText(profileModelClass.getLocation());

        holder.button_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringfname = holder.editText_fName.getText().toString();
                String stringlname = holder.editText_lName.getText().toString();
                String stringuserid = holder.editText_userid.getText().toString();
                String stringqualifications = holder.editText_qualifications.getText().toString();
                String stringcontact = holder.editText_contact.getText().toString();
                String stringlocation = holder.editText_location.getText().toString();

                databaseHelper.updateProfile(new ProfileModelClass(profileModelClass.getId(),stringfname,stringlname,stringuserid,stringqualifications,stringcontact,stringlocation));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });

        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.deleteProfile(profileModelClass.getId());
                profile.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return profile.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewID;
        EditText editText_fName;
        EditText editText_lName;
        EditText editText_userid;
        EditText editText_qualifications;
        EditText editText_contact;
        EditText editText_location;
        Button button_update;
        Button button_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewID = itemView.findViewById(R.id.text_id);
            editText_fName = itemView.findViewById(R.id.edittext_fname);
            editText_lName = itemView.findViewById(R.id.edittext_lname);
            editText_userid = itemView.findViewById(R.id.edittext_userid);
            editText_qualifications = itemView.findViewById(R.id.edittext_qualifications);
            editText_contact = itemView.findViewById(R.id.edittext_contact);
            editText_location = itemView.findViewById(R.id.edittext_location);
            button_delete = itemView.findViewById(R.id.button_delete);
            button_update = itemView.findViewById(R.id.button_edit);

        }
    }
}

