import dao.StudentDao;
import entity.Student;
import enums.Mark;
import factory.HibernateFactory;
import utils.StudentsGeneration;

import java.util.List;

public class HibernateApp {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();

        studentDao.save(new Student("Roman", Mark.STUDYING));
        System.out.println(studentDao.findById(24L));
        studentDao.delete(studentDao.findById(24L));
        System.out.println(studentDao.findById(24L));
        Student student = studentDao.findById(26L);
        student.setName("Kolya");
        student.setMark(Mark.GRADUATED);
        studentDao.update(student);
        System.out.println(studentDao.findById(6L));
        System.out.println(studentDao.findAll());
        System.out.println(studentDao.findById(3L));
        List<Student> studentList = StudentsGeneration.studentList(1000);
        studentDao.save(studentList);

        HibernateFactory.shutdown();
    }

}
