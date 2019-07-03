package dars17.corvo.example.com.muximduolar;

import android.app.Application;

import dars17.corvo.example.com.muximduolar.db.Item;
import dars17.corvo.example.com.muximduolar.db.ItemDB;

public class App extends Application {
    public ItemDB getItemDB() {
        return itemDB;
    }

    public void setItemDB(ItemDB itemDB) {
        this.itemDB = itemDB;
    }

    private ItemDB itemDB;
}
