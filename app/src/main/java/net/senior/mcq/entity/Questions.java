package net.senior.mcq.entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Questions {

    @PrimaryKey
    public long id;
    public String text;

    public Questions(long id, String text) {
        this.id = id;
        this.text = text;
    }

    public long getId() {
        return id;
    }



    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
