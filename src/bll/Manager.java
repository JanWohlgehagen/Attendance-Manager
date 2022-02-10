package bll;

import be.Student;
import be.Teacher;
import dal.StudentRepository;
import dal.TeacherRepository;

public class Manager {

    private TeacherRepository teacherRepository = new TeacherRepository();
    private StudentRepository studentRepository = new StudentRepository();

    public Student getStudent(){
        return studentRepository.getStudent();
    }

    public Teacher getTeacher(){
        return teacherRepository.getTeacher();
    }
}
