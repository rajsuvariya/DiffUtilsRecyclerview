package com.rajsuvariya.diffutilsrecyclerview.Adapter;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.util.DiffUtil;
import android.support.v7.util.ListUpdateCallback;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.rajsuvariya.diffutilsrecyclerview.Model.Contact;
import com.rajsuvariya.diffutilsrecyclerview.R;
import com.rajsuvariya.diffutilsrecyclerview.Utils.MyDiffUtilCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kuliza-319 on 16/2/17.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ContactViewHolder>{

    private ArrayList<Contact> data;

    public class ContactViewHolder extends RecyclerView.ViewHolder{

        public TextView icon, name, phonenumber;

        public ContactViewHolder(View itemView) {
            super(itemView);
            icon = (TextView) itemView.findViewById(R.id.tv_contact_icon);
            name = (TextView) itemView.findViewById(R.id.tv_contact_name);
            phonenumber = (TextView) itemView.findViewById(R.id.tv_contact_phone_number);
        }
    }

    public MyRecyclerViewAdapter(ArrayList<Contact> data) {
        this.data = data;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        holder.icon.setText(data.get(position).getName().substring(0,2));
        holder.name.setText(data.get(position).getName());
        holder.phonenumber.setText(data.get(position).getPhonenumber());
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position, List<Object> payloads) {

        if (payloads.isEmpty()){
            super.onBindViewHolder(holder, position, payloads);
        }
        else {
            Bundle o = (Bundle) payloads.get(0);
            for (String key : o.keySet()) {
                if(key.equals("name")){
                    Toast.makeText(holder.itemView.getContext(), "Contact "+position+" : Name Changed", Toast.LENGTH_SHORT).show();;
                    holder.icon.setText(data.get(position).getName().substring(0,2));
                    holder.name.setText(data.get(position).getName());
                }
                if(key.equals("phone")){
                    Toast.makeText(holder.itemView.getContext(), "Contact "+position+" : Phone Number Changed", Toast.LENGTH_SHORT).show();;
                    holder.phonenumber.setText(data.get(position).getPhonenumber());
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public ArrayList<Contact> getData() {
        return data;
    }

    public void onNewProducts(ArrayList<Contact> newProducts) {
        Log.d("diffutilcheck", "Size : "+newProducts.size());
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new MyDiffUtilCallback(newProducts, data));
        diffResult.dispatchUpdatesTo(this);
        this.data.clear();
        this.data.addAll(newProducts);
    }
}
