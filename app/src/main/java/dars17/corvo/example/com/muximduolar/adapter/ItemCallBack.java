package dars17.corvo.example.com.muximduolar.adapter;

import android.support.v7.util.DiffUtil;

import dars17.corvo.example.com.muximduolar.db.Item;

public class ItemCallBack extends DiffUtil.ItemCallback<Item> {

    @Override public boolean areItemsTheSame(Item oldItem, Item newItem) {
        return oldItem.id == newItem.id;
    }

    @Override public boolean areContentsTheSame(Item oldItem, Item newItem) {
        return oldItem.equals(newItem);
    }
}
