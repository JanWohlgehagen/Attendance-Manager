package be;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.Date;

public class AbsentDay {
    private BooleanProperty correctionPending = new SimpleBooleanProperty();
    private ObjectProperty<Date> date = new SimpleObjectProperty<>();

    public AbsentDay(Date date){
        this.date.set(date);
        this.correctionPending.set(false);
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
}
