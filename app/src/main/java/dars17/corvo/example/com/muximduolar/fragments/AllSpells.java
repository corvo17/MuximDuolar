package dars17.corvo.example.com.muximduolar.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import dars17.corvo.example.com.muximduolar.App;
import dars17.corvo.example.com.muximduolar.Const;
import dars17.corvo.example.com.muximduolar.MainActivity;
import dars17.corvo.example.com.muximduolar.R;
import dars17.corvo.example.com.muximduolar.adapter.ItemAdapter;
import dars17.corvo.example.com.muximduolar.db.Item;
import dars17.corvo.example.com.muximduolar.db.ItemDB;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllSpells extends Fragment {
private Context context;
private App app;
private RecyclerView rVAllSpells;

    public AllSpells() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_spells, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = view.getContext();
        MainActivity mainActivity = (MainActivity) context;
        app = (App) mainActivity.getApplication();
        rVAllSpells = view.findViewById(R.id.rv1);
        ItemAdapter adapter = new ItemAdapter(context,app.getItemDB());
        Disposable d = app.getItemDB().loadItemDao().loadUnliked(0)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Item>>() {
                    @Override
                    public void accept(List<Item> items) {

                        adapter.submitList(items);
                    }
                });
        rVAllSpells.setAdapter(adapter);
        rVAllSpells.smoothScrollToPosition(Const.smoothScrollPosition);
    }

    @Override
    public void onStart() {
        super.onStart();
        rVAllSpells.smoothScrollToPosition(Const.smoothScrollPosition);
    }
}
