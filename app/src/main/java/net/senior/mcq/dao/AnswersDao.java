package net.senior.mcq.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import net.senior.mcq.entity.Answer;

import java.util.List;

@Dao
public interface AnswersDao {
    @Query("SELECT * FROM Answer")
    List<Answer> getAll();


    @Query("SELECT * FROM Answer WHERE id = :Id")
    Answer loadById(long Id);

    @Insert
    long insert(Answer answer);


    @Update
    void update(Answer answer);


    @Delete
    void delete(Answer answer);

}
