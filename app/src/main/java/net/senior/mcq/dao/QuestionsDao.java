package net.senior.mcq.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import net.senior.mcq.entity.Questions;

import java.util.List;

@Dao
public interface QuestionsDao {
    @Query("SELECT * FROM Questions")
    List<Questions> getAll();

    
    @Query("SELECT * FROM Questions WHERE id = :Id")
    Questions loadById(long Id);

    @Insert
    long insert(Questions questions);


    @Update
    void update(Questions questions);


    @Delete
    void delete(Questions Questions);
}
