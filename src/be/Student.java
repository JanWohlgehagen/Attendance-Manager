package be;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.awt.*;
import java.util.Date;

public class Student {
    private StringProperty firstName = new SimpleStringProperty();
    private StringProperty lastName = new SimpleStringProperty();
    private StringProperty studentID = new SimpleStringProperty();
    private ObservableList<AbsentDay> absentDays = FXCollections.observableArrayList();

    public Student(String studentID, String firstName, String lastName){
        this.studentID.set(studentID);
        this.firstName.set(firstName);
        this.lastName.set(lastName);

        absentDays.add(new AbsentDay(new Date(2022, 1, 21),"ITO"));
        absentDays.add(new AbsentDay(new Date(2022, 1, 23),"ITO"));
        absentDays.add(new AbsentDay(new Date(2022, 1, 24),"SCO"));
        absentDays.add(new AbsentDay(new Date(2022, 1, 24),"SDE"));
    }

    public StringProperty getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty getfullName(){
        StringProperty fullName = new SimpleStringProperty();
        fullName.set(firstName.getValue() + " " + lastName.getValue());
        return fullName;
    }

    public StringProperty getStudentID(){
        return studentID;
    }

    public StringProperty getAbsentInPercent(){
        StringProperty absentInPercent = new SimpleStringProperty();
        absentInPercent.set("5 %");
        return absentInPercent;
    }

    public StringProperty getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public ObservableList<AbsentDay> getAbsentDays() {
        return absentDays;
    }

    public void addAbsentDay(AbsentDay absentDay) {
        this.absentDays.add(absentDay);
    }

    public void removeAbsentDay(AbsentDay absentDay){
        this.absentDays.remove(absentDay);
    }
}
