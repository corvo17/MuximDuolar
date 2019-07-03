package dars17.corvo.example.com.muximduolar.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Item {
    @PrimaryKey(autoGenerate = true)
    public long id  ;
    public int imgRes;
    public String text;
    public int isFavour = 0;

    public void setIsFavour(int isFavour) {
        this.isFavour = isFavour;
    }
}
