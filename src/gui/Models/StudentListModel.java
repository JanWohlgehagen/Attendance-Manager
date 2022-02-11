package gui.Models;

import be.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class StudentListModel {

    private ObservableList<Student> students = FXCollections.observableArrayList();


    public StudentListModel() {

        students.add(new Student("mark20", "Mark", "Rasmussen"));
        students.add(new Student("Tobias30","Tobias", " Jensen"));
        students.add(new Student("Kim32", "Kim", "V"));
        students.add(new Student("Thomas54", "Thomas", " Bolds"));
        students.add(new Student("Rasmus80", "Rasmus", " Wol"));
        students.add(new Student("Lars62", "Lars", " Q"));
    }

    public ObservableList<Student> getStudents(){
        return students;
    }
}
