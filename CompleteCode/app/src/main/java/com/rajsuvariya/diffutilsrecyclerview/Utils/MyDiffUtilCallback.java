package com.rajsuvariya.diffutilsrecyclerview.Utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.util.Log;

import com.rajsuvariya.diffutilsrecyclerview.Model.Contact;

import java.util.ArrayList;

/**
 * Created by kuliza-319 on 16/2/17.
 */

public class MyDiffUtilCallback extends DiffUtil.Callback {
    ArrayList<Contact> newList;
    ArrayList<Contact> oldList;

    public MyDiffUtilCallback(ArrayList<Contact> newList, ArrayList<Contact> oldList) {
        this.newList = newList;
        this.oldList = oldList;
    }

    @Override
    public int getOldListSize() {
        return oldList != null ? oldList.size() : 0 ;
    }

    @Override
    public int getNewListSize() {
        return newList != null ? newList.size() : 0 ;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return true;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        int result = newList.get(newItemPosition).compareTo(oldList.get(oldItemPosition));
        if (result==0){
            return true;
        }
        return false;
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        Contact newContact = newList.get(newItemPosition);
        Contact oldContact = oldList.get(oldItemPosition);

        Bundle diff = new Bundle();
        if(!newContact.getName().equals(oldContact.getName())){
            diff.putString("name", newContact.getName());
        }
        if(!newContact.getPhonenumber().equals(oldContact.getPhonenumber())){
            diff.putString("phone", newContact.getPhonenumber());
        }
        if (diff.size()==0){
            return null;
        }
//        Log.d("diffutilcheck", "Diff");
        return diff;
//        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
