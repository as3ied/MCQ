package net.senior.mcq.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import net.senior.mcq.entity.User;

import java.util.List;

@Dao
public interface UsersDao {
    @Query("SELECT * FROM User")
    List<User> getAll();


    @Query("SELECT * FROM User WHERE userName = :userName and password=:password")
    User loadById(String userName,String password);

    @Insert
    long insert(User User);


    @Update
    void update(User User);


    @Delete
    void delete(User User);

}
