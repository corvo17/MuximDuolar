package dars17.corvo.example.com.muximduolar.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.os.Parcelable;

@Database(entities = {Item.class}, version = 1)
public abstract class ItemDB extends RoomDatabase  {
    public abstract ItemDAO loadItemDao();
}
















