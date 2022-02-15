package be;

import javafx.beans.property.*;

import java.util.Date;

public class AbsentDay {
    private BooleanProperty correctionPending = new SimpleBooleanProperty();
    private ObjectProperty<Date> date = new SimpleObjectProperty<>();
    private StringProperty subject = new SimpleStringProperty();

    public AbsentDay(Date date, String subject){
        this.date.set(date);
        this.correctionPending.set(false);
        this.subject.set(subject);
    }

    public BooleanProperty getCorrectionPending() {
        return correctionPending;
    }

    public void setCorrectionPending() {
        correctionPending.set(!getCorrectionPending().get());
    }

    public ObjectProperty<Date> getDate() {
        return date;
    }

    public void setDate(ObjectProperty<Date> date) {
        this.date = date;
    }

    public StringProperty getSubject() {
        return subject;
    }
}
