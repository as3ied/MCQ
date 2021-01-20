package net.senior.mcq.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Answer {

    @PrimaryKey
    public long id;
   public String Text;

    public Answer() {
    }

    public Answer(long id, String text) {
        this.id = id;
        Text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
