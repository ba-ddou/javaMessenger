package dp;

import java.util.ArrayList;

import Observer.Observable;

public class DataStore extends Observable {
    private User user;
    public ArrayList<Message> messages = new ArrayList<Message>();

    public DataStore(User user) {
        this.user = user;
    }

    public String getUsername() {
        return user.getUsername();
    }

    public void addMessage(Message message) {
        messages.add(message);
        dispatch(message);
    }

}
