package dao;

import entity.Student;
import factory.HibernateFactory;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    /* Создать DAO-слой с операциями добавления, удаления, изменения сущности, выборки записи по ID и всех записей.*/

    public void save(Student student) {
        try (Session session = HibernateFactory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            session.persist(student);
            session.getTransaction().commit();
        }
    }

    public void save(List<Student> studentList) {
        try (Session session = HibernateFactory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            for (Student student : studentList) {
                session.persist(student);
            }
            session.getTransaction().commit();
        }
    }

    public void delete(Student student) {
        try (Session session = HibernateFactory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            session.remove(student);
            session.getTransaction().commit();
        }
    }

    public void update(Student student) {
        try (Session session = HibernateFactory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            session.merge(student);
            session.getTransaction().commit();
        }
    }

    public Student findById(Long id) {
        Student student = null;
        try (Session session = HibernateFactory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            student = session.find(Student.class, id);
            session.getTransaction().commit();
        }
        return student;
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try (Session session = HibernateFactory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            students = session.createQuery("from Student", Student.class).getResultList();
            session.getTransaction().commit();
        }
        return students;
    }

    public void test() {
        Session session = HibernateFactory.getFactory().getCurrentSession();
    }
}


