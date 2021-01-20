package net.senior.mcq.entity;

import android.content.Context;

import androidx.room.Room;

import net.senior.mcq.dao.AnswersDao;
import net.senior.mcq.dao.QuestionsDao;
import net.senior.mcq.dao.UsersDao;

import java.util.List;

public class AppDbManager {
    private static AppDbManager ourInstance;
    private static final String database_name = "TODO_DB";
    private QuestionsDao questionsDao;
    private AnswersDao answersDao;
    private UsersDao usersDao ;


    public static AppDbManager getInstance(Context c) {
        if (ourInstance == null)
            ourInstance = new AppDbManager(c);

        return ourInstance;
    }

    private AppDbManager(Context c) {
        AppData db = Room.databaseBuilder(c,AppData.class, database_name)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
        questionsDao = db.getQuestionsDao();
        answersDao = db.getAnswersDao();
        usersDao = db.getUsersDao();
    }




    public List<Answer> getAll() {
        return answersDao.getAll();
    }

    public Answer selectById(long id) {
        return (Answer) answersDao.loadById(id);
    }




    public long insert(Answer answer) {

        long id=answersDao.insert(answer);
//       todoEntity.id=id;
        return id;

    }

    public void delete(Answer answer) {
        answersDao.delete(answer);
    }



  public List<Questions> getAllQues() {
        return questionsDao.getAll();
    }
  public List<User> getAllUsers() {
        return usersDao.getAll();
    }

    public Questions selectQueById(long id) {
        return (Questions) questionsDao.loadById(id);
    }




    public long insert(Questions questions) {

        long id=questionsDao.insert(questions);
//       todoEntity.id=id;
        return id;

    }

    public void delete(Questions questions) {
        questionsDao.delete(questions);
    }



 public User selectQueById(String name,String pass) {
        return usersDao.loadById(name,pass);
    }




    public long insert(User user) {

        long id=usersDao.insert(user);
       user.setId(id);
        return id;

    }
    public void update(User user) {

       usersDao.update(user);
//       todoEntity.id=id;

    }

    public void delete(User user) {
        usersDao.delete(user);
    }



}
