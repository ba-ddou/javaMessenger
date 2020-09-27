package dp;

import Observer.Observer;

public class ChatWindow implements Observer {
    // private DataStore dataStoreRef = null;

    // public ChatWindow(DataStore dataStore) {
    // dataStoreRef = dataStore;
    // }

    @Override
    public void onUpdate(Message message) {
        System.out.println("****Chat Window****\nfrom: " + message.from + "\nmessage:" + message.message
                + "\ntimestamp:" + message.timestamp);

    }

}
