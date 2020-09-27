package dp;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Message {
    public final DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    public String from = "";
    public String message = "";
    public String timestamp = "";

    public Message(String from, String message) {
        this.from = from;
        this.message = message;
        Date dateobj = new Date();
        timestamp = df.format(dateobj);
    }

}
