package be;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Date;

public class Student {
    private StringProperty firstName = new SimpleStringProperty();
    private StringProperty lastName = new SimpleStringProperty();
    private ObservableList<AbsentDay> absentDays = FXCollections.observableArrayList();

    public Student(){
        firstName.set("Mark");
        lastName.set("Davis");

        absentDays.add(new AbsentDay(new Date(2022, 1, 21)));
        absentDays.add(new AbsentDay(new Date(2022, 1, 23)));
        absentDays.add(new AbsentDay(new Date(2022, 1, 24)));
        absentDays.add(new AbsentDay(new Date(2022, 1, 25)));
    }

    public StringProperty getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
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
