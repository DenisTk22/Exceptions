package lecture_3.SavedExcept;

import java.io.IOException;
import java.util.Date;

// Создание собственного типа исключения
public class SavedException extends IOException {

    private Date startDate;


    //конструктор:
    public SavedException(String message, Date startDate, Exception e) {
        super("exception with message: " + message, e);
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }
}
