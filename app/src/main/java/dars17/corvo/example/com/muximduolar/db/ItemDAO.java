package dars17.corvo.example.com.muximduolar.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import kotlin.ReplaceWith;

@Dao
public interface ItemDAO {

    @Insert
    void addItem(Item item);

    @Delete
    void removeItem(Item student);

    @Update
    void updateItem(Item item);

    @Query("select * from Item")
    Flowable<List<Item>> loadAll();
    @Query("select * from Item")
    List<Item> loadAllItems();

    @Query("select *from Item where isFavour=:id")
    Flowable<List<Item>> loadUnliked(int id);

    @Query("select *from Item where isFavour=:id")
    Flowable<List<Item>> loadLiked(int id);

    @Query("select *from Item where isFavour=:id")
    List<Item> loadUnlikeds(int id);

    @Query("select *from Item where id=:id") Item loadById(long id);

    @Query("select count(*) from Item") int loadCount();
}
