import dao.StudentDao;
import entity.Student;
import factory.HibernateFactory;
import utils.StudentsGeneration;

import java.util.List;

public class HibernateApp {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();

        studentDao.save(new Student("Roman","studying"));
        System.out.println(studentDao.findById(13L));
        studentDao.delete(studentDao.findById(13L));
        System.out.println(studentDao.findById(13L));
        Student student = studentDao.findById(6L);
        student.setName("Kolya");
        student.setMark("graduated");
        studentDao.update(student);
        System.out.println(studentDao.findById(6L));
        System.out.println(studentDao.findAll());
        System.out.println(studentDao.findById(3L));
        List<Student> studentList = StudentsGeneration.studentList(1000);
        studentDao.save(studentList);

        HibernateFactory.shutdown();
    }

}
