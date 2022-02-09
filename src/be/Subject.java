package be;

import javafx.beans.property.*;

import java.util.Date;

public class Subject {

    private StringProperty name = new SimpleStringProperty();
    private ObjectProperty<Date> date = new SimpleObjectProperty<>();
    private BooleanProperty isAttend = new SimpleBooleanProperty();

    public Subject(String name, Date date, boolean isAttend) {
        this.name.set(name);
        this.date.set(date);
        this.isAttend.set(isAttend);
    }
}
