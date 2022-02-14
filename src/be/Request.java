package be;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class Request {

    private StringProperty fullName = new SimpleStringProperty();
    private ObjectProperty<Date> date = new SimpleObjectProperty<>();
    private StringProperty subject = new SimpleStringProperty();
    private StringProperty absent = new SimpleStringProperty();

    public Request(String fullName, Date date, String subject, String absent) {
        this.fullName.set(fullName);
        this.date.set(date);
        this.subject.set(subject);
        this.absent.set(absent);
    }

    public StringProperty fullNameProperty() {
        return fullName;
    }

    public ObjectProperty<Date> dateProperty() {
        return date;
    }

    public StringProperty subjectProperty() {
        return subject;
    }

    public StringProperty absentProperty() {
        return absent;
    }
}
