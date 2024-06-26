package com.paccy.hibernate.dao;

import com.paccy.hibernate.model.Student;
import com.paccy.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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


//    Updating student

    public void  updateStudent(Student student){
        Transaction transaction = null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
//            Start transaction
            transaction= session.beginTransaction();

//            Save student
            session.saveOrUpdate(student);
//            Commit the transaction

            transaction.commit();


        }
        catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

//    Getting student by id

    public Student  getStudentById(long id){
        Transaction transaction = null;
        Student student = null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
//            Start transaction
            transaction= session.beginTransaction();

//            get student object
            student= session.get(Student.class,id);

//            Commit the transaction

            transaction.commit();
        }
        catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return  student;
    }


//    Getting all students

    public List<Student>  getStudents(){
        Transaction transaction = null;
        List<Student> students =null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
//            Start transaction
            transaction= session.beginTransaction();

//            get student object
            students= session.createQuery("from Student ").list();

//            Commit the transaction

            transaction.commit();
        }
        catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return  students;
    }

//    Deleting a student

    public void   deleteStudent(long id){
        Transaction transaction = null;
        Student student =null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
//            Start transaction
            transaction= session.beginTransaction();

//            get student object
            student= session.get(Student.class,id);

            session.delete(student);

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
