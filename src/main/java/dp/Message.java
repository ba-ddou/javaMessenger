package dp;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Message {
    public DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    public String from;
    public String message;
    public String timestamp;

    public Message setTimestamp() {
        Date dateobj = new Date();
        this.timestamp = df.format(dateobj);
        return this;
    }

}
