package net.senior.mcq.entity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import net.senior.mcq.dao.AnswersDao;
import net.senior.mcq.dao.QuestionsDao;
import net.senior.mcq.dao.UsersDao;


@Database(entities = {Answer.class,Questions.class,User.class},exportSchema = false,version =7 )
public abstract class AppData extends RoomDatabase {
    public abstract AnswersDao getAnswersDao();
    public abstract QuestionsDao getQuestionsDao();
    public abstract UsersDao getUsersDao();




}