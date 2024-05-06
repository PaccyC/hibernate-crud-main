package com.paccy.hibernate.dao;

import com.paccy.hibernate.model.Student;
import com.paccy.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDao {

    public void  saveStudent(Student student){
        Transaction transaction = null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
//            Start transaction
            transaction= session.beginTransaction();

//            Save student
            session.save(student);
//            Commit the transaction

            transaction.commit();


        }
        catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

}
