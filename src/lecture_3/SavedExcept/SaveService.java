package lecture_3.SavedExcept;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class SaveService {
    public void save() throws SavedException {
        Date date = new Date();
        System.out.println("save document started ...");
        try (FileWriter writer = new FileWriter("test")) {
            throw new IOException("operation failed");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            throw new SavedException ("Saved document failed", date, e);
        }
    }
}
