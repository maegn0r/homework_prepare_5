import dao.StudentDao;
import entity.Student;
import factory.HibernateFactory;

public class HibernateApp {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();

        studentDao.save(new Student("Roman","studying"));
        System.out.println(studentDao.findById(8L));
        studentDao.delete(studentDao.findById(8L));
        System.out.println(studentDao.findById(8L));
        Student student = studentDao.findById(6L);
        student.setName("Kolya");
        student.setMark("graduated");
        studentDao.update(student);
        System.out.println(studentDao.findById(6L));
        System.out.println(studentDao.findAll());
        System.out.println(studentDao.findById(3L));

        HibernateFactory.shutdown();
    }

}
