package utils;

import entity.Student;
import enums.Mark;

import java.util.ArrayList;
import java.util.List;

public class StudentsGeneration {

    public static List<Student> studentList(int i) {
        List<Student> studentList = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            studentList.add(new Student("Roman" + j, Mark.STUDYING));
        }
        return studentList;
    }
}
