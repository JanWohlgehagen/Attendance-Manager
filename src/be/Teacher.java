package be;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Teacher {
    private StringProperty firstName = new SimpleStringProperty();
    private StringProperty lastName = new SimpleStringProperty();
    private StringProperty teacherID = new SimpleStringProperty();

    public Teacher (){
        setFirstName("John");
        setLastName("Miller");
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

    public StringProperty getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String studentID) {
        this.teacherID.set(studentID);
    }
}
