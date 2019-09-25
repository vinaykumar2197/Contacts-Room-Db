package com.vinaykumar.contactroom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vinaykumar.contactroom.db.Contacts;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder> {

    ArrayList<Contacts> contactsArrayList;
    Context context ;
    MainActivity mainActivity;

    public ContactsAdapter(Context context,ArrayList<Contacts> contactsArrayList,MainActivity mainActivity) {
        this.contactsArrayList = contactsArrayList;
        this.context = context;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public ContactsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_contact,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter.MyViewHolder holder, final int i) {
        final Contacts contacts = contactsArrayList.get(i);
        holder.tvContactName.setText(contacts.getContactName());
        holder.tvContactEmail.setText(contacts.getContactEmail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                mainActivity.addAndEditContacts(true, contacts, i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactsArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvContactName , tvContactEmail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvContactName = (TextView) itemView.findViewById(R.id.tv_contact_name);
            tvContactEmail = (TextView) itemView.findViewById(R.id.tv_contact_email);
        }
    }
}
